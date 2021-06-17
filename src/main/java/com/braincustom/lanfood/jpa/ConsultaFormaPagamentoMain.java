package com.braincustom.lanfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.braincustom.lanfood.LanfoodApplication;
import com.braincustom.lanfood.domain.model.FormaPagamento;
import com.braincustom.lanfood.domain.repository.FormaPagamentoRepository;

//chama o método listar do FormaPagamento
public class ConsultaFormaPagamentoMain {

	public static void main(String[] args) {
		// inciando a aplicação
		ApplicationContext applicationContext = new SpringApplicationBuilder(LanfoodApplication.class)
				.web(WebApplicationType.NONE).run(args);

		// rodando o código
		FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);

		List<FormaPagamento> todasFormasPagamentos = formaPagamentoRepository.listar();

		// iterando a lista
		for (FormaPagamento formaPagamento : todasFormasPagamentos) {
			System.out.println(formaPagamento.getDescricao());
		}
	}
}
