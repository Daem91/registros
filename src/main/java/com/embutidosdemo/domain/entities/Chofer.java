package com.embutidosdemo.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Getter
@Setter
@Table(name="choferes")
public class Chofer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty("idChofer")
    private Integer idChofer;

    @NotNull
    @Column(name = "nombre_chofer", nullable = false)
    private String nombreChofer;

}
