package classes;

import interfaces.Calculadora;
import interfaces.Numero;

public class CalculadoraImpl implements Calculadora {
    public Numero soma(Numero a, Numero b)  {
        double resultado = a.getValor() + b.getValor();
        return new NumeroImpl(resultado);
    }

    public Numero subtracao(Numero a, Numero b)  {
        double resultado = a.getValor() - b.getValor();
        return new NumeroImpl(resultado);
    }

    public Numero multiplicacao(Numero a, Numero b)  {
        double resultado = a.getValor() * b.getValor();
        return new NumeroImpl(resultado);
    }

    public Numero divisao(Numero a, Numero b) {
        double divisor = b.getValor();
        try {
            if (divisor == 0) {
                throw new RuntimeException("Divisão por zero não é permitida.");
            }
            double resultado = a.getValor() / divisor;
            return new NumeroImpl(resultado);
        } catch (RuntimeException e) {
            System.err.println("Valor Invalido: " +  e.toString());
        }
        return new NumeroImpl(0);
    }

    public Numero potencia(Numero base, Numero expoente) {
        double resultado = Math.pow(base.getValor(), expoente.getValor());
        return new NumeroImpl(resultado);
    }

    public Numero raizQuadrada(Numero numero) {
        double resultado = Math.sqrt(numero.getValor());
        return new NumeroImpl(resultado);
    }

    public Numero logaritmo(Numero numero) {
        double resultado = Math.log(numero.getValor());
        return new NumeroImpl(resultado);
    }

    public Numero porcentagem(Numero valor, Numero porcentagem) {
        double resultado = (porcentagem.getValor() / 100) * valor.getValor();
        return new NumeroImpl(resultado);
    }






}

