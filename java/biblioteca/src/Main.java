import entity.Biblioteca;
import entity.Livro;
import entity.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int qtdeLivros = 0;
        int qtdeUsuarios = 0;
        Livro livroParaTeste = null;
        Usuario usuarioParaTeste = null;

        System.out.println("Digite a quantidade de livros que deseja cadastrar: ");
        if (!scanner.hasNextInt()) {
            System.out.println("ERROR!! Digite a quantidade em numeros inteiros!!");
            scanner.close();
            return;
        }
        qtdeLivros = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite a quantidade de usuarios que deseja cadastrar: ");
        if (!scanner.hasNextInt()) {
            System.out.println("ERROR!! Digite a quantidade em numeros inteiros!!");
            scanner.close();
            return;
        }
        qtdeUsuarios = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < qtdeLivros; i++) {
            System.out.println("Digite os dados do " + (i + 1) + "º livro(título, autor): ");
            String titulo = scanner.nextLine();
            String autor = scanner.nextLine();
            Livro novoLivro = new Livro(titulo, autor);
            livroParaTeste = novoLivro;
            biblioteca.cadastrarLivro(novoLivro);

        }
        for (int j = 0; j < qtdeUsuarios; j++) {
            System.out.println("Digite os dados do " + (j + 1) + "º usuário(id, nome): ");
            String id = scanner.nextLine();
            String nome = scanner.nextLine();
            Usuario novoUsuario = new Usuario(id, nome);
            usuarioParaTeste = novoUsuario;
            biblioteca.cadastrarUsuario(novoUsuario);

        }
        System.out.println("====LIVROS CADASTRADOS====");
        for(Livro livro : biblioteca.getLivros()){
            System.out.println("Livros cadastrados:  "+ livro);

        }

        System.out.println("====USUÁRIOS CADASTRADOS====");
        for(Usuario usuario : biblioteca.getUsuarios()){
            System.out.println("Usuários cadastrados:  "+ usuario);
        }

        if (livroParaTeste != null && usuarioParaTeste != null) {
            System.out.println("====STATUS LIVROS E USUARIOS====");
            Boolean emprestou = biblioteca.emprestarLivro(livroParaTeste, usuarioParaTeste);
            if (emprestou) {
                System.out.println("Empréstimo realizado: livro '" + livroParaTeste.getTitulo() + "' para " + usuarioParaTeste.getNome());
            } else {
                System.out.println("Falha: o livro '" + livroParaTeste.getTitulo() + "' não está disponível.");
            }

        }
        scanner.close();
    }
}