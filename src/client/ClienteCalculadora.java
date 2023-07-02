package client;

import java.lang.reflect.Method;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import classes.NumeroImpl;
import interfaces.Calculadora;
import interfaces.Numero;
import server.GerenciadorRepositorios;

public class ClienteCalculadora {
    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("Uso: java ClienteCalculadora <nome_repositorio> <IP> <porta>");
            System.out.println("Opções <nome_repositorio>: 'CalculadoraBasica' ou 'CalculadoraAvancada'");
            System.exit(1);
        }
        
        String repositorio = args[0];
        String ip = args[1];
        int porta = Integer.parseInt(args[2]);

        try {
            // Localiza o registro RMI
            Registry registry = LocateRegistry.getRegistry(ip, porta);

            // Obtém referência ao gerenciador de repositórios
            GerenciadorRepositorios gerenciador = (GerenciadorRepositorios) registry.lookup("GerenciadorRepositorios");

            // Obtém referência ao repositório de métodos
            Calculadora calculadora = gerenciador.obterRepositorio(repositorio);

            // Examinar nome do repositório e número de métodos
            String nomeRepositorio = calculadora.getRepositoryName();
            int numMetodos = calculadora.getMethodCount();
            System.out.println("Nome do Repositório: " + nomeRepositorio);
            System.out.println("Número de Métodos: " + numMetodos);

            // Listar os métodos no repositório
            List<String> metodos = calculadora.listMetodos();
            System.out.println("Métodos Disponíveis:");
            for (int i = 0; i < metodos.size(); i++) {
                System.out.println((i + 1) + ". " + metodos.get(i));
            }

            // Buscar um método por código de método e parâmetros
            Scanner scanner = new Scanner(System.in);
            
            // Solicitar ao usuário a escolha de um método
            System.out.print("Escolha o número do método desejado: ");
            int numMetodo = scanner.nextInt();

            if (numMetodo >= 1 && numMetodo <= metodos.size()) {
                String metodoEscolhido = metodos.get(numMetodo - 1);
                System.out.println("Método escolhido: " + metodoEscolhido);

                //Verificar se o método tem um ou dois parâmetros
                Method metodo;
                int numeroParametros;
                if (metodoEscolhido.equals("RaizQuadrada") ||
                        metodoEscolhido.equals("Logaritmo") ||
                        metodoEscolhido.equals("Seno") ||
                        metodoEscolhido.equals("Cosseno") ||
                        metodoEscolhido.equals("Tangente") ||
                        metodoEscolhido.equals("Modulo") ||
                        metodoEscolhido.equals("Fatorial")
                    ) {
                    numeroParametros = 1;
                    metodo = calculadora.getClass().getMethod(metodoEscolhido, Numero.class);
                } else {
                    numeroParametros = 2;
                    metodo = calculadora.getClass().getMethod(metodoEscolhido, Numero.class, Numero.class);
                }

                //Solicitar ao usuário os parâmetros
                List<Numero> parametros = new ArrayList<>();
                for (int i = 0; i < numeroParametros; i++) {
                    System.out.print("Digite o valor do parâmetro " + (i + 1) + ": ");
                    Numero parametro = new NumeroImpl(scanner.nextDouble());
                    parametros.add(parametro);
                }                
                
                //Invocar o método
                double resultado;
                if (numeroParametros == 2) {
                    Numero parametro1 = parametros.get(0);
                    Numero parametro2 = parametros.get(1);
                    resultado = ((Numero) metodo.invoke(calculadora, parametro1, parametro2)).getValor();
                } else {
                    Numero parametro = parametros.get(0);
                    resultado = ((Numero) metodo.invoke(calculadora, parametro)).getValor();
                }

                System.out.println("Resultado: " + resultado);
            } else {
                System.out.println("Opção inválida. Encerrando o programa.");
            }

            scanner.close();

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

