package cl.DBD.ejemplo.services;
import cl.DBD.ejemplo.Models.Usuario;

import org.springframework.web.bind.annotation.*;


import cl.DBD.ejemplo.repositories.Usuariorepository;

import java.util.List;

@CrossOrigin
@RestController
public class UsuarioService {

    private final Usuariorepository UsuarioRepository;

    UsuarioService(Usuariorepository UsuarioRepository) { this.UsuarioRepository = UsuarioRepository;}

    // Crear C
    @PostMapping("/Usuario")
    @ResponseBody
    public Usuario crear(@RequestBody Usuario Usuario){
        Usuario resultado = UsuarioRepository.crear(Usuario);
        return resultado;
    }

    // Get R
    @GetMapping("/Usuario")
    public List<Usuario> getAllUsuario(){ return UsuarioRepository.getAll();}

    //Get By
    @GetMapping("/Usuario/{codigo_usuario}")
    public List<Usuario> getUsuario(@PathVariable int codigo_usuario){ return UsuarioRepository.show(codigo_usuario);}

    //Actualizar U
    @PutMapping("/Usuario/{codigo_usuario}")
    @ResponseBody
    public String updateUsuario(@RequestBody Usuario Usuario,@PathVariable int codigo_usuario) {
        String retorno = UsuarioRepository.update(Usuario, codigo_usuario);
        return retorno;
    }

    // Eliminar D
    @DeleteMapping("/Usuario/{codigo_usuario}")
    public void borrar(@PathVariable int codigo_usuario){UsuarioRepository.delete(codigo_usuario);}

}
