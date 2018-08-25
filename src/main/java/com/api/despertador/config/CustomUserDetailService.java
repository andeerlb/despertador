package com.api.despertador.config;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.api.despertador.models.Usuario;
import com.api.despertador.services.UsuarioService;

@Component
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = Optional.ofNullable(usuarioService.findByUsername(username))
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		return new User(user.getUsername(), user.getPassword(), authorities);

	}


}
