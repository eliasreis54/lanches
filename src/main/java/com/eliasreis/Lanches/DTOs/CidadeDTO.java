package com.eliasreis.Lanches.DTOs;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class CidadeDTO {
	private long id;
	private String Nome;
	private String UF;
	
	@NotEmpty(message = "Nome da cidade não pode ser vazio")
	@Length(min = 2, max = 100, message = "O nome deve conter entre 2 e 100 caracteres")
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
	@NotEmpty(message = "Nome do estado não pode ser vazio")
	@Length(min = 2, max = 2, message = "O nome do estado não pode ser vazio")
	public String getUF() {
		return UF;
	}
	public void setUF(String uF) {
		UF = uF;
	}
	
	
	public long getiD() {
		return id;
	}
	public void setiD(long iD) {
		this.id = iD;
	}
	@Override
	public String toString() {
		return "CidadeDTO [Nome=" + Nome + ", UF=" + UF + "]";
	}
}
