package ar.com.ej1.fecade;

import java.util.List;

import ar.com.ej1.dao.CursoDao;
import ar.com.ej1.dao.FormaDePagoDao;
import ar.com.ej1.dao.InscripcionDao;
import ar.com.ej1.dto.Curso;
import ar.com.ej1.dto.FormaDePago;
import ar.com.ej1.dto.Inscripcion;

public class Fecade {
	
	private CursoDao cursoDao = new CursoDao();
	private FormaDePagoDao formaDePagoDao = new FormaDePagoDao();
	private InscripcionDao inscripcionDao = new InscripcionDao();
	
	public List<Curso> getCursos(){
		return cursoDao.getCursos();
	}
	
	public List<FormaDePago> getFormasDePago(){
		return formaDePagoDao.getFormasDePago();
	}
	
	public Long inscribir(Inscripcion insc){
		return inscripcionDao.generarInscripcion(insc);
	}
}
