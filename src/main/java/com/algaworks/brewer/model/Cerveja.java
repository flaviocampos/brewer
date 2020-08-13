package com.algaworks.brewer.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

import com.algaworks.brewer.validation.SKU;


@Entity
@Table(name = "cerveja")
public class Cerveja implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotBlank(message = "SKU - Nao pode ser branco!")
	@SKU
	private String sku;
	
	@NotBlank(message = "Nome e obrigatorio!")
	private String nome;
	
	@Size(min = 10, max = 100, message = "Descrição de ter entre {min} e {max} caracteres!")
	private String descricao;
	
	@NotNull(message = "Valor obrigatorio")
	@DecimalMin("0.01")
	@DecimalMax(value = "9999999.99", message = "O da cerveja deve ser menor que 9.999.999,99")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valor;
	
	@NotNull(message = "Teor Alcoolico obrigatorio")
	@Column(name ="teor_alcoolico")
	@DecimalMax(value = "100.0", message = "Maior teor alcoolico deve ser 100.00%")
	@NumberFormat(pattern = "##0.00")
	private BigDecimal teorAlcoolico;
	
	@NotNull(message = "Comissao e obrigatoria")
	@DecimalMax(value = "100.0", message = "Comissao Maxima 100.0%")
	@NumberFormat(pattern = "##0.00")
	private BigDecimal comissao;
	
	@NotNull(message = "Estoque e obrigatoria")
	@Max(value = 9999, message = "Estoque Maximo 9.999")
	@Column(name = "quantidade_estoque")
	private Integer quantidadeEstoque;
	
	@NotNull(message = "Origem e obrigatorio")
	@Enumerated(EnumType.STRING)
	private Origem origem;
	
	@NotNull(message = "Sabor e obrigatorio")
	@Enumerated(EnumType.STRING)
	private Sabor sabor;
	
	@NotNull(message = "Estilo e obrigatorio")
	@ManyToOne
	@JoinColumn(name = "codigo_estilo")
	private Estilo estilo;

	
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(BigDecimal teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public BigDecimal getComissao() {
		return comissao;
	}

	public void setComissao(BigDecimal comissao) {
		this.comissao = comissao;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cerveja other = (Cerveja) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	

}
