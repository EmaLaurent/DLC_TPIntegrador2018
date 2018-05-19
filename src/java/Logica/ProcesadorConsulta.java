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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

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
                OAHashtableReader slr = new OAHashtableReader();
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
            
            ArrayList<DatosPosteo> listaPosteo = new ArrayList<>();
            
            for (DatosConsulta d : tfs) // recorremos las palabras de la consulta segun orden de relevancia
            {
                
                listaPosteo.addAll(dbp.obtenerPosteos(d.getTermino())); // agregamos la lista de posteo de esa palabra
                
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
