package com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.controller.dto;

public class TokenDto {

    private String type;
    private String token;

    public TokenDto(String token) {
        this.token = token;
        this.type = "Bearer";
    }


    public String getType() {
        return this.type;
    }

    public String getToken() {
        return this.token;
    }

}
