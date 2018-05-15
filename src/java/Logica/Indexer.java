/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entidades.DatosTermino;
import java.io.File;

/**
 *
 * @author Emanuel Laurent
 */
public class Indexer
{
    private ProcesadorArchivo archivoPr;
    private TSB_OAHashtable<String,DatosTermino> hash;
    private final String PATHINDEXACION = "D:/Usuarios/Ema/Mis Documentos/Facu UTN/2018/DLC/DLC_TPIntegrador2018/Documentos"; 
//    private final String PATHINDEXACION = "";
//    private final String PATHINDEXACION = "";
    
    public Indexer()
    {
        archivoPr = new ProcesadorArchivo();
        hash = new TSB_OAHashtable<>(); 
    }

    public TSB_OAHashtable<String, DatosTermino> getHash()
    {
        return hash;
    }
    
    public void indexarDirectorio()
    {
        File directorio = new File(PATHINDEXACION);
        for (File archivo : directorio.listFiles())
        {
            archivoPr.setFile(archivo);
        }
        hash = archivoPr.getHash();
    }
}
