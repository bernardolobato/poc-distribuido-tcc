package com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.config.security;

import java.util.Date;
import com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.modelo.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

    @Value("${forum.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication auth) {
        Usuario logado = (Usuario) auth.getPrincipal();
        return Jwts.builder().setIssuer("API do Fórum").setSubject(logado.getId().toString())
                .setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + 86400000))
                .signWith(SignatureAlgorithm.HS256, this.secret).compact();
    }

    public boolean isValido(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        Claims c = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(c.getSubject());
    }
}
