package com.embutidosdemo.application.controllers;

import com.embutidosdemo.application.dto.Respuesta;
import com.embutidosdemo.application.dto.RespuestaRegistro;
import com.embutidosdemo.domain.entities.Registro;
import com.embutidosdemo.domain.services.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros")
public class RegistroController {

    @Autowired
    RegistroService registroService;

    @Value("Registro creado")
    private String msgCrear;

    @Value("Registro editado")
    private String msgEditar;

    @Value("Error al momento de procesar el servicio.")
    private String msgErrorProceso;

    @PostMapping(value="/crear", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<RespuestaRegistro> crearEstado(@RequestBody Registro registro){
        RespuestaRegistro res = new RespuestaRegistro();

        try {

            res.setSatisfactorio(true);
            res.setCodigo("101");
            res.setMensaje(msgCrear);
            Registro registro1 = registroService.crearRegistro(registro);

            res.setData(registro1);

            if (res.isSatisfactorio() == true){
                return new ResponseEntity<RespuestaRegistro>(res, HttpStatus.OK);
            }

            else {
                return new ResponseEntity<RespuestaRegistro>(res, HttpStatus.BAD_REQUEST);
            }

        } catch(InterruptedException e){
            RespuestaRegistro respuesta = new RespuestaRegistro();
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("109");
            respuesta.setMensaje(msgErrorProceso + e.getMessage());
            return new ResponseEntity<>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value="/editar", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<RespuestaRegistro> modificarRegistro(@RequestBody Registro registro){
        RespuestaRegistro res = new RespuestaRegistro();

        try {

            res.setSatisfactorio(true);
            res.setCodigo("101");
            res.setMensaje(msgEditar);
            Registro registro1 = registroService.modificarRegistro(registro);

            res.setData(registro1);

            if (res.isSatisfactorio() == true){
                return new ResponseEntity<RespuestaRegistro>(res, HttpStatus.OK);
            }

            else {
                return new ResponseEntity<RespuestaRegistro>(res, HttpStatus.BAD_REQUEST);
            }

        } catch(InterruptedException e){
            RespuestaRegistro respuesta = new RespuestaRegistro();
            respuesta.setSatisfactorio(false);
            respuesta.setCodigo("109");
            respuesta.setMensaje(msgErrorProceso + e.getMessage());
            return new ResponseEntity<>(respuesta,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="/eliminar/{idRegistro}", produces = {"application/json"})
    public ResponseEntity<Respuesta> borrarRegistro(@PathVariable("idRegistro") Integer idRegistro){
        Respuesta res = new Respuesta();

        try {

            res = registroService.eliminarRegistro(idRegistro);


            if (res.isSatisfactorio() == true){
                return new ResponseEntity<Respuesta>(res, HttpStatus.OK);
            }

            else {
                return new ResponseEntity<Respuesta>(res, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch(InterruptedException e){
            res.setSatisfactorio(false);
            res.setCodigo("109");
            res.setMensaje(msgErrorProceso);
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        catch(Exception e){

            res.setSatisfactorio(false);
            res.setCodigo("109");
            res.setMensaje(e.getMessage());
            return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/listar", produces = {"application/json"})
    public ResponseEntity<List<Registro>> listarRegistro(){
        List<Registro> lista = registroService.listarRegistros();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

}
