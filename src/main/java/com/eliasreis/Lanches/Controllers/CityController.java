package com.eliasreis.Lanches.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eliasreis.Lanches.DTOs.CityDTO;
import com.eliasreis.Lanches.Repositores.CidadesRepositori;
import com.eliasreis.Lanches.Response.Response;
import com.eliasreis.Lanches.entities.City;

@RestController
@RequestMapping("/api/cidades")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CityController {
	
	@Autowired
	CidadesRepositori cidadeRepositori;
	@PostMapping
	public ResponseEntity<Response<CityDTO>> CadastrarCidade(@Valid @RequestBody CityDTO cidade,
			BindingResult results){
		System.out.println(cidade.toString());
		Response<CityDTO> response = new Response<CityDTO>();
		
		if (results.hasErrors()){
			results.getAllErrors().forEach(erro -> response.getErros().add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		City cidadesave = new City();
		
		cidadesave.setNome(cidade.getName());
		cidadesave.setUF(cidade.getUF());
		this.cidadeRepositori.save(cidadesave);
		response.setObjeto(cidade);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping
	public List<City> RetornaCidade(){
		List<City> cidades = this.cidadeRepositori.findAll();
		return cidades;
	}
	
	@PutMapping
	public City atualizaCidade(@RequestBody CityDTO cidadeUpdate){
		City cidadeAtual = this.cidadeRepositori.findOne(cidadeUpdate.getiD());
		cidadeAtual.setNome(cidadeUpdate.getName());
		cidadeAtual.setUF(cidadeUpdate.getUF());
		this.cidadeRepositori.save(cidadeAtual);
		return cidadeAtual;
	}
}
