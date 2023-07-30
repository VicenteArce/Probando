package cl.DBD.ejemplo.services;

import cl.DBD.ejemplo.Models.Libro;
import cl.DBD.ejemplo.repositories.Librorepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@CrossOrigin
@RestController
public class LibroService {
    private final Librorepository Librorepository;

    LibroService(Librorepository Librorepository){
        this.Librorepository = Librorepository;
    }

    //Crear C
    @PostMapping("/Libro")
    @ResponseBody
    public Libro crear(@RequestBody Libro Libro){
        Libro resultado = Librorepository.crear(Libro);
        return resultado;
    }


    //Get R
    @GetMapping("/Libro")
    public List<Libro> getAllLibros(){
        return Librorepository.getAll();
    }

    //Get By
    @GetMapping("/Libro/{id_libro}")
    public List<Libro> getLibro(@PathVariable int id_libro){
        return  Librorepository.show(id_libro);
    }

    //Actualizar U
    @PutMapping("/Libro/{id_libro}")
    @ResponseBody
    public String updateLibro(@RequestBody Libro Libro, @PathVariable int id_libro){
        String retorno = Librorepository.update(Libro, id_libro);
        return retorno;
    }

    //Borrar D
    @DeleteMapping("/Libro/{id_libro}")
    public void borrar(@PathVariable int id_libro){
        Librorepository.delete(id_libro);
    }

}
