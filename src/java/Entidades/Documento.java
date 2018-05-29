/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Emanuel Laurent
 */
public class Documento
{
    private String nombArchivo;
    private String titulo;
    private String intro = "";
    private String path;
//    private final String PATHDOCUMENTOS = "D:/Usuarios/Ema/Mis Documentos/Facu UTN/2018/DLC/DLC_TPIntegrador2018/Documentos/";
    private final String PATHDOCUMENTOS = "E:/Users/milen/Documents/Facu UTN/2018/DLC/DLC_TPIntegrador2018/Documentos/";
//    private final String PATHDOCUMENTOS = "";
    
    public Documento()
    {
            
    }

    public Documento(String nombArchivo, String titulo, String intro, String path)
    {
        this.nombArchivo = nombArchivo;
        this.titulo = titulo;
        this.intro = intro;
        this.path = path;
    }
    
    public String getNombArchivo()
    {
        return nombArchivo;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public String getIntro()
    {
        return intro;
    }

    public String getPath()
    {
        return path;
    }
    
    public void setNombArchivo(String nombArchivo)
    {
        this.nombArchivo = nombArchivo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public void setIntro(String intro)
    {
        this.intro = intro;
    }
    
    public void obtenerInfo(String archivo)
    {
        try
        {
            File file = new File(PATHDOCUMENTOS + archivo);
            String regex = "[^a-zA-ZñÑá-úÁ-Ú\']";
            Scanner scanner = new Scanner(file,"ISO-8859-1").useDelimiter(regex);
            String aux;
            titulo = scanner.nextLine();
            if(titulo.equals(""))
                titulo = scanner.nextLine();
            nombArchivo = archivo;
            path = PATHDOCUMENTOS + archivo;
            for(int i = 0; i<6;)
            {
                aux = scanner.nextLine();
                if(!aux.equals(""))
                {
                    intro += aux + " ";
                    i++;
                }
            }
            intro += "...";
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Error al leer el archivo: " + ex.getMessage());
        }
    }
}
