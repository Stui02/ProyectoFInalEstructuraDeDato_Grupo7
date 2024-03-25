
package com.mycompany.proyectofinalestructuradedato_grupo7;

/**
 *
 * @author Josimar
 */
public class AscensoEmpresa {
    private Empleado primerEmpleado;

    public AscensoEmpresa() {
        // Inicializar los empleados
        agregarEmpleado("Valeria", "Gerente Regional 1");
        agregarEmpleado("Christopher", "Gerente Regional 1");
        agregarEmpleado("Martina", "Gerente Regional 2");
        agregarEmpleado("Jugador", "Gerente Regional 2");
        agregarEmpleado("Veronica", "Gerente Regional 3");
        agregarEmpleado("Isabel", "Gerente Regional 3");
        agregarEmpleado("Andrew", "Gerente Regional 4");
        agregarEmpleado("Daniel", "Gerente Regional 4");
    }

    public void comenzarAscenso() {
        // Primera ronda
        System.out.println("Primera Ronda:\n");
        realizarRonda();

        // Segunda ronda
        System.out.println("\nSegunda Ronda:\n");
        realizarRonda();

        // Ronda final
        System.out.println("\nRonda Final:\n");
        realizarRonda();
        System.out.println("¡Ascenso completado!\n\n");
    }

    private void realizarRonda() {
        // Realizar la ronda
        Empleado actual = primerEmpleado;
        while (actual != null && actual.getSiguiente() != null) {
            System.out.println(actual.getNombre() + " vs " + actual.getSiguiente().getNombre() + " por " + actual.getPuesto());
            actual = actual.getSiguiente().getSiguiente();
        }
    }

    private void agregarEmpleado(String nombre, String puesto) {
        Empleado nuevoEmpleado = new Empleado(nombre, puesto);
        if (primerEmpleado == null) {
            primerEmpleado = nuevoEmpleado;
        } else {
            Empleado actual = primerEmpleado;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoEmpleado);
        }
    }
}