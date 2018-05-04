package com.eliasreis.Lanches.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eliasreis.Lanches.DTOs.CityDTO;
import com.eliasreis.Lanches.Repositores.CitiesRepositori;
import com.eliasreis.Lanches.Response.Response;
import com.eliasreis.Lanches.entities.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CityController {
	
	@Autowired
	CitiesRepositori cityRepositori;
	@PostMapping
	public ResponseEntity<Response<CityDTO>> RegisterCity(@Valid @RequestBody CityDTO cidade,
			BindingResult results){
		Response<CityDTO> response = new Response<CityDTO>();
		
		if (results.hasErrors()){
			results.getAllErrors().forEach(erro -> response.getErros().add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		City citysave = new City();
		
		citysave.setNome(cidade.getName());
		citysave.setUF(cidade.getUF());
		this.cityRepositori.save(citysave);
		citysave = this.cityRepositori.findByNome(cidade.getName());
		cidade.setiD(citysave.getiD());
		response.setObjeto(cidade);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping
	public List<City> ReturnCity(){
		List<City> cities = this.cityRepositori.findAll();
		return cities;
	}
	
	@PutMapping
	public City UpdateCity(@RequestBody CityDTO cityUpdate){
		City currentCity = this.cityRepositori.findOne(cityUpdate.getiD());
		currentCity.setNome(cityUpdate.getName());
		currentCity.setUF(cityUpdate.getUF());
		this.cityRepositori.save(currentCity);
		return currentCity;
	}
	
	@DeleteMapping(value= "/{id}")
	public String DeleteCity(@PathVariable("id") long id) {
		City city = this.cityRepositori.findOne(id);
		if (city != null) {
			this.cityRepositori.delete(id);
			return "Product deleted successfully";
		}
		else{
			return "Unable to delete product";
		}
	}
}
