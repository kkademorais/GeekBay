package ascii.ecommerce.demo.controllers;

import ascii.ecommerce.demo.domain.produto.ProdutoPatchRequestDTO;
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

    @GetMapping("/produto/nome/{nome}")
    public ResponseEntity<ProdutoResponseDTO> getProdutoByNome(@PathVariable String nome){
        return ResponseEntity.ok(this.produtoService.getProdutoByNome(nome));
    }

    @GetMapping("/produto/categoria/{categoria_id}")
    public ResponseEntity<List<ProdutoResponseDTO>> getProdutoListByCategoria(@PathVariable Integer categoria_id){
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

    @PutMapping("/produto/nome/{nome}")
    public ResponseEntity updateProdutoByNome(@PathVariable String nome, @RequestBody ProdutoRequestDTO produtoRequestDTO){
        this.produtoService.updateProdutoByNome(nome, produtoRequestDTO);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/produto/{id}")
    public ResponseEntity updatePartialProdutoById(@PathVariable int id, @RequestBody ProdutoPatchRequestDTO produtoPatchRequestDTO){
        this.produtoService.updatePartialProdutoById(id, produtoPatchRequestDTO);
        return ResponseEntity.ok().build();
    }


        // DELETE
    @DeleteMapping("/produto/{id}")
    public ResponseEntity deleteProdutoById(@PathVariable int id){
        this.produtoService.deleteProdutoById(id);
        return ResponseEntity.ok().build();
    }
}
