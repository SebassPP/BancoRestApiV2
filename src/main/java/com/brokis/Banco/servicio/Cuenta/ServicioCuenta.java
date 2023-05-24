package com.brokis.Banco.servicio.Cuenta;

import com.brokis.Banco.gateway.dto.CuentaDTO;
import com.brokis.Banco.gateway.dto.IdCuentaDTO;
import com.brokis.Banco.modelo.Cuenta;

import java.util.List;

public interface ServicioCuenta {
    Cuenta crearCuenta(CuentaDTO cuenta);
    Cuenta consultarSaldo(IdCuentaDTO idCuentaDTO);
    Cuenta eliminarCuenta(IdCuentaDTO idCuentaDTO);
    List consultarCuentas(CuentaDTO cuentaDTO);
}
