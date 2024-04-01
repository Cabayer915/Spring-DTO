package com.example.springdto.dto;

public class UsuarioConsultaDto {
    private int id;
    private String nomeCompleto;
    private String enderecoEmail;
    private boolean ativo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    public String isAtivo() {
        return ativo ? "Ativo" : "Inativo";
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
