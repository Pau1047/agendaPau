package Ex2av_Pau.controladores;

import Ex2av_Pau.entidades.ArteMarcial;
import Ex2av_Pau.servicios.ArteMarcialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/arte_marcial")
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
