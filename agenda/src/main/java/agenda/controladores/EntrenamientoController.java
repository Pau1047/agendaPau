package agenda.controladores;

import agenda.entidades.ArteMarcial;
import agenda.entidades.Entrenamiento;
import agenda.servicios.EntrenamientoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenamiento")
public class EntrenamientoController {
    private final EntrenamientoService entrenamientoService;

    public EntrenamientoController(EntrenamientoService entrenamientoService) {
        this.entrenamientoService = entrenamientoService;
    }

    @GetMapping
    public List<Entrenamiento> obtenerTodos(){
        return entrenamientoService.obtenerTodos();
    }

    @PostMapping
    public Entrenamiento save(@RequestBody Entrenamiento entrenamiento){
        return entrenamientoService.save(entrenamiento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        entrenamientoService.delete(id);
    }

    @PutMapping("/{id}")
    public Entrenamiento modificarEntrenamiento(@PathVariable Long id, @RequestBody Entrenamiento entrenamiento) {
        return entrenamientoService.modificarEntrenamiento(id, entrenamiento);
    }
}
