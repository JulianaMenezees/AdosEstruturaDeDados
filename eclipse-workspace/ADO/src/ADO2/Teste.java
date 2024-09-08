package ADO2;

import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Fila fila = new Fila();

        int menu;
        String senha;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Solicitar nova senha (Comum)");
            System.out.println("2. Solicitar nova senha (Prioridade)");
            System.out.println("3. Excluir uma senha (Remover próximo)");
            System.out.println("4. Listar todas as senhas");
            System.out.println("5. Visualizar próximo a ser atendido");
            System.out.println("6. Chamar próximo a ser atendido");
            System.out.println("0. Sair");
            menu = scan.nextInt();
            scan.nextLine(); // Limpar o buffer do scanner

            switch (menu) {
                case 1:
                    System.out.println("Digite a senha comum:");
                    senha = scan.nextLine();
                    fila.adicionarSenhaComum(senha);
                    break;
                case 2:
                    System.out.println("Digite a senha prioritária:");
                    senha = scan.nextLine();
                    fila.adicionarSenhaPrioridade(senha);
                    break;
                case 3:
                    // Exclui o próximo da fila
                    String removido = fila.chamarProximo();
                    if (removido != null) {
                        System.out.println("Senha removida: " + removido);
                    } else {
                        System.out.println("Nenhuma senha para remover.");
                    }
                    break;
                case 4:
                    System.out.println(fila.toString());
                    break;
                case 5:
                    String proximo = fila.proximoNaFila();
                    if (proximo != null) {
                        System.out.println("Próximo a ser atendido: " + proximo);
                    } else {
                        System.out.println("A fila está vazia.");
                    }
                    break;
                case 6:
                    String chamado = fila.chamarProximo();
                    if (chamado != null) {
                        System.out.println("Chamando: " + chamado);
                    } else {
                        System.out.println("A fila está vazia.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (menu != 0);

        scan.close();
    }
}
