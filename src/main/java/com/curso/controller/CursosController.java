package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursosService;

@RestController
public class CursosController {

	@Autowired //Para utilizar el service
	CursosService service;
	
	//GET de todos los cursos
	@GetMapping(value = "cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursos(){
		
		return service.cursos();
	}
	
	//GET cursos por código de curso
	@GetMapping(value = "buscarCurso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@PathVariable ("codCurso") int codCurso) {
		
		return service.buscarCurso(codCurso);
	}
	
	//POST Dar de alta curso
	@PostMapping(value = "altaCurso", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void altaCurso(@RequestBody Curso curso) {
		service.altaCurso(curso);
	}
	
	//DELETE para borrar curso
	@DeleteMapping(value = "borrarCurso/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> cursosBorrar(@PathVariable ("codCurso") int codCurso) {
		
		return service.borrarCurso(codCurso);
	}
	
	//PUT para actualizar
	@PutMapping(value = "actualizarHoras/{codCurso}/{horas}", produces=MediaType.APPLICATION_JSON_VALUE)
	public void actualizarDuracion(@PathVariable ("codCurso") int codCurso, @PathVariable ("horas") int horas) {
		
		service.actualizarCurso(codCurso, horas);
	}
	
	
	@GetMapping(value = "buscarPrecioCurso/{precioMinimo}/{precioMaximo}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> mostrarCursoPrecio(@PathVariable ("precioMinimo") double precioMinimo, @PathVariable ("precioMaximo") double precioMaximo) {
		
		return service.mostrarCursoPrecio(precioMinimo, precioMaximo);
	}
}
