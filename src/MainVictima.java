import java.io.IOException;
import java.rmi.server.ExportException;

/**
 * Created by porfirio on 3/23/17.
 */
public class MainVictima {
    public static void main(String[] args) {
        Victima victima = new Victima();
        try {
            System.out.println("Víctima> Enviando mensajes...");
            victima.sendMessage("Hola mundo");
        } catch (Exception e) {
            System.err.println("ERROR: " + e);
        }
    }
}
