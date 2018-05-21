/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import DataBase.DBPosteo;
import Entidades.DatosTermino;
import Entidades.DatosPosteo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


/**
 *
 * @author Laurent
 */
public class ProcesadorArchivo 
{

    private File file;
    private TSB_OAHashtable<String,DatosTermino> hash;
//    private final String PATHVOCABULARIO = "D:/Usuarios/Ema/Mis Documentos/Facu UTN/2018/DLC/DLC_TPIntegrador2018/tabla.dat";
    private final String PATHVOCABULARIO = "E:/Users/milen/Documents/Facu UTN/2018/DLC/DLC_TPIntegrador2018/tabla.dat";
//    private final String PATHVOCABULARIO = "";
//    private final String PATHVOCABULARIO = "";
    
    public ProcesadorArchivo()
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

    public void setFile(File file) 
    {
        this.file = file;
        if(this.file != null)
           leerArchivo();
    }

    private void leerArchivo()
    {
        try
        {
            String regex = "[^a-zA-ZñÑá-úÁ-Ú\']";
            Scanner scanner = new Scanner(file,"ISO-8859-1").useDelimiter(regex);
            String aux[];
            TSB_OAHashtable<String,Integer> hashDoc = new TSB_OAHashtable<>();
            DBPosteo dbp = new DBPosteo();
            dbp.iniciar();
            while(scanner.hasNext())
            {                
                aux = scanner.nextLine().split(regex);
                for(String st : aux)
                {
                    st = st.toLowerCase().replace("æ", "ae");
                    if(!st.equals("") & !st.equals("\'"))
                    {
                        if(!hashDoc.containsKey(st))
                        {
                            hashDoc.put(st, 1);
                        }
                        else
                        {
                            hashDoc.put(st, hashDoc.get( st ) + 1);
                        }
                    }
                }
            }
            Set<Map.Entry<String,Integer>> se = hashDoc.entrySet();
            Iterator<Map.Entry<String,Integer>> it = se.iterator();
            while(it.hasNext()) // recorremos cada palabra que encontramos en este documento (recorremos la hash temporal)
            {
                Entry<String,Integer> x = it.next();
                String termino = x.getKey();
                if (hash.contains(termino)) // si el vocabulario tiene esta palabra
                {
                    DatosTermino dt = hash.get(termino); // obtenemos los datos de la palabra en el vocabulario
                    dt.setNr(dt.getNr() + 1); // sumamos 1a la cantidad de documentos
                    if (x.getValue() > dt.getMaxTf()) // si el tf que tuvo el termino en este documento es mayor al maximo...
                    {
                        dt.setMaxTf(x.getValue()); // actualizarlo
                    }
                }
                else // si la palabra no esta en el vocabulario
                {
                    DatosTermino dt = new DatosTermino();
                    hash.put(termino, dt);
                }
                DatosPosteo dp = new DatosPosteo(file.getName(), x.getValue()); // se crea los datos del posteo
                dbp.insertarPosteo(termino, dp); // se almacena el registro con los datos para ese termino
            }
            dbp.finalizar();
            OAHashtableWriter htw = new OAHashtableWriter(PATHVOCABULARIO);
            htw.write( hash );
        }
        catch (FileNotFoundException ex) 
        {
            System.out.println("Error al leer el archivo: " + ex.getMessage());
        }
        catch(IOException e)
        {
            System.out.println("Error: " + e.getMessage());    
        } 
        catch (ClassNotFoundException | SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String,DatosTermino>> se = hash.entrySet();
        for (Entry entry : se) 
        {
            sb.append(entry.getKey()).append("\n");
        }
        return sb.toString();
    }
    
    public boolean buscarPalabra(String palabra)
    {
        return hash.containsKey(palabra);
    }

    public TSB_OAHashtable<String, DatosTermino> getHash()
    {
        return hash;
    }
}
