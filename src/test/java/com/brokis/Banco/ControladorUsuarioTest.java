package com.brokis.Banco;

import com.brokis.Banco.controlador.ControladorCuenta;
import com.brokis.Banco.controlador.dto.CuentaDTO;
import com.brokis.Banco.controlador.dto.UsuarioDTO;

import com.brokis.Banco.modelo.Usuario;
import com.brokis.Banco.repositorio.RepUsuario;
import com.brokis.Banco.servicio.Usuario.ServicioUsuarioImp;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ControladorUsuarioTest extends AbstractTest{
    @Autowired
    private TestRestTemplate restTemplate;
    private static final String pathCrearUsuario = "/usuario/creacion";
    private static final String pathConsultarUsuario = "/usuario/consulta/123";

    @Mock
    private RepUsuario repUsuario;

    @InjectMocks
    private ServicioUsuarioImp servicioUsuarioImp;


    @Test
    void Given_UserInfo_When_Invoke_crearCuentaUsuario_Then_crearUsuario (){
        UsuarioDTO usuarioDto = new UsuarioDTO(25L, "Juan", "Alvarez");
        ResponseEntity<Usuario> usuarioResponseEntity= restTemplate.postForEntity(pathCrearUsuario, usuarioDto, Usuario.class);
        HttpStatusCode status = usuarioResponseEntity.getStatusCode();
        assertEquals(HttpStatusCode.valueOf(201), status);
    }

    /*@Sql(statements = "INSERT INTO USER (DOCUMENT, NAME, LAST_NAME,DATE_CREATED) VALUES (25, 'Juan', 'Alvarez','2023-02-04')")
    @Test
    void Given_UserInfo_When_Invoke_consultarCuentas_Then_consultarCuentas (){
        Long id= 1L;
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setDocument(id);
        List<CuentaDTO> cuentaDTO = new ArrayList<>();
        ServicioUsuarioImp servicioUsuarioImp = mock(ServicioUsuarioImp.class);
        when(servicioUsuarioImp.consultarCuentas(usuarioDTO)).thenReturn(cuentaDTO);

        ResponseEntity response = new ControladorCuenta().consultarCuentas(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cuentaDTO, response.getBody());
    }
*/





}
