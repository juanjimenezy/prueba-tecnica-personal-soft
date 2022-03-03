package com.personalsoft.admision.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.personalsoft.admision.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long>{
	
	@Query("SELECT u FROM Usuario u WHERE u.username = :username AND u.password = :password")
	Usuario usuarioByLogin(@Param("username") String username,@Param("password") String password);

}
