package com.eliasreis.Lanches.DTOs;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.eliasreis.Lanches.entities.City;

public class ClientDTO {
	private long id;
	private String name;
	private String address;
	private String fullAddress;
	private String neighborhood;
	private String number;
	private int cep;
	private City city;
	private String uf;
	private int cpf;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@NotEmpty(message = "The name can't be empty")
	@Length(max = 100, min = 5, message = "the name have to contain between 5 and 100 characters")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@NotEmpty(message = "The address can't be empty")
	@Length(max = 50, message = "the address have to contain between 5 and 50 characters")
	public String getLogardouto() {
		return address;
	}
	public void setLogardouto(String logardouto) {
		this.address = logardouto;
	}
	public String getAddress() {
		return fullAddress;
	}
	public void setAddress(String address) {
		this.fullAddress = address;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	
	
}
