/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Entidades.DatosPosteo;
import java.sql.*;

/**
 *
 * @author Emanuel Laurent
 */
public class DBPosteo
{
    private final String URL ="jdbc:sqlserver://PC-Laurent:1433;databaseName=DLC_MotorDeBusqueda;integratedSecurity=true";
//    private final String URL =""; 
//    private final String URL ="";
    
    public void insertarPosteo(String termino, DatosPosteo dp)
            throws ClassNotFoundException, SQLException
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(URL);
        String query = "Insert into Posteo values (?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, termino);
        pstmt.setString(2, dp.getNombreDocumento());
        pstmt.setInt(3, dp.getTf());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }
    
    public DatosPosteo obtenerPorDocumento(String st, String nombDoc)
            throws ClassNotFoundException, SQLException
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(URL);
        Statement stmt = con.createStatement();
        String query = "Select documento, tf From Posteo Where termino LIKE '" + 
                st + "' AND documento LIKE '" + nombDoc + "'";
        ResultSet rs = stmt.executeQuery(query);
        DatosPosteo dp = null; 
        if(rs.next())
        {
            dp = new DatosPosteo();
            dp.setNombreDocumento(rs.getString("documento"));
            dp.setTf(rs.getInt("tf"));
        }
        return dp;
    }
    
    public void actualizarPosteo(String termino, DatosPosteo dp)
            throws ClassNotFoundException, SQLException
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(URL);
        String query = "Update Posteo set tf = ? Where termino LIKE ? AND documento LIKE ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, dp.getTf());
        pstmt.setString(2, termino);
        pstmt.setString(3, dp.getNombreDocumento());
        pstmt.executeUpdate();
        pstmt.close();
        con.close();
    }
}
