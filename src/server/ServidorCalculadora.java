package server;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

import classes.CalculadoraImplAvancada;
import classes.CalculadoraImplBasica;

public class ServidorCalculadora {
    public static void main(String args[]) {
        if (args.length < 3) {
            System.out.println("Uso: java ServidorCalculadora <nome_servidor> <porta>");
            System.exit(1);
        }

        String nomeServidor = args[0];
        int porta = Integer.parseInt(args[1]);

        try {
            // Cria uma instância do gerenciador de repositórios
            GerenciadorRepositorios gerenciador = new GerenciadorRepositorios();

            // Cria uma instância do repositório de métodos para o servidor atual
            CalculadoraImplBasica calculadoraBasica = new CalculadoraImplBasica("CalculadoraBasica");
            CalculadoraImplAvancada calculadoraAvancada = new CalculadoraImplAvancada("CalculadoraAvancada");

            // Registra a instância do repositório no gerenciador
            gerenciador.registrarRepositorio("CalculadoraBasica", calculadoraBasica);
            gerenciador.registrarRepositorio("CalculadoraAvancada", calculadoraAvancada);

            // Cria e exporta o registro RMI
            Registry registry = LocateRegistry.createRegistry(porta);

            // Vincula o gerenciador de repositórios ao registro RMI
            registry.rebind("GerenciadorRepositorios", gerenciador);

            System.out.println("Servidor " + nomeServidor + " pronto para receber conexões.");
        } catch (Exception e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

