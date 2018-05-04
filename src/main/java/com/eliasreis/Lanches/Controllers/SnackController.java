package com.eliasreis.Lanches.Controllers;

import java.text.Normalizer;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.eliasreis.Lanches.Repositores.ingredientRepositori;
import com.eliasreis.Lanches.Response.Response;
import com.eliasreis.Lanches.entities.Ingredients;

/**
 * @author eliasreis
 *	Controller responsável por qualquer manipulação no cadastro de produto
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/snacks")
public class SnackController {
	@Autowired
	ingredientRepositori IngredientRepositori;
	
	/**
	 * Método utilizado para cadastrar um novo ingrediente
	 * @param snack recebido em json com os seguintes parâmetros 	"nome" : "Pão frances ",	"valor" : 0.40, 	"descricao" : "      "
	 * @param results
	 * @return Lanche DTO
	 */
	@PostMapping
	public ResponseEntity<Response<SnackDTO>> RegisterLanche(@Valid @RequestBody SnackDTO snack,
			BindingResult results) {
		Response<SnackDTO> response = new Response<SnackDTO>();
		
		if (results.hasErrors()){
			results.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Ingredients ingredient = new Ingredients();
		
		ingredient.setName(snack.getNome());
		ingredient.setDescription(snack.getDescripton());
		ingredient.setPrice(snack.getPrice());
		this.IngredientRepositori.save(ingredient);
		ingredient = this.IngredientRepositori.findByNome(snack.getNome());
		snack.setiD(ingredient.getId());
		response.setObjeto(snack);
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Método utilizado para retornar todos os produtos cadastrados
	 * @return Lista de ingredientes
	 */
	@GetMapping
	public List<Ingredients> ReturnAll() {
		List<Ingredients> ingredient = IngredientRepositori.findAll();
		return ingredient;
	}
	
	/**
	 * Método utilizado para retornar um ingrediente através do seu nome
	 * @param Nome sem acento 
	 * @return ingrediente solicidato 
	 */
	@GetMapping (value = "/{nome}")
	public Ingredients FindByName(@PathVariable("nome") String Nome) {
		String newIngredient = Normalizer.normalize(Nome, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		System.out.println(newIngredient);
		Ingredients ingredient = IngredientRepositori.findByNome(newIngredient);
		return ingredient;
	}
	
	@PutMapping
	public Ingredients UpdateIngrediente(@RequestBody SnackDTO lancheUpdate) {
		Ingredients currentRecord = this.IngredientRepositori.findOne(lancheUpdate.getiD());
		currentRecord.setName(lancheUpdate.getNome());
		currentRecord.setPrice(lancheUpdate.getPrice());
		currentRecord.setCurrentInventory(lancheUpdate.getStock());
		currentRecord.setDescription(lancheUpdate.getDescripton());
		this.IngredientRepositori.save(currentRecord);
		return currentRecord;
	}
	
	@DeleteMapping (value = "/{iD}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String DeleteIngrediente(@PathVariable("iD") long productID) {
		Ingredients currentRecord = this.IngredientRepositori.findOne(productID);
		if (currentRecord != null) {
			IngredientRepositori.delete(productID);
			return "Product deleted successfully";	
		}
		else
		{
			return "Unable delete product";
		}
	}
}
