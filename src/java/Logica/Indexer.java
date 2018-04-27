/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;

/**
 *
 * @author Emanuel Laurent
 */
public class Indexer
{
    private ProcesadorArchivo archivoPr;
    private TSB_OAHashtable<String,DatosTermino> hash;

    public Indexer()
    {
  
    }

    public TSB_OAHashtable<String, DatosTermino> getHash()
    {
        return hash;
    }
    
    public void indexarDirectorio()
    {
        File directorio = new File("/Documentos");
        for (File archivo : directorio.listFiles())
        {
            archivoPr.setFile(archivo);
        }
        hash = archivoPr.getHash();
    }
}
