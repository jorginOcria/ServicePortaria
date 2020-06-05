package br.com.primefaces.repository.http;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import org.omg.CORBA.PUBLIC_MEMBER;

import br.com.primefaces.repository.entity.CadastradosEntity;

@XmlRootElement
public class Visitante {

	private Long id;
	private String nome;
	private String RG;
	private CadastradosEntity cadastrados;

	public Visitante() {

	}

	public Visitante(Long id, String nome, String RG, CadastradosEntity cadastrados) {
		super();
		this.id = id;
		this.nome = nome;
		this.RG = RG;
		this.cadastrados = cadastrados;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public CadastradosEntity getCadastrados() {
		return cadastrados;
	}

	public void setCadastrados(CadastradosEntity cadastrados) {
		this.cadastrados = cadastrados;
	}

}
