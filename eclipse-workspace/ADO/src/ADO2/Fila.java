package ADO2;

public class Fila extends EstruturaEstatica {
    private static final int MAX_PRIORIDADE = 3; // Após 3 atendimentos prioritários, um comum deve ser chamado
    private int contagemPrioridade;

    public Fila() {
        super();
        this.contagemPrioridade = 0;
    }

    public Fila(int capacidade) {
        super(capacidade);
        this.contagemPrioridade = 0;
    }

    // Adiciona uma senha à fila com prioridade
    public void adicionarSenhaPrioridade(String senha) {
        adicionarSenha(senha, true);
    }

    // Adiciona uma senha à fila sem prioridade
    public void adicionarSenhaComum(String senha) {
        adicionarSenha(senha, false);
    }

    // Método interno para adicionar uma senha à fila com ou sem prioridade
    private void adicionarSenha(String senha, boolean prioridade) {
        if (prioridade) {
            this.adiciona(senha);
            this.contagemPrioridade++;
        } else {
            this.adiciona(senha);
        }
    }

    // Verifica e chama o próximo paciente, respeitando as regras de prioridade
    public String chamarProximo() {
        if (this.estaVazia()) {
            return null;
        }

        // Se o número de atendimentos prioritários atingiu o máximo permitido
        if (this.contagemPrioridade >= MAX_PRIORIDADE) {
            while (!this.estaVazia() && this.senhas[0].startsWith("P")) {
                // Remove senhas prioritárias até que a contagem de prioridades diminua
                this.remove(0);
                this.contagemPrioridade--;
            }
        }

        // Chama o próximo paciente
        if (!this.estaVazia()) {
            String elementoASerRemovido = this.senhas[0];
            this.remove(0);
            if (elementoASerRemovido.startsWith("P")) {
                this.contagemPrioridade--;
            }
            return elementoASerRemovido;
        }

        return null;
    }

    public String proximoNaFila() {
        if (this.estaVazia()) {
            return null;
        }
        return this.senhas[0];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Fila: ");
        s.append(super.toString());
        return s.toString();
    }
}
