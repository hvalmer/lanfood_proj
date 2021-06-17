package com.braincustom.lanfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.braincustom.lanfood.domain.model.Cidade;
import com.braincustom.lanfood.domain.repository.CidadeRepository;

@Component
public class CidadeRepositoryImplem implements CidadeRepository {

	//interface JPA que gerencia o contexto de persistência
	@PersistenceContext //injeta um EntityManager
	private EntityManager manager; //salvar e consultar no BD
	
	//método para listar todas as cidades(from Cidades)
	//createQuery - consulta JPQL em Objetos e não em tabelas
	@Override
	public List<Cidade> listar(){
		return manager.createQuery("from Cidade", Cidade.class).getResultList();
	}
	
	//buscando uma Cidade por id
	@Override
	public Cidade buscar(Long id) {
		return manager.find(Cidade.class, id);
	}
	
	@Transactional //método executado dentro de uma transação
	@Override
	public Cidade salvar(Cidade cidade) {
		//usando o JPA para adicionar objeto Cidade no BD
		return manager.merge(cidade);
	}
	
	public void remover(Cidade cidade) {
		cidade = buscar(cidade.getId());
		manager.remove(cidade);
	}
	
}
