package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class GestorCuentasTestMock {

    private RepositorioCuenta repositorioMock;
    private Notificador notificadorMock;
    private GestorCuentas gestor;

    @BeforeEach
    void setUp() {
        repositorioMock = mock(RepositorioCuenta.class);
        notificadorMock = mock(Notificador.class);
        gestor = new GestorCuentas(repositorioMock, notificadorMock);
    }

    @Test
    void testRetiroConNotificacionExitosa() {
        CuentaBancaria cuenta = new CuentaBancaria("Axel", 1000.0);
        when(repositorioMock.buscarCuentaPorTitular("Axel")).thenReturn(cuenta);
        when(notificadorMock.notificar(anyString())).thenReturn(true);

        gestor.retirar("Axel", 300.0);

        assertEquals(700.0, cuenta.getSaldo());
        verify(notificadorMock).notificar("Se retiró 300.0 de la cuenta de Axel");
    }

    @Test
    void testRetiroConNotificacionFallida() {
        CuentaBancaria cuenta = new CuentaBancaria("Axel", 1000.0);
        when(repositorioMock.buscarCuentaPorTitular("Axel")).thenReturn(cuenta);
        when(notificadorMock.notificar(anyString())).thenReturn(false); // Simula error

        gestor.retirar("Axel", 200.0);

        assertEquals(800.0, cuenta.getSaldo());
        verify(notificadorMock).notificar("Se retiró 200.0 de la cuenta de Axel");
    }

}
