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

	public Serie(int idSerie, String nome2, String dataLancamento) {
	}
	
	public Serie(String nome, String genero, String idioma, int quantidadeDeEpsodios, int audiencia) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.idioma = idioma;
		this.quantidadeDeEpsodios = quantidadeDeEpsodios;
		this.audiencia = audiencia;
	}
	
	/**
	 * Método que registra audiência de determinada série
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

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getQuantidadeDeEpsodios() {
		return quantidadeDeEpsodios;
	}

	public void setQuantidadeDeEpsodios(int quantidadeDeEpsodios) {
		this.quantidadeDeEpsodios = quantidadeDeEpsodios;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
