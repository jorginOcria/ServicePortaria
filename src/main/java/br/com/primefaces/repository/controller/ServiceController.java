package br.com.primefaces.repository.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.inject.Named;
import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import br.com.primefaces.repository.CadastradoRepository;
import br.com.primefaces.repository.VisitanteRepository;
import br.com.primefaces.repository.entity.CadastradosEntity;
import br.com.primefaces.repository.entity.VisitanteEntity;
import br.com.primefaces.repository.http.Cadastrados;
import br.com.primefaces.repository.http.Visitante;

@Path("/service")
public class ServiceController {

	private final VisitanteRepository repository = new VisitanteRepository();
	private final CadastradoRepository repositoryCadastrado = new CadastradoRepository();

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/visitantes")
	public List<Visitante> getVisitantes() {
		List<Visitante> visitantes = new ArrayList<Visitante>();
		List<VisitanteEntity> listaEntityVisitantes = repository.TodosVisitantes();
		for (VisitanteEntity entity : listaEntityVisitantes) {
			visitantes.add(new Visitante(entity.getId(), entity.getNome(), entity.getRG(), entity.getCadastrados()));
		}
		return visitantes;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/visitantes/{idCadastrado}")
	public List<Visitante> getVisitantesPorId(@PathParam("idCadastrado") Long idCadastrado) {
		List<Visitante> visitantes = new ArrayList<Visitante>();
		List<VisitanteEntity> listaEntityVisitantes = repository.TodosVisitantesPorId(idCadastrado);
		for (VisitanteEntity entity : listaEntityVisitantes) {
			visitantes.add(new Visitante(entity.getId(), entity.getNome(), entity.getRG(), entity.getCadastrados()));
		}
		return visitantes;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/liberacao/{id}")
	public Visitante GetPessoa(@PathParam("id") Long id) {

		VisitanteEntity entity = repository.GetVisistante(id);

		if (entity != null)
			return new Visitante(entity.getId(), entity.getNome(), entity.getRG(), entity.getCadastrados());

		return null;
	}

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrar")
	public String Cadastrar(Visitante visitante) {

		VisitanteEntity entity = new VisitanteEntity();

		try {

			entity.setNome(visitante.getNome());
			entity.setRG(visitante.getRG());
			entity.setCadastrados(visitante.getCadastrados());

			repository.Salvar(entity);

			return "Registro cadastrado com sucesso!";

		} catch (Exception e) {

			return "Erro ao cadastrar um registro " + e.getMessage();
		}

	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterar/{id}")
	public Visitante Alterar(@PathParam("id") Long id, Visitante visitante) {

		VisitanteEntity entity = new VisitanteEntity();

		entity.setId(id);
		entity.setNome(visitante.getNome());
		entity.setRG(visitante.getRG());
		entity.setCadastrados(visitante.getCadastrados());
		repository.Alterar(entity);

		return new Visitante(entity.getId(), entity.getNome(), entity.getRG(), entity.getCadastrados());

	}

	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluir/{id}")
	public String Excluir(@PathParam("id") Long id) {

		try {

			repository.Excluir(id);

			return "Registro excluido com sucesso!";

		} catch (Exception e) {

			return "Erro ao excluir o registro! " + e.getMessage();
		}

	}

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/validar")
	public CadastradosEntity ValidarLogin(Cadastrados cadastrados) {

		CadastradosEntity entity = new CadastradosEntity();

		entity.setIdCadastrado(cadastrados.getId());
		entity.setCpf(cadastrados.getCpf());
		entity.setSenha(cadastrados.getSenha());
		List<CadastradosEntity> list = repositoryCadastrado.Validarlist(entity.getCpf(), entity.getSenha());
		if (list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}

	}

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/criarUsuario")
	public CadastradosEntity CriarUsuario(Cadastrados cadastrados) {
		CadastradosEntity entity = new CadastradosEntity();

		entity.setIdCadastrado(cadastrados.getId());
		entity.setCpf(cadastrados.getCpf());
		List<CadastradosEntity> list = repositoryCadastrado.PesquisarPeloCpf(entity.getCpf(), entity.getIdCadastrado());
		if (list.size() == 1) {
			CadastradosEntity classe= list.get(0);
			classe.setSenha(cadastrados.getSenha());
			return repositoryCadastrado.CriarUsuario(classe);
		} else {
			return null;
		}

	}
}