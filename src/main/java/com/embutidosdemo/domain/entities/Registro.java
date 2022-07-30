package com.embutidosdemo.domain.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@ToString
@Getter
@Setter
@Table(name="registros")
public class Registro {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty("idRegistro")
    private Integer idRegistro;

    @ManyToOne
    @JoinColumn(name = "id_chofer", nullable = false, foreignKey = @ForeignKey(name = "FK_id_chofer"))
    private Chofer chofer;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha_salida",nullable = false)
    private Date fechaSalida;

    @NotNull
    @Column(name = "hora_salida", nullable = false)
    private String horaSalida;

    @NotNull
    @Column(name = "placa_vehiculo", nullable = false)
    private String placaVehiculo;

}
