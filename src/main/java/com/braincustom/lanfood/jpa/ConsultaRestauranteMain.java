package com.braincustom.lanfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.braincustom.lanfood.LanfoodApplication;
import com.braincustom.lanfood.domain.model.Restaurante;
import com.braincustom.lanfood.domain.repository.RestauranteRepository;

//chama o método listar do CadastroRestaurante
public class ConsultaRestauranteMain {

	public static void main(String[] args) {
		
		//inciando a aplicação
		ApplicationContext applicationContext = new SpringApplicationBuilder(LanfoodApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		//rodando o código
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		
		List<Restaurante> todosRestaurantes = restauranteRepository.listar();
		
		//iterando a lista
		for(Restaurante restaurante : todosRestaurantes) {
			System.out.printf("%s - %f - %s\n", restaurante.getNome(),
					restaurante.getTaxaFrete(), restaurante.getCozinha().getNome());
		}
	}
}
