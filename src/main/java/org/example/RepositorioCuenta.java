package org.example;

public interface RepositorioCuenta {
    CuentaBancaria buscarCuentaPorTitular(String titular);
    void guardarCuenta(CuentaBancaria cuenta);
}
