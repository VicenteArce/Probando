package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.Models.Calificacion_libro;
import org.springframework.web.bind.annotation.*;
import cl.DBD.ejemplo.repositories.Calificacion_librorepository;

import java.util.List;


@CrossOrigin
@RestController
public class Calificacion_libroService {
    private final Calificacion_librorepository Calificacion_libroRepository;

    Calificacion_libroService(Calificacion_librorepository Calificacion_libroRepository){
        this.Calificacion_libroRepository = Calificacion_libroRepository;
    }

    // Crear C
    @PostMapping("/Calificacion_libro")
    @ResponseBody
    public Calificacion_libro crear(@RequestBody Calificacion_libro Calificacion_libro){
        Calificacion_libro resultado = Calificacion_libroRepository.crear(Calificacion_libro);
        return resultado;
    }

    // Get R
    @GetMapping("/Calificacion_libro")
    public List<Calificacion_libro> getAllCalificacion_libro(){ return Calificacion_libroRepository.getAll();}

    //Get By
    @GetMapping("/Calificacion_libro/{codigo_calificacion}")
    public List<Calificacion_libro> getCalificacion_libro(@PathVariable int codigo_calificacion){ return Calificacion_libroRepository.show(codigo_calificacion);}

    //Actualizar U
    @PutMapping("/Catrgoria/{codigo_calificacion}")
    @ResponseBody
    public String apdateUsuario(@RequestBody Calificacion_libro Calificacion_libro,@PathVariable int codigo_calificacion) {
        String retorno = Calificacion_libroRepository.update(Calificacion_libro, codigo_calificacion);
        return retorno;
    }

    // Eliminar D
    @DeleteMapping("/Calificacion_libro/{codigo_calificacion}")
    public void borrar(@PathVariable int codigo_calificacion){Calificacion_libroRepository.delete(codigo_calificacion);}



}
