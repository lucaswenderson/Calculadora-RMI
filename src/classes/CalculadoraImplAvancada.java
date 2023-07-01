package classes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.Calculadora;
import interfaces.Numero;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraImplAvancada extends UnicastRemoteObject implements Calculadora {
    private String nomeRepositorio;

    public CalculadoraImplAvancada(String nomeRepositorio) throws RemoteException {
        super();
        this.nomeRepositorio = nomeRepositorio;
    }

    //Repository
    public String getRepositoryName() throws RemoteException {
        return nomeRepositorio; 
    }
    
    public List<String> listMetodos() throws RemoteException {
        List<String> metodos = new ArrayList<>();
        metodos.add("Soma");
        metodos.add("Subtracao");
        metodos.add("Multiplicacao");
        metodos.add("Divisao");
        metodos.add("Porcentagem");
        metodos.add("Potencia");
        metodos.add("RaizQuadrada");
        metodos.add("Logaritmo");
        return metodos;
    }

    public int getMethodCount() throws RemoteException {
        return listMetodos().size(); 
    }

    //Operações
    public Numero Soma(Numero a, Numero b)  {
        double resultado = a.getValor() + b.getValor();
        return new NumeroImpl(resultado);
    }

    public Numero Subtracao(Numero a, Numero b)  {
        double resultado = a.getValor() - b.getValor();
        return new NumeroImpl(resultado);
    }

    public Numero Multiplicacao(Numero a, Numero b)  {
        double resultado = a.getValor() * b.getValor();
        return new NumeroImpl(resultado);
    }

    public Numero Divisao(Numero a, Numero b) {
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

    public Numero Potencia(Numero base, Numero expoente) {
        double resultado = Math.pow(base.getValor(), expoente.getValor());
        return new NumeroImpl(resultado);
    }

    public Numero Porcentagem(Numero valor, Numero porcentagem) {
        double resultado = (porcentagem.getValor() / 100) * valor.getValor();
        return new NumeroImpl(resultado);
    }

    public Numero RaizQuadrada(Numero numero) {
        double resultado = Math.sqrt(numero.getValor());
        return new NumeroImpl(resultado);
    }

    public Numero Logaritmo(Numero numero) {
        double resultado = Math.log(numero.getValor());
        return new NumeroImpl(resultado);
    }




}

