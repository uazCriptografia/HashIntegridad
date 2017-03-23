package com.porfirioads.criptografia.hashintegridad.sockets;

import java.io.IOException;

//Clase principal que hará uso del cliente
public class RunCliente {
    public static void main(String[] args) throws IOException {
        //Se crea el cliente
        Cliente cli = new Cliente();
        //Se inicia el cliente
        System.out.println("Iniciando cliente\n");
        cli.startClient();
    }
}

