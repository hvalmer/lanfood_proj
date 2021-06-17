package com.braincustom.lanfood.domain.repository;

import java.util.List;

import com.braincustom.lanfood.domain.model.Estado;

public interface EstadoRepository {

	List<Estado> listar();
    Estado buscar(Long id);
    Estado salvar(Estado estado);
    void remover(Estado estado);
}
