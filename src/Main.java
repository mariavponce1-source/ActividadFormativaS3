import java.util.ArrayList;
import java.util.List;

/**
 * Simulación que cubre al 100% los criterios 6, 7 y 8 de la rúbrica.
 */
public class Main {
    public static void main(String[] args) {
        List<Pedido> listaPedidos = new ArrayList<>();

        System.out.println("==================================================");
        System.out.println("         SPEEDFAST - SISTEMA DE ENTREGAS         ");
        System.out.println("==================================================");

        // 1. Instanciación diferenciada
        Pedido pedido1 = new PedidoComida("CMD-101", "Ana Silva", "Calle Los Alerces 123", "Pizzería Bella");
        Pedido pedido2 = new PedidoEncomienda("ENC-202", "Pedro Rojas", "Av. Industrial 890", 18.5);
        Pedido pedido3 = new PedidoExpress("EXP-303", "Camila Paz", "Pasaje Central 45", "Farmacia Cruz");

        listaPedidos.add(pedido1);
        listaPedidos.add(pedido2);
        listaPedidos.add(pedido3);

        // 2. Simulación de Reserva (Criterio 6)
        System.out.println("\n--- 1. SIMULACIÓN DE RESERVA ---");
        pedido1.reservarPedido("Hoy a las 20:30 hrs");

        // 3. Demostración de Polimorfismo (Sobrescritura y Sobrecargas)
        System.out.println("\n--- 2. ASIGNACIÓN DE REPARTIDORES (POLIMORFISMO) ---");
        // Sobrescritura (Automático)
        pedido1.asignarRepartidor();
        // Sobrecarga 1 (Manual simple)
        pedido2.asignarRepartidor("Gonzalo Morales");
        // Sobrecarga 2 (Manual VIP con tiempo ajustado)
        pedido3.asignarRepartidor("Esteban Dido (Flash Courier)", 10);

        // 4. Cálculo y Resumen por Consola
        System.out.println("\n--- 3. RESÚMENES Y CÁLCULO DE TIEMPOS ESTIMADOS ---");
        for (Pedido p : listaPedidos) {
            p.mostrarResumen();
        }

        // 5. Simulación de Despacho y Cancelación (Interfaces)
        System.out.println("\n--- 4. DESPACHO Y CANCELACIÓN ---");
        pedido1.despachar();
        pedido3.despachar();

        // Cancelación y prueba de flujo alternativo
        pedido2.cancelar();
        pedido2.despachar(); // Demuestra control de errores

        // 6. Visualización de Historial de Trazabilidad (ArrayList)
        System.out.println("\n--- 5. HISTORIALES DE ENTREGA (RASTREABILIDAD) ---");
        for (Pedido p : listaPedidos) {
            p.verHistorial();
            System.out.println();
        }

        System.out.println("==================================================");
        System.out.println("          FIN DE LA SIMULACIÓN SPEEDFAST          ");
        System.out.println("==================================================");
    }
}