package com.mycompany.formulario;

/**
 *
 * @author leli
 */
public class NodoLibro {
    String titulo;
    NodoLibro siguiente;

    public NodoLibro(String titulo) {
        this.titulo = titulo;
        this.siguiente = null;
    }
}
