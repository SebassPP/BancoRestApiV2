package com.brokis.Banco;

import com.brokis.Banco.modelo.Cuenta;
import com.brokis.Banco.modelo.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("unitTest")
public class ModeloCuentaTest {
    @Test
    public void testCuenta(){
        Long id = 1L;
        String tipo = "ahorro";
        int saldo = 100;
        Date fechaDeCreacion = new Date();
        Usuario usuario = new Usuario(1L, "nombre", "apellido", new Date());

        Cuenta cuenta = new Cuenta(id, tipo, saldo, fechaDeCreacion, usuario);

        assertEquals(id, cuenta.getId());
        assertEquals(tipo, cuenta.getTipo());
        assertEquals(saldo, cuenta.getSaldo());
        assertEquals(fechaDeCreacion, cuenta.getFechaDeCreacion());
        assertEquals(usuario, cuenta.getUsuario());
    }

    @Test
    public void TestCuentaAllArguments(){
        Long id = 1L;
        String tipo = "ahorro";
        int saldo = 100;
        Date fechaDeCreacion = new Date();
        Usuario usuario = new Usuario(1L,"usuario", "apellido",null);

        Cuenta cuenta = new Cuenta(id, tipo, saldo, fechaDeCreacion, usuario);

        assertEquals(id, cuenta.getId());
        assertEquals(tipo, cuenta.getTipo());
        assertEquals(saldo, cuenta.getSaldo());
        assertEquals(fechaDeCreacion, cuenta.getFechaDeCreacion());
        assertEquals(usuario, cuenta.getUsuario());

    }

    @Test
    public void testCuentaNoArgsConstructor (){
        Cuenta cuenta = new Cuenta();

        assertNull(cuenta.getId());
        assertNull(cuenta.getTipo());
        assertEquals(0, cuenta.getSaldo());
        assertNull(cuenta.getFechaDeCreacion());
        assertNull(cuenta.getUsuario());
    }
}
