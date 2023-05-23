package com.brokis.Banco.servicio.Transaccion;

import com.brokis.Banco.gateway.dto.TransaccionDTO;

public interface ServicioTransaccion {

    String hacerTransferencia(TransaccionDTO transaccionDTO);

}
