package com.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.modelo.Alumno;
import com.spring.modelo.Curso;
import com.spring.modelo.Especialidad;
import com.spring.modeloDao.AlumnoDao;
import com.spring.modeloDao.CursoDao;
import com.spring.modeloDao.EspecialidadDao;

@Controller
public class IndexController {

	@Autowired
	private EspecialidadDao daoEsp;
	
	@Autowired
	private CursoDao daoCurs;
	
	@Autowired
	private AlumnoDao daoAlum;
	
	@GetMapping("/")
	public String ListarEspecialidad(Model model) {
		List lista = daoEsp.getAll();
		model.addAttribute("especialidades", lista);
		return "/index";
	}
	
	@GetMapping("/listar")
	public List<Map<String, Object>> ListarEspecialidad2() {
		System.out.println(daoEsp.getAll());
		System.out.println(daoEsp.listar());
		return daoEsp.listar();
	}
	
	@GetMapping("/listar2")
	public List<Especialidad> ListarEspecialidad3() {
		System.out.println(daoEsp.getAll());
		System.out.println(daoEsp.listar());
		System.out.println(daoEsp.listar2());
		return daoEsp.listar2();
	}
	
	@GetMapping("/cursos/{id}")
	public String ListCursos(Model model , @PathVariable("id") String id) {
		List<Curso> lista = daoCurs.Listar(id);
		model.addAttribute("cursos", lista);
		return "/ListCursos";
	}
	
	@GetMapping("/alumnos")
	public String ListAlumnos(Model model , @RequestParam("id") String id) {
		List<Alumno> lista = daoAlum.Listar(id);
		Curso curso = daoCurs.ObtenerPorId(id);
		String nroMat = daoAlum.nroMatricula();
		
		model.addAttribute("alumnos", lista);
		model.addAttribute("codCurso", id);
		model.addAttribute("curso", curso);
		model.addAttribute("nroMat", nroMat);
		return "/ListAlumnos";
	}
	
	@GetMapping("/alumnos/delete/{nroMatr}/{codCurso}")
	public String AnularMatricula(Model model , @PathVariable("nroMatr") String nroMatr ,
			@PathVariable("codCurso") String codCurso , RedirectAttributes attributes) {
		
		int res = daoAlum.Anular(nroMatr, codCurso);
		String mensaje = "";
		
		if(res > 0) {
			mensaje = "Se elimino con exito el nro de matricula "+nroMatr;
		}else {
			mensaje = "No se ha podido eliminar nro de matricula "+nroMatr;
		}
		
		attributes.addFlashAttribute("mensaje", mensaje);
		
		return "redirect:/alumnos?id="+codCurso;
	}
	
	@PostMapping("/alumnos/save")
	public String GuardarMatricula(Model model ,Alumno alumno , RedirectAttributes attributes) {
		int res = daoAlum.GuardarMatricula(alumno);
		String mensaje = "";
		
		if(res > 0) {
			mensaje = "Se registro con exito datos de la matricula ";
		}else {
			mensaje =  "No se ha podido registrar datos de la matricula ";
		}
		
		attributes.addFlashAttribute("mensaje", mensaje);
		
		return "redirect:/alumnos?id="+alumno.getCodCur();
	}
}
