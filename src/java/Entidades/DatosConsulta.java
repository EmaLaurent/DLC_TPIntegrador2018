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
public class DatosConsulta implements Comparable<DatosConsulta>
{
    String termino;
    int nr;

    public DatosConsulta()
    {
        termino = "";
        nr = 0;
    }
    
    public DatosConsulta(String termino, int nr)
    {
        this.termino = termino;
        this.nr = nr;
    }

    public String getTermino()
    {
        return termino;
    }

    public void setTermino(String termino)
    {
        this.termino = termino;
    }

    public int getNr()
    {
        return nr;
    }

    public void setNr(int nr)
    {
        this.nr = nr;
    }

    @Override
    public int compareTo(DatosConsulta obj)
    {
        return nr - obj.getNr();
    }
}
