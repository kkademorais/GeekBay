package ascii.ecommerce.demo.services;

import ascii.ecommerce.demo.domain.categoria.Categoria;
import ascii.ecommerce.demo.domain.categoria.CategoriaRequestDTO;
import ascii.ecommerce.demo.domain.categoria.CategoriaResponseDTO;
import ascii.ecommerce.demo.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

        // GET

    public List<CategoriaResponseDTO> getCategoriaList(){
        return this.categoriaRepository.findAll().stream().map(categoria -> new CategoriaResponseDTO(categoria)).toList();
    }

    public CategoriaResponseDTO getCategoriaById(Integer id){
        return new CategoriaResponseDTO(this.categoriaRepository.findById(id).get());
    }

    public CategoriaResponseDTO getCategoriaByNome(String nome){
        //return new CategoriaResponseDTO(this.categoriaRepository.findByNome(nome));
        return new CategoriaResponseDTO(
                this.categoriaRepository.findAll().stream().filter(categoria -> categoria.getNome().equalsIgnoreCase(nome)).findFirst().get()
        );
    }

        // POST

    public void addNewCategoria(CategoriaRequestDTO categoriaRequestDTO){
        this.categoriaRepository.save(new Categoria(categoriaRequestDTO));
    }

        // PUT

    public void updateCategoriaById(Integer id, CategoriaRequestDTO categoriaRequestDTO){

        Categoria categoriaUpdate = new Categoria(categoriaRequestDTO);

            // Falta adicionar um try-catch pra pegar o use-case onde o id é inválido
        Categoria categoriaASerAtualizada = this.categoriaRepository.findById(id).get();
        categoriaUpdate.setId(id);

        if(categoriaRequestDTO.descricao() == null) categoriaUpdate.setDescricao(categoriaASerAtualizada.getDescricao());

        this.categoriaRepository.save(categoriaUpdate);
    }

    public void updateCategoriaByNome(String nome, CategoriaRequestDTO categoriaRequestDTO){

        Categoria categoriaUpdate = new Categoria(categoriaRequestDTO);

        Categoria categoriaASerAtualizada = this.categoriaRepository.findAll().stream().filter(categoria -> categoria.getNome().equalsIgnoreCase(nome)).findFirst().get();
        categoriaUpdate.setId(categoriaASerAtualizada.getId());

        if(categoriaRequestDTO.descricao() == null) categoriaUpdate.setDescricao(categoriaASerAtualizada.getDescricao());

        this.categoriaRepository.save(categoriaUpdate);
    }

        // DELETE

    public void deleteCategoriaById(Integer id){

        if(this.categoriaRepository.existsById(id)) this.categoriaRepository.deleteById(id);
        else throw new RuntimeException("ID inválido ou categoria inexistente");
    }

    public void deleteCategoriaByNome(String nome){

        Optional<Categoria> categoriaDelete = this.categoriaRepository.findAll().stream().filter(categoria -> categoria.getNome().equalsIgnoreCase(nome)).findFirst();
        if(categoriaDelete.isPresent()){
            this.categoriaRepository.delete(categoriaDelete.get());
        }
        else throw new RuntimeException("ID inválido ou categoria inexistente");
    }

}
