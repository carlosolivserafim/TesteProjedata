package main.java.br.com.desafio.projedata.model;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public int getIdade() {
        return LocalDate.now().getYear() - dataNascimento.getYear();
    }
}