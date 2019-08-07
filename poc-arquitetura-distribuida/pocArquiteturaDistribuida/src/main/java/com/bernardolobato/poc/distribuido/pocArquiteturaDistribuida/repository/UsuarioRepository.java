package com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.repository;

import java.util.Optional;
import com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String username);

}
