package com.porfirioads.criptografia.hashintegridad.sockets;

import java.io.IOException;

//Clase principal que hará uso del servidor
public class RunServidor {
    public static void main(String[] args) throws IOException {
        //Se crea el servidor
        Servidor serv = new Servidor();
        System.out.println("Iniciando servidor\n");
        //Se inicia el servidor
        serv.startServer();
    }
}
