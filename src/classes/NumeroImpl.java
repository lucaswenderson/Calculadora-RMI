package classes;

import interfaces.Numero;

public class NumeroImpl implements Numero {
    private double valor;

    public NumeroImpl(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
