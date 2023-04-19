package codigo;

/**
 * Classe Serie
 * 
 * @author Ana Flavia
 *
 */
public class Serie {
	private final String[] GENEROS = { "Drama", "Comédia", "Terror", "Ficção Científica", "Ação", "Policial",
			"Fantasia" };
	private String nome;
	private String genero;
	private String idioma;
	private int quantidadeDeEpsodios;
	private int audiencia;

	/**
	 * Método que registra audieência de determinada série
	 */
	public int registraAudiencia() {
		return this.audiencia += this.audiencia;
	}

	public String getNome() {
		return this.nome;
	}

	public int getAudiencia() {
		return audiencia;
	}

	public void setAudiencia(int audiencia) {
		this.audiencia = audiencia;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
