package com.eliasreis.Lanches.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Cliente")
public class Client implements Serializable {
	private static final long serialVersionUID = 4862991749577621407L;
	
	private long id;
	private String nome;
	private String logardouto;
	private String endereco;
	private String bairro;
	private String numero;
	private int cep;
	private int cidade;
	private String uf;
	private int cpf;
	
	public Client() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
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
	@Column(name = "logradouro", nullable = false)
	public String getLogardouto() {
		return logardouto;
	}

	public void setLogardouto(String logardouto) {
		this.logardouto = logardouto;
	}
	@Column(name = "endereco", nullable = false)
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	@Column(name = "bairro", nullable = false)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	@Column(name = "numero", nullable = false)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	@Column(name = "CEP", nullable = false)
	public int getCEP() {
		return cep;
	}

	public void setCEP(int cep) {
		this.cep = cep;
	}
	@Column(name = "cidade", nullable = false)
	public int getCidade() {
		return cidade;
	}

	public void setCidade(int cidade) {
		this.cidade = cidade;
	}
	@Column(name = "UF", nullable = false)
	public String getUF() {
		return uf;
	}

	public void setUF(String uf) {
		this.uf = uf;
	}
	@Column(name = "CPF", nullable = false)
	public int getCPF() {
		return cpf;
	}

	public void setCPF(int cpf) {
		this.cpf = cpf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
