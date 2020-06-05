package br.com.primefaces.repository.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
public class CadastradosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	private Long idCadastrado;

	@Column(nullable = false)
	private String cpf;
	private String senha;
	private String email;
	private String nome;
	private String celular;
	private String tipo;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	// getters setters
	public String getCpf() {
		return cpf;
	}

	public Long getIdCadastrado() {
		return idCadastrado;
	}

	public void setIdCadastrado(Long idCadastrado) {
		this.idCadastrado = idCadastrado;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}