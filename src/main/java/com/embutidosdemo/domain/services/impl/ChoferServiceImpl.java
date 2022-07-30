package com.embutidosdemo.domain.services.impl;

import com.embutidosdemo.domain.entities.Chofer;
import com.embutidosdemo.domain.repositories.ChoferRepository;
import com.embutidosdemo.domain.repositories.RegistroRepository;
import com.embutidosdemo.domain.services.ChoferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoferServiceImpl implements ChoferService {

    @Autowired
    ChoferRepository choferRepository;

    @Override
    public Chofer crearChofer(Chofer chofer) throws InterruptedException {
        return choferRepository.save(chofer);
    }

    @Override
    public List<Chofer> listarChoferes() {
        return choferRepository.findAll();
    }
}
