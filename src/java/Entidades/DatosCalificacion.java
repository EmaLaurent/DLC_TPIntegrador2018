/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Manuel
 */
public class DatosCalificacion
{
    String nombreDoc;
    int tf;
    
    public DatosCalificacion()
    {
        this("", 0);
    }

    public DatosCalificacion(String nombreDoc, int tf)
    {
        this.nombreDoc = nombreDoc;
        this.tf = tf;
    }
    
    public String getNombreDoc()
    {
        return nombreDoc;
    }

    public void setNombreDoc(String nombreDoc)
    {
        this.nombreDoc = nombreDoc;
    }

    public int getTf()
    {
        return tf;
    }

    public void setTf(int tf)
    {
        this.tf = tf;
    }

    @Override
    public boolean equals(Object o) 
    {
        if (o == this) 
        {
            return true;
        }
 
        if (!(o instanceof DatosCalificacion)) 
        {
            return false;
        }
         
        DatosCalificacion c = (DatosCalificacion) o;
         
        // Compare the data members and return accordingly 
        return this.nombreDoc.equals(c.nombreDoc);
    }

    
}
