import java.io.IOException;

/**
 * Created by porfirio on 3/23/17.
 */
public class MainAtacante {
    public static void main(String[] args) {
        Atacante atacante = new Atacante();
        try {
            System.out.println("Atacante> Esperando recibir mensajes...");
            atacante.receiveMessage();
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
        }
    }
}
