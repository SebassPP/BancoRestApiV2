package com.brokis.Banco.gateway.controladorRest;

import com.brokis.Banco.gateway.dto.CuentaDTO;
import com.brokis.Banco.gateway.dto.IdCuentaDTO;
import com.brokis.Banco.servicio.Cuenta.ServicioCuenta;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuenta")
@AllArgsConstructor
public class ControladorCuenta {
    private final ServicioCuenta servicioCuenta;
    @PostMapping("/creacion")

    public ResponseEntity crearCuenta(@RequestBody CuentaDTO cuentaDTO) {
        return new ResponseEntity(servicioCuenta.crearCuenta(cuentaDTO), HttpStatus.CREATED);
    }
    @GetMapping("/consulta/{id}")
    public ResponseEntity consultarSaldo(@PathVariable Long id) {
        IdCuentaDTO idCuentaDTO = new IdCuentaDTO();
        idCuentaDTO.setId(id);
        return new ResponseEntity(servicioCuenta.consultarSaldo(idCuentaDTO), HttpStatus.OK);
    }
    @PostMapping("/mostrar")
    public ResponseEntity consultarCuentas(@RequestBody CuentaDTO usuario){

        return new ResponseEntity(servicioCuenta.consultarCuentas(usuario), HttpStatus.OK);
    }
    @DeleteMapping("/eliminacion/{id}")
    public ResponseEntity eliminarCuenta(@PathVariable Long id){
        IdCuentaDTO idCuentaDTO = new IdCuentaDTO();
        idCuentaDTO.setId(id);
        return new ResponseEntity(servicioCuenta.eliminarCuenta(idCuentaDTO), HttpStatus.OK);
    }
}
