package br.com.primefaces.repository.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.print.attribute.standard.DateTimeAtCompleted;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class VisitanteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	
	private Long id;
	private String nome;
	private String RG;

	@ManyToOne
	@JoinColumn(name = "idCadastrado")
	private CadastradosEntity cadastrados;
	
	private Boolean status = true;
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
	
	public boolean GetStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
