package entity;

import java.util.ArrayList;
import java.util.List;

import static java.util.List.copyOf;

public class Biblioteca {
    private List<Usuario> usuarios;
    private List<Livro> livros;

    public Biblioteca() {
        this.usuarios = new ArrayList<>();
        this.livros = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {

        if (livro != null && !this.livros.contains(livro)) {
            this.livros.add(livro);
        }
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (usuario != null && !this.usuarios.contains(usuario)) {
            this.usuarios.add(usuario);
        }
    }

    public boolean emprestarLivro(Livro livro, Usuario usuario) {
        if (livro != null && usuario != null && livros.contains(livro) &&
                this.usuarios.contains(usuario) && livro.isDisponivel()) {
            livro.setDisponivel(false);
            return true;
        } else {
            return false;
        }
    }

    public boolean devolverLivro(Livro livro) {
        if (livro != null && livros.contains(livro) && !livro.isDisponivel()) {
            livro.setDisponivel(true);
            return true;
        } else {
            return false;
        }
    }
    public List<Livro> getLivros() {
     return List.copyOf(this.livros);
    }
    public List<Usuario> getUsuarios() {
        return List.copyOf(this.usuarios);
    }
}
