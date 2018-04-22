package com.eliasreis.Lanches.Controllers;

import java.text.Normalizer;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scripting.config.LangNamespaceHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.eliasreis.Lanches.DTOs.SnackDTO;
import com.eliasreis.Lanches.Repositores.IngredientesRepositori;
import com.eliasreis.Lanches.Response.Response;
import com.eliasreis.Lanches.entities.Ingredients;

/**
 * @author eliasreis
 *	Controller responsável por qualquer manipulação no cadastro de produto
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/lanches")
public class SnackController {
	@Autowired
	IngredientesRepositori IngredientesRepositori;
	
	/**
	 * Método utilizado para cadastrar um novo ingrediente
	 * @param lanche recebido em json com os seguintes parâmetros 	"nome" : "Pão frances ",	"valor" : 0.40, 	"descricao" : "      "
	 * @param results
	 * @return Lanche DTO
	 */
	@PostMapping
	public ResponseEntity<Response<SnackDTO>> CadastrarLanche(@Valid @RequestBody SnackDTO lanche,
			BindingResult results) {
		Response<SnackDTO> response = new Response<SnackDTO>();
		
		if (results.hasErrors()){
			results.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Ingredients ingrediente = new Ingredients();
		
		ingrediente.setNome(lanche.getNome());
		ingrediente.setDescricao(lanche.getDescripton());
		ingrediente.setValor(lanche.getPrice());
		this.IngredientesRepositori.save(ingrediente);
		ingrediente = this.IngredientesRepositori.findByNome(lanche.getNome());
		lanche.setiD(ingrediente.getId());
		response.setObjeto(lanche);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Método utilizado para retornar todos os produtos cadastrados
	 * @return Lista de ingredientes
	 */
	@GetMapping
	public List<Ingredients> RetornaTodas() {
		List<Ingredients> ingrediente = IngredientesRepositori.findAll();
		return ingrediente;
	}
	
	/**
	 * Método utilizado para retornar um ingrediente através do seu nome
	 * @param Nome sem acento 
	 * @return ingrediente solicidato 
	 */
	@GetMapping (value = "/{nome}")
	public Ingredients ProcuraPeloNome(@PathVariable("nome") String Nome) {
		String novo = Normalizer.normalize(Nome, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		System.out.println(novo);
		Ingredients ingrediente = IngredientesRepositori.findByNome(novo);
		return ingrediente;
	}
	
	@PutMapping
	public Ingredients UpdateIngredientes(@RequestBody SnackDTO lancheUpdate) {
		Ingredients registroAtual = this.IngredientesRepositori.findOne(lancheUpdate.getiD());
		registroAtual.setNome(lancheUpdate.getNome());
		registroAtual.setValor(lancheUpdate.getPrice());
		registroAtual.setEstoqueAtual(lancheUpdate.getStock());
		registroAtual.setDescricao(lancheUpdate.getDescripton());
		this.IngredientesRepositori.save(registroAtual);
		return registroAtual;
	}
	
	@DeleteMapping (value = "/{iD}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String DeleteIngredientes(@PathVariable("iD") long productID) {
		Ingredients registroAtual = this.IngredientesRepositori.findOne(productID);
		if (registroAtual != null) {
			IngredientesRepositori.delete(productID);
			return "Product deleted successfully";	
		}
		else
		{
			return "Unable delete product";
		}
	}
}
