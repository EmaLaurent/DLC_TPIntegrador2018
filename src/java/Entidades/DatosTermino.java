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
public class DatosTermino
{
    private int nr;
    private int maxTf;

    public DatosTermino()
    {
        nr = 1;
        maxTf = 1;
    }

    public DatosTermino(int nr, int maxTf)
    {
        this.nr = nr;
        this.maxTf = maxTf;
    }

    public int getNr()
    {
        return nr;
    }

    public int getMaxTf()
    {
        return maxTf;
    }

    public void setNr(int nr)
    {
        this.nr = nr;
    }

    public void setMaxTf(int maxTf)
    {
        this.maxTf = maxTf;
    }

    @Override
    public String toString()
    {
        return "DatosTermino{" + "nr=" + nr + ", maxTf=" + maxTf + '}';
    }
}
