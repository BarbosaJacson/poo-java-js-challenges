package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Agenda {

    private final List<Contato> contato;

    public Agenda() {
        this.contato = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        if (contato == null && this.contato.contains(contato)) {
            throw new IllegalStateException("Contato já existe!!");
            } else {
            this.contato.add(contato);
        }
    }

    public Contato buscarContato(String nome) {
        if (!nome.isBlank()) {
            for (Contato c : this.contato) {
                if (c.getNome().equalsIgnoreCase(nome)) {
                    return c;
                }
            }
            throw new NoSuchElementException("Contato não encontrado: " + nome);
        } else {
            throw new NoSuchElementException("Contato não encontrado: " + nome);
        }
    }

    public boolean removerContato(String nome) {
        Contato contato = buscarContato(nome);
        this.contato.remove(contato);
        return true;
    }

    public void listarContatos() {
        if (!this.contato.isEmpty()) {
            for (Contato c : this.contato) {
                System.out.println(c);
            }
        } else {
            throw new IllegalStateException("A lista está vazia!!");
        }
    }
}