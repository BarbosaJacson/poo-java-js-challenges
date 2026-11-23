package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class CarrinhoDeCompras {
    private List<ItemCarrinho> itens;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public List<ItemCarrinho> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public void adicionarItem(Produto produto, int quantidade) {

        if (produto == null || quantidade <= 0) {
            throw new IllegalArgumentException("Preço ou quantidade inválidos!!");
        }
        produto.baixarEstoque(quantidade);
        this.itens.add(new ItemCarrinho(produto, quantidade));

    }

    public void removerItem(int idProduto) {

        Iterator<ItemCarrinho> it = this.itens.iterator();
        while (it.hasNext()) {
            ItemCarrinho item = it.next();
            if (item.getProduto().getId() == idProduto) {
                it.remove();
                item.getProduto().reporEstoque(item.getQuantidade());
                return;
            }
        }

    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemCarrinho itens : this.itens) {
            total += itens.calcularSubtotal();
        }
        return total;
    }
}
