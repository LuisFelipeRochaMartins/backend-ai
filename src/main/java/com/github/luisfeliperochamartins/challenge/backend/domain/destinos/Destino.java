package com.github.luisfeliperochamartins.challenge.backend.domain.destinos;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "destinos")
public class Destino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String foto;
	private String nome;
	private BigDecimal preco;

	public Destino() {}

	public Destino(String foto, String nome, BigDecimal preco) {
		this.foto = foto;
		this.nome = nome;
		this.preco = preco;
	}

	public Destino(DestinoRecord record) {
		this.foto = record.foto();
		this.nome = record.nome();
		this.preco = record.preco();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public void update(DestinoUpdateRecord record) {
		if (record.preco() != null) {
			this.preco = record.preco();
		}

		if (record.foto() != null) {
			this.foto = record.foto();
		}

		if (record.nome() != null) {
			this.nome = record.nome();
		}
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("id = ").append(id);
		sb.append(", foto = ").append(foto);
		sb.append(", nome = ").append(nome);
		sb.append(", preco = ").append(preco);
		return sb.toString();
	}
}
