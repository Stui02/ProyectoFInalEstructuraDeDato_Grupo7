package com.mycompany.proyectofinalestructuradedato_grupo7;

/**
 *
 * @author stu22
 */
public class Auto {

    private String modelo;
    private Material materiales;

    public Auto(String modelo) {
        this.modelo = modelo;
        this.materiales = null;
    }

    public void agregarMaterial(Material material) {
        if (materiales == null) {
            materiales = material;
        } else {
            Material temp = materiales;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(material);
            material.setAnterior(temp);
        }
    }

    public String getModelo() {
        return modelo;
    }

    public Material getMateriales() {
        return materiales;
    }
}
