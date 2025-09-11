package ti2cc;

import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws Exception {
        EletronicoDAO eletronicoDAO = new EletronicoDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 5) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Listar eletrônicos");
            System.out.println("2 - Inserir eletrônico");
            System.out.println("3 - Atualizar eletrônico");
            System.out.println("4 - Excluir eletrônico");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Lista de Eletrônicos ---");
                    List<Eletronico> eletronicos = eletronicoDAO.getOrderByCodigo();
                    for (Eletronico e : eletronicos) {
                        System.out.println(e.toString());
                    }
                    break;

                case 2:
                    System.out.println("\n--- Inserir Eletrônico ---");
                    System.out.print("Código: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine(); // consumir quebra de linha
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Valor: ");
                    double valor = scanner.nextDouble();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine(); // consumir quebra de linha

                    Eletronico novoEletronico = new Eletronico(codigo, nome, valor, quantidade);
                    if (eletronicoDAO.insert(novoEletronico)) {
                        System.out.println("Eletrônico inserido com sucesso.");
                    } else {
                        System.out.println("Erro ao inserir eletrônico.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Atualizar Eletrônico ---");
                    System.out.print("Código do eletrônico a ser atualizado: ");
                    int codigoAtualizar = scanner.nextInt();
                    scanner.nextLine(); // consumir quebra de linha
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo Valor: ");
                    double novoValor = scanner.nextDouble();
                    System.out.print("Nova Quantidade: ");
                    int novaQuantidade = scanner.nextInt();
                    scanner.nextLine(); // consumir quebra de linha

                    Eletronico eletronicoAtualizado = new Eletronico(codigoAtualizar, novoNome, novoValor, novaQuantidade);
                    if (eletronicoDAO.update(eletronicoAtualizado)) {
                        System.out.println("Eletrônico atualizado com sucesso.");
                    } else {
                        System.out.println("Erro ao atualizar eletrônico.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Excluir Eletrônico ---");
                    System.out.print("Código do eletrônico a ser excluído: ");
                    int codigoExcluir = scanner.nextInt();
                    scanner.nextLine(); // consumir quebra de linha

                    if (eletronicoDAO.delete(codigoExcluir)) {
                        System.out.println("Eletrônico excluído com sucesso.");
                    } else {
                        System.out.println("Erro ao excluir eletrônico.");
                    }
                    break;

                case 5:
                    System.out.println("\nSaindo...");
                    eletronicoDAO.close(); // fecha a conexão com o banco
                    break;

                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}
