public class Simulador {

    public static void procesarDespacho(Producto producto) {
        System.out.println("--- INICIANDO PROCESO DE DESPACHO SERVER ---");
        System.out.println("Producto a procesar: " + producto.getStrNombre());

        boolean despachado = false;

        // 1. Verificar 2 veces existencia para despacho
        for (int i = 1; i <= 2; i++) {
            System.out.println("Verificación " + i + " de existencia...");
            if (producto.getStock() > 0) {
                System.out.println("-> ¡Hay existencia! Procediendo al DESPACHO.");
                producto.setStock(producto.getStock() - 1);
                despachado = true;
                break;
            }
        }

        // 2. Si NO hay existencia tras las 2 verificaciones
        if (!despachado) {
            System.out.println("-> NO hay existencia en las verificaciones iniciales.");
            System.out.println("Esperando 15 días... (Días transcurridos: " + producto.getDiasEspera() + ")");

            // 3. Evaluar si pasaron los 15 días y re-verificar
            if (producto.getDiasEspera() >= 15) {
                System.out.println("Re-verificando existencia tras 15 días...");
                
                if (producto.getStock() > 0) {
                    System.out.println("-> ¡Hay existencia tras la espera! Procediendo al DESPACHO.");
                    producto.setStock(producto.getStock() - 1);
                    despachado = true;
                } else {
                    System.out.println("-> NO hay existencia tras la re-verificación.");
                    System.out.println("-> Estado: CANCELO el pedido.");
                    
                    // 4. Evaluar condición Fecha / Días < 30 para ANULAR
                    if (producto.getDiasEspera() < 30) {
                        System.out.println("-> Condición (Fecha < 30 días) cumplida: Proceso ANULAR completado.");
                    } else {
                        System.out.println("-> Supera los 30 días. No aplica anulación estándar.");
                    }
                }
            }
        }
        System.out.println("--- FIN DEL PROCESO ---\n");
    }

    public static void main(String[] args) {
        // Caso 1: Hay stock de inmediato
        Producto p1 = new Producto("Laptop", 1200.0, 5, 0);
        System.out.println("=== PRUEBA 1 ===");
        procesarDespacho(p1);

        // Caso 2: No hay stock inicial, pasaron 15 días y sigue sin stock (< 30 días) -> Cancela y Anula
        Producto p2 = new Producto("Teclado Mechanical", 80.0, 0, 15);
        System.out.println("=== PRUEBA 2 ===");
        procesarDespacho(p2);
    }
}