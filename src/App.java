import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<String> pedidos = new ArrayList<>();
    HashMap<Integer, String> produtos = new HashMap<>(); // Mapeia o código do produto para o nome
    HashMap<Integer, Double> precos = new HashMap<>();   // Mapeia o código do produto para o preço
    // Produtos pré-definidos com seus preços
     produtos.put(1, "iPhone X");
    precos.put(1, 5000.0);

        produtos.put(2, "Samsung Galaxy S22");
        precos.put(2, 4000.0);

        produtos.put(3, "iPhone 13");
        precos.put(3, 6000.0);

        produtos.put(4, "Samsung Galaxy S24");
        precos.put(4, 7000.0);

        produtos.put(5, "Intel Core I5, 16GB RAM, SSD 512GB, Windows 10 + Monitor Led 19.5");
        precos.put(5, 3500.0);

        produtos.put(6, "Intel i5-13400F, GeForce RTX 4060 8GB, 16GB DDR4, SSD M.2 512GB");
        precos.put(6, 4500.0);

        produtos.put(7, "Dell Inspiron 15 3000");
        precos.put(7, 3000.0);

        produtos.put(8, "MacBook Air M2");
        precos.put(8, 8000.0);

        produtos.put(9, "Lenovo Legion 5");
        precos.put(9, 5500.0);

        int codigoProduto = 10; // Para novos produtos cadastrados

        double total = 0.0; // Variável para armazenar o valor total dos pedidos

        while (true) {
            System.out.println("Digite a opção desejada:");
            System.out.println("1: Comprar produto");
            System.out.println("2: Cadastrar produto");
            System.out.println("0: Sair");
            int opcao = scanner.nextInt();
            if (opcao == 0) {
            System.out.println("Saindo da loja. Obrigado!");
            break;
            }
            switch (opcao) {
                case 1:
                // Exibir todos os produtos disponíveis
                System.out.println("Produtos disponíveis:");
                    for (int key : produtos.keySet()) {
                    System.out.println(key + ": " + produtos.get(key) + " - R$ " + precos.get(key));
                    }
                    System.out.println("Escolha o número do produto para adicionar ao pedido:");
                    int opcaoDeProduto = scanner.nextInt();
                    if (produtos.containsKey(opcaoDeProduto)) {
                    pedidos.add(produtos.get(opcaoDeProduto));
                    total += precos.get(opcaoDeProduto); // Adiciona o preço ao total
                    System.out.println("Você adicionou " + produtos.get(opcaoDeProduto) + " ao seu pedido.");
                    } else {
                    System.out.println("Opção inválida.");
                    }
                    break;
                case 2:
                 // Cadastrar um novo produto
                System.out.println("Digite o nome do novo produto:");
                scanner.nextLine();  // Consumir a quebra de linha
                String novoProduto = scanner.nextLine();
                System.out.println("Digite o preço do novo produto:");
                double precoNovoProduto = scanner.nextDouble();
                produtos.put(codigoProduto, novoProduto);
                precos.put(codigoProduto, precoNovoProduto);
                System.out.println("Produto " + novoProduto + " cadastrado com sucesso com o código " + codigoProduto + " e preço de R$ " + precoNovoProduto);
                codigoProduto++; // Incrementa o código para o próximo produto
                break;
                default:
                System.out.println("Opção inválida.");
                break;
            }
        }
        // Exibir todos os produtos cadastrados ao final
        System.out.println("\nTodos os produtos disponíveis na loja:");
        for (int key : produtos.keySet()) {
        System.out.println(key + ": " + produtos.get(key) + " - R$ " + precos.get(key));
        }
        // Exibir pedidos realizados
        System.out.println("\nSeus pedidos:");
        for (String pedido : pedidos) {
        System.out.println(pedido);
        }
        // Exibir o valor total dos pedidos
        System.out.println("\nTotal dos pedidos: R$ " + total);
        scanner.close();
    }
}

