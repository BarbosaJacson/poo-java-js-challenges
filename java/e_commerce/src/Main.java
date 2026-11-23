import entity.CarrinhoDeCompras;
import entity.ItemCarrinho;
import entity.Produto;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.US)) {

            List<Produto> catalogo = new ArrayList<>();
            CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
            int qtdadeCatalogo =0;

            System.out.println("Quantos produtos irá cadstrar na loja?");
            if(!scanner.hasNextInt()){
                System.out.println("ERROR!! Digite apenas números inteiros!!");
                return;
            }
            qtdadeCatalogo = scanner.nextInt();
            scanner.nextLine();

            for(int i = 0; i < qtdadeCatalogo; i++){
                System.out.println("Digite o nome do "+(i + 1)+"º produto");
                String nome = scanner.nextLine();

                System.out.println("Digite o preço do "+(i + 1)+"º produto");
                if(!scanner.hasNextDouble()){
                    System.out.println("ERROR!! Digite apenas números!!");
                    return;
                }
                double preco = scanner.nextDouble();
                scanner.nextLine();

                System.out.println("Digite a quantidade do "+(i + 1)+"º produto");
                if(!scanner.hasNextInt()){
                    System.out.println("ERROR!! Digite apenas números inteiros!!");
                    return;
                }
                int quantidadeProduto = scanner.nextInt();
                scanner.nextLine();
                Produto produto = new Produto(nome, preco, quantidadeProduto);
                catalogo.add(produto);
            }

            for(Produto produto: catalogo){
                System.out.println("Id:  " +produto.getId()+" | Nome:  "+  produto.getNome()+" | Preço:  "+produto.getPreco()+" | Quantidade:  "+produto.getQuantidadeEstoque());
            }
            System.out.println("Adicione o produto ao carrinho: ");
            System.out.println("Quantos produtos irá adicionar no carrinho?");
            if(!scanner.hasNextInt()){
                System.out.println("ERROR!! Digite apenas números inteiros!!");
                return;
            }
            int qtdadeCarrinho = scanner.nextInt();
            scanner.nextLine();

            for (int j = 0; j < qtdadeCarrinho; j++) {
                System.out.println("Digite o id do " + (j + 1) + "º produto");
                if (!scanner.hasNextInt()) {
                    System.out.println("ERROR!! Digite apenas números!!");
                    return;
                }
                int idEscolhido = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Digite a quantidade do " + (j + 1) + "º produto");
                if (!scanner.hasNextInt()) {
                    System.out.println("ERROR!! Digite apenas números!!");
                    return;
                }
                int qtdadeProduto = scanner.nextInt();
                scanner.nextLine();

                boolean encontrado = false;
                for (Produto produto : catalogo) {
                    if (produto.getId() == idEscolhido) {
                        carrinho.adicionarItem(produto, qtdadeProduto);
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    throw new IllegalArgumentException("Produto com ID " + idEscolhido + " não encontrado no catálogo!");
                }
            }

            String resposta = "";
            while ((!resposta.equalsIgnoreCase("S")) && (!resposta.equalsIgnoreCase("N"))) {
                System.out.println("Deseja remover algum produto antes de fechar a conta? (S/N)");
                resposta = scanner.nextLine().trim();
                if ((!resposta.equalsIgnoreCase("S")) && (!resposta.equalsIgnoreCase("N"))) {
                    System.out.println("Entrada inválida!! Digite S ou N");
                }
            }

            if (resposta.equalsIgnoreCase("S")) {
                System.out.println("Digite o id do produto que irá remover: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("ERROR!! Digite apenas números!!");
                    return;
                }
                int idRemover = scanner.nextInt();
                scanner.nextLine();
                carrinho.removerItem(idRemover);
            }

            System.out.println("\n--- RESUMO DO PEDIDO ---");
            for (ItemCarrinho item : carrinho.getItens()) {
                System.out.printf("Nome: %s | Preço: R$ %.2f | Quantidade: %d | Subtotal: R$ %.2f%n",
                        item.getProduto().getNome(),
                        item.getProduto().getPreco(),
                        item.getQuantidade(),
                        item.calcularSubtotal());
            }

            System.out.printf("Total da compra: R$ %.2f%n", carrinho.calcularTotal());

        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException e) {
            System.out.println("Falha na operação!! Sistema será encerrado!!"+e.getMessage());
        }
    }
}