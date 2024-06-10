package edu.siglo21.app.Model;

import edu.siglo21.app.App;

import java.util.Calendar;
import java.util.Date;

public class Articulo {
    private int idArticulo;
    private String codigo;
    private String nombre;
    private String descripcion;
    private String categoria;
    private String marca;
    private String unidadMedida;
    private Date fechaEntrada;
    private Date fechaVencimiento;
    private int alerta;
    private int cantidad;
    private String proveedor;

    public Articulo(Integer ArticuloN, String codigo, String nombre, String descripcion, String categoria, String marca, String unidadMedida,Date fechaEntrada , Date fechaVencimiento
            , Integer cantidad, Integer alerta, String proveedor){
        this.setIdArticulo(ArticuloN);
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

    private void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida;}

    public int getIdArticulo() {
        return idArticulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setIdArticulo(int idArticulo) {
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
        this.marca = marca;
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

    public int getAlerta() {
        return alerta;
    }

    public void setAlerta(int alerta) {
        this.alerta = alerta;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
}
