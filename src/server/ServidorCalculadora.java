package server;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

import classes.CalculadoraImpl;

public class ServidorCalculadora {
    public static void main(String args[]) {
        if (args.length < 1) {
            System.out.println("Uso: java ServidorCalculadora <nome_servidor>");
            System.exit(1);
        }
        
        String nomeServidor = args[0];

        try {
            // Cria uma instância do gerenciador de repositórios
            GerenciadorRepositorios gerenciador = new GerenciadorRepositorios();

            // Cria uma instância do repositório de métodos para o servidor atual
            CalculadoraImpl calculadoraBasica = new CalculadoraImpl("Operações Básicas");
            CalculadoraImpl calculadoraAvancada = new CalculadoraImpl("Operações Avançadas");

            // Registra a instância do repositório no gerenciador
            gerenciador.registrarRepositorio("Operações Básicas", calculadoraBasica);
            gerenciador.registrarRepositorio("Operações Avançadas", calculadoraAvancada);

            // Cria e exporta o registro RMI
            Registry registry = LocateRegistry.createRegistry(1099);

            // Vincula o gerenciador de repositórios ao registro RMI
            registry.rebind("GerenciadorRepositorios", gerenciador);

            System.out.println("Servidor " + nomeServidor + " pronto para receber conexões.");
        } catch (Exception e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

