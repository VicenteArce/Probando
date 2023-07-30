package cl.DBD.ejemplo.services;

import cl.DBD.ejemplo.Models.Tipo_usuario;
import cl.DBD.ejemplo.repositories.Tipo_usuariorepository;

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
public class Tipo_usuarioService {
    private final Tipo_usuariorepository Tipo_usuariorepository;

    Tipo_usuarioService(Tipo_usuariorepository Tipo_usuariorepository){
        this.Tipo_usuariorepository = Tipo_usuariorepository;
    }

    //Crear C
    @PostMapping("/Tipo_usuario")
    @ResponseBody
    public Tipo_usuario crear(@RequestBody Tipo_usuario Tipo_usuario){
        Tipo_usuario resultado = Tipo_usuariorepository.crear(Tipo_usuario);
        return resultado;
    }

    //Get R
    @GetMapping("/Tipo_usuario")
    public List<Tipo_usuario> getAllTipo_usuarios(){
        return Tipo_usuariorepository.getAll();
    }

    //Get By
    @GetMapping("/Tipo_usuario/{codigo_tipo_usuario}")
    public List<Tipo_usuario> getTipo_usuario(@PathVariable int codigo_tipo_usuario){
        return Tipo_usuariorepository.show(codigo_tipo_usuario);
    }

    //Actualizar U
    @PutMapping("/Tipo_usuario/{codigo_tipo_usuario}")
    @ResponseBody
    public String updateTipo_usuario(@RequestBody Tipo_usuario Tipo_usuario, @PathVariable int codigo_tipo_usuario){
        String retorno = Tipo_usuariorepository.update(Tipo_usuario,codigo_tipo_usuario);
        return retorno;
    }

    //Borrar D
    @DeleteMapping("/Tipo_usuario/{codigo_tipo_usuario}")
    public void borrar(@PathVariable int codigo_tipo_usuario){
        Tipo_usuariorepository.delete(codigo_tipo_usuario);
    }
}

