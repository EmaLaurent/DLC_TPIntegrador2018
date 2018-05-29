/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entidades.DatosTermino;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Emanuel Laurent
 */
public class Indexer
{
    private ProcesadorArchivo archivoPr;
    private TSB_OAHashtable<String,DatosTermino> hash;
//    private final String PATHINDEXACION = "D:/Usuarios/Ema/Mis Documentos/Facu UTN/2018/DLC/DLC_TPIntegrador2018/Documentos";
    private final String PATHINDEXACION = "E:/Users/milen/Documents/Facu UTN/2018/DLC/DLC_TPIntegrador2018/Documentos";
//    private final String PATHINDEXACION = "d:\\Users\\Manuel\\Desktop\\UTN\\[DLC] Diseño de Lenguajes de Consulta\\TPIntegrador\\docs7";
//    private final String PATHINDEXACION = "";
    private int contador;
    
    public Indexer()
    {
        archivoPr = new ProcesadorArchivo();
        hash = new TSB_OAHashtable<>();
        contador = 0;
    }

    public Indexer(TSB_OAHashtable<String, DatosTermino> hash)
    {
        archivoPr = new ProcesadorArchivo(hash);
        this.hash = hash;
        contador = 0;
    }
    
    public TSB_OAHashtable<String, DatosTermino> getHash()
    {
        return hash;
    }
    
    public void indexarDirectorio()
    {
        File directorio = new File(PATHINDEXACION);
        Date date = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Inicio de proceso de indexacion a las: "+ hourFormat.format(date));
        for (File archivo : directorio.listFiles())
        {
            archivoPr.setFile(archivo);
            contador ++;
            date = new Date();
            System.out.println("Archivo ("+ archivo.getName() +") procesado con éxito! Hora: "+ hourFormat.format(date));
            System.out.println("Archivos procesados : "+ contador);
            System.out.println("Palabras indexadas :" + archivoPr.getHash().size());
        }
        hash = archivoPr.getHash();
    }
    
    public void indexarArchivo(File archivo)
    {
        Date date = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Inicio de proceso de indexacion a las: "+ hourFormat.format(date));
        archivoPr.setFile(archivo);
        System.out.println("Archivo ("+ archivo.getName() +") procesado con éxito! Hora: "+ hourFormat.format(date));
    }
}
