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

@Entity
public class Movimentacao_visitante {

	@Id
	@GeneratedValue(generator = "movimentacao_visitanteseq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "movimentacao_visitanteseq", sequenceName = "movimentacao_visitanteseq", allocationSize = 1, initialValue = 1)
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date horario;
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name="idCadastrado")
	private CadastradosEntity cadastradosEntity;
	
	@ManyToOne
	@JoinColumn(name="idVisitante")
	private VisitanteEntity visitantes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public CadastradosEntity getCadastrados() {
		return cadastradosEntity;
	}

	public void setCadastrados(CadastradosEntity cadastradosEntity) {
		this.cadastradosEntity = cadastradosEntity;
	}

	public VisitanteEntity getVisitantes() {
		return visitantes;
	}

	public void setVisitantes(VisitanteEntity visitantes) {
		this.visitantes = visitantes;
	}
	
}
