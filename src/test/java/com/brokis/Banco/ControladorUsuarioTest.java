package com.brokis.Banco;


import com.brokis.Banco.servicio.Usuario.ServicioUsuario;
import org.junit.jupiter.api.Test;
import com.brokis.Banco.controlador.ControladorUsuario;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ControladorUsuarioTest {

    @Mock
    private ServicioUsuario servicioUsuario;

    @InjectMocks
    private ControladorUsuario controladorUsuario;



    @Test
    private void Given_userForCuenta_When_invoke_crearCuenta_Then_ResponseEntity() {

    }
}
