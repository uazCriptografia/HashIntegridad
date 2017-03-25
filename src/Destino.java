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
        System.out.println("Destino> Recibiendo el mensaje...");
        // Lee mensaje del cliente
        String message = clientInput.readLine();
        // Limpia la entrada
        output.flush();
        // Envía la respuesta al cliente
        output.println("Destino> Mensaje recibido");
        System.out.println("Destino> Mensaje recibido");
        // Cierra la conexión
        sourceSocket.close();
        // Manda llamar al verificador de integridad
        verificarIntegridad(message);
    }

    public void verificarIntegridad(String message) {
        // Extrae el hash y el contenido del mensaje original
        int longitud = message.length();
        String hash = message.substring(longitud - 8, longitud);
        String onlyMessage = message.substring(0, longitud - 8);
        String hashCalculado = StringUtils.getHash(onlyMessage);
        System.out.println("Destino> Hash original: " + hash);
        System.out.println("Destino> Hash calculado: " + hashCalculado);
        if(hash.equals(hashCalculado))
            System.out.println("Destino> El mensaje es el original");
        else
            System.out.println("Destino> El mensaje fue modificado");
    }
}
