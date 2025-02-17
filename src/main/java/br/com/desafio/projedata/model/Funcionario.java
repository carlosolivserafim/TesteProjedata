package main.java.br.com.desafio.projedata.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    @Override
    public String toString() {
        String dataFormatada = getDataNascimento().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        NumberFormat nf = NumberFormat.getInstance(Locale.getDefault());
        nf.setMaximumFractionDigits(2);
        String salarioFormatado = nf.format(salario.doubleValue());

        return String.format("Nome: %s, Data de Nascimento: %s, Função: %s, Salário: %s",
                getNome(), dataFormatada, funcao, salarioFormatado);
    }
}
