package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Postagem;
import com.example.demo.repository.PostagemRepository;



@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
		public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
		
	}
	
	
	
	//Controller FindById
	@GetMapping ("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
		
	//Controller FindByTitulo
	@GetMapping ("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@GetMapping(value = "/maior")
	public ResponseEntity<List<Postagem>> findAllMaior(){
		return ResponseEntity.ok(repository.findAllAtivas());
	}

	
	@GetMapping (value = "/ordem")
	public ResponseEntity<List<Postagem>> anosDesc(){
		return ResponseEntity.ok(repository.anosDesc());
	}
	
	@GetMapping (value = "/intervalo")
	public ResponseEntity<List<Postagem>> anosIntervalos(){
		return ResponseEntity.ok(repository.anosIntervalos());
	}
	
	@GetMapping (value = "/Asc")
	public ResponseEntity<List<Postagem>> anosAsc(){
		return ResponseEntity.ok(repository.anosAsc());
	}
	

	@PostMapping
	public Postagem addPostagem (@RequestBody Postagem postagem){
		repository.save(postagem);
		return postagem;
	}
	
	@PutMapping
	public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
		
	}

	
	@DeleteMapping("/{id}")
		public void delete(@PathVariable long id ) {
			repository.deleteById(id);
			
		}
	
		
	}
	

