package cl.DBD.ejemplo.services;

import cl.DBD.ejemplo.Models.Agrega_libro_transaccion;

import org.springframework.web.bind.annotation.*;

import cl.DBD.ejemplo.repositories.Agrega_libro_transaccionrepository;

import java.util.List;


@CrossOrigin
@RestController
public class Agrega_libro_transaccionService {

    private final Agrega_libro_transaccionrepository Agrega_libro_transaccionRepository;

    Agrega_libro_transaccionService(Agrega_libro_transaccionrepository Agrega_libro_transaccionRepository){
        this.Agrega_libro_transaccionRepository = Agrega_libro_transaccionRepository;
    }

    //crea C
    @PostMapping("/Agrega_libro_transaccion")
    @ResponseBody
    public Agrega_libro_transaccion crear(@RequestBody Agrega_libro_transaccion Agrega_libro_transaccion){
        Agrega_libro_transaccion resultado = Agrega_libro_transaccionRepository.crear(Agrega_libro_transaccion);
        return resultado;
    }

    // Get R
    @GetMapping("/Agrega_libro_transaccion")
    public List<Agrega_libro_transaccion> getAllAgrega_libro_transaccion(){ return Agrega_libro_transaccionRepository.getAll();}


    //Get By
    @GetMapping("/Agrega_libro_transaccion/{serial_alt}")
    public List<Agrega_libro_transaccion> getAgrega_libro_transaccion(@PathVariable int codigo_agregar_libro){
        return Agrega_libro_transaccionRepository.show(codigo_agregar_libro);}

    //Actualizar U
    @PutMapping("/Agrega_libro_transaccion/{serial_alt}")
    @ResponseBody
    public String updateAGREGALIBRO(@RequestBody Agrega_libro_transaccion Agrega_libro_transaccion,@PathVariable int codigo_agregar_libro) {
        String retorno = Agrega_libro_transaccionRepository.update(Agrega_libro_transaccion, codigo_agregar_libro);
        return retorno;
    }


    // Eliminar D
    @DeleteMapping("/Agrega_libro_transaccion/{serial_alt}")
    public void borrar(@PathVariable int codigo_agregar_libro){Agrega_libro_transaccionRepository.delete(codigo_agregar_libro);}


}
