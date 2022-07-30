package com.embutidosdemo.application.controllers;

import com.embutidosdemo.application.dto.Respuesta;
import com.embutidosdemo.application.dto.RespuestaChofer;
import com.embutidosdemo.application.dto.RespuestaRegistro;
import com.embutidosdemo.domain.entities.Chofer;
import com.embutidosdemo.domain.entities.Registro;
import com.embutidosdemo.domain.services.ChoferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;

@RestController
@RequestMapping("/chofer")
public class ChoferController {

    @Autowired
    ChoferService choferService;

    @Value("Chofer creado")
    private String msgCrear;

    @Value("Error al momento de procesar el servicio.")
    private String msgErrorProceso;


    @PostMapping(value="/crear", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<RespuestaChofer> crearEstado(@RequestBody Chofer chofer){
        RespuestaChofer res = new RespuestaChofer();

        try {

            res.setSatisfactorio(true);
            res.setCodigo("101");
            res.setMensaje(msgCrear);
            Chofer chofer1 = choferService.crearChofer(chofer);

            res.setData(chofer1);

            if (res.isSatisfactorio() == true){
                return new ResponseEntity<RespuestaChofer>(res, HttpStatus.OK);
            }

            else {
                return new ResponseEntity<RespuestaChofer>(res, HttpStatus.BAD_REQUEST);
            }

        } catch(InterruptedException e){
            RespuestaChofer respuesta = new RespuestaChofer();
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("109");
            respuesta.setMensaje(msgErrorProceso + e.getMessage());
            return new ResponseEntity<>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/listar", produces = {"application/json"})
    public ResponseEntity<List<Chofer>> listarRegistro(){
        List<Chofer> lista = choferService.listarChoferes();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

}
