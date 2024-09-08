package ADO2;

public class EstruturaEstatica {

	public String[] senhas;
	public int tamanho;

	public EstruturaEstatica(int capacidade) {
		this.senhas = (String[]) new String[capacidade];
		this.tamanho = 0;
	}

	public EstruturaEstatica() {
		this(10);
	}

	public boolean adiciona(String elemento) {
		this.aumentaCapacidade();
		if (this.tamanho < this.senhas.length) {
			this.senhas[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}
		return false;
	}

	public boolean adiciona(int posicao, String elemento) {
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posicao Invalida");
		}
		this.aumentaCapacidade();
		for (int i = this.tamanho - 1; i >= posicao; i--) {
			this.senhas[i + 1] = this.senhas[i];
		}
		this.senhas[posicao] = elemento;
		this.tamanho++;

		return true;
	}

	public void aumentaCapacidade() {
		if (this.tamanho == this.senhas.length) {
			String[] elementosNovos = (String[]) new String[this.senhas.length * 2];
			for (int i = 0; i < this.senhas.length; i++) {
				elementosNovos[i] = this.senhas[i];
			}
			this.senhas = elementosNovos;
		}
	}

	public int tamanho() {
		return this.tamanho;
	}

	public boolean estaVazia() {
		return this.tamanho == 0;
	}

	public void remove(int posicao) {
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posicao Invalida");
		}
		for (int i = posicao; i < tamanho - 1; i++) {
			senhas[i] = senhas[i + 1];
		}
		tamanho--;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");

		for (int i = 0; i < this.tamanho - 1; i++) {
			s.append(this.senhas[i]);
			s.append(", ");
		}

		if (this.tamanho > 0) {
			s.append(this.senhas[this.tamanho - 1]);
		}

		s.append("]");

		return s.toString();
	}

}
