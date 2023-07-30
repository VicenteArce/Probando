package cl.DBD.ejemplo.services;

import cl.DBD.ejemplo.Models.Categoria;
import org.springframework.web.bind.annotation.*;
import cl.DBD.ejemplo.repositories.Categoriarepository;

import java.util.List;

@CrossOrigin
@RestController
public class CategoriaService {
    private final Categoriarepository CategoriaRepository;


    public CategoriaService(Categoriarepository categoriaRepository) {
        CategoriaRepository = categoriaRepository;
    }

    // Crear C
    @PostMapping("/Categoria")
    @ResponseBody
    public Categoria crear(@RequestBody Categoria Categoria){
        Categoria resultado = CategoriaRepository.crear(Categoria);
        return resultado;
    }

    // Get R
    @GetMapping("/Categoria")
    public List<Categoria> getAllCategoria(){ return CategoriaRepository.getAll();}

    //Get By
    @GetMapping("/Categoria/{codigo_categoria}")
    public List<Categoria> getCategoria(@PathVariable int codigo_categoria){ return CategoriaRepository.show(codigo_categoria);}

    //Actualizar U
    @PutMapping("/Categoria/{codigo_categoria}")
    @ResponseBody
    public String updateCategoria(@RequestBody Categoria Categoria,@PathVariable int codigo_categoria) {
        String retorno = CategoriaRepository.update(Categoria, codigo_categoria);
        return retorno;
    }
    // Eliminar D
    @DeleteMapping("/Categoria/{codigo_categoria}")
    public void borrar(@PathVariable int codigo_categoria){CategoriaRepository.delete(codigo_categoria);}

}
