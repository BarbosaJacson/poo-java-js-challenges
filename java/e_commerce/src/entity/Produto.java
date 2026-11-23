package entity;

public class Produto {
    private final int id;
    private static int proximoId = 1;
    private final String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String nome, double preco, int quantidadeEstoque) {
        if(nome ==null || nome.isBlank()|| preco <= 0 || quantidadeEstoque <0){
            throw new IllegalArgumentException("Parâmetros incorretos!!");
        }
        this.id = proximoId++;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void baixarEstoque(int quantidade) {
        if (quantidade <= getQuantidadeEstoque() || quantidade > 0) {
            this.quantidadeEstoque -= quantidade;
        } else {
            throw new IllegalArgumentException("Quantidade no estoque insifuciente!!");
        }
    }

    public void reporEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidadeEstoque += quantidade;
        } else {
            throw new IllegalArgumentException("Entrada inválida");
        }

    }
}
