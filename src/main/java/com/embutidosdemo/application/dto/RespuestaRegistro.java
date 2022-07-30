package com.embutidosdemo.application.dto;

import com.embutidosdemo.domain.entities.Registro;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class RespuestaRegistro extends Respuesta{

    @JsonProperty("datos")
    Registro data;
}
