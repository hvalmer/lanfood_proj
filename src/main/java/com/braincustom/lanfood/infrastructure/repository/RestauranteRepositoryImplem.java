package com.braincustom.lanfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.braincustom.lanfood.domain.model.Restaurante;
import com.braincustom.lanfood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImplem implements RestauranteRepository {

		//interface JPA que gerencia o contexto de persistência
		@PersistenceContext //injeta um EntityManager
		private EntityManager manager; //salvar e consultar no BD
		
		//método para listar todas os restaurantes(from Restaurante)
		//createQuery - consulta JPQL em Objetos e não em tabelas
		@Override
		public List<Restaurante> listar(){
			return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
		}
		
		//buscando a Restaurante por id
		@Override
		public Restaurante buscar(Long id) {
			return manager.find(Restaurante.class, id);
		}
		
		@Transactional //método executado dentro de uma transação
		@Override
		public Restaurante salvar(Restaurante restaurante) {
			//usando o JPA para adicionar objeto Restaurante no BD
			return manager.merge(restaurante);
		}
		
		//removendo um Restaurante
		@Transactional//método executado dentro de uma transação
		@Override
		public void remover(Restaurante restaurante) {
			restaurante = buscar(restaurante.getId());
			manager.remove(restaurante);
		}
}
