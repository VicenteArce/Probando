package cl.DBD.ejemplo.services;


import cl.DBD.ejemplo.Models.Libro_lista_favoritos;
import cl.DBD.ejemplo.repositories.Libro_lista_favoritosrepository;
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
public class Libro_lista_favoritosService {
    private final Libro_lista_favoritosrepository Libro_lista_favoritosrepository;

    Libro_lista_favoritosService(Libro_lista_favoritosrepository Libro_lista_favoritosrepository){
        this.Libro_lista_favoritosrepository = Libro_lista_favoritosrepository;
    }

    //Crear C
    @PostMapping("/Libro_lista_favoritos")
    @ResponseBody
    public Libro_lista_favoritos crear(@RequestBody Libro_lista_favoritos Libro_lista_favoritos){
        Libro_lista_favoritos resultado = Libro_lista_favoritosrepository.crear((Libro_lista_favoritos));
        return resultado;
    }


    //Get R
    @GetMapping("/Libro_lista_favoritos")
    public List<Libro_lista_favoritos> getAllLibro_lista_favoritos(){
        return Libro_lista_favoritosrepository.getAll();
    }

    //Get By
    @GetMapping("/Libro_lista_favoritos/{codigo_lista_libro_favoritos}")
    public List<Libro_lista_favoritos> getLibro_lista_favoritos(@PathVariable int codigo_lista_libro_favoritos){
        return Libro_lista_favoritosrepository.show(codigo_lista_libro_favoritos);
    }

    //Actualizar U
    @PutMapping("/Libro_lista_favoritos/{codigo_lista_libro_favoritos}")
    @ResponseBody
    public String updateLibro_lista_favoritos(@RequestBody Libro_lista_favoritos Libro_lista_favoritos, @PathVariable int codigo_lista_libro_favoritos){
        String retorno = Libro_lista_favoritosrepository.update(Libro_lista_favoritos, codigo_lista_libro_favoritos);
        return retorno;
    }

    //Borrar D
    @DeleteMapping("/Libro_lista_favoritos/{codigo_lista_libro_favoritos}")
    public void borrar(@PathVariable int codigo_lista_libro_favoritos){
        Libro_lista_favoritosrepository.delete(codigo_lista_libro_favoritos);
    }

}
