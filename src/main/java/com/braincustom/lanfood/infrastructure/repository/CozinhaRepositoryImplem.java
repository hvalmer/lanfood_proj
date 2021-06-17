package com.braincustom.lanfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.braincustom.lanfood.domain.model.Cozinha;
import com.braincustom.lanfood.domain.repository.CozinhaRepository;

@Component
public class CozinhaRepositoryImplem implements CozinhaRepository {

		//interface JPA que gerencia o contexto de persistência
		@PersistenceContext //injeta um EntityManager
		private EntityManager manager; //salvar e consultar no BD
		
		//método para listar todas as cozinhas(from Cozinha)
		//createQuery - consulta JPQL em Objetos e não em tabelas
		@Override
		public List<Cozinha> listar(){
			return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
		}
		
		//buscando a Cozinha por id
		@Override
		public Cozinha buscar(Long id) {
			return manager.find(Cozinha.class, id);
		}
		
		@Transactional //método executado dentro de uma transação
		@Override
		public Cozinha salvar(Cozinha cozinha) {
			//usando o JPA para adicionar objeto Cozinha no BD
			return manager.merge(cozinha);
		}
		
		//removendo uma Cozinha
		@Transactional//método executado dentro de uma transação
		@Override
		public void remover(Cozinha cozinha) {
			cozinha = buscar(cozinha.getId());
			manager.remove(cozinha);
		}
}
