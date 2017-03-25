
/**
 * Created by porfirio on 3/24/17.
 */
public class MainDestino {
    public static void main(String[] args) {
        Destino destino = new Destino();
        try {
            System.out.println("Destino> Esperando recibir mensajes...");
            destino.receiveMessage();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
        }
    }
}
