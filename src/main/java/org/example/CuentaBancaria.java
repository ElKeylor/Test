package org.example;

public class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldoInicial) {
        if (saldoInicial < 0) throw new IllegalArgumentException("Saldo inicial no puede ser negativo");
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("El monto a depositar debe ser positivo");
        saldo += monto;
    }

    public void retirar(double monto) {
        if (monto <= 0) throw new IllegalArgumentException("El monto a retirar debe ser positivo");
        if (monto > saldo) throw new IllegalArgumentException("Saldo insuficiente");
        saldo -= monto;
    }
}
