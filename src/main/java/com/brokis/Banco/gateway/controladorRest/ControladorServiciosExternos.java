package com.brokis.Banco.gateway.controladorRest;

import com.brokis.Banco.gateway.dto.IdCuentaDTO;
import com.brokis.Banco.gateway.dto.TransaccionDTO;
import com.brokis.Banco.gateway.rabbitmq.PublisherTransaccion;
import com.brokis.Banco.gateway.rabbitmq.PublisherDeposito;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servicio")
@AllArgsConstructor
public class ControladorServiciosExternos {
    private final PublisherTransaccion PublisherTransaccion;
    private final PublisherDeposito publisherDeposito;
    @PostMapping("/transferencia")
    public ResponseEntity envioTransferencia(@RequestBody TransaccionDTO transaccionDTO){
        PublisherTransaccion.sendJsonMessage(transaccionDTO);
        return ResponseEntity.ok(transaccionDTO);
    }
    @PostMapping("/deposito")
    public ResponseEntity envioDeposito(@RequestBody IdCuentaDTO idCuentaDTO){
        publisherDeposito.sendJsonMessage(idCuentaDTO);
        return ResponseEntity.ok(idCuentaDTO);
    }
}
