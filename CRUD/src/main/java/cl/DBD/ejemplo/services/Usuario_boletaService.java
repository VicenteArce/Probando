package cl.DBD.ejemplo.services;


import cl.DBD.ejemplo.Models.Usuario_boleta;
import cl.DBD.ejemplo.repositories.Usuario_boletarepository;
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
public class Usuario_boletaService {
    private final Usuario_boletarepository Usuario_boletarepositority;

    Usuario_boletaService(Usuario_boletarepository Usuario_boletarepositority){
        this.Usuario_boletarepositority = Usuario_boletarepositority;
    }

    //Crear C
    @PostMapping("/Usuario_boleta")
    @ResponseBody
    public Usuario_boleta crear(@RequestBody Usuario_boleta Usuario_boleta){
        Usuario_boleta resultado = Usuario_boletarepositority.crear((Usuario_boleta));
        return resultado;
    }


    //Get R
    @GetMapping("Usuario_boleta")
    public List<Usuario_boleta> getAllUsario_boletas(){
        return Usuario_boletarepositority.getAll();
    }

    //Get By
    @GetMapping("/Usuario_boleta/{codigo_usuario_boleta}")
    public List<Usuario_boleta> getUsuario_boleta(@PathVariable int codigo_usuario_boleta){
        return Usuario_boletarepositority.show(codigo_usuario_boleta);
    }

    //Actualizar U
    @PutMapping("/Usuario_boleta/{codigo_usuario_boleta}")
    @ResponseBody
    public String updateUsuario_boleta(@RequestBody Usuario_boleta Usuario_boleta, @PathVariable int codigo_usuario_boleta){
        String retorno = Usuario_boletarepositority.update(Usuario_boleta, codigo_usuario_boleta);
        return retorno;
    }

    //Borrar D
    @DeleteMapping("/Usuario_boleta/{codigo_usuario_boleta}")
    public void borrar(@PathVariable int codigo_usuario_boleta){
        Usuario_boletarepositority.delete(codigo_usuario_boleta);
    }

}
