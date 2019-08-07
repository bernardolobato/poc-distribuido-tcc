package com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.controller;

import javax.validation.Valid;
import com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.config.security.TokenService;
import com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.controller.dto.TokenDto;
import com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.controller.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form) {
        UsernamePasswordAuthenticationToken dadosLogin = form.convert();
        try {
            Authentication auth = authManager.authenticate(dadosLogin);
            String token = this.tokenService.gerarToken(auth);

            return ResponseEntity.ok(new TokenDto(token));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }


    }
}
