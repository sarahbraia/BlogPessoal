package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Postagem;


@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
	
	@Query(value = "select*from postagem where ano > 2011", nativeQuery = true)
	List<Postagem> findAllAtivas();
	
	@Query(value = "SELECT*from postagem where ano > 2011 ORDER BY ano DESC", nativeQuery = true)
	List<Postagem> anosDesc();
	
	@Query(value = "SELECT*from postagem where ano > 2011 ORDER BY ano ASC", nativeQuery = true)
	List<Postagem> anosAsc();
	
	@Query(value = "SELECT*from postagem where ano >=2011 and ano <=2013", nativeQuery = true)
	List<Postagem> anosIntervalos();
	
}
