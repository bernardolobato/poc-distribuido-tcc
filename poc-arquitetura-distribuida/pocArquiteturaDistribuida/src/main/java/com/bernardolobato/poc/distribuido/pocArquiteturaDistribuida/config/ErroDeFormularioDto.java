package com.bernardolobato.poc.distribuido.pocArquiteturaDistribuida.config;

import java.util.Objects;

public class ErroDeFormularioDto {

    private String campo;
    private String erro;

    public ErroDeFormularioDto() {
    }

    public ErroDeFormularioDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public ErroDeFormularioDto campo(String campo) {
        this.campo = campo;
        return this;
    }

    public ErroDeFormularioDto erro(String erro) {
        this.erro = erro;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ErroDeFormularioDto)) {
            return false;
        }
        ErroDeFormularioDto erroDeFormularioDto = (ErroDeFormularioDto) o;
        return Objects.equals(campo, erroDeFormularioDto.campo)
                && Objects.equals(erro, erroDeFormularioDto.erro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(campo, erro);
    }

    @Override
    public String toString() {
        return "{" + " campo='" + getCampo() + "'" + ", erro='" + getErro() + "'" + "}";
    }



    public String getCampo() {
        return this.campo;
    }

    public String getErro() {
        return this.erro;
    }


}
