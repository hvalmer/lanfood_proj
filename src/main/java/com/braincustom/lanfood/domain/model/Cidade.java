package com.braincustom.lanfood.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cidade {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Auto Increment
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@ManyToOne //muitas cidades possuem um Estado
	@JoinColumn(nullable = false)
	private Estado estado;
	
}