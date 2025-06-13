package org.example;

public class GestorCuentas {

    private RepositorioCuenta repositorio;
    private Notificador notificador;

    public GestorCuentas(RepositorioCuenta repositorio, Notificador notificador) {
        this.repositorio = repositorio;
        this.notificador = notificador;
    }

    public void retirar(String titular, double monto) {
        CuentaBancaria cuenta = repositorio.buscarCuentaPorTitular(titular);
        if (cuenta == null) throw new IllegalArgumentException("Cuenta no encontrada");

        cuenta.retirar(monto);

        repositorio.guardarCuenta(cuenta);

        boolean notificado = notificador.notificar("Se retiró " + monto + " de la cuenta de " + titular);
        if (!notificado) {
            System.out.println("⚠️ Falló el envío de la notificación");
        }
    }

}
