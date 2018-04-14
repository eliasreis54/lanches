package com.eliasreis.Lanches.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cidade")
public class City implements Serializable {
	private static final long serialVersionUID = 4862991749577621407L;
	
	private long id;
	private String nome;
	private String uf;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getiD() {
		return id;
	}
	public void setiD(long iD) {
		this.id = iD;
	}
	@Column(name = "nome", nullable = false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Column(name = "UF", nullable = false)
	public String getUF() {
		return uf;
	}
	public void setUF(String uF) {
		uf = uF;
	}
	
	
	
}
