package com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.controller.dto;

import com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.modelo.Pessoa;
import org.springframework.data.domain.Page;

public class PessoaDTO {

    private final Long id;
    private final String nome;
    private final String email;



    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.email = pessoa.getEmail();
    }


    public Long getId() {
        return this.id;
    }


    public String getNome() {
        return this.nome;
    }


    public String getEmail() {
        return this.email;
    }



    public static Page<PessoaDTO> convert(Page<Pessoa> list) {
        return list.map(PessoaDTO::new);
    }


}
