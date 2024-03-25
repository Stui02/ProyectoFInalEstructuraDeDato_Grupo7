/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectofinalestructuradedato_grupo7;

/**
 *
 * @author stu22
 */
public class ProyectoFInalEstructuraDeDato_Grupo7 {

    private static final int TIEMPO_JUEGO_SEGUNDOS = 120;
    private static final int TIEMPO_ENTRADA_ORDEN_SEGUNDOS = 12;

    private static Pedido generarPedidoAleatorio() {
        int tipoAleatorio = (int) (Math.random() * 4);
        String tipoPedido;
        switch (tipoAleatorio) {
            case 0:
                tipoPedido = "sedan de lujo";
                break;
            case 1:
                tipoPedido = "suv de lujo";
                break;
            case 2:
                tipoPedido = "pick-up de alta gama";
                break;
            case 3:
                tipoPedido = "maquinaria de alta gama para trabajos pesados";
                break;
            default:
                tipoPedido = "sedan de lujo";
                break;
        }
        return new Pedido(tipoPedido);
    }

    public static void main(String[] args) {

        AscensoEmpresa ascensoEmpresa = new AscensoEmpresa();

        ascensoEmpresa.comenzarAscenso();
        FabricaAutos fabrica = new FabricaAutos(3, 0, 3);

        long startTime = System.currentTimeMillis();
        long endTime = startTime + (TIEMPO_JUEGO_SEGUNDOS * 1000);

        while (System.currentTimeMillis() < endTime) {
            Pedido pedido = generarPedidoAleatorio();
            fabrica.recibirPedido(pedido);
            fabrica.generarMateriales();
            fabrica.construirAutos();

            // Salida de información para verificar el funcionamiento
            System.out.println("Pedido recibido: " + pedido.getTipo());
            System.out.println("Materiales en la cinta transportadora: " + fabrica.getCintaTransportadora().getCantidad());
            System.out.println("Dinero acumulado: " + fabrica.getDinero());
            System.out.println("---------------------------------------");

            try {
                Thread.sleep(TIEMPO_ENTRADA_ORDEN_SEGUNDOS * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Tiempo de juego terminado");
    }
}
