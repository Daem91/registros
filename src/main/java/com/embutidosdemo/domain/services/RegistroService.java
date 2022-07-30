package com.embutidosdemo.domain.services;

import com.embutidosdemo.application.dto.Respuesta;
import com.embutidosdemo.domain.entities.Registro;

import java.util.List;

public interface RegistroService {

    Registro crearRegistro(Registro registro) throws InterruptedException;
    Registro modificarRegistro(Registro registro) throws InterruptedException;
    Respuesta eliminarRegistro(Integer idEstado) throws InterruptedException;
    List<Registro> listarRegistros() ;

}
