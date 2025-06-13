package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorCuentasTest {

    @Test
    void testDepositar() {
        CuentaBancaria cuenta = new CuentaBancaria("Axel", 0.0);
        cuenta.depositar(500.0);
        assertEquals(500.0, cuenta.getSaldo());
    }

    @Test
    void testRetirarConSaldoSuficiente() {
        CuentaBancaria cuenta = new CuentaBancaria("Axel", 1000.0);
        cuenta.retirar(400.0);
        assertEquals(600.0, cuenta.getSaldo());
    }

    @Test
    void testRetirarConSaldoInsuficiente() {
        CuentaBancaria cuenta = new CuentaBancaria("Axel", 100.0);
        assertThrows(IllegalArgumentException.class, () -> cuenta.retirar(200.0));
    }

}
