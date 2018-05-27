/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Emanuel Laurent
 */
public class ResultadoDeBusqueda
{
    private Documento doc;
    private float calificacion;

    public ResultadoDeBusqueda()
    {
        
    }

    public ResultadoDeBusqueda(Documento doc, float calificacion)
    {
        this.doc = doc;
        this.calificacion = calificacion;
    }

    public Documento getDoc()
    {
        return doc;
    }

    public float getCalificacion()
    {
        return calificacion;
    }

    public void setDoc(Documento doc)
    {
        this.doc = doc;
    }

    public void setCalificacion(float calificacion)
    {
        this.calificacion = calificacion;
    }
}
