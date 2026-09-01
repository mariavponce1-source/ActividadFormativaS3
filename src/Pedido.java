import java.util.ArrayList;
import java.util.List;

/**
 * Criterios 1, 3, 4, 5 y 9:
 * Clase abstracta que centraliza atributos, implementa 3 interfaces
 * y define métodos concretos y abstractos.
 */
public abstract class Pedido implements Despachable, Cancelable, Rastreable {
    protected String id;
    protected String cliente;
    protected String direccion;
    protected String repartidor;
    protected String estado;
    protected int tiempoAjustado;
    protected List<String> historial;

    public Pedido(String id, String cliente, String direccion) {
        this.id = id;
        this.cliente = cliente;
        this.direccion = direccion;
        this.repartidor = "No asignado";
        this.estado = "Creado";
        this.tiempoAjustado = 0;
        this.historial = new ArrayList<>();
        registrarEvento("Pedido creado en el sistema.");
    }

    // --- MÉTODOS ABSTRACTOS ---
    public abstract int calcularTiempoEntrega();

    // --- POLIMORFISMO: SOBRESCRITURA EN SUBCLASES ---
    public abstract void asignarRepartidor();

    // --- POLIMORFISMO: SOBRECARGA (Ejemplo 1) ---
    public void asignarRepartidor(String nombre) {
        this.repartidor = nombre;
        this.estado = "Repartidor Asignado Manualmente";
        registrarEvento("Repartidor manual asignado: " + nombre);
        System.out.println("[" + id + "] Repartidor manual asignado: " + nombre);
    }

    // --- POLIMORFISMO: SOBRECARGA (Ejemplo 2 - Requisito Criterio 2) ---
    public void asignarRepartidor(String nombre, int tiempoPersonalizado) {
        this.repartidor = nombre;
        this.tiempoAjustado = tiempoPersonalizado;
        this.estado = "Repartidor VIP/Manual con tiempo ajustado";
        registrarEvento("Repartidor VIP " + nombre + " asignado con tiempo fijado a " + tiempoPersonalizado + " min.");
        System.out.println("[" + id + "] Repartidor VIP: " + nombre + " (Tiempo ajustado a " + tiempoPersonalizado + " mins)");
    }

    // --- FUNCIONALIDAD: RESERVA (Requisito Criterio 6) ---
    public void reservarPedido(String fechaHora) {
        this.estado = "Reservado para: " + fechaHora;
        registrarEvento("Pedido programado/reservado para: " + fechaHora);
        System.out.println("[" + id + "] Pedido programado con éxito para: " + fechaHora);
    }

    // --- REUTILIZACIÓN DE MÉTODOS BASE ---
    public void mostrarResumen() {
        int tiempoFinal = (tiempoAjustado > 0) ? tiempoAjustado : calcularTiempoEntrega();
        System.out.println("------------------------------------------");
        System.out.println("ID: " + id + " | Tipo: " + this.getClass().getSimpleName());
        System.out.println("Cliente: " + cliente + " | Destino: " + direccion);
        System.out.println("Repartidor: " + repartidor);
        System.out.println("Estado: " + estado);
        System.out.println("Tiempo estimado de entrega: " + tiempoFinal + " minutos");
        System.out.println("------------------------------------------");
    }

    @Override
    public void despachar() {
        if (!estado.equals("Cancelado")) {
            this.estado = "En Ruta";
            registrarEvento("Despacho iniciado hacia " + direccion);
            System.out.println("[" + id + "] Despachado con éxito.");
        } else {
            System.out.println("[" + id + "] ERROR: No se puede despachar un pedido en estado Cancelado.");
        }
    }

    @Override
    public void cancelar() {
        this.estado = "Cancelado";
        registrarEvento("Pedido cancelado por el cliente/sistema.");
        System.out.println("[" + id + "] El pedido ha sido marcado como CANCELADO.");
    }

    @Override
    public void verHistorial() {
        System.out.println("=== Historial de Trazabilidad [" + id + "] ===");
        for (String ev : historial) {
            System.out.println("  • " + ev);
        }
    }

    protected void registrarEvento(String evento) {
        this.historial.add(evento);
    }
}