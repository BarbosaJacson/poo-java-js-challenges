import entity.Desenvolvedor;
import entity.Funcionario;
import entity.Gerente;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Funcionario> equipe = new ArrayList<>();

            System.out.println("Quantos funcionários a equipe é composta?");
            if (!scanner.hasNextInt()) {
                System.out.println("ERROR!! Insira a quantidade em números inteiros");
                return;
            }
            int qtdade = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < qtdade; i++) {
                System.out.println("Digite o nome do " + (i + 1) + "º funcionário: ");
                String nome = scanner.nextLine();

                System.out.println("Digite o cargo do " + (i + 1) + "º funcionário: ");
                String cargo = scanner.nextLine();

                System.out.println("Digite o salario do " + (i + 1) + "º funcionário: ");
                double salarioBase = scanner.nextDouble();

                if ("gerente".equalsIgnoreCase(cargo.trim())) {
                    System.out.println("Digite o valor do bônus do funcionário: ");
                    double bonus = scanner.nextDouble();
                    scanner.nextLine();
                    Gerente gerente = new Gerente(nome, salarioBase, bonus);
                    equipe.add(gerente);
                } else if ("desenvolvedor".equalsIgnoreCase(cargo.trim())) {
                    System.out.println("Digite o valor da hora extra do funcionário: ");
                    double valorHoraExtra = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Digite quantidade de horas extras do funcionário: ");
                    int horasExtras = scanner.nextInt();
                    scanner.nextLine();
                    Desenvolvedor desenvolvedor = new Desenvolvedor(nome, salarioBase, horasExtras, valorHoraExtra);
                    equipe.add(desenvolvedor);
                } else {
                    throw new IllegalArgumentException("Cargo inválido: " + cargo + ". Use 'Gerente' ou 'Desenvolvedor'.");
                }


            }
            for (Funcionario e : equipe) {
                System.out.printf("O funcionário %s recebeu R$ %.2f de salário total.%n", e.getNome(), e.calcularSalario());
            }


        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException e) {
            System.out.println("Erro na operação: " + e.getMessage());
        }
    }
}