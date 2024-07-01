package edu.siglo21.app.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Articulo implements ArticuloDAO{
    private Integer idArticulo;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String categoria;
    private String marca;
    private String unidadMedida;
    private Date fechaEntrada;
    private Date fechaVencimiento;
    private Integer alerta;
    private Integer cantidad;
    private String proveedor;

    public Articulo(String codigo, String nombre, String descripcion, String categoria, String marca, String unidadMedida,Date fechaEntrada , Date fechaVencimiento
            , Integer cantidad, Integer alerta, String proveedor){
        this.setCodigo(codigo);
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setCategoria(categoria);
        this.setMarca(marca);
        this.setUnidadMedida(unidadMedida);
        this.setFechaEntrada(fechaEntrada);
        this.setFechaVencimiento(fechaVencimiento);
        this.setAlerta(alerta);
        this.setCantidad(cantidad);
        this.setAlerta(alerta);
        this.setProveedor(proveedor);

    }
    public Articulo(Integer id, String codigo, String nombre, String descripcion, String categoria, String marca, String unidadMedida,Date fechaEntrada , Date fechaVencimiento
            , Integer cantidad, Integer alerta, String proveedor){
        this.setIdArticulo(id);
        this.setCodigo(codigo);
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setCategoria(categoria);
        this.setMarca(marca);
        this.setUnidadMedida(unidadMedida);
        this.setFechaEntrada(fechaEntrada);
        this.setFechaVencimiento(fechaVencimiento);
        this.setAlerta(alerta);
        this.setCantidad(cantidad);
        this.setAlerta(alerta);
        this.setProveedor(proveedor);
    }

    public Articulo(){

    }

    private void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida;}

    public Integer getIdArticulo() {
        return idArticulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setIdArticulo(Integer idArticulo) {
        this.idArticulo = idArticulo+1;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String idMarca) {
        this.marca = idMarca;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getAlerta() {
        return alerta;
    }

    public void setAlerta(Integer alerta) {
        this.alerta = alerta;
    }


    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public ObservableList<Articulo> getArticulo(String codigo, String nombre, String descripcion) {

        ObservableList<Articulo> articulos = FXCollections.observableArrayList();
        Connection connection = conexionFabrica.getConexion();

        try{
            String sp = "{ CALL `seminario`.`articulo_buscar`(?,?,?)}";
            CallableStatement cs = connection.prepareCall(sp);
            //Registrar los 3 parametros de entrada y los 11 parametros de salida


            //Entrada 3 parametros
            cs.setString(1, codigo);
            cs.setString(2, nombre);
            cs.setString(3, descripcion);

            //SALIDA 12 parametros
            /*
            cs.registerOutParameter(1, Types.INTEGER);
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.registerOutParameter(5, Types.VARCHAR);
            cs.registerOutParameter(6, Types.VARCHAR);
            cs.registerOutParameter(7, Types.VARCHAR);
            cs.registerOutParameter(8, Types.DATE);
            cs.registerOutParameter(9, Types.DATE);
            cs.registerOutParameter(10, Types.INTEGER);
            cs.registerOutParameter(11, Types.INTEGER);
            cs.registerOutParameter(12, Types.VARCHAR);
*/
            ResultSet rs = cs.executeQuery();

            while (rs.next()){
                Articulo a = new Articulo(
                    rs.getInt("idArticulo"),
                    rs.getString("codigo"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getString("nombre_categoria"),
                    rs.getString("nombre_marca"),
                    rs.getString("unidadMedida"),
                    rs.getDate("fecha_entrada"),
                    rs.getDate("fecha_vencimiento"),
                    rs.getInt("stock_disponible"),
                    rs.getInt("stock_minimo"),
                    rs.getString("nombre_proveedor")
                );
                articulos.add(a);
            }

            rs.close();
            cs.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return articulos;
    }

    @Override
    public ObservableList<Articulo> getAllArticulos() {
        return null;
    }

    @Override
    public Articulo getArticuloById(int id) {


        return null;
    }

    @Override
    public int insertArticulo(Articulo a) {
        /*private String codigo;1
        private String nombre;2
        private String descripcion;3
        private String categoria;4
        private String marca;5
        private String unidadMedida;6
        private Date fechaEntrada;7
        private Date fechaVencimiento; 8
        private Integer alerta; 9
        private Integer cantidad;10
        private String proveedor; 11
        */
        Connection connection = conexionFabrica.getConexion();
        try{
            String sp = "{ CALL `seminario`.`articulo_nuevo`(?,?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cs = connection.prepareCall(sp);
            //Registrar los 11 parametros y el parametro de salida

            cs.setString(1, a.getCodigo());
            cs.setString(2, a.getNombre());
            cs.setString(3, a.getDescripcion());
            cs.setString(4, a.getCategoria());
            cs.setString(5, a.getMarca());
            cs.setString(6, a.getUnidadMedida());
            cs.setDate(7, new java.sql.Date(a.getFechaEntrada().getDate()));
            cs.setDate(8, new java.sql.Date(a.getFechaVencimiento().getDate()));
            cs.setInt(9, a.getAlerta());
            cs.setInt(10, a.getCantidad());
            cs.setString(11, a.getProveedor());
            cs.registerOutParameter(12, Types.INTEGER);
            cs.executeUpdate();


            a.setIdArticulo(cs.getInt(12));


        } catch (SQLException ex) {
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } catch (Exception e){
            e.printStackTrace();
        }

    return a.getIdArticulo();

    }

    @Override
    public boolean updateArticulo() {
        return false;
    }

    @Override
    public boolean deleteArticulo() {
        return false;
    }
}
