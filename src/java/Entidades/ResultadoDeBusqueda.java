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
public class ResultadoDeBusqueda implements Comparable<ResultadoDeBusqueda>
{
    private Documento doc;
    private int calificacion;

    public ResultadoDeBusqueda()
    {
        
    }

    public ResultadoDeBusqueda(Documento doc, int calificacion)
    {
        this.doc = doc;
        this.calificacion = calificacion;
    }

    public Documento getDoc()
    {
        return doc;
    }

    public int getCalificacion()
    {
        return calificacion;
    }

    public void setDoc(Documento doc)
    {
        this.doc = doc;
    }

    public void setCalificacion(int calificacion)
    {
        this.calificacion = calificacion;
    }

    @Override
    public int compareTo(ResultadoDeBusqueda o) 
    {
        return calificacion - o.getCalificacion();
    }
}
