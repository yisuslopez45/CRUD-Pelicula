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
public class Categoria {

    private String idCategoria;
    private String nombre;

    public Categoria(String idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }

    public Categoria() {

    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String toString(){
        return idCategoria+" - "+nombre;
    }
    
    public int ingresarCategoria(Categoria objCategoria) {
        Conexion objConexion = new Conexion();
        String nombre = "";

        try {
            nombre = objCategoria.getNombre();
            String datos = String.format("INSERT INTO categorias (  nombre ) VALUES ('%s')", nombre);
            objConexion.ejecutarSentenciaSQL(datos);
            return 1;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return 0;
        }

    }

    public ResultSet obtenerCategorias() {
        Conexion objConexion = new Conexion();

        try {
            ResultSet resultado = objConexion.consultarDatos("SELECT * FROM categorias");
            return resultado;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public int editarCategoria(Categoria objCategoria) {
        Conexion objConexion = new Conexion();
        String idCategoria = "";
        String nombre = "";

        try {
            idCategoria = objCategoria.getIdCategoria();
            nombre = objCategoria.getNombre();

            String datos = String.format("UPDATE categorias SET idcategoria=' " + idCategoria + "',nombre='" + nombre + "' where idcategoria='" + idCategoria + " ' ");
            objConexion.ejecutarSentenciaSQL(datos);

            return 1;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return 0;
        }

    }

    public int eliminarCategoria(String id) {
        
        Conexion objConexion = new Conexion();
        
        try {
            String datos = String.format("DELETE FROM categorias WHERE idcategoria='" + id + "' ");
            objConexion.ejecutarSentenciaSQL(datos);
            return 1;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
            return 0;
        }

    }

}
