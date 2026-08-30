public class Tarjeta {
    private String numeroTarjeta;
    private Banco banco;

    public Tarjeta(String numeroTarjeta, Banco banco) {
        this.numeroTarjeta = numeroTarjeta;
        this.banco = banco;
    }

    public boolean verificarTarjeta() {
        return banco != null && banco.validarTransaccion();
    }
}