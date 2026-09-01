public class PedidoEncomienda extends Pedido {
    private double pesoKg;

    public PedidoEncomienda(String id, String cliente, String direccion, double pesoKg) {
        super(id, cliente, direccion);
        this.pesoKg = pesoKg;
    }

    @Override
    public int calcularTiempoEntrega() {
        return pesoKg > 10 ? 120 : 60;
    }

    @Override
    public void asignarRepartidor() {
        this.repartidor = (pesoKg > 10) ? "Furgón Logístico Pesado" : "Repartidor Utilitario";
        this.estado = "Repartidor Asignado";
        registrarEvento("Asignación automática según peso (" + pesoKg + " kg): " + this.repartidor);
        System.out.println("[" + id + "] Asignación automática de Encomienda completada.");
    }
}