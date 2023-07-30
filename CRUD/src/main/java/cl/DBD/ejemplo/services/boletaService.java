package cl.DBD.ejemplo.services;

import cl.DBD.ejemplo.Models.Boleta;
import org.springframework.web.bind.annotation.*;
import cl.DBD.ejemplo.repositories.Boletarepository;

import java.util.List;

@CrossOrigin
@RestController
public class boletaService {
    private final Boletarepository BoletaRepository;

    boletaService(Boletarepository BoletaRepository){
        this.BoletaRepository = BoletaRepository;
    }

    // Crear C
    @PostMapping("/Boleta")
    @ResponseBody
    public Boleta crear(@RequestBody Boleta Boleta){
        Boleta resultado = BoletaRepository.crear(Boleta);
        return resultado;
    }

    // Get R
    @GetMapping("/Boleta")
    public List<Boleta> getAllBoleta(){
        return BoletaRepository.getAll();}

    //Get By
    @GetMapping("/Boleta/{codigo_boleta}")
    public List<Boleta> getBoleta(@PathVariable int codigo_boleta){ return BoletaRepository.show(codigo_boleta);}


    //Actualizar U
    @PutMapping("/Boleta/{codigo_boleta}")
    @ResponseBody
    public String apdateUsuario(@RequestBody Boleta Boleta,@PathVariable int codigo_boleta) {
        String retorno = BoletaRepository.update(Boleta, codigo_boleta);
        return retorno;
    }

    // Eliminar D
    @DeleteMapping("/Boleta/{codigo_boleta}")
    public void borrar(@PathVariable int codigo_boleta){BoletaRepository.delete(codigo_boleta);}

}
