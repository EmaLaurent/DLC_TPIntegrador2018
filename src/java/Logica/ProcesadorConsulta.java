/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DataBase.DBPosteo;
import Entidades.DatosTermino;
import Entidades.DatosConsulta;
import Entidades.DatosPosteo;
import Entidades.Documento;
import Entidades.ResultadoDeBusqueda;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Manuel, Laurent Emanuel
 */
public class ProcesadorConsulta
{
    private final TSB_OAHashtable<String,DatosTermino> HASH;

    public ProcesadorConsulta(TSB_OAHashtable<String,DatosTermino> hash)
    {
        this.HASH = hash;
    }
    
    public ArrayList<ResultadoDeBusqueda> leerConsulta(String consulta)
    {
        String regex = "[^a-zA-ZñÑá-úÁ-Ú\']";
        String aux[];
        ArrayList<DatosConsulta> tfs;
        ArrayList<ResultadoDeBusqueda> resultados = null;
        ArrayList<ResultadoDeBusqueda> resultTemp;
        if(consulta.equals(""))
            return resultados;
        aux = consulta.split(regex);
        tfs = new ArrayList<>(aux.length); // arreglo que tendra los terminos y su Nr
        for(String st : aux)
        {
            st = st.toLowerCase();
            if(HASH.containsKey(st))
            {
                DatosConsulta dc = new DatosConsulta(st, HASH.get(st).getNr() );
                tfs.add(dc); 
            }
        }
        Collections.sort(tfs); // se ordena el termino por su Nr ascendente
        try
        {    
            DBPosteo dbp = new DBPosteo();
            dbp.iniciar();
            resultTemp = new ArrayList<>();
            for (DatosConsulta d : tfs) // recorremos las palabras de la consulta segun orden de relevancia
            {
                ArrayList<DatosPosteo> listaPosteo;
                listaPosteo = dbp.obtenerPosteos(d.getTermino()); // agregamos datos de posteo y calificacion
                if(listaPosteo != null)
                {
                    for (DatosPosteo dp : listaPosteo)
                    {
                        boolean flag = false;
                        Documento doc = new Documento();
                        doc.obtenerInfo(dp.getNombreDocumento());
                        double calculo = dp.getTf() * Math.log(593 / d.getNr());
                        int calificacion = (int)Math.round(calculo);
                        for( ResultadoDeBusqueda r : resultTemp)
                        {
                            if(r.getDoc().getNombArchivo().equals(doc.getNombArchivo()))
                            {
                                r.setCalificacion(r.getCalificacion() + calificacion);
                                flag = true;
                                break;
                            }    
                        }
                        if(flag == false)
                        {
                            ResultadoDeBusqueda res = new ResultadoDeBusqueda(doc, calificacion);
                            resultTemp.add(res);
                        }
                    }
                }
            }
            if(resultTemp.isEmpty())
                return resultados;
            Collections.sort(resultTemp, Collections.reverseOrder());
            resultados = new ArrayList<>(50);
            for(int i = 0; i < 50 & i < resultTemp.size(); i++)
            {
                resultados.add(resultTemp.get(i));
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        return resultados;
    }
}
