package com.empresa.security;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.empresa.entity.Opcion;
import com.empresa.entity.Rol;
import com.empresa.entity.Usuario;
import com.empresa.repository.UsuarioRepository;

import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog
public class UsuarioSeguridadServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		log.info(">>>loadUserByUsername >>> " + login);
		UserDetails userDetails = null;
		try {
			Optional<Usuario> optUsuario = usuarioRepository.findByLogin(login);
			if (optUsuario.isPresent()) {
				log.info("==> Login =========== " + optUsuario.get());

				List<Rol> lstRol = usuarioRepository.traerRolesDeUsuario(optUsuario.get().getIdUsuario());
				log.info("==> Roles =========== " + lstRol);
				
				List<Opcion> lstOpciones = usuarioRepository.traerEnlacesDeUsuario(optUsuario.get().getIdUsuario());
				log.info("==> Opciones =========== " + lstOpciones);

				userDetails = UsuarioPrincipal.build(optUsuario.get(), lstRol, lstOpciones);
			}
		} catch (IndexOutOfBoundsException e) {
			throw new UsernameNotFoundException("Wrong username");
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("Database Error");
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("Unknown Error");
		}
		return userDetails;
	}

}
