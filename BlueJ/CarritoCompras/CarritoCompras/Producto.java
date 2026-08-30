public class Producto {
    private String strNombre;
    private double precio;
    private int stock;
    private int diasEspera;

    public Producto(String strNombre, double precio, int stock, int diasEspera) {
        this.strNombre = strNombre;
        this.precio = precio;
        this.stock = stock;
        this.diasEspera = diasEspera;
    }

    public String getStrNombre() {
        return strNombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getDiasEspera() {
        return diasEspera;
    }

    public void setDiasEspera(int diasEspera) {
        this.diasEspera = diasEspera;
    }
}