package com.empresa.security;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenFilter extends OncePerRequestFilter {

	private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
			throws ServletException, IOException {
		logger.info(">>> Ingreso doFilterInternal");
		try {
		    String token = getToken(req);
		    System.out.println("DEBUG -> Token extraido: " + token);

		    if (token != null && jwtProvider.validateToken(token)) {
		        String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
		        System.out.println("DEBUG -> Token VALIDO para el usuario: " + nombreUsuario);

		        UserDetails userDetails = userDetailsService.loadUserByUsername(nombreUsuario);
		        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
		                userDetails, null, userDetails.getAuthorities());
		        SecurityContextHolder.getContext().setAuthentication(auth);
		    } else {
		        System.out.println("DEBUG -> El token es NULL o la validacion de jwtProvider.validateToken fallo.");
		    }
		} catch (Exception e) {
		    System.out.println("DEBUG -> Ocurrio una excepcion en el filtro: " + e.getMessage());
		    e.printStackTrace();
		}
		filterChain.doFilter(req, res);
	}

	private String getToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		logger.info(">>> header >>> " + header);
		if (header != null && header.startsWith("Bearer ")) {
			return header.substring(7);
		}
		return null;
	}
}
