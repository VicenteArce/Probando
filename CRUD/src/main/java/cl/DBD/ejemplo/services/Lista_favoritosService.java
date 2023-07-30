package cl.DBD.ejemplo.services;

import cl.DBD.ejemplo.Models.Lista_favoritos;
import cl.DBD.ejemplo.repositories.Lista_favoritosrepository;
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
public class Lista_favoritosService {
    private final Lista_favoritosrepository Lista_favoritosrepository;

    Lista_favoritosService(Lista_favoritosrepository Lista_favoritosrepository) {this.Lista_favoritosrepository = Lista_favoritosrepository;}


    //Crear C
    @PostMapping("/Lista_favoritos")
    @ResponseBody
    public Lista_favoritos crear(@RequestBody Lista_favoritos Lista_favoritos){
        Lista_favoritos resultado = Lista_favoritosrepository.crear(Lista_favoritos);
        return resultado;
    }

    //Get R
    @GetMapping("/Lista_favoritos")
    public List<Lista_favoritos> getAllLista_favoritos(){
        return Lista_favoritosrepository.getAll();
    }

    //Get By
    @GetMapping("/Lista_favoritos/{codigo_lista_favoritos}")
    public List<Lista_favoritos> getLista_favoritos(@PathVariable int codigo_lista_favoritos){
        return  Lista_favoritosrepository.show(codigo_lista_favoritos);
    }

    //Actualizar U
    @PutMapping("/Lista_favoritos/{codigo_lista_favoritos}")
    @ResponseBody
    public String updateLista_favoritos(@RequestBody Lista_favoritos Lista_favoritos, @PathVariable int codigo_lista_favoritos){
        String retorno = Lista_favoritosrepository.update(Lista_favoritos, codigo_lista_favoritos);
        return retorno;
    }


    //Borrar D
    @DeleteMapping("/Lista_favoritos/{codigo_listafa_voritos}")
    public void borrar(@PathVariable int codigo_lista_favoritos){
        Lista_favoritosrepository.delete(codigo_lista_favoritos);
    }





}
