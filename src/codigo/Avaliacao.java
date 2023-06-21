package codigo;

/**
 * A classe Avaliacao representa uma avaliação com uma nota e um comentário opcional.
 */

public class Avaliacao {
    private final int nota; // A nota da avaliação
    private String comentario; // O comentário da avaliação

    /**
     * Cria uma nova instância da classe Avaliacao com a nota e o comentário fornecidos.
     *
     * @param nota       - A nota da avaliação.
     * @param comentario - O comentário da avaliação.
     */

    public Avaliacao(int nota, String comentario) {
        this.nota = nota;
        this.comentario = comentario;
    }

    /**
     * Cria uma nova instância da classe Avaliacao com a nota fornecida e sem comentário.
     *
     * @param nota A nota da avaliação.
     */

    public Avaliacao(int nota) {
        this.nota = nota;
    }

    /**
     * Obtém a nota da avaliação.
     *
     * @return A nota da avaliação.
     */

    public int getNota() {
        return nota;
    }

    /**
     * Obtém o comentário da avaliação.
     *
     * @return O comentário da avaliação. Se não houver comentário, retorna null.
     */

    public String getComentario() {
        return comentario;
    }
}
