package com.mycompany.proyectofinalestructuradedato_grupo7;

/**
 *
 * @author Josimar
 */
public class Empleado {

    private String nombre;
    private String puesto;
    private Empleado siguiente;

    public Empleado(String nombre, String puesto) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.siguiente = null;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public Empleado getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Empleado siguiente) {
        this.siguiente = siguiente;
    }
}
