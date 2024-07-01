package edu.siglo21.app.Model;

import javafx.collections.ObservableList;

import java.util.Date;
import java.util.Set;

public interface ArticuloDAO {
    ObservableList<Articulo> getArticulo(String codigo, String nombre, String descripcion);

    ObservableList<Articulo> getAllArticulos();

    Articulo getArticuloById(int id);

    int insertArticulo(Articulo a);

    boolean updateArticulo();
    boolean deleteArticulo();
}
