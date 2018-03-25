package com.eliasreis.Lanches.DTOs;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class LancheDTO {
	private String nome;
	private double valor;
	private String descricao;

	
	public LancheDTO() {
		super();
	}
	
	@NotEmpty(message = "Nome do produto não pode ser vazio")
	@Length(min = 5, max = 100, message = "O nome deve conter entre 5 e 100 caracteres")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Min(value = 0, message = "O valor não pode ser 0")
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	@Length(min = 5, max = 100, message = "A descrição do produto deve conter entre 5 e 100 caracteres")
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
