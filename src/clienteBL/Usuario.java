/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clienteBL;

import clienteDAL.Conexion;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Yisus
 */
public class Usuario {

    private String cedula;
    private String nombreComplero;
    private String celular;
    private String dieccion;

    public Usuario(String cedula, String nombreComplero, String celular, String dieccion) {
        this.cedula = cedula;
        this.nombreComplero = nombreComplero;
        this.celular = celular;
        this.dieccion = dieccion;
    }

    public Usuario() {

    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreComplero() {
        return nombreComplero;
    }

    public void setNombreComplero(String nombreComplero) {
        this.nombreComplero = nombreComplero;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDieccion() {
        return dieccion;
    }

    public void setDieccion(String dieccion) {
        this.dieccion = dieccion;
    }

    public int ingresarUsuario(Usuario objUsuario) {
        Conexion objConexion = new Conexion();
        String cedula = "";
        String nombreCompleto = "";
        String celular = "";
        String direccion = "";

        try {
            cedula = objUsuario.getCedula();
            nombreCompleto = objUsuario.getNombreComplero();
            celular = objUsuario.getCelular();
            direccion = objUsuario.getDieccion();

            String datos = String.format("INSERT INTO usuarios ( cedula, nombrecompleto, numerocelular, direccion ) VALUES ('%s' , '%s' , '%s', '%s')", cedula, nombreCompleto, celular, direccion);
            objConexion.ejecutarSentenciaSQL(datos);
            return 1;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return 0;
        }

    }

    public ResultSet obtenerUsuarios() {
        Conexion objConexion = new Conexion();
        try {
            ResultSet resultado = objConexion.consultarDatos("SELECT * FROM usuarios");
            return resultado;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public int editarUsuario(Usuario objUsuario) {
        Conexion objConexion = new Conexion();
        String cedula = "";
        String nombreCompleto = "";
        String celular = "";
        String direccion = "";

        try {
            cedula = objUsuario.getCedula();
            nombreCompleto = objUsuario.getNombreComplero();
            celular = objUsuario.getCelular();
            direccion = objUsuario.getDieccion();

            String datos = String.format("UPDATE usuarios SET nombrecompleto=' " + nombreCompleto + "',numerocelular='" + celular + "',direccion='" + direccion + "' where cedula='" + cedula + " ' ");
            objConexion.ejecutarSentenciaSQL(datos);

            return 1;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return 0;
        }

    }
    
       public int eliminarUsuario(String id) {

        Conexion objConexion = new Conexion();

        try {
            String datos = String.format("DELETE FROM usuarios WHERE cedula='" + id + "' ");
            objConexion.ejecutarSentenciaSQL(datos);
            return 1;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return 0;
        }

    }

}
