package com.eliasreis.Lanches.DTOs;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class CityDTO {
	private long id;
	private String name;
	private String uf;
	
	@NotEmpty(message = "Nome da cidade não pode ser vazio")
	@Length(min = 2, max = 100, message = "O nome deve conter entre 2 e 100 caracteres")
	public String getName() {
		return name;
	}
	public void setNome(String nome) {
		name = nome;
	}
	
	@NotEmpty(message = "Nome do estado não pode ser vazio")
	@Length(min = 2, max = 2, message = "O nome do estado não pode ser vazio")
	public String getUF() {
		return uf;
	}
	public void setUF(String uF) {
		uf = uF;
	}
	
	
	public long getiD() {
		return id;
	}
	public void setiD(long iD) {
		this.id = iD;
	}
	@Override
	public String toString() {
		return "CidadeDTO [Nome=" + name + ", UF=" + uf + "]";
	}
}
