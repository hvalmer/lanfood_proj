package com.braincustom.lanfood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.braincustom.lanfood.LanfoodApplication;
import com.braincustom.lanfood.domain.model.Cozinha;
import com.braincustom.lanfood.domain.repository.CozinhaRepository;

//chama o método listar do CadastroCozinha
public class AltercaoCozinhaMain {

	public static void main(String[] args) {
		
		//inciando a aplicação
		ApplicationContext applicationContext = new SpringApplicationBuilder(LanfoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		//rodando o código
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		//alterando o nome das Cozinhas
		Cozinha cozinha = new Cozinha();
		cozinha.setId(1L);
		cozinha.setNome("Brasileira");
		
		cozinhaRepository.salvar(cozinha);
		
	}
}
