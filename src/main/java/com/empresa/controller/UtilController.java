package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Alumno;
import com.empresa.entity.DataCatalogo;
import com.empresa.entity.Deporte;
import com.empresa.entity.Pais;
import com.empresa.entity.Pasatiempo;
import com.empresa.entity.Tipo;
import com.empresa.entity.Usuario;
import com.empresa.service.AlumnoService;
import com.empresa.service.DataCatalogoService;
import com.empresa.service.DeporteService;
import com.empresa.service.PaisService;
import com.empresa.service.PasatiempoService;
import com.empresa.service.TipoService;
import com.empresa.service.UsuarioService;
import com.empresa.util.AppSettings;

@RestController
@RequestMapping("/url/util")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UtilController {

	@Autowired
	private PaisService paisService;

	@Autowired
	private DataCatalogoService dataCatalogoService;

	@Autowired
	private AlumnoService alumnoService;

	@Autowired
	private PasatiempoService pasatiempoService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private DeporteService deporteService;

	@Autowired
	private TipoService tipoService;

	@GetMapping("/listaPais")
	@ResponseBody
	public List<Pais> listaPais() {
		return paisService.listaTodos();
	}

	@GetMapping("/listaAlumno")
	@ResponseBody
	public List<Alumno> listaAlumno() {
		return alumnoService.listaTodos();
	}


	@GetMapping("/listaCategoriaDeLibro")
	@ResponseBody
	public List<DataCatalogo> listaCategoriaDeLibro() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_01_CATEGORIA_DE_LIBRO);
	}

	@GetMapping("/listaTipoProveedor")
	@ResponseBody
	public List<DataCatalogo> listaTipoProveedor() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_02_TIPO_DE_PROVEEDOR);
	}

	@GetMapping("/listaModalidadAlumno")
	@ResponseBody
	public List<DataCatalogo> listaModalidadAlumno() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_03_MODALIDAD_DE_ALUMNO);
	}

	@GetMapping("/listaGradoAutor")
	@ResponseBody
	public List<DataCatalogo> listaGradoAutor() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_04_GRADO_DE_AUTOR);
	}

	@GetMapping("/listaTipoLibroRevista")
	@ResponseBody
	public List<DataCatalogo> listaTipoLibroRevista() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_05_TIPO_DE_LIBRO_Y_REVISTA);
	}

	@GetMapping("/listaTipoSala")
	@ResponseBody
	public List<DataCatalogo> listaTipoSala() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_06_TIPO_DE_SALA);
	}

	@GetMapping("/listaSede")
	@ResponseBody
	public List<DataCatalogo> listaSede() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_07_SEDE);
	}

	@GetMapping("/listaEstadoLibro")
	@ResponseBody
	public List<DataCatalogo> listaEstadoLibro() {
		return dataCatalogoService.listaDataCatalogo(AppSettings.CATALOGO_08_ESTADO_DE_LIBRO);
	}

	@GetMapping("/listaPasatiempo")
	@ResponseBody
	public List<Pasatiempo> listaPasatiempo() {
		return pasatiempoService.listaPasatiempo();
	}

	@GetMapping("/listaUsuario")
	@ResponseBody
	public List<Usuario> listaUsuario() {
		return usuarioService.listaUsuario();
	}


	@GetMapping("/listaDeporte")
	public ResponseEntity<List<Deporte>> listaTodos(){
		List<Deporte> lista = deporteService.listaTodos();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/listaTiposDeProveedor")
	public ResponseEntity<List<Tipo>> listaTodosTiposDeProveedor(){
		List<Tipo> lista = tipoService.listaTodos();
		return ResponseEntity.ok(lista);
	}
}
