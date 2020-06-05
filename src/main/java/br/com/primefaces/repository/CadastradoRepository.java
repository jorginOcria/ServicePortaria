package br.com.primefaces.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.primefaces.repository.entity.CadastradosEntity;
import br.com.primefaces.repository.entity.VisitanteEntity;
import br.com.primefaces.repository.http.Cadastrados;

public class CadastradoRepository {

	private final EntityManagerFactory entityManagerFactory;
	private final EntityManager entityManager;

	public CadastradoRepository() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_estudo");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List<CadastradosEntity> Validarlist(String cpf, String senha) {

		return this.entityManager.createQuery(
				"SELECT p FROM CadastradosEntity p where cpf like '" + cpf + "' and senha like '" + senha + "' ")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<CadastradosEntity> PesquisarPeloCpf(String cpf, long id) {

		return this.entityManager.createQuery("SELECT p FROM CadastradosEntity p where cpf like '" + cpf + "' and id = "+ id +"")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public CadastradosEntity CriarUsuario(CadastradosEntity entity) {

		CadastradosEntity cad = new CadastradosEntity();
		this.entityManager.getTransaction().begin();
		CadastradosEntity classe = this.entityManager.merge(entity);
		this.entityManager.getTransaction().commit();
		return classe;

	}

	@SuppressWarnings("unchecked")
	public CadastradosEntity BuscaPeloCpf(String cpf) {
		TypedQuery<CadastradosEntity> query = entityManager
				.createQuery("SELECT p FROM CadastradosEntity p where p.cpf like :cpf", CadastradosEntity.class);
		return query.setParameter("cpf", cpf).getSingleResult();
	}
}