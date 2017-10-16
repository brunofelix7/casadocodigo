package br.com.caelum.casadocodigo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.caelum.casadocodigo.model.Produto;

@Repository
@Transactional
public class ProdutoDAO {
	
	//	https://en.wikibooks.org/wiki/Java_Persistence/Criteria

	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Produto produto){
		entityManager.persist(produto);
	}
	
	public List<Produto> listar(){
		return entityManager.createQuery("select p from Produto p", Produto.class).getResultList();
	}
	
}
