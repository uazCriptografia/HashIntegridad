import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Entidad que funge el rol de servidor y es a donde el mensaje de la víctima
 * era originalmente destinado, pero al ser retenido por el atacante, se
 * recibirá un mensaje modificado y el hash original, por lo que esta entidad
 * deberá determinar si el mensaje es el bueno
 */
public class Destino {
     /*
    ----------------------------------------------------------------------------
    Datos de conexión
    ----------------------------------------------------------------------------
    */

    private static final int PUERTO = 4321;

    /*
    ----------------------------------------------------------------------------
    Métodos de la clase
    ----------------------------------------------------------------------------
    */

    public void receiveMessage() throws IOException {
        // Socket de servidor para recibir mensajes
        ServerSocket serverSocket = new ServerSocket(PUERTO);
        // Socket del cliente que se conecta al servidor
        Socket sourceSocket = serverSocket.accept();
        // Reader para leer los mensajes del cliente
        BufferedReader clientInput = new BufferedReader(new InputStreamReader
                (sourceSocket.getInputStream()));
        // Writer para enviar respuestas al cliente
        PrintStream output = new PrintStream(sourceSocket.getOutputStream());
        // Lee mensaje del cliente
        String message = clientInput.readLine();
        // Muestra el mensaje recibido
        System.out.println("Atacante> " + message);
        // Limpia la entrada
        output.flush();
        // Envía la respuesta al cliente
        output.println("Destino> Mensaje recibido");
        // Cierra la conexión
        sourceSocket.close();
    }
}
