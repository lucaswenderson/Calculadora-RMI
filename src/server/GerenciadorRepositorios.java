package server;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.HashMap;
import java.util.Map;

import interfaces.Calculadora;

public class GerenciadorRepositorios implements Remote, Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, Calculadora> repositorios;

    public GerenciadorRepositorios() {
        this.repositorios = new HashMap<>();
    }

    public void registrarRepositorio(String nome, Calculadora calculadora) {
        repositorios.put(nome, calculadora);
    }

    public Calculadora obterRepositorio(String nome) {
        return repositorios.get(nome);
    }
}

