package com.curso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.model.Curso;

@Service
public class CursosServiceImplement implements CursosService {

	
	
	List<Curso> cursos;
	
	public CursosServiceImplement() {
		
		cursos = new ArrayList<>();
		cursos.add(new Curso(1234, "Curso JAVA", 193, 0));
		cursos.add(new Curso(5678, "Bootcamp Javascript", 250, 3000));
		cursos.add(new Curso(9876, "Maquetación web", 50, 9.99));
		cursos.add(new Curso(5432, "Iniciación React", 90, 20.99));
		cursos.add(new Curso(1010, "Curso SpringBoot", 160, 250));
		
	}
	
	
	@Override
	public List<Curso> cursos() {
		
		return cursos;
	}


	@Override
	public List<Curso> borrarCurso(int codCurso) {
		
		for(Curso curso:cursos) {
			if(curso.getCodCurso() == codCurso) {
				cursos.remove(curso);
				return cursos;
			}
		}
		return null;
	}


	@Override
	public Curso buscarCurso(int codCurso) {
		
		for(Curso curso:cursos) {
			if(curso.getCodCurso() == codCurso) {
				return curso;
			}
		}
		
		return null;
	}


	@Override
	public List<Curso> mostrarCursoPrecio(double precioMinimo, double precioMaximo) {
		
				List<Curso>cursosPrecio = new ArrayList();
				
				for(int i = 0; i < cursos.size(); i++) {
					if(cursos.get(i).getPrecio() >= precioMinimo && cursos.get(i).getPrecio() <= precioMaximo) {
						cursosPrecio.add(cursos.get(i));
					}
				}
				return cursosPrecio;
			}
		


	@Override
	public void altaCurso(Curso curso) {
		
		cursos.add(curso);
		
	}


	@Override
	public void actualizarCurso(int codCurso, int duracion) {
		
		for(Curso cursoElement:cursos) {
			if(cursoElement.getCodCurso() == codCurso) {
				cursoElement.setDuracion(duracion);
			}
		}
		
	}
	
	
}
