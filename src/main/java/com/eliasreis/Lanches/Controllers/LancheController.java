package com.eliasreis.Lanches.Controllers;

import java.text.Normalizer;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.annotations.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.eliasreis.Lanches.DTOs.LancheDTO;
import com.eliasreis.Lanches.Repositores.IngredientesRepositori;
import com.eliasreis.Lanches.Response.Response;
import com.eliasreis.Lanches.entities.Ingredientes;
import com.mysql.jdbc.log.Log;

/**
 * @author eliasreis
 *	Controller responsável por qualquer manipulação no cadastro de produto
 */
@RestController
@RequestMapping("/api/lanches")
public class LancheController {
	@Autowired
	IngredientesRepositori IngredientesRepositori;
	
	/**
	 * Método utilizado para cadastrar um novo ingrediente
	 * @param lanche recebido em json com os seguintes parâmetros 	"nome" : "Pão frances ",	"valor" : 0.40, 	"descricao" : "      "
	 * @param results
	 * @return Lanche DTO
	 */
	@PostMapping
	public ResponseEntity<Response<LancheDTO>> CadastrarLanche(@Valid @RequestBody LancheDTO lanche,
			BindingResult results) {
		Response<LancheDTO> response = new Response<LancheDTO>();
		
		if (results.hasErrors()){
			results.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Ingredientes ingrediente = new Ingredientes();
		
		ingrediente.setNome(lanche.getNome());
		ingrediente.setDescricao(lanche.getDescricao());
		ingrediente.setValor(lanche.getValor());
		
		this.IngredientesRepositori.save(ingrediente);
		response.setObjeto(lanche);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Método utilizado para retornar todos os produtos cadastrados
	 * @return Lista de ingredientes
	 */
	@GetMapping
	public List<Ingredientes> RetornaTodas() {
		List<Ingredientes> ingrediente = IngredientesRepositori.findAll();
		return ingrediente;
	}
	
	/**
	 * Método utilizado para retornar um ingrediente através do seu nome
	 * @param Nome sem acento 
	 * @return ingrediente solicidato 
	 */
	@GetMapping (value = "/{nome}")
	public Ingredientes ProcuraPeloNome(@PathVariable("nome") String Nome) {
		String novo = Normalizer.normalize(Nome, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		System.out.println(novo);
		Ingredientes ingrediente = IngredientesRepositori.findByNome(novo);
		return ingrediente;
	}
	
	@PutMapping
	public Ingredientes UpdateIngredientes(@RequestBody LancheDTO lancheUpdate) {
		Ingredientes registroAtual = this.IngredientesRepositori.findOne(lancheUpdate.getiD());
		registroAtual.setNome(lancheUpdate.getNome());
		registroAtual.setValor(lancheUpdate.getValor());
		registroAtual.setEstoqueAtual(lancheUpdate.getEstoque());
		this.IngredientesRepositori.save(registroAtual);
		return registroAtual;
	}
}
