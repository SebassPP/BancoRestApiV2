package com.brokis.Banco.gateway;

import com.brokis.Banco.AbstractTest;
import com.brokis.Banco.gateway.dto.UsuarioDTO;
import com.brokis.Banco.modelo.Usuario;
import com.brokis.Banco.servicio.Usuario.ServicioUsuarioImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ControladorUsuarioTest extends AbstractTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private static final String pathUsuarioCreacion = "/usuario/creacion";
    @InjectMocks
    private ServicioUsuarioImp servicioUsuario;
    @Test
    public void Given_UsuarioDTO_When_Invoke_CrearUsuario_Then_Return_NewUsuario(){
        UsuarioDTO usuarioDTO = new UsuarioDTO(19L,"Juan","Parrado");
        ResponseEntity<Usuario> responseEntity = restTemplate.postForEntity(pathUsuarioCreacion, usuarioDTO, Usuario.class);

        HttpStatusCode status = responseEntity.getStatusCode();

        assertEquals(HttpStatusCode.valueOf(201), status);

    }
    @Test
    public void Given_UsuarioDTO_null_When_Invoke_CrearUsuario_Then_Return_Error(){
        UsuarioDTO usuarioDTO = new UsuarioDTO(null,null,null);
        ResponseEntity<Usuario> responseEntity = restTemplate.postForEntity(pathUsuarioCreacion, usuarioDTO, Usuario.class);

        HttpStatusCode status = responseEntity.getStatusCode();

        assertEquals(HttpStatusCode.valueOf(500), status);

    }
}
