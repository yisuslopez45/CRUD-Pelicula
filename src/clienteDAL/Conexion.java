/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clienteDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Yisus
 */
public class Conexion {

    Connection conn = null;

    private String host = "localhost";
    private String puerto = "5432";
    private String db = "PruebaCine";
    private String user = "postgres";
    private String pass = "root";

    public  Conexion() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://" + host + ":" + puerto + "/" + db;
            conn = DriverManager.getConnection(url, user, pass);
            
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public int ejecutarSentenciaSQL(String strSentenciaSQL) {
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }

    public ResultSet consultarDatos(String strSentenciaSQL) {
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
