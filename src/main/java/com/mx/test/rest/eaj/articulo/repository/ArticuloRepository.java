package com.mx.test.rest.eaj.articulo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.test.rest.eaj.articulo.dto.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, String> {

	@Query("SELECT a FROM Articulo a WHERE LOWER(a.nombre) = LOWER(:name)")
	Articulo retrieveByName(@Param("name") String name);
	
}
