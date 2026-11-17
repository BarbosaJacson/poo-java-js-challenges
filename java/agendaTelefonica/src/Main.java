import entity.Agenda;
import entity.Contato;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            Agenda agenda = new Agenda();

            System.out.println("Quantos contatos irá adicionar? ");
            if (!scanner.hasNextInt()) {
                System.out.println("ERROR!! Digite a quantidade em número inteiro!!");
                return;
            }
            int qtdadeContatos = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < qtdadeContatos; i++) {
                String nome = "";
                String telefone = "";
                String email = "";

                System.out.println("Digite o  " + (i + 1) + "º contato: ");
                System.out.println("Digite o nome: ");
                nome = scanner.nextLine();

                System.out.println("Digite o telefone: ");
                telefone = scanner.nextLine();

                System.out.println("Digite o email: ");
                email = scanner.nextLine();

                Contato novoContato = new Contato(nome, telefone, email);
                agenda.adicionarContato(novoContato);

            }

            System.out.println("Digite o nome do contato para busca: ");
            String buscaContato = scanner.nextLine().toLowerCase().trim();
            Contato contatoEncontrado = agenda.buscarContato(buscaContato);
            System.out.println(contatoEncontrado);

            System.out.println("=====LISTA DE CONTATOS=====");
            agenda.listarContatos();

            System.out.println("Digite o nome do contato para remover: ");
            String encontrarERemover = scanner.nextLine().toLowerCase().trim();
            System.out.println("=====CONTATOS REMOVIDOS=====");
            Boolean removerContato = agenda.removerContato(encontrarERemover);
            if (removerContato) {
                System.out.println("Contato " + encontrarERemover + " removido!!");
            }

            System.out.println("=====LISTA DE CONTATOS=====");
            agenda.listarContatos();

        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException e) {
            System.out.println("Erro na operação: " + e.getMessage());
        }
    }

}