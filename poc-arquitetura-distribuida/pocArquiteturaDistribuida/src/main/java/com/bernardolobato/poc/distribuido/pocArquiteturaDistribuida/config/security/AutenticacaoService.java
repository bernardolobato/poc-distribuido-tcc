package com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.config.security;

import java.util.Optional;
import com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.modelo.Usuario;
import com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AutenticacaoService implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = this.usuarioRepository.findByEmail(username);
        if (usuario.isPresent()) {
            return usuario.get();
        } else {
            throw new UsernameNotFoundException("Dados inválidos");
        }
    }

}
