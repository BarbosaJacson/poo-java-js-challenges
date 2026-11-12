package entity;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<String> usuario;
    private List<String> livro;

    public Biblioteca() {
        this.usuario = new ArrayList<>();
        this.livro = new ArrayList<>();
    }

    public void cadastrarLivro(String livro) {

        if (livro != null && !this.livro.contains(livro)) {
            this.livro.add(livro);
        }
    }

    public void cadastrarUsuario(String usuario) {
        if (usuario != null && !this.usuario.contains(usuario)) {
            this.usuario.add(usuario);
        }
    }

    public boolean emprestarLivro(String livro, String usuario) {
        if (livro != null && usuario != null && this.livro.contains(livro) &&
                this.usuario.contains(usuario) && livro.isDisponivel()) {
            livro.setDisponivel(false);
            return true;
        } else {
            return false;
        }
    }

    public boolean devolverLivro(String livro) {
        if (livro != null && this.livro.contains(livro) && !this.livro.isDisponivel()) {
            livro.setDisponivel(true);
            return true;
        } else {
            return false;
        }
    }
}
