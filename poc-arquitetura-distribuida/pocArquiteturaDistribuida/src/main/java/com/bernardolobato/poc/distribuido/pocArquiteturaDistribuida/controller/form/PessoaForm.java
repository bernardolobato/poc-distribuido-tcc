package com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.controller.form;

import javax.validation.constraints.NotNull;
import com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.modelo.Pessoa;
import org.hibernate.validator.constraints.Length;


public class PessoaForm {

    @NotNull
    @Length(min = 5)
    private String nome;

    @NotNull
    private String email;


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pessoa convert() {
        Pessoa p = new Pessoa(this.nome, this.email, null, null, null, null);
        return p;
    }

}
