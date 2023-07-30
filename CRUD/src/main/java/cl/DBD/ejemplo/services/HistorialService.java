package cl.DBD.ejemplo.services;

import cl.DBD.ejemplo.Models.Historial;
import org.springframework.web.bind.annotation.*;
import cl.DBD.ejemplo.repositories.Historialrepository;


import java.util.List;

public class HistorialService {

    private final Historialrepository Historialrepository;

    HistorialService(Historialrepository Historialrepository){
        this.Historialrepository =Historialrepository;
    }

    //Crear C
    @PostMapping("/Historial")
    @ResponseBody
    public Historial crear(@RequestBody Historial Historial){
        Historial resultado = Historialrepository.crear(Historial);
        return resultado;
    }


    //Get R
    @GetMapping("/Historial")
    public List<Historial> getAllHistorial(){
        return Historialrepository.getAll();
    }

    //Get By
    @GetMapping("/Historial/{codigo_historial}")
    public List<Historial> getPermiso(@PathVariable int codigo_historial){
        return  Historialrepository.show(codigo_historial);
    }

    //Actualizar U
    @PutMapping("/Historial/{codigo_historial}")
    @ResponseBody
    public String updateHistorial(@RequestBody Historial Historial, @PathVariable int codigo_historial){
        String retorno = Historialrepository.update(Historial, codigo_historial);
        return retorno;
    }

    //Borrar D
    @DeleteMapping("/Historial/{codigo_historial}")
    public void borrar(@PathVariable int codigo_historial){
        Historialrepository.delete(codigo_historial);
    }

}
