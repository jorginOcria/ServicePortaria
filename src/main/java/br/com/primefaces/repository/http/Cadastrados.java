package br.com.primefaces.repository.http;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cadastrados {

	private Long idCadastrado;
	private String cpf;
	private String senha;

	public Cadastrados() {

	}

	public Cadastrados(Long idCadastrado, String cpf, String senha) {
		this.idCadastrado = idCadastrado;
		this.cpf = cpf;
		this.senha = senha;
	}

	public Long getIdCadastrado() {
		return idCadastrado;
	}

	public void setIdCadastrado(Long idCadastrado) {
		this.idCadastrado = idCadastrado;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
