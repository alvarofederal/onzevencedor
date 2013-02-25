package br.com.javamagazine.onzevencedor.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.javamagazine.onzevencedor.entity.Clube;

@Repository("clubeDao")
public class ClubeDAO {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	@Transactional(readOnly = true)
	public List<Clube> findAll() {
		
		String jpql = "SELECT c from Clube c order by c.nome";
		Query query = this.entityManager.createQuery(jpql);
		List<Clube> clubes = query.getResultList();
				
		return clubes;
				
	}
	
	@Transactional(readOnly = true)
	public List<Clube> findByName(String nomeClube) {
		
		String jpql = "SELECT c from Clube c where nome like :nome order by c.nome";
		Query query = this.entityManager.createQuery(jpql);
		query.setParameter("nome", nomeClube + "%");
		List<Clube> clubes = query.getResultList();
		
		return clubes;
				
	}
	
	@Transactional
	public Clube create(Clube clube) {
		
		this.entityManager.persist(clube);
		
		return clube;
				
	}
	
	@Transactional
	public void update(Clube clube) {
		
		this.entityManager.merge(clube);
				
	}
	
	@Transactional
	public void delete(Clube clube) {
				
		clube = this.entityManager.find(Clube.class, clube.getIdf());
		this.entityManager.remove(clube);
				
	}
	
	public void setEntityManager(EntityManager entityManager) {
		
		this.entityManager = entityManager;
		
	}

}
