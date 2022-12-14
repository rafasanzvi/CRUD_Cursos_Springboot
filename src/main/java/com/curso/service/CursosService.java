package com.curso.service;

import java.util.List;

import com.curso.model.Curso;

public interface CursosService {

	List<Curso> cursos(); // GET 
	
	Curso buscarCurso(int codCurso); // GET
	
	void altaCurso(Curso curso); // POST

	List<Curso> borrarCurso(int codCurso); //DELETE
	
	void actualizarCurso(int codCurso, int duracion); //PUT
	
	List<Curso> mostrarCursoPrecio(double precioMinimo, double precioMaximo); // GET
}
