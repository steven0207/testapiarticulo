package com.mx.test.rest.eaj.articulo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Table(schema = "public", name = "articulo")
@Entity
public class Articulo {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String idarticulo;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private double precio;
	@Column
	private String modelo;
	
}
