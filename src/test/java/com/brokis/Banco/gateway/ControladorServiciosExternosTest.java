package com.brokis.Banco.gateway;

import com.brokis.Banco.AbstractTest;
import com.brokis.Banco.gateway.controladorRest.ControladorServiciosExternos;
import com.brokis.Banco.gateway.dto.CuentaDTO;
import com.brokis.Banco.gateway.dto.IdCuentaDTO;
import com.brokis.Banco.gateway.dto.TransaccionDTO;
import com.brokis.Banco.gateway.rabbitmq.PublisherDeposito;
import com.brokis.Banco.gateway.rabbitmq.PublisherTransaccion;
import com.brokis.Banco.modelo.Cuenta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ControladorServiciosExternosTest extends AbstractTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private static final String pathTransferencia= "/servicio/transferencia";
    private static final String pathDeposito= "/servicio/deposito";

    @Test
    void Given_TransaccionDTO_withAccount_When_invoke_envioTransferencia_Then_return_Error500() {

        TransaccionDTO transaccionDTO = new TransaccionDTO();

        ResponseEntity<TransaccionDTO> responseEntity = restTemplate.postForEntity(pathTransferencia, transaccionDTO, TransaccionDTO.class);

        HttpStatusCode status = responseEntity.getStatusCode();

        assertEquals(HttpStatusCode.valueOf(500), status);
    }

    @Test
    void Given_TransaccionDTO_withAccount_When_invoke_envioDeposito_Then_return_Error500() {
        IdCuentaDTO idCuentaDTO = new IdCuentaDTO();

        ResponseEntity<IdCuentaDTO> responseEntity = restTemplate.postForEntity(pathDeposito, idCuentaDTO, IdCuentaDTO.class);

        HttpStatusCode status = responseEntity.getStatusCode();

        assertEquals(HttpStatusCode.valueOf(500), status);
    }
}
