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
    private final String PATHVOCABULARIO = "D:/Usuarios/Ema/Mis Documentos/Facu UTN/2018/DLC/DLC_TPIntegrador2018/tabla.dat";
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
        if(file != null)
           leerArchivo();
    }

    private void leerArchivo()
    {
        try
        {
            String regex = "[^a-zA-ZñÑá-úÁ-Ú]";
            Scanner scanner = new Scanner(file,"ISO-8859-1").useDelimiter(regex);
            String aux[], separadores = "[ 0-9\\.·,»«></=º°ª^`’£\\{\\-\\+_;:\\?!¡¿~\\|&@#%\\(\\)\\*\\$\"\\[\\]]+";
            DBPosteo dbp = new DBPosteo();
            dbp.iniciar();
            while(scanner.hasNext())
            {                
                aux = scanner.nextLine().split(separadores);
                for(String st : aux)
                {
                    st = st.toLowerCase().replace("æ", "ae");
                    if(!st.equals(""))
                    {
                        if(!hash.containsKey(st))
                        {
                            DatosTermino dt = new DatosTermino();
                            hash.put(st, dt);
                            DatosPosteo dp = new DatosPosteo(file.getName());
                            dbp.insertarPosteo(st, dp);
                        }
                        else
                        {
                            DatosTermino x = hash.get(st);
                            DatosPosteo dpDoc = dbp.obtenerPorDocumento(st, file.getName()); //obtenemos el objeto de posteo correspondiente al archivo actual
                            if(dpDoc != null)
                            {
                                dpDoc.setTf(dpDoc.getTf() + 1); // se incrementa en uno el tf
                                if (dpDoc.getTf() > x.getMaxTf()) // comparo el tf de este doc con el max tf de la palabra
                                {
                                    x.setMaxTf(dpDoc.getTf()); // reemplazo el maxTf en el vocabulario
                                }
                                dbp.actualizarPosteo(st, dpDoc);
                            }
                            else // si no esta el documento
                            {
                                DatosPosteo dp = new DatosPosteo(file.getName());
                                dbp.insertarPosteo(st, dp);
                                x.setNr(x.getNr() + 1); // incrementamos el nr la palabra en el vocabulario
                            }
                        }
                    } 
                }
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
