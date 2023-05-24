package com.brokis.Banco.gateway.dto;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TransaccionDTO {
    private Long origen;
    private Long destino;
    private int monto;
}
