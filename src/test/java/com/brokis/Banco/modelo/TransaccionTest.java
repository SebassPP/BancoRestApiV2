package com.brokis.Banco.modelo;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("unitTest")
public class TransaccionTest {
    @Test
    public void Given_transaccion_When_null_Then_nullArgs() {
        Transaccion transaccion = new Transaccion();
        assertNull(transaccion.getId());
        assertNull(transaccion.getOrigen());
        assertNull(transaccion.getDestino());
        assertEquals(0, transaccion.getMonto());

    }

    @Test
    public void Given_addTransaccion_When_transaccion_Then_EqualsArgs(){
        Long id = 1L;
        Long origen = 2L;
        Long destino = 3L;
        int Monto = 100;

        Transaccion transaccion = new Transaccion(id, origen, destino, Monto);

        assertEquals(id, transaccion.getId());
        assertEquals(origen, transaccion.getOrigen());
        assertEquals(destino, transaccion.getDestino());
        assertEquals(Monto, transaccion.getMonto());
    }

}
