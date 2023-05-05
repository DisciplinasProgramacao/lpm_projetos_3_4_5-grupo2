package codigo;

public class Serie extends Midia {
	private int idSerie;
	private int quantidadeDeEpsodios;

	/**
	 * Construtores padrão
	 */
	public Serie() {
	}

	public Serie(int idSerie, String nome, String dataLancamento, String genero) {
		this.id = idSerie;
		this.nome = nome;
		this.dataLancamento = dataLancamento;
		this.genero = genero;
	}

	public Serie(String nome, String genero, String idioma, int quantidadeDeEpsodios, String dataLancamento) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.idioma = idioma;
		this.quantidadeDeEpsodios = quantidadeDeEpsodios;
		this.dataLancamento = dataLancamento;
	}
	
	/**
	 * Getters e Setters
	 * @return
	 */
	public int getIdSerie() {
		return idSerie;
	}

	public void setIdSerie(int idSerie) {
		this.idSerie = idSerie;
	}

	public int getQuantidadeDeEpsodios() {
		return quantidadeDeEpsodios;
	}

	public void setQuantidadeDeEpsodios(int quantidadeDeEpsodios) {
		this.quantidadeDeEpsodios = quantidadeDeEpsodios;
	}

	@Override
	public String toString() {
		return "Série: " + nome + " | Gênero: " + genero + " | " +
				" | Episódios: " + quantidadeDeEpsodios + " | Lançamento: " + dataLancamento;
	}
}
