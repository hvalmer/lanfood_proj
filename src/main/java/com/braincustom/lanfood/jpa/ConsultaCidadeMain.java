package com.braincustom.lanfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.braincustom.lanfood.LanfoodApplication;
import com.braincustom.lanfood.domain.model.Cidade;
import com.braincustom.lanfood.domain.repository.CidadeRepository;

//chama o método listar do CadastroCidade
public class ConsultaCidadeMain {

	public static void main(String[] args) {
		
		//iniciando a aplicação
        ApplicationContext applicationContext = new SpringApplicationBuilder(LanfoodApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
        
        //rodando o código
        CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
        
        List<Cidade> todasCidades = cidadeRepository.listar();
        
        //iterando a lista
        for (Cidade cidade : todasCidades) {
            System.out.printf("%s - %s\n", cidade.getNome(), cidade.getEstado().getNome());
        }
    }
}
