import entity.Agenda;
import entity.Contato;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        System.out.println("Quantos contatos irá adicionar? ");
        if(!scanner.hasNextInt()){
            System.out.println("ERROR!! Digite a quantidade em número inteiro!!");
            scanner.close();
            return;
        }
        int qtdadeContatos = scanner.nextInt();
        scanner.nextLine();

        String nome ="";
        String telefone = "";
        String email = "";

        for(int i = 0;i < qtdadeContatos; i++){
            System.out.println("Digite o  "+(i +1)+"º contato: ");
            System.out.println("Digite o nome: ");
            nome = scanner.nextLine();

            if (nome == null || !nome.matches("^[a-zA-ZÀ-ÿ\\s]+$")) {
                throw new IllegalArgumentException("Erro: Digite apenas texto, números não são permitidos.");
            }

            System.out.println("Digite o telefone: ");
            telefone = scanner.nextLine();

            if (telefone == null || !telefone.matches("^[0-9()\\s-]+$")) {
                throw new IllegalArgumentException("Erro: Digite apenas texto, números não são permitidos.");
            }

            System.out.println("Digite o email: ");
            email = scanner.nextLine();

            if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                throw new IllegalArgumentException("Erro: Digite apenas texto, números não são permitidos.");
            }
            Contato novoContato = new Contato(nome, telefone, email);
            agenda.adicionarContato(novoContato);

        }

        System.out.println("Digite o nome do contato para busca: ");
        String buscaContato = scanner.nextLine().toLowerCase().toUpperCase();
        Contato contatoEncontrado = agenda.buscarContato(buscaContato);

        System.out.println(contatoEncontrado);


    }
}