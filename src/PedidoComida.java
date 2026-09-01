public class PedidoComida extends Pedido {
    private String restaurante;

    public PedidoComida(String id, String cliente, String direccion, String restaurante) {
        super(id, cliente, direccion);
        this.restaurante = restaurante;
    }

    @Override
    public int calcularTiempoEntrega() {
        return 35; // 35 minutos estándar
    }

    @Override
    public void asignarRepartidor() {
        this.repartidor = "Repartidor Automático (Mochila Térmica)";
        this.estado = "Repartidor Asignado";
        registrarEvento("Asignación automática: Repartidor con equipo térmico para " + restaurante);
        System.out.println("[" + id + "] Asignación automática de Comida completada.");
    }
}