package com.brokis.Banco.controlador;


import com.brokis.Banco.servicio.Transaccion.ServicioTransaccion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicio")
@AllArgsConstructor
public class ControladorServicio {
    private final ServicioTransaccion servicioCuenta;


    /*

    @PutMapping("transferencia/{numeroCuentaOrigen}/{numeroCuentaDestino}/{monto}")
    public ResponseEntity<String> transferir(
            @PathVariable Long numeroCuentaOrigen,
            @PathVariable Long numeroCuentaDestino,
            @PathVariable Double monto) {

        String resultadoTransferencia = servicioCuenta.hacerTransferencia(numeroCuentaOrigen, numeroCuentaDestino, monto);
        System.out.println(resultadoTransferencia);

        if (resultadoTransferencia.equals("Transferencia realizada con exito")) {
            return ResponseEntity.ok(resultadoTransferencia);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La transferencia no se pudo realizar");
        }
    }*/
}