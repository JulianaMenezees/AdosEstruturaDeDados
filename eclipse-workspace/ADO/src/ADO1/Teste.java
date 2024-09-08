package ADO1;

import java.util.Scanner;

public class Teste {
	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);
		Vetor v = new Vetor(3);

		int menu = 0;

		do {

			System.out.println("\n****Livraria****");
			System.out.println("1. Incluir livro");
			System.out.println("2. Pesquisar livro");
			System.out.println("3. Alterar livro");
			System.out.println("4. Excluir livro");
			System.out.println("5. Listar livros");
			System.out.println("0. Sair");
			menu = scan.nextInt();

			switch (menu) {

			case 1:
				System.out.println("Nome:");
				String nome = scan.next();
				System.out.println("Autor:");
				String autor = scan.next();
				System.out.println("Gênero:");
				String genero = scan.next();
				Livro livro = new Livro(nome, autor, genero);
				v.adiciona(livro);
				break;

			case 2:
				System.out.println("Digite o codigo do livro que deseja pesquisar:");
				int elemento = scan.nextInt();
				v.busca(elemento);
				System.out.println(v.busca(elemento));
				break;

			case 3:
				System.out.println("Digite o codigo do livro que deseja alterar:");
				int codigo = scan.nextInt();
				System.out.println("Digite o novo nome do livro:");
				String novoNome = scan.next();
				System.out.println("Digite o novo autor do livro:");
				String novoAutor = scan.next();
				System.out.println("Digite o novo gênero do livro:");
				String novoGenero = scan.next();
				Livro livro2 = new Livro(novoNome, novoAutor, novoGenero);
				v.alterar(codigo, livro2);
				break;

			case 4:
				System.out.println("Digite o codigo do livro que deseja excluir:");
				int posicao = scan.nextInt();
				v.remove(posicao);
				break;

			case 5:
				System.out.println(v.toString());
				break;

			}

		} while (menu != 0);

		scan.close();
	}
}