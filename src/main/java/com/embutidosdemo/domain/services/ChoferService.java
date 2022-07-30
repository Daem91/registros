package com.embutidosdemo.domain.services;

import com.embutidosdemo.domain.entities.Chofer;

import java.util.List;

public interface ChoferService {

    Chofer crearChofer(Chofer chofer) throws InterruptedException;

    List<Chofer> listarChoferes();

}
