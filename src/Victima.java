import sun.util.BuddhistCalendar;

import java.io.*;
import java.net.Socket;

/**
 * Entidad que funge el rol de cliente que envía el mensaje que será
 * interceptado por el atacante, que en este caso, por simplicidad, el
 * mensaje será directamente envíado al atacante.
 */
public class Victima {
    /*
    ----------------------------------------------------------------------------
    Datos de conexión
    ----------------------------------------------------------------------------
    */

    private static final int PUERTO = 1234;
    private static final String HOST = "localhost";

    /*
    ----------------------------------------------------------------------------
    Métodos de la clase
    ----------------------------------------------------------------------------
    */

    public void sendMessage(String message) throws IOException {
        // Socket de cliente para conectarse a un servidor
        Socket clientSocket = new Socket(HOST, PUERTO);
        // Reader para leer las respuestas del servidor
        BufferedReader input = new BufferedReader(new InputStreamReader
                (clientSocket.getInputStream()));
        // Writer para mandar mensajes al servidor
        PrintStream output = new PrintStream(clientSocket.getOutputStream());
        // Envía un mensaje al servidor
        output.println(message);
        // Obtiene la respuesta del servidor
        String respuesta = input.readLine();
        // Muestra la respuesta
        System.out.println(respuesta);
        // Cierra la conexión
        clientSocket.close();
    }

    public void sendFile(File file) throws IOException {
        // TODO Convertir archivo a String
        sendMessage("file_string");
    }

}
