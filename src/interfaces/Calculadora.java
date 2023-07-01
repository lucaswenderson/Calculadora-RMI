package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface Calculadora extends Remote {
    //Pre implementado
    Numero Soma(Numero a, Numero b) throws RemoteException;

    Numero Subtracao(Numero a, Numero b) throws RemoteException;

    Numero Multiplicacao(Numero a, Numero b) throws RemoteException;

    Numero Divisao(Numero a, Numero b) throws RemoteException;

    //Implementação pessoal 
    Numero Potencia(Numero base, Numero expoente) throws RemoteException;

    Numero RaizQuadrada(Numero numero) throws RemoteException;

    Numero Logaritmo(Numero numero) throws RemoteException;

    Numero Porcentagem(Numero valor, Numero porcentagem) throws RemoteException;

    //Repository    
    String getRepositoryName() throws RemoteException;

    int getMethodCount() throws RemoteException;

    List<String> listMetodos() throws RemoteException;


}
