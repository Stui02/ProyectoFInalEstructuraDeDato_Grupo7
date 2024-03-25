package com.mycompany.proyectofinalestructuradedato_grupo7;

/**
 *
 * @author stu22
 */
public class FabricaAutos {

    private Pedido inicio;
    private Pedido fin;
    private int dinero;
    private int ordenesPerdidas;
    private int maxEspacios;
    private cintaTransportadora cintaTransportadora;

    public FabricaAutos(int dineroInicial, int ordenesPerdidasInicial, int maxEspacios) {
        this.dinero = dineroInicial;
        this.ordenesPerdidas = ordenesPerdidasInicial;
        this.maxEspacios = maxEspacios;
        this.cintaTransportadora = new cintaTransportadora(maxEspacios);
    }

    public void recibirPedido(Pedido pedido) {
        if (inicio == null) {
            inicio = pedido;
            fin = pedido;
        } else {
            fin.setSiguiente(pedido);
            pedido.setAnterior(fin);
            fin = pedido;
        }
    }

    public Pedido atenderPedido() {
        if (inicio == null) {
            return null;
        }
        Pedido pedido = inicio;
        inicio = inicio.getSiguiente();
        if (inicio != null) {
            inicio.setAnterior(null);
        }
        return pedido;
    }

    private int generarNumeroAleatorio(int maximo) {
        return (int) (Math.random() * maximo);
    }

    public void generarMateriales() {
        int valorAleatorio = generarNumeroAleatorio(100);
        Material nuevoMaterial = new Material("Material" + valorAleatorio, valorAleatorio);
        int cantidadMaxima = 3; // Cantidad máxima de materiales en la cinta transportadora
        if (cintaTransportadora.getCantidad() < cantidadMaxima) {
            cintaTransportadora.agregarMaterial(nuevoMaterial);
        }
    }

    public cintaTransportadora getCintaTransportadora() {
        return cintaTransportadora;
    }

    public void construirAutos() {
        Pedido pedidoActual = inicio;
        while (pedidoActual != null && cintaTransportadora.getCantidad() > 0) {
            Auto nuevoAuto = new Auto(pedidoActual.getTipo());
            Material materialActual = cintaTransportadora.obtenerMaterial();
            while (materialActual != null) {
                nuevoAuto.agregarMaterial(materialActual);
                materialActual = cintaTransportadora.obtenerMaterial();
            }
            dinero += calcularGanancia(nuevoAuto);
            pedidoActual = pedidoActual.getSiguiente();
        }
    }

    public int calcularGanancia(Auto auto) {
        int ganancia = 0;
        Material materiales = auto.getMateriales();
        while (materiales != null) {
            ganancia += materiales.getValor();
            materiales = materiales.getSiguiente();
        }
        return ganancia;
    }

    public int getDinero() {
        return dinero;
    }

    public int getOrdenesPerdidas() {
        return ordenesPerdidas;
    }
}
