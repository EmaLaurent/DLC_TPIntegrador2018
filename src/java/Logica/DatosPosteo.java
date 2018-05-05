/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;

/**
 *
 * @author Manuel Carballido
 */
public class DatosPosteo
{
    private File archivo;
    private int tf;
    
    public DatosPosteo(File arch)
    {
        archivo = arch;
        tf = 1;
    }

    public File getArchivo()
    {
        return archivo;
    }

    public void setArchivo(File archivo)
    {
        this.archivo = archivo;
    }

    public int getTf()
    {
        return tf;
    }

    public void setTf(int tf)
    {
        this.tf = tf;
    }
    
    
}
