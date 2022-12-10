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
public class Titulo {

    private String idTitulo;
    private String idCategoria;
    private String nombreTitulo;
    private String cantidad;

    public Titulo(String idTitulo, String idCategoria, String nombreTitulo, String cantidad) {
        this.idTitulo = idTitulo;
        this.idCategoria = idCategoria;
        this.nombreTitulo = nombreTitulo;
        this.cantidad = cantidad;
    }

    public Titulo() {

    }

    public String getIdTitulo() {
        return idTitulo;
    }

    public void setIdTitulo(String idTitulo) {
        this.idTitulo = idTitulo;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreTitulo() {
        return nombreTitulo;
    }

    public void setNombreTitulo(String nombreTitulo) {
        this.nombreTitulo = nombreTitulo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public int ingresarCategoria(Titulo objTitulo) {
        Conexion objConexion = new Conexion();
        String idCategoria = "";
        String nombreTitulo = "";
        String cantidad = "";

        try {
            idCategoria = objTitulo.getIdCategoria();
            nombreTitulo = objTitulo.getNombreTitulo();
            cantidad = objTitulo.getCantidad();
            String datos = String.format("INSERT INTO titulos ( idcategoria, nombretitulo, cantidad ) VALUES ('%s' , '%s' , '%s')", idCategoria, nombreTitulo, cantidad);
            objConexion.ejecutarSentenciaSQL(datos);
            return 1;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return 0;
        }

    }

    public ResultSet obtenerTitulos() {
        Conexion objConexion = new Conexion();

        try {
            ResultSet resultado = objConexion.consultarDatos("SELECT * FROM titulos");
            return resultado;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public int editarTitulo(Titulo objTitulo) {
        Conexion objConexion = new Conexion();
        String idTitulo = "";
        String idCategoria = "";
        String nombreTitulo = "";
        String Cantidad = "";

        try {
            idCategoria = objTitulo.getIdCategoria();
            idTitulo = objTitulo.getIdTitulo();
            nombreTitulo = objTitulo.getNombreTitulo();
            Cantidad = objTitulo.getCantidad();

            String datos = String.format("UPDATE titulos SET idcategoria=' " + idCategoria + "',nombretitulo='" + nombreTitulo + "',cantidad='" + Cantidad + "' where idtitulo='" + idTitulo + " ' ");
            objConexion.ejecutarSentenciaSQL(datos);

            return 1;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return 0;
        }

    }

    public int eliminarTitulo(String id) {

        Conexion objConexion = new Conexion();

        try {
            String datos = String.format("DELETE FROM titulos WHERE idtitulo='" + id + "' ");
            objConexion.ejecutarSentenciaSQL(datos);
            return 1;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return 0;
        }

    }
    
    
    

}
