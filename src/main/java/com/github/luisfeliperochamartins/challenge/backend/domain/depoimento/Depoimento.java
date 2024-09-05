package com.github.luisfeliperochamartins.challenge.backend.domain.depoimento;

import jakarta.persistence.*;

@Entity
@Table(name = "Depoimentos")
public class Depoimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String fotoUrl;
	private String depoimento;
	private String nomePessoa;

	public Depoimento() {}

	public Depoimento(String fotoUrl, String depoimento, String nomePessoa) {
		this.fotoUrl = fotoUrl;
		this.depoimento = depoimento;
		this.nomePessoa = nomePessoa;
	}

	public Depoimento(DepoimentoRecord record) {
		this.fotoUrl = record.fotoUrl();
		this.depoimento = record.depoimento();
		this.nomePessoa = record.nomePessoa();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

	public String getDepoimento() {
		return depoimento;
	}

	public void setDepoimento(String depoimento) {
		this.depoimento = depoimento;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public void update(DepoimentoUpdateRecord record) {
		if (record.depoimento() != null) {
			this.depoimento = record.depoimento();
		}

		if (record.fotoUrl() != null) {
			this.fotoUrl = record.fotoUrl();
		}

		if (record.nomePessoa() != null) {
			this.nomePessoa = record.nomePessoa();
		}
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("id = ").append(id);
		sb.append(", fotoUrl = ").append(fotoUrl);
		sb.append(", depoimento = ").append(depoimento);
		sb.append(", nomePessoa = ").append(nomePessoa);
		return sb.toString();
	}
}
