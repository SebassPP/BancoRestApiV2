package com.brokis.Banco;

import com.brokis.Banco.modelo.Transaccion;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("unitTest")
public class ModeloTransaccionTest {
    @Test
    public void testTransaccion() {
        Transaccion transaccion = new Transaccion();
        assertNull(transaccion.getId());
        assertNull(transaccion.getOrigen());
        assertNull(transaccion.getDestino());
        assertEquals(0, transaccion.getMonto());

    }

    @Test
    public void testAllArguments(){
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
