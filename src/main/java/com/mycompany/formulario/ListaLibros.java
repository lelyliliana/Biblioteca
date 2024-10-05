package com.mycompany.formulario;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author leli
 */
public class ListaLibros {
    private NodoLibro cabeza;

    public ListaLibros() {
        this.cabeza = null;
    }

    // Método para agregar un nuevo libro a la lista
    public void agregarLibro(String titulo) {
        NodoLibro nuevoNodo = new NodoLibro(titulo);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoLibro actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    // Método para verificar si un libro ya existe en la lista
    public boolean existeLibro(String titulo) {
        NodoLibro actual = cabeza;
        while (actual != null) {
            if (actual.titulo.equalsIgnoreCase(titulo)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // Método para obtener todos los libros en la lista
    public String[] obtenerLibros() {
        List<String> libros = new ArrayList<>();
        NodoLibro actual = cabeza;
        while (actual != null) {
            libros.add(actual.titulo);
            actual = actual.siguiente;
        }
        return libros.toArray(new String[0]);
    }
}
