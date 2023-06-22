package codigo;

/**
 * A classe Avaliacao representa uma avaliação com uma nota e um comentário
 * opcional.
 */
public class Avaliacao {
	private int nota;
	private String comentario;

	/**
	 * Cria uma nova instância da classe Avaliacao com a nota e o comentário
	 * fornecidos.
	 *
	 * @param nota       - A nota da avaliação.
	 * @param comentario - O comentário da avaliação.
	 */
	public Avaliacao(int nota, String comentario) {
		this.nota = nota;
		this.comentario = comentario;
	}

	/**
	 * Cria uma nova instância da classe Avaliacao com a nota fornecida e sem
	 * comentário.
	 *
	 * @param nota A nota da avaliação.
	 */
	public Avaliacao(int nota) {
		this.nota = nota;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
