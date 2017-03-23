package com.porfirioads.criptografia.hashintegridad.sockets;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Servidor extends Conexion {
    //Se usa el constructor para servidor de Conexion
    public Servidor() throws IOException {
        super("servidor");
    }

    //Método para iniciar el servidor
    public void startServer() {
        try {
            System.out.println("Esperando...");
            //Accept comienza el socket y espera una conexión desde un cliente
            cs = ss.accept();
            System.out.println("Cliente en línea");
            //Se obtiene el flujo de salida del cliente para enviarle mensajes
            salidaCliente = new DataOutputStream(cs.getOutputStream());
            //Se le envía un mensaje al cliente usando su flujo de salida
            salidaCliente.writeUTF("Petición recibida y aceptada");
            //Se obtiene el flujo entrante desde el cliente
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(cs.getInputStream()));
            //Mientras haya mensajes desde el cliente
            while ((mensajeServidor = entrada.readLine()) != null) {
                //Se muestra por pantalla el mensaje recibido
                System.out.println(mensajeServidor);
            }
            System.out.println("Fin de la conexión");
            //Se finaliza la conexión con el cliente
            ss.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}