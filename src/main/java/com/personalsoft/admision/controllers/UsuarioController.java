package com.personalsoft.admision.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personalsoft.admision.models.Usuario;
import com.personalsoft.admision.services.UsuarioService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/Api")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/usuarios")
	public ResponseEntity<?> listUsuarios() {
		Map<String, Object> response = new HashMap<>();
		List<Usuario> usuarios = usuarioService.findAll();
		if (usuarios.size() == 0) {
			response.put("mensaje", "No existen Usuarios");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}

	@GetMapping("/usuariosById")
	public ResponseEntity<?> usuariById(@RequestParam Long idUsuario) {
		Map<String, Object> response = new HashMap<>();
		Usuario usuario = usuarioService.findById(idUsuario);

		if (usuario == null) {
			response.put("mensaje", "No existe usuario");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@GetMapping("/usuariosByLogin")
	public ResponseEntity<?> usuariById(@RequestParam String username,@RequestParam String password) {
		Map<String, Object> response = new HashMap<>();
		Usuario usuario = usuarioService.usuarioByLogin(username, password);

		if (usuario == null) {
			response.put("mensaje", "Usuario o contraseña incorrecta");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}

	@PutMapping("/usuarios")
	public ResponseEntity<?> created(@RequestBody Usuario usuario) {
		Map<String, Object> response = new HashMap<>();
		Usuario usuarioNew = null;
		try {
			usuarioNew = usuarioService.save(usuario);
			if (usuarioNew == null) {
				response.put("mensaje", "Error al grabar usuario");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.put("mensaje", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Usuario>(usuarioNew, HttpStatus.OK);
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<?> update(@RequestBody Usuario usuario){
		Map<String, Object> response = new HashMap<>();
		Usuario usuarioUp = null;
		
		try {
			usuarioUp = usuarioService.save(usuario);
			if (usuarioUp == null) {
				response.put("mensaje", "Error al grabar usuario");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.put("mensaje", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Usuario>(usuarioUp, HttpStatus.OK);
	}
	
	@DeleteMapping("/usuarios")
	public ResponseEntity<?> deleteById(@RequestParam Long id){
		Map<String, Object> response = new HashMap<>();
		try {
			usuarioService.deleteById(id);
		} catch (Exception e) {
			response.put("mensaje", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
