package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import classes.NumeroImpl;
import interfaces.Calculadora;
import interfaces.Numero;

public class ClienteCalculadora {
    public static void main(String[] args) {
        try {
            // Localiza o registro RMI
            Registry registry = LocateRegistry.getRegistry(null);
            // Consulta o registro e obtém o stub para o objeto remoto
            Calculadora calc = (Calculadora) registry.lookup("calculadora");

            // Realiza operações de cálculo remoto
            Numero num1 = new NumeroImpl(5);
            Numero num2 = new NumeroImpl(2);
            Numero soma = calc.soma(num1, num2);
            Numero subtracao = calc.subtracao(num1, num2);
            Numero multiplicacao = calc.multiplicacao(num1, num2);
            Numero divisao = calc.divisao(num1, num2);
            Numero potencia = calc.potencia(num1, num2);
            Numero raizQuadrada = calc.raizQuadrada(num1);
            Numero logaritmo = calc.logaritmo(num1);
            Numero porcentagem = calc.porcentagem(num1, num2);

            // Exibe os resultados obtidos do servidor
            System.out.println("Resultados obtidos do servidor:");
            System.out.println("Soma: " + soma.getValor());
            System.out.println("Subtração: " + subtracao.getValor());
            System.out.println("Multiplicação: " + multiplicacao.getValor());
            System.out.println("Divisão: " + divisao.getValor());
            System.out.println("Potencia: " + potencia.getValor());
            System.out.println("Raiz Quadrada: " + raizQuadrada.getValor());
            System.out.println("Logaritmo: " + logaritmo.getValor());
            System.out.println("Porcentagem: " + porcentagem.getValor());

            
        } catch (Exception e) {
            System.err.println("Ocorreu um erro no cliente: " + e.toString());
        }
    }
}

