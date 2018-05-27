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
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Manuel
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
            resultados = new ArrayList<>();
            for (DatosConsulta d : tfs) // recorremos las palabras de la consulta segun orden de relevancia
            {
                ArrayList<DatosPosteo> listaPosteo;
                listaPosteo = dbp.obtenerPosteos(d.getTermino()); // agregamos datos de posteo y calificacion
                if(listaPosteo != null)
                {
                    for (DatosPosteo dp : listaPosteo)
                    {
                        Documento doc = new Documento();
                        doc.obtenerInfo(dp.getNombreDocumento());
                        float calificacion = (float)(dp.getTf() * Math.log(593 / d.getNr()));
                        ResultadoDeBusqueda res = new ResultadoDeBusqueda(doc, calificacion);
                        resultados.add(res);
    //                    if (hasht.contains(dp.getNombreDocumento()))
    //                    {
    //                        hasht.put(dp.getNombreDocumento(), hasht.get(dp.getNombreDocumento()) + calificacion);
    //                    }
    //                    else
    //                    {
    //                        hasht.put(dp.getNombreDocumento(), calificacion);
    //                    }
                    }
                }
            }
//            Set<Map.Entry<String,Double>> se = hasht.entrySet();
//            Iterator<Map.Entry<String,Double>> it = se.iterator();
//
//            Map.Entry<String,Double> max = it.next();
//            while(it.hasNext())
//            {
//                Map.Entry<String,Double> x = it.next();
//                if (max.getValue() < x.getValue()) max = x;
//            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        return resultados;
    }
}
