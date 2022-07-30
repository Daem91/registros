package com.embutidosdemo.application.dto;

import com.embutidosdemo.domain.entities.Chofer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RespuestaChofer extends Respuesta {

    @JsonProperty("datos")
    Chofer data;

}
