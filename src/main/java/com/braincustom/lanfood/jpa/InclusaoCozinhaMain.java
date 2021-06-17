package com.braincustom.lanfood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.braincustom.lanfood.LanfoodApplication;
import com.braincustom.lanfood.domain.model.Cozinha;
import com.braincustom.lanfood.domain.repository.CozinhaRepository;

//chama o método listar do CadastroCozinha
public class InclusaoCozinhaMain {

	public static void main(String[] args) {
		
		//inciando a aplicação
		ApplicationContext applicationContext = new SpringApplicationBuilder(LanfoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		//rodando o código
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		//cadastrando outras cozinhas
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Brasileira");
		
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Japonesa");
		
		cozinha1 = cozinhaRepository.salvar(cozinha1);
		cozinha2 = cozinhaRepository.salvar(cozinha2);
		
		//mostrando no print em desenvolvimento as duas cozinhas adicionadas
		System.out.printf("%d - %s\n", cozinha1.getId(), cozinha1.getNome());
		System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome());
	}
}
