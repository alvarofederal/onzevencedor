package br.com.javamagazine.onzevencedor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.javamagazine.onzevencedor.entity.Atleta;

@Repository("atletaDao")
public class AtletaDAO {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Transactional(readOnly = true)
	public List<Atleta> findAll() {
		
		String jpql = "SELECT a from Atleta a order by a.nome";
		Query query = this.entityManager.createQuery(jpql);
		List<Atleta> atletas = query.getResultList();
		
		return atletas;
		
	}
	
	@Transactional(readOnly = true)
	public List<Atleta> findByClube(Integer idfClube) {
		
		String jpql = "SELECT a from Atleta a" +
				       " JOIN a.clube c" +
				       " WHERE c.idf = :idfClube" +
				       " ORDER BY a.nome";
		Query query = this.entityManager.createQuery(jpql);
		query.setParameter("idfClube", idfClube);
		List<Atleta> atletas = query.getResultList();
		
		return atletas;
				
	}
	
	@Transactional
	public Atleta create(Atleta atleta) {
		
		this.entityManager.persist(atleta);
		
		return atleta;
				
	}
	
	@Transactional
	public void update(Atleta atleta) {
		
		this.entityManager.merge(atleta);
		
	}
	
	@Transactional
	public void delete(Atleta atleta) {
			
		atleta = this.entityManager.find(Atleta.class, atleta.getIdf());
		this.entityManager.remove(atleta);
				
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
