package com.braincustom.lanfood.domain.repository;

import java.util.List;

import com.braincustom.lanfood.domain.model.Cidade;

public interface CidadeRepository {

	List<Cidade> listar();
    Cidade buscar(Long id);
    Cidade salvar(Cidade cidade);
    void remover(Cidade cidade);
}
