/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Manuel Carballido
 */
public class DatosPosteo
{
    private String nombreDocumento;
    private int tf;
    
    public DatosPosteo()
    {
        
    }
    
    public DatosPosteo(String nombDoc)
    {
        nombreDocumento = nombDoc;
        tf = 1;
    }
    
    public DatosPosteo(String nombDoc, int tf)
    {
        nombreDocumento = nombDoc;
        this.tf = tf;
    }

    public String getNombreDocumento()
    {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombDoc)
    {
        this.nombreDocumento = nombDoc;
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
