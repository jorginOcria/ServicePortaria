package br.com.primefaces.repository.http;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.primefaces.repository.entity.CadastradosEntity;
import br.com.primefaces.repository.entity.VisitanteEntity;

@XmlRootElement
public class movimentacaoVisitante {

	private int id;
	private Date horario;
	private String tipo;
	private CadastradosEntity cadastradosEntity;
	private VisitanteEntity visitantes;

	public movimentacaoVisitante() {

	}

	public movimentacaoVisitante(int id, Date horario, String tipo, CadastradosEntity cadastradosEntity,
			VisitanteEntity visitantes) {
		this.id = id;
		this.horario = horario;
		this.tipo = tipo;
		this.cadastradosEntity = cadastradosEntity;
		this.visitantes = visitantes;
	}

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