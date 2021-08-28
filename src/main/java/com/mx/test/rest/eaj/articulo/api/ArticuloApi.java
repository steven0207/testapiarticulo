package com.mx.test.rest.eaj.articulo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mx.test.rest.eaj.articulo.dto.Articulo;
import com.mx.test.rest.eaj.articulo.repository.ArticuloRepository;
import com.sun.istack.NotNull;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/articulos")
@Api(value="ArticulosResources", consumes="application/json", produces="application/json",protocols="http", description="Operations Related to Articulos")
public class ArticuloApi {
	
	@Autowired
	private ArticuloRepository articuloRepository;

	@RequestMapping(value="/", method = RequestMethod.GET)
	@ApiOperation(consumes="application/json", produces="application/json",protocols="http", value = "getAllArticulos" )
	public List<Articulo> getArticulos() {
		List<Articulo> lstArticulos = new ArrayList<Articulo>();
		List<Articulo> lstArticulo = articuloRepository.findAll();
		
		Articulo articulo = new Articulo();
		articulo.setNombre("AR001");
		articulo.setDescripcion("Laptop");
		articulo.setIdarticulo("Lenovo Core i7");
		articulo.setPrecio(21000.01);
		articulo.setModelo("T486");
		lstArticulos.add(articulo);
		System.out.println("La lista esta vacia: " + lstArticulo.size());
		if (!lstArticulo.isEmpty())
			return lstArticulo;
		else
			return lstArticulos;
	}
	

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(consumes="application/json", produces="application/json",protocols="http", value = "getArticulo" )
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved articulo"),
			@ApiResponse(code = 401, message = "The request has not been applied because it lacks valid authentication credentials for the target resource"),
			@ApiResponse(code = 403, message = "The server understood the request but refuses to authorize it"),
			@ApiResponse(code = 404, message = "The resource  not found")
	})	
	public Articulo getArticuById(@PathVariable String id) {
		Articulo nuevo = null;
		Optional<Articulo> art = articuloRepository.findById(id);
		if (art.isPresent()) {
			nuevo = art.get();
			System.out.println(nuevo.getNombre());
		}		
		return nuevo;
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Articulo updateArticulo(@PathVariable("id") final String id, @RequestBody final Articulo articulo) {
		articuloRepository.save(articulo);
		return articulo;
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Articulo postArticulo(@NotNull @Validated @RequestBody final Articulo articulo) {
		articuloRepository.save(articulo);
		return articulo;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteArticulo(@PathVariable final String id) {
		Articulo art = articuloRepository.findById(id).get();
		
		articuloRepository.delete(art);
		return "El articulo con id: " + id + " Fue elimiando exitosamente";
	}
}
