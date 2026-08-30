public class Cliente extends Persona {
    private Carrito carrito;
    private Tarjeta tarjeta;
    private Documento documento;

    public Cliente(String nombre, String documentoIdentidad) {
        super(nombre, documentoIdentidad);
        this.carrito = new Carrito();
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public void comprar() {
        if (tarjeta != null && tarjeta.verificarTarjeta()) {
            this.documento = new Documento("Factura de compra");
        }
    }
}