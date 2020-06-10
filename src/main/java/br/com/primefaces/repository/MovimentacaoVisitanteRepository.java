package br.com.primefaces.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.primefaces.repository.entity.Movimentacao_visitante;


public class MovimentacaoVisitanteRepository {
	private final EntityManagerFactory entityManagerFactory;
	private final EntityManager entityManager;

	public MovimentacaoVisitanteRepository() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_estudo");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List<Movimentacao_visitante> todasMovimentacoesPorId(long id) {

		return this.entityManager.createQuery("SELECT p FROM Movimentacao_visitante p where idCadastrado = " + id)
				.getResultList();
	}
}
