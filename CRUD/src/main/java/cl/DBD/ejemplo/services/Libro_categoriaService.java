package cl.DBD.ejemplo.services;

import cl.DBD.ejemplo.Models.Libro_categoria;
import cl.DBD.ejemplo.repositories.Libro_categoriarepository;

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
public class Libro_categoriaService {
    private final Libro_categoriarepository Libro_categoriarepository;

    Libro_categoriaService(Libro_categoriarepository Libro_categoriarepository) {this.Libro_categoriarepository = Libro_categoriarepository;}


    //Crear C

    @PostMapping("/Libro_categoria")
    @ResponseBody
    public Libro_categoria crear(@RequestBody Libro_categoria Libro_categoria){
        Libro_categoria resultado = Libro_categoriarepository.crear(Libro_categoria);
        return resultado;
    }

    //Get R
    @GetMapping("/Libro_categoria")
    public List<Libro_categoria> getAllLibro_categoria(){ return Libro_categoriarepository.getAll();}

    //Get By
    @GetMapping("/Libro_categoria/{codigo_libro_categoria}")
    public List<Libro_categoria> getLibro_categoria(@PathVariable int codigo_libro_categoria){return Libro_categoriarepository.show(codigo_libro_categoria);}


    //Actualizar U
    @PutMapping("/Libro_categoria/{codigo_libro_categoria}")
    @ResponseBody
    public String updateLibro_categoria(@RequestBody Libro_categoria Libro_categoria,@PathVariable int codigo_libro_categoria){
        String retorno = Libro_categoriarepository.update(Libro_categoria, codigo_libro_categoria);
        return retorno;
    }


    //Eliminar D
    @DeleteMapping("/Libro_categoria/{codigo_libro_categoria}")
    public void borrar(@PathVariable int codigo_libro_categoria){Libro_categoriarepository.delete(codigo_libro_categoria);}
}
