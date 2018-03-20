package com.eliasreis.Lanches.Controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.eliasreis.Lanches.DTOs.LancheDTO;
import com.eliasreis.Lanches.Response.Response;

@RestController
@RequestMapping("/api/lanches")
public class LancheController {
	
	@PostMapping
	public ResponseEntity<Response<LancheDTO>> CadastrarLanche(@Valid @RequestBody LancheDTO lanche,
			BindingResult results) {
		
		Response<LancheDTO> response = new Response<LancheDTO>();
		if (results.hasErrors()){
			results.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		lanche.setID(1L);
		response.setObjeto(lanche);;
		return ResponseEntity.ok(response);
	}
}
