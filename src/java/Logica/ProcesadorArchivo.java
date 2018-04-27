/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Heredia,Laurent
 */
public class ProcesadorArchivo 
{

    private File file;
    private TSB_OAHashtable<String,DatosTermino> hash;

    public ProcesadorArchivo()
    {
        File data = new File("tabla.dat");
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

    public void setFile(File file) 
    {
        this.file = file;
        if(file != null)
           leerArchivo();
    }

    private void leerArchivo()
    {
        try
        {
            //Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)));
            String regex = "[^a-zA-ZñÑá-úÁ-Ú]";
            Scanner scanner = new Scanner(file,"ISO-8859-1").useDelimiter(regex);
            String aux[], separadores = "[ 0-9\\.,»«/=º°ª\\-\\+_;:?!¡¿#%\\(\\)\\*\\$\'\"\\[\\]]+";
            while(scanner.hasNext())
            {
                aux = scanner.nextLine().split(separadores);
                for(String st : aux)
                {
                    st = st.toLowerCase();
                    if(!hash.containsKey(st))
                    {
                        DatosTermino dt = new DatosTermino();
                        hash.put(st, dt);
                    }
                    else
                    {
                        Set<Map.Entry<String,DatosTermino>> se = hash.entrySet();
                        Iterator<Map.Entry<String,DatosTermino>> it = se.iterator();
                        while(it.hasNext())
                        {
                            Entry<String,DatosTermino> x = it.next();
                            if(x.getKey().equals(st))
                            {
                                DatosTermino auxDt = x.getValue();
                                auxDt.setMaxTf(auxDt.getMaxTf() + 1); //por ahora maxTf es el contador de veces que aparece la palabra
                                x.setValue(auxDt);
                                break;
                            }
                        }
                    }      
                } 
            }
            OAHashtableWriter htw = new OAHashtableWriter();
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
