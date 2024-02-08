package agenda.controladores;

import agenda.entidades.ArteMarcial;
import agenda.servicios.ArteMarcialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artesmarciales")
public class ArteMarcialController {
    private final ArteMarcialService arteMarcialService;

    @Autowired
    public ArteMarcialController(ArteMarcialService arteMarcialService) {
        this.arteMarcialService = arteMarcialService;
    }

    @GetMapping
    public List<ArteMarcial> obtenerTodos(){
        return arteMarcialService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ArteMarcial getId(@PathVariable Long id){
        return arteMarcialService.getId(id);
    }

    @PostMapping
    public ArteMarcial save(@RequestBody ArteMarcial arteMarcial){
        return arteMarcialService.save(arteMarcial);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        arteMarcialService.delete(id);
    }

    @PutMapping("/{id}")
    public ArteMarcial modificarArteMarcial(@PathVariable Long id, @RequestBody ArteMarcial arteMarcial){
        return arteMarcialService.modificarArteMarcial(id,arteMarcial);
    }
}
