package br.com.loja.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja.model.Produto;
import br.com.loja.repository.ProdutoRepository;



@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	//A anotação AutoWired faz uma auto instanciação dos objetos no código
	@Autowired
	private ProdutoRepository produtoRepository;

	@CrossOrigin(origins = "*")	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Produto> listar(){
		return produtoRepository.findAll();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Produto> pesquisa(@PathVariable(value = "id") Long idproduto) {
		return produtoRepository.findById(idproduto);
	}
	
	
	@CrossOrigin(origins = "*")	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto cadastro(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@CrossOrigin(origins = "*")	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Produto atualizar(@RequestBody Produto produto) {
		return produtoRepository.saveAndFlush(produto);
	}
	
	@CrossOrigin(origins = "*")	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String apagar(@RequestBody Produto produto) {
		 produtoRepository.delete(produto);
		return "Produto apagado com sucesso!";
	}
	
	
	
	
	
}
