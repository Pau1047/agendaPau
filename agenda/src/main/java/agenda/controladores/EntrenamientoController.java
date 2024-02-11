package agenda.controladores;

import agenda.entidades.Entrenamiento;
import agenda.servicios.EntrenamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenador/entrenamiento")
public class EntrenamientoController {
    private final EntrenamientoService entrenamientoService;

    @Autowired
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
