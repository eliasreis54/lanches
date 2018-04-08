package com.eliasreis.Lanches.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eliasreis.Lanches.DTOs.CidadeDTO;
import com.eliasreis.Lanches.Repositores.CidadesRepositori;
import com.eliasreis.Lanches.Response.Response;
import com.eliasreis.Lanches.entities.Cidade;

@RestController
@RequestMapping("/api/cidades")
public class CidadeController {
	
	@Autowired
	CidadesRepositori cidadeRepositori;
	@PostMapping
	public ResponseEntity<Response<CidadeDTO>> CadastrarCidade(@Valid @RequestBody CidadeDTO cidade,
			BindingResult results){
		System.out.println(cidade.toString());
		Response<CidadeDTO> response = new Response<CidadeDTO>();
		
		if (results.hasErrors()){
			results.getAllErrors().forEach(erro -> response.getErros().add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Cidade cidadesave = new Cidade();
		
		cidadesave.setNome(cidade.getNome());
		cidadesave.setUF(cidade.getUF());
		this.cidadeRepositori.save(cidadesave);
		response.setObjeto(cidade);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping
	public List<Cidade> RetornaCidade(){
		List<Cidade> cidades = this.cidadeRepositori.findAll();
		return cidades;
	}
	
	@PutMapping
	public Cidade atualizaCidade(@RequestBody CidadeDTO cidadeUpdate){
		Cidade cidadeAtual = this.cidadeRepositori.findOne(cidadeUpdate.getiD());
		cidadeAtual.setNome(cidadeUpdate.getNome());
		cidadeAtual.setUF(cidadeUpdate.getUF());
		this.cidadeRepositori.save(cidadeAtual);
		return cidadeAtual;
	}
}
