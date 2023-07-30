package cl.DBD.ejemplo.services;


import cl.DBD.ejemplo.Models.Historial_libro;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cl.DBD.ejemplo.repositories.Historial_librorepository;

import java.util.List;

@CrossOrigin
@RestController
public class Historial_libroService {
    private final Historial_librorepository Historial_librorepository;

    Historial_libroService(Historial_librorepository Historial_librorepository){this.Historial_librorepository = Historial_librorepository;}

    //Crear C
    @PostMapping("/Historial_libro")
    @ResponseBody
    public Historial_libro crear(@RequestBody Historial_libro Historial_libro){
        Historial_libro resultado = Historial_librorepository.crear(Historial_libro);
        return resultado;
    }

    //Get R
    @GetMapping("/Historial_libro")
    public List<Historial_libro> getAllHistorial_libro(){return  Historial_librorepository.getAll();}

    //Get By
    @GetMapping("/Historial_libro/{codigo_historial_libro}")
    public List<Historial_libro> getHistorial_libro(@PathVariable int codigo_historial_libro){
        return Historial_librorepository.show(codigo_historial_libro);
    }

    //Actualizar U
    @PutMapping("/Historial_libro/{codigo_historial_libro}")
    @ResponseBody
    public String updateHistorial_libro(@RequestBody Historial_libro Historial_libro, @PathVariable int codigo_historial_libro){
        String retorno = Historial_librorepository.update(Historial_libro, codigo_historial_libro);
        return retorno;
    }

    //Eliminar D
    @DeleteMapping("/Historial_libro/{codigo_historial_libro}")
    public  void borrar(@PathVariable int codigo_historial_libro){
        Historial_librorepository.delete(codigo_historial_libro);
    }

}
