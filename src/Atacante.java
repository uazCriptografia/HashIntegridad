import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Entidad que funge el rol de cliente y servidor al mismo tiempo, funciona
 * como servidor para recibir el mensaje de la víctima, pero a su vez es
 * cliente
 */
public class Atacante {
    /*
    ----------------------------------------------------------------------------
    Datos de conexión
    ----------------------------------------------------------------------------
    */

    // Puerto al que esta entidad permite conexiones (será servidor)
    private static final int PUERTO_SERVER = 1234;
    // Host y puerto de a dónde solicitará conexiones (será cliente)
    private static final String HOST_CLIENTE = "localhost";
    private static final int PUERTO_CLIENTE = 4321;

    /*
    ----------------------------------------------------------------------------
    Métodos de la clase
    ----------------------------------------------------------------------------
    */

    public void receiveMessage() throws IOException {
        // Socket de servidor para recibir mensajes
        ServerSocket serverSocket = new ServerSocket(PUERTO_SERVER);
        // Socket del cliente que se conecta al servidor
        Socket sourceSocket = serverSocket.accept();
        // Reader para leer los mensajes del cliente
        BufferedReader clientInput = new BufferedReader(new InputStreamReader
                (sourceSocket.getInputStream()));
        // Writer para enviar respuestas al cliente
        PrintStream output = new PrintStream(sourceSocket.getOutputStream());
        System.out.println("Atacante> Recibiendo el mensaje...");
        // Lee mensaje del cliente
        String message = clientInput.readLine();
        // Limpia la entrada
        output.flush();
        // Envía la respuesta al cliente
        output.println("Atacante> Mensaje recibido");
        // Cierra la conexión
        sourceSocket.close();
        // Manda editar y reenviar el mensaje
        editAndSendMessage(message);
        // Escribe el archivo recibido
        message = message.substring(0, message.length() - 8);
        FileUtils.writeFile(FileUtils.decodeFile(message), "recibido_atacante");
    }

    public void editAndSendMessage(String message) throws IOException {
        // TODO Enviar el mensaje modificado al destino original
        // Socket de cliente para conectarse a un servidor
        Socket clientSocket = new Socket(HOST_CLIENTE, PUERTO_CLIENTE);
        // Reader para leer las respuestas del servidor
        BufferedReader input = new BufferedReader(new InputStreamReader
                (clientSocket.getInputStream()));
        // Writer para mandar mensajes al servidor
        PrintStream output = new PrintStream(clientSocket.getOutputStream());
        // Extrae el hash y el contenido del mensaje original
        int longitud = message.length();
        String hash = message.substring(longitud - 8, longitud);
        String onlyMessage = message.substring(0, longitud - 8);
        // Edita el mensaje
        message = onlyMessage.replaceAll("[aeiou]", "r");
        // Envía el mensaje editado al servidor con el hash original
        output.println(message + hash);
        // Obtiene la respuesta del servidor
        String respuesta = input.readLine();
        // Muestra la respuesta
        System.out.println(respuesta);
        // Cierra la conexión
        clientSocket.close();
    }
}
