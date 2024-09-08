package ADO1;

public class Vetor {

	private Object[] livros;
	public int tamanho;

	public Vetor(int capacidade) {
		this.livros = new Object[capacidade];
		this.tamanho = 0;

	}

	public void adiciona(Object livro) throws Exception {
		this.aumentaCapacidade();
		if (this.tamanho < this.livros.length) {
			this.livros[this.tamanho] = livro;
			this.tamanho++;
		} else {
			throw new Exception("Erro ao adicionar livro!");
		}
	}

	public int tamanho() {
		return this.tamanho;
	}

	public Object busca(int posicao) throws Exception {
		if (posicao >= 0 && posicao < tamanho) {
			return this.livros[posicao];
		} else {
			throw new Exception("Posicao Invalida");
		}
	}

	private void aumentaCapacidade() {
		if (this.tamanho == this.livros.length) {
			Object[] elementosNovos = new Object[this.livros.length * 2];
			for (int i = 0; i < this.livros.length; i++) {
				elementosNovos[i] = this.livros[i];
			}
			this.livros = elementosNovos;
		}
	}

	public void remove(int posicao) throws Exception {
		if (posicao >= 0 && posicao < tamanho) {
			for (int i = posicao; i < this.tamanho - 1; i++) {
				this.livros[i] = this.livros[i + 1];
			}
			this.livros[tamanho] = null;
			this.tamanho--;
		} else {
			throw new Exception("Posiçao Invalida");
		}
	}

	public void alterar(int codigo, Object livroAlterado) throws Exception {
		if (codigo >= 0 && codigo < this.tamanho) {
			this.livros[codigo] = livroAlterado;
		} else {
			throw new Exception("Posição Inválida");
		}
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("");

		for (int i = 0; i < this.tamanho; i++) {
			s.append("\nLivro ").append(i).append(": ").append(this.livros[i]);
			if (i < this.tamanho - 1) {
				s.append(" ");
			}
		}

		s.append(" ");
		return s.toString();

	}

}
