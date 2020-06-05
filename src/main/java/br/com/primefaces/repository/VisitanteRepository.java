package br.com.primefaces.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.primefaces.repository.entity.VisitanteEntity;

public class VisitanteRepository {

	private final EntityManagerFactory entityManagerFactory;
	private final EntityManager entityManager;

	public VisitanteRepository() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_estudo");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	public void Salvar(VisitanteEntity visitante) {

		this.entityManager.getTransaction().begin();
		this.entityManager.persist(visitante);
		this.entityManager.getTransaction().commit();
	}

	public void Alterar(VisitanteEntity visitante) {

		this.entityManager.getTransaction().begin();
		this.entityManager.merge(visitante);
		this.entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<VisitanteEntity> TodosVisitantes() {

		return this.entityManager.createQuery("SELECT p FROM VisitanteEntity p ORDER BY p.nome").getResultList();
	}

	public VisitanteEntity GetVisistante(Long id) {

		return this.entityManager.find(VisitanteEntity.class, id);
	}

	public void Excluir(Long id) {

		VisitanteEntity visitante = this.GetVisistante(id);

		this.entityManager.getTransaction().begin();
		this.entityManager.remove(visitante);
		this.entityManager.getTransaction().commit();

	}

	@SuppressWarnings("unchecked")
	public List<VisitanteEntity> TodosVisitantesPorId(Long id) {

		return this.entityManager.createQuery("SELECT p FROM VisitanteEntity p where idCadastrado = " + id)
				.getResultList();
	}

}
