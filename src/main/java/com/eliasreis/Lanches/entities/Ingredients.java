package com.eliasreis.Lanches.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table (name = "Ingredientes")
public class Ingredients implements Serializable{

	private static final long serialVersionUID = 4862991749577621407L;
	
	private long id; 
	private String nome;
	private double valor;
	private int estoqueAtual;
	private Date dataCriacao;
	private Date dataUltimaAtualizacao;
	private String descricao;
	
	public Ingredients() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "nome", nullable = false)
	public String getName() {
		return nome;
	}
	
	public void setName(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "valor", nullable = false)
	public double getPrice() {
		return valor;
	}
	public void setPrice(double valor) {
		this.valor = valor;
	}
	
	@Column(name = "estoque_atual", nullable = false)
	public int getCurrentInventory() {
		return estoqueAtual;
	}
	
	public void setCurrentInventory(int estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}
	
	@Column(name = "data_criacao", nullable = false)
	public Date getCreateDate() {
		return dataCriacao;
	}
	public void setCreateDate(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	@Column(name = "data_atualizacao", nullable = false)
	public Date getLastUpdate() {
		return dataUltimaAtualizacao;
	}
	public void setLastUpdate(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}
	
	@Column(name = "descricao", nullable = false)
	public String getDescription() {
		return descricao;
	}

	public void setDescription(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Ingredientes [id=" + id + ", nome=" + nome + ", valor=" + valor + ", estoqueAtual=" + estoqueAtual
				+ "]";
	}

	@PreUpdate
    public void preUpdate() {
        dataUltimaAtualizacao = new Date();
    }
     
    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        dataCriacao = atual;
        dataUltimaAtualizacao = atual;
    }
	
	
}
