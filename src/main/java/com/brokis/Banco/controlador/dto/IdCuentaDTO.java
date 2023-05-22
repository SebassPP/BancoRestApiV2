package com.brokis.Banco.controlador.dto;

import com.brokis.Banco.modelo.Usuario;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class IdCuentaDTO {
  private Long id;
  private Usuario usuario;
  int monto;
}
