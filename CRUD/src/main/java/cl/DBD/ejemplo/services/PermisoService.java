package cl.DBD.ejemplo.services;

import cl.DBD.ejemplo.Models.Permiso;
import cl.DBD.ejemplo.repositories.Permisorepository;

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
public class PermisoService {
    private final Permisorepository Permisorepository;

    PermisoService(Permisorepository Permisorepository){
        this.Permisorepository = Permisorepository;
    }

    //Crear C
    @PostMapping("/Permiso")
    @ResponseBody
    public Permiso crear(@RequestBody Permiso Permiso){
        Permiso resultado = Permisorepository.crear(Permiso);
        return resultado;
    }


    //Get R
    @GetMapping("/Permiso")
    public List<Permiso> getAllPermisos(){
        return Permisorepository.getAll();
    }

    //Get By
    @GetMapping("/Permiso/{codigo_permiso}")
    public List<Permiso> getPermiso(@PathVariable int codigo_permiso){
        return  Permisorepository.show(codigo_permiso);
    }

    //Actualizar U
    @PutMapping("/Permiso/{codigo_permiso}")
    @ResponseBody
    public String updatePermiso(@RequestBody Permiso Permiso, @PathVariable int codigo_permiso){
        String retorno = Permisorepository.update(Permiso,codigo_permiso);
        return retorno;
    }

    //Borrar D
    @DeleteMapping("/Permiso/{codigo_permiso}")
    public void borrar(@PathVariable int codigo_permiso){
        Permisorepository.delete(codigo_permiso);
    }

}
