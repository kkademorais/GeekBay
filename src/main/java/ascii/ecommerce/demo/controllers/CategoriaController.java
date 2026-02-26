package ascii.ecommerce.demo.controllers;

import ascii.ecommerce.demo.domain.categoria.CategoriaRequestDTO;
import ascii.ecommerce.demo.domain.categoria.CategoriaResponseDTO;
import ascii.ecommerce.demo.services.CategoriaService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

        // GET

    @GetMapping()
    public ResponseEntity<List<CategoriaResponseDTO>> getCategoriaList(){
        return ResponseEntity.ok(this.categoriaService.getCategoriaList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> getCategoriaById(@PathVariable Integer id){
        return ResponseEntity.ok(this.categoriaService.getCategoriaById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<CategoriaResponseDTO> getCategoriaByNome(@PathVariable String nome){
        return ResponseEntity.ok(this.categoriaService.getCategoriaByNome(nome));
    }

        // POST

    @PostMapping()
    public ResponseEntity addNewCategoria(@RequestBody CategoriaRequestDTO categoriaRequestDTO){
        this.categoriaService.addNewCategoria(categoriaRequestDTO);
        return ResponseEntity.ok().build();
    }

        // PUT

    @PutMapping("/{id}")
    public ResponseEntity updateCategoriaById(@PathVariable Integer id, @RequestBody CategoriaRequestDTO categoriaRequestDTO){
        this.categoriaService.updateCategoriaById(id, categoriaRequestDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/nome/{nome}")
    public ResponseEntity updateCategoriaByNome(@PathVariable String nome, @RequestBody CategoriaRequestDTO categoriaRequestDTO){
        this.categoriaService.updateCategoriaByNome(nome, categoriaRequestDTO);
        return ResponseEntity.ok().build();
    }

        // DELETE

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategoriaById(@PathVariable Integer id){
        this.categoriaService.deleteCategoriaById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/nome/{nome}")
    public ResponseEntity deleteCategoriaByNome(@PathVariable String nome){
        this.categoriaService.deleteCategoriaByNome(nome);
        return ResponseEntity.ok().build();
    }


}
