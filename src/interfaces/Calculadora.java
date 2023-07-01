package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Calculadora extends Remote {
    //Pre implementado
    Numero soma(Numero a, Numero b) throws RemoteException;

    Numero subtracao(Numero a, Numero b) throws RemoteException;

    Numero multiplicacao(Numero a, Numero b) throws RemoteException;

    Numero divisao(Numero a, Numero b) throws RemoteException;

    //Implementação pessoal 
    Numero potencia(Numero base, Numero expoente) throws RemoteException;

    Numero raizQuadrada(Numero numero) throws RemoteException;

    Numero logaritmo(Numero numero) throws RemoteException;

    Numero porcentagem(Numero valor, Numero porcentagem) throws RemoteException;


}
