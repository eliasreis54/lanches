package com.eliasreis.Lanches.DTOs;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class SnackDTO {
	private long iD;
	private String name;
	private double price;
	private String descripton;
	private int stock;

	
	public int getStock() {
		return stock;
	}

	public void setStock(int sotck) {
		this.stock = stock;
	}

	public SnackDTO() {
		super();
	}
	
	public long getiD() {
		return iD;
	}

	public void setiD(long iD) {
		this.iD = iD;
	}
	
	@NotEmpty(message = "Nome do produto não pode ser vazio")
	@Length(min = 5, max = 100, message = "O nome deve conter entre 5 e 100 caracteres")
	public String getNome() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Min(value = 0, message = "O valor não pode ser 0")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Length(min = 5, max = 100, message = "A descrição do produto deve conter entre 5 e 100 caracteres")
	public String getDescripton() {
		return descripton;
	}
	public void setDescription(String descripton) {
		this.descripton = descripton;
	}
}
