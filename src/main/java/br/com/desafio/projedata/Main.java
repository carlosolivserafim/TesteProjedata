package main.java.br.com.desafio.projedata;

import main.java.br.com.desafio.projedata.model.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1985, 1, 3), new BigDecimal("2234.56"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        funcionarios.removeIf(f -> f.getNome().equals("João"));

        System.out.println("Lista de funcionários atualizada:");
        funcionarios.forEach(System.out::println);

        funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(new BigDecimal("1.10"))));

        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        System.out.println("\nFuncionários categorizados por função:");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println(funcao + ":");
            lista.forEach(System.out::println);
        });

        System.out.println("\nFuncionários que fazem aniversário em Outubro ou Dezembro:");
        funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12)
                .forEach(System.out::println);

        Funcionario maisExperiente = funcionarios.stream()
                .max(Comparator.comparingInt(Funcionario::getIdade))
                .orElseThrow(() -> new IllegalStateException("Nenhum funcionário encontrado."));
        System.out.println("\nFuncionário mais experiente:");
        System.out.println(maisExperiente.getNome() + ", Idade: " + maisExperiente.getIdade());

        List<Funcionario> listaOrdenada = new ArrayList<>(funcionarios);
        listaOrdenada.sort(Comparator.comparing(Funcionario::getNome));
        System.out.println("\nFuncionários organizados por ordem alfabética:");
        listaOrdenada.forEach(System.out::println);

        BigDecimal somaSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nSoma total dos salários: " + somaSalarios);

        final BigDecimal salarioBase = new BigDecimal("1212.00");
        System.out.println("\nProporção de salários em relação ao mínimo:");
        funcionarios.forEach(f -> {
            BigDecimal proporcao = f.getSalario().divide(salarioBase, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println(f.getNome() + " recebe " + proporcao + " salários mínimos.");
        });
    }
}
