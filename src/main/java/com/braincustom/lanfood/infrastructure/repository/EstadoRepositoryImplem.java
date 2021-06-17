package com.braincustom.lanfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.braincustom.lanfood.domain.model.Estado;
import com.braincustom.lanfood.domain.repository.EstadoRepository;

@Component
public class EstadoRepositoryImplem implements EstadoRepository {

	//interface JPA que gerencia o contexto de persistência
	@PersistenceContext //injeta um EntityManager
	private EntityManager manager; //salvar e consultar no BD
	
	//método para listar todos os estados(from Estados)
	//createQuery - consulta JPQL em Objetos e não em tabelas
	@Override
	public List<Estado> listar(){
		return manager.createQuery("from Estado", Estado.class).getResultList();
	}
	
	//buscando um Estado por id
	@Override
	public Estado buscar(Long id) {
		return manager.find(Estado.class, id);
	}
	
	@Transactional //método executado dentro de uma transação
	@Override
	public Estado salvar(Estado estado) {
		//usando o JPA para adicionar objeto Estado no BD
		return manager.merge(estado);
	}
	
	//removendo um Estado
	@Transactional //método executado denro de uma transação
	@Override
	public void remover(Estado estado) {
		estado = buscar(estado.getId());
		manager.remove(estado);
	}
}
