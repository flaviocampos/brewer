package com.algaworks.brewer.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Cerveja {
	
	@NotBlank(message = "SKU - Nao pode ser branco!")
	@Pattern(regexp = "[A-Z]{3}[0-9]{4}", message = "SKU - Use padrao 3 letras e 4 numeros")
	private String sku;
	@NotBlank(message = "Nome e obrigatorio!")
	private String nome;
	@Size(min = 10, max = 100, message = "Descrição de ter entre {min} e {max} caracteres!")
	private String descricao;
	
	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
