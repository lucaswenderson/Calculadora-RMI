package server;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import classes.CalculadoraImpl;
import interfaces.Calculadora;

public class ServidorCalculadora {
    public static void main(String args[]) {
        try {
            // Cria o objeto servidor
            CalculadoraImpl calc = new CalculadoraImpl();
            // Cria o stub do objeto que será registrado
            Calculadora stub = (Calculadora) UnicastRemoteObject.exportObject(calc, 0);
            // Obtém o registro do RMI
            Registry registry = LocateRegistry.getRegistry();
            // Registra (binds) o stub no registry
            registry.bind("calculadora", stub);
            System.out.println("Servidor iniciado.");
        } catch (Exception e) {
            System.err.println("Ocorreu um erro no servidor: " + e.toString());
        }
    }
}

