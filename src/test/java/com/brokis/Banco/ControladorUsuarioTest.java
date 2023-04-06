package com.brokis.Banco;

import com.brokis.Banco.controlador.dto.UsuarioDTO;

import com.brokis.Banco.modelo.Usuario;
import com.brokis.Banco.repositorio.RepUsuario;
import com.brokis.Banco.controlador.dto.UsuarioDTO;
import com.brokis.Banco.servicio.Usuario.ServicioUsuarioImp;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ControladorUsuarioTest extends AbstractTest{
    @Autowired
    private TestRestTemplate restTemplate;
    private static final String PATH_CrearUsuario = "/usuario/crear";
    private static final String PATH_ConsultarCuentas = "/usuario/consulta/123";

    @Mock
    private RepUsuario repUsuario;

    @InjectMocks
    private ServicioUsuarioImp servicioUsuarioImp;

    @Test
    void Given_UserInfo_When_Invoke_crearCuentaUsuario_Then_crearUsuario (){
        Usuario usuario = new Usuario(1L, "Juan", "Alvarez", null);
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        repUsuario.save (usuario);

        Mockito.when(repUsuario.save(usuario)).thenReturn(usuario);
        ResponseEntity<Usuario> usuarioResponseEntity= restTemplate.postForEntity(PATH_CrearUsuario, usuarioDTO, Usuario.class);
        HttpStatusCode statusCode = usuarioResponseEntity.getStatusCode();
        assertEquals(HttpStatus.valueOf(201), statusCode);
    }



}
