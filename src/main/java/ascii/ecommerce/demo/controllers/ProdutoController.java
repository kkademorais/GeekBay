package ascii.ecommerce.demo.controllers;

import ascii.ecommerce.demo.domain.produto.ProdutoRequestDTO;
import ascii.ecommerce.demo.domain.produto.ProdutoResponseDTO;
import ascii.ecommerce.demo.services.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }


        // GET

    @GetMapping("/produto")
    public ResponseEntity<List<ProdutoResponseDTO>> getProdutoList(){
        return ResponseEntity.ok(this.produtoService.getProdutoList());
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<ProdutoResponseDTO> getProdutoById(@PathVariable int id){
        return ResponseEntity.ok(this.produtoService.getProdutoById(id));
    }

    @GetMapping("/produto/{nome}")
    public ResponseEntity<ProdutoResponseDTO> getProdutoByNome(@PathVariable String nome){
        return ResponseEntity.ok(this.produtoService.getProdutoByNome(nome));
    }

    @GetMapping("/produto/{categoria_id}")
    public ResponseEntity<List<ProdutoResponseDTO>> getProdutoListByCategoria(@PathVariable int categoria_id){
        return ResponseEntity.ok(this.produtoService.getProdutoListByCategoria(categoria_id));
    }


        // POST

    @PostMapping("/produto")
    public ResponseEntity addNewProduto(@RequestBody ProdutoRequestDTO produtoRequestDTO){
        this.produtoService.addNewProduto(produtoRequestDTO);
        return ResponseEntity.ok().build();
    }


        // PUT
    @PutMapping("/produto/{id}")
    public ResponseEntity updateProdutoById(@PathVariable int id, @RequestBody ProdutoRequestDTO produtoRequestDTO){
        this.produtoService.updateProdutoById(id, produtoRequestDTO);
        return ResponseEntity.ok().build();
    }
    //Falta fazer updateByNome


        // DELETE
    @DeleteMapping("/produto/{id}")
    public ResponseEntity deleteProdutoById(@PathVariable int id){
        this.produtoService.deleteProdutoById(id);
        return ResponseEntity.ok().build();
    }
}
