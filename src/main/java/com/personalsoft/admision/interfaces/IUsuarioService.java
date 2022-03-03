package com.personalsoft.admision.interfaces;

import java.util.List;

import com.personalsoft.admision.models.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findById(Long id);
	
	public Usuario save(Usuario usuario);
	
	public void deleteById(Long id);
	
	public void delete(Usuario usuario);
	
	public Usuario usuarioByLogin(String username, String password);

}
