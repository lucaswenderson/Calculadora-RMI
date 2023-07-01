package classes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.Calculadora;
import interfaces.Numero;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraImplBasica extends UnicastRemoteObject implements Calculadora {
    private String nomeRepositorio;

    public CalculadoraImplBasica(String nomeRepositorio) throws RemoteException {
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

    //Métodos avançados não suportados implementados apenas para satisfazer a interface
    public Numero Potencia(Numero base, Numero expoente) {
        throw new UnsupportedOperationException("Método avançado não suportado pela calculadora básica.");
    }

    public Numero Porcentagem(Numero valor, Numero porcentagem) {
        throw new UnsupportedOperationException("Método avançado não suportado pela calculadora básica.");
    }

    public Numero RaizQuadrada(Numero numero) {
        throw new UnsupportedOperationException("Método avançado não suportado pela calculadora básica.");
    }

    public Numero Logaritmo(Numero numero) {
        throw new UnsupportedOperationException("Método avançado não suportado pela calculadora básica.");
    }
}