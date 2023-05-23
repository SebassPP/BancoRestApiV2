package com.brokis.Banco.gateway.controladorRest;

import com.brokis.Banco.gateway.dto.UsuarioDTO;
import com.brokis.Banco.servicio.Usuario.ServicioUsuario;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class ControladorUsuario {
    private final ServicioUsuario servicioUsuario;

    @PostMapping("/creacion")
    public ResponseEntity crearCuenta(@RequestBody UsuarioDTO usuario) {
        return new ResponseEntity(servicioUsuario.crearUsuario(usuario), HttpStatus.CREATED);
    }
    @GetMapping("/consulta/{id}")
    public ResponseEntity consultarCuentas(@PathVariable Long id) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setDocument(id);
        return new ResponseEntity(new ArrayList<>(servicioUsuario.consultarCuentas(usuarioDTO)), HttpStatus.OK);
    }
}
