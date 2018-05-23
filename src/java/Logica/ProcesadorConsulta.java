/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DataBase.DBPosteo;
import Entidades.DatosCalificacion;
import Entidades.DatosTermino;
import Entidades.DatosConsulta;
import Entidades.DatosPosteo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Manuel
 */
public class ProcesadorConsulta
{
    private TSB_OAHashtable<String,DatosTermino> hash;
    private final String PATHVOCABULARIO = "d:\\Users\\Manuel\\Desktop\\UTN\\[DLC] Diseño de Lenguajes de Consulta\\TPIntegrador\\HashTable\\tabla.dat";
    
    public ProcesadorConsulta()
    {
        File data = new File(PATHVOCABULARIO);
        if(data.exists())
        {
            try
            {
                OAHashtableReader slr = new OAHashtableReader(PATHVOCABULARIO);
                hash = (TSB_OAHashtable<String,DatosTermino>) slr.read();
            }
            catch(IOException e)
            {
                System.out.println("Error: " + e.getMessage());    
            }
        }
        else
            hash = new TSB_OAHashtable<>();
    }
    
    public void leerConsulta(String consulta)
    {
        try
        {
            String regex = "[^a-zA-ZñÑá-úÁ-Ú]";
            Scanner scanner = new Scanner(consulta).useDelimiter(regex);
            String aux[], separadores = "[ 0-9\\.,»«/=º°ª\\-\\+_;:?!¡¿#%\\(\\)\\*\\$\'\"\\[\\]]+";
            DatosConsulta tfs[];
            aux = scanner.nextLine().split(separadores);
            tfs = new DatosConsulta[aux.length]; // arreglo que tendra los terminos y su Nr
            for (int i = 0; i < aux.length; i++)
            {
                aux[i] = aux[i].toLowerCase();
                DatosConsulta dc = new DatosConsulta( aux[i], hash.get(aux[i]).getNr() );
                tfs[i] = dc;
            }
            Arrays.sort(tfs); // se ordena el termino por su Nr ascendente
            DBPosteo dbp = new DBPosteo();
            dbp.iniciar();
            TSB_OAHashtable<String,Double> hasht = new TSB_OAHashtable<>();
            for (DatosConsulta d : tfs) // recorremos las palabras de la consulta segun orden de relevancia
            {
                LinkedList<DatosCalificacion> listaPosteo = new LinkedList<>();
                listaPosteo.addAll(dbp.obtenerPosteos(d.getTermino())); // agregamos datos de posteo y calificacion
                for (DatosCalificacion dc : listaPosteo)
                {
                    double expresion = dc.getTf() + Math.log(593 / d.getNr());
                    if (hasht.contains(dc.getNombreDoc()))
                    {
                        hasht.put(dc.getNombreDoc(), hasht.get(dc.getNombreDoc()) + expresion);
                    }
                    else
                    {
                        hasht.put(dc.getNombreDoc(), expresion);
                    }
                }
            }
            
            Set<Map.Entry<String,Double>> se = hasht.entrySet();
            Iterator<Map.Entry<String,Double>> it = se.iterator();
            
            Map.Entry<String,Double> max = it.next();
            while(it.hasNext())
            {
                Map.Entry<String,Double> x = it.next();
                if (max.getValue() < x.getValue()) max = x;
            }
            
            System.out.println("Documento number 1: " + max.getKey() + " , " + max.getValue());
        }
        catch (Exception e)
        {
            System.out.println("Error 2: " + e);
        }
    }
}
