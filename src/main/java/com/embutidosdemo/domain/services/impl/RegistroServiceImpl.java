package com.embutidosdemo.domain.services.impl;

import com.embutidosdemo.application.dto.Respuesta;
import com.embutidosdemo.domain.entities.Registro;
import com.embutidosdemo.domain.repositories.RegistroRepository;
import com.embutidosdemo.domain.services.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroServiceImpl implements RegistroService {

    @Autowired
    RegistroRepository registroRepository;

    @Override
    public Registro crearRegistro(Registro registro) throws InterruptedException {
        return registroRepository.save(registro);
    }

    @Override
    public Registro modificarRegistro(Registro registro) throws InterruptedException {
        return registroRepository.save(registro);
    }

    @Override
    public Respuesta eliminarRegistro(Integer idRegistro) throws InterruptedException {

        Respuesta respuesta = new Respuesta();

        if (registroRepository.existsById(idRegistro)){
            registroRepository.deleteById(idRegistro);
            respuesta.setSatisfactorio(true);
            respuesta.setCodigo("101");
            respuesta.setMensaje("Registro Eliminado.");
            return respuesta;
        }
        else {
            throw new InterruptedException("Error en la respuesta del Servicio Invocado.");
        }
    }

    @Override
    public List<Registro> listarRegistros() {
        return registroRepository.findAll();
    }
}
