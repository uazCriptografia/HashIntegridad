package com.porfirioads.criptografia.hashintegridad.sockets;

import java.io.DataOutputStream;
import java.io.IOException;

public class Cliente extends Conexion {
    //Se usa el constructor para cliente de Conexion
    public Cliente() throws IOException {
        super("cliente");
    }

    //Método para iniciar el cliente
    public void startClient() {
        try {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());
            //Se enviarán dos mensajes
            for (int i = 0; i < 2; i++) {
                //Se escribe en el servidor usando su flujo de datos
                salidaServidor.writeUTF("Hola Pérro");
                salidaServidor.writeUTF("Este es el mensaje número " + (i +
                        1) + "\n");
            }
            //Fin de la conexión
            cs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}