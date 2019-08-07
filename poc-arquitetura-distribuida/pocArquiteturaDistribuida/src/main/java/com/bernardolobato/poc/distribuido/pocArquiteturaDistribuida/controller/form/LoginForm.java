package com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.controller.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {
    private String email;
    private String senha;

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
    }

    public UsernamePasswordAuthenticationToken convert() {
        return new UsernamePasswordAuthenticationToken(email, senha);
    }
}
