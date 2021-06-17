package com.braincustom.lanfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.braincustom.lanfood.domain.model.FormaPagamento;
import com.braincustom.lanfood.domain.repository.FormaPagamentoRepository;

@Component
public class FormaPagamentoRepositoryImplem implements FormaPagamentoRepository {

	//interface JPA que gerencia o contexto de persistência
	@PersistenceContext //injeta um EntityManager
	private EntityManager manager; //salvar e consultar no BD
	
	//método para listar todas as FormaPagamento(from FormaPagamento)
	//createQuery - consulta JPQL em Objetos e não em tabelas
	@Override
	public List<FormaPagamento> listar(){
		return manager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
	}
	
	//buscando FormaPagamento por id
	@Override
	public FormaPagamento buscar(Long id) {
		return manager.find(FormaPagamento.class, id);
	}
	
	@Transactional //método executado dentro de uma transação
	@Override
	public FormaPagamento salvar(FormaPagamento formaPagamento) {
		//usando o JPA para adicionar objeto FormaPagamento no BD
		return manager.merge(formaPagamento);
	}
	
	//removendo um FormaPagamento
	@Transactional //método executado denro de uma transação
	@Override
	public void remover(FormaPagamento formaPagamento) {
		formaPagamento = buscar(formaPagamento.getId());
		manager.remove(formaPagamento);
	}
}
