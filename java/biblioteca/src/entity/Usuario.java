package entity;

public class Usuario {
    private String id;
    private String nome;

    public Usuario(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    @Override
    public String toString() {

        return "Id: %s | nome: %s".formatted(this.id,
                this.nome);
    }
}
