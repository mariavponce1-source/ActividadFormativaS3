public class PedidoExpress extends Pedido {
    private String tienda;

    public PedidoExpress(String id, String cliente, String direccion, String tienda) {
        super(id, cliente, direccion);
        this.tienda = tienda;
    }

    @Override
    public int calcularTiempoEntrega() {
        return 15; // 15 minutos entrega express
    }

    @Override
    public void asignarRepartidor() {
        this.repartidor = "Repartidor Flash Prioritario";
        this.estado = "Repartidor Asignado (Alta Prioridad)";
        registrarEvento("Asignación automática exprés asignada desde " + tienda);
        System.out.println("[" + id + "] Asignación automática Express completada.");
    }
}