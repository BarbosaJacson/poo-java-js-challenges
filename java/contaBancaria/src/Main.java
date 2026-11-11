import service.ContaBancaria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria minhaConta = new ContaBancaria("01005413-4", "Jacson Barbosa");
        double depositar = 0.0;
        double sacar = 0.0;


        System.out.println("Digite um valor para depósito: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("ERROR!! Digite um valor numerico válido!!");
            scanner.close();
            return;
        }
        depositar = scanner.nextDouble();
        minhaConta.depositar(depositar);

        System.out.println("Digite um valor para saque: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("ERROR!! Digite um valor numerico válido!!");
            scanner.close();
            return;
        }
        sacar = scanner.nextDouble();
        minhaConta.sacar(sacar);
        List<String> extrato = minhaConta.getHistorico();

        System.out.println("=== EXTRATO DA CONTA ===");
        System.out.println(minhaConta.getTitular()+" "+minhaConta.getNumeroDaConta());
        extrato.stream().forEach(System.out::println);

        scanner.close();

    }

}