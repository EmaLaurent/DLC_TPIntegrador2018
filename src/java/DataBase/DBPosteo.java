/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Entidades.DatosPosteo;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Emanuel Laurent
 */
public class DBPosteo
{
//    private final String URL ="jdbc:sqlserver://PC-Laurent:1433;databaseName=DLC_MotorDeBusqueda;integratedSecurity=true";
    private final String URL ="jdbc:sqlserver://EMA-LENOVO:1433;databaseName=DLC_MotorDeBusqueda;integratedSecurity=true";
//    private final String URL =""; 
//    private final String URL ="";
    private Connection con;
    String query = "";
    PreparedStatement pstmt;
    ResultSet rs;
    
    public void iniciar()
            throws ClassNotFoundException, SQLException
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        con = DriverManager.getConnection(URL);
    }
    
    public void finalizar()
            throws SQLException
    {
        con.close();
    }
    
    public void insertarPosteo(String termino, DatosPosteo dp)
            throws SQLException
    {
        query = "Insert into Posteo values (?,?,?)";
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, termino);
        pstmt.setString(2, dp.getNombreDocumento());
        pstmt.setInt(3, dp.getTf());
        pstmt.executeUpdate();
        pstmt.close();
    }
    
    public DatosPosteo obtenerPorDocumento(String st, String nombDoc)
            throws SQLException
    {
        query = "Select documento, tf From Posteo Where termino = ? "
                + "AND documento = ?";
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, st);
        pstmt.setString(2, nombDoc);
        rs = pstmt.executeQuery();
        DatosPosteo dp = null; 
        if(rs.next())
        {
            dp = new DatosPosteo();
            dp.setNombreDocumento(rs.getString("documento"));
            dp.setTf(rs.getInt("tf"));
        }
        rs.close();
        pstmt.close();
        return dp;
    }
    
    public void actualizarPosteo(String termino, DatosPosteo dp)
            throws SQLException
    {
        query = "Update Posteo set tf = ? Where termino = ? AND documento = ?";
        pstmt = con.prepareStatement(query);
        pstmt.setInt(1, dp.getTf());
        pstmt.setString(2, termino);
        pstmt.setString(3, dp.getNombreDocumento());
        pstmt.executeUpdate();
        pstmt.close();
    }
    
    public ArrayList<DatosPosteo> obtenerPosteos(String st)
            throws SQLException
    {
        query = "SELECT TOP 50 * FROM Posteo WHERE termino = ? ORDER BY tf DESC";
        pstmt = con.prepareStatement(query);
        pstmt.setString(1, st);
        rs = pstmt.executeQuery();
        DatosPosteo dp = null;
        ArrayList<DatosPosteo> list = new ArrayList<>();
        while(rs.next())
        {
            dp = new DatosPosteo();
            dp.setNombreDocumento(rs.getString("documento"));
            dp.setTf(rs.getInt("tf"));
            list.add(dp);
        }
        rs.close();
        pstmt.close();
        return list;
    }
}
