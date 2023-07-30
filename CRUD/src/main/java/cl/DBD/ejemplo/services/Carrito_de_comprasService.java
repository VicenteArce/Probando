package cl.DBD.ejemplo.services;

import cl.DBD.ejemplo.Models.Carrito_de_compras;
import org.springframework.web.bind.annotation.*;
import cl.DBD.ejemplo.repositories.Carrito_de_comprasrepository;

import java.util.List;

@CrossOrigin
@RestController
public class Carrito_de_comprasService {

    private final Carrito_de_comprasrepository Carrito_de_comprasRepository;

    public Carrito_de_comprasService(Carrito_de_comprasrepository carrito_de_comprasRepository) {
        Carrito_de_comprasRepository = carrito_de_comprasRepository;
    }

    // Crear C
    @PostMapping("/Carrito_de_compras")
    @ResponseBody
    public Carrito_de_compras crear(@RequestBody Carrito_de_compras Carrito_de_compras){
        Carrito_de_compras resultado = Carrito_de_comprasRepository.crear(Carrito_de_compras);
        return resultado;
    }

    // Get R
    @GetMapping("/Carrito_de_compras")
    public List<Carrito_de_compras> getAllCarrito_de_compras(){ return Carrito_de_comprasRepository.getAll();}

    //Get By
    @GetMapping("/Carrito_de_compras/{codigo_carrito}")
    public List<Carrito_de_compras> getCarrito_de_compras(@PathVariable int codigo_carrito){ return Carrito_de_comprasRepository.show(codigo_carrito);}

    //Actualizar U
    @PutMapping("/Carrito_de_compras/{codigo_carrito}")
    @ResponseBody
    public String updateCarrito_de_compras(@RequestBody Carrito_de_compras Carrito_de_compras,@PathVariable int codigo_carrito) {
        String retorno = Carrito_de_comprasRepository.update(Carrito_de_compras, codigo_carrito);
        return retorno;
    }

    // Eliminar D
    @DeleteMapping("/Carrito_de_compras/{codigo_carrito}")
    public void borrar(@PathVariable int codigo_carrito){Carrito_de_comprasRepository.delete(codigo_carrito);}

}
