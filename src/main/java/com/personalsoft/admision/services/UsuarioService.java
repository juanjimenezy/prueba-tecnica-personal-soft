package com.personalsoft.admision.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalsoft.admision.interfaces.IUsuarioService;
import com.personalsoft.admision.models.Usuario;
import com.personalsoft.admision.repositories.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
		
	}

	@Override
	public void delete(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

	@Override
	public Usuario usuarioByLogin(String username, String password) {
		return usuarioRepository.usuarioByLogin(username, password);
	}
	
	

}
