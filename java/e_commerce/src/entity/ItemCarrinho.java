package entity;

public class ItemCarrinho {
private final Produto produto;
private int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        if(produto == null || quantidade <= 0){
            throw new IllegalArgumentException("ERROR!! Quantidade inválida ou produto incorreto!!");
        }
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public double calcularSubtotal(){
        return this.quantidade * getProduto().getPreco();

    }
}
