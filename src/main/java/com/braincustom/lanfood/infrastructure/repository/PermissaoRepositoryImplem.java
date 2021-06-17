package com.braincustom.lanfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.braincustom.lanfood.domain.model.Permissao;
import com.braincustom.lanfood.domain.repository.PermissaoRepository;

@Component
public class PermissaoRepositoryImplem implements PermissaoRepository {

	//interface JPA que gerencia o contexto de persistência
	@PersistenceContext //injeta um EntityManager
	private EntityManager manager; //salvar e consultar no BD
    
	//método para listar todas as Permissoes(from Permissao)
	//createQuery - consulta JPQL em Objetos e não em tabelas
    @Override
    public List<Permissao> listar() {
        return manager.createQuery("from Permissao", Permissao.class).getResultList();
    }
    
    //buscando Permissao por id
    @Override
    public Permissao buscar(Long id) {
        return manager.find(Permissao.class, id);
    }
    
    @Transactional //método executado dentro de uma transação
    @Override
    public Permissao salvar(Permissao permissao) {
    	//usando o JPA para adicionar objeto Permissao no BD
        return manager.merge(permissao);
    }
    
  //removendo uma Permissao
  	@Transactional //método executado denro de uma transação
    @Override
    public void remover(Permissao permissao) {
        permissao = buscar(permissao.getId());
        manager.remove(permissao);
    }
}
