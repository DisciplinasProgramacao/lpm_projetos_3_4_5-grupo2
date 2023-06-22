package codigo;

import java.util.Random;

/**
 * Representa uma série de TV.
 */

public class Serie extends Midia {
	private int idSerie;
	private int quantidadeDeEpsodios;

	/**
	 * Construtor padrão.
	 */

	public Serie() {
	}

	/**
	 * Construtor com parâmetros.
	 *
	 * @param idSerie           o ID da série
	 * @param nome              o nome da série
	 * @param dataLancamento    a data de lançamento da série
	 */

	public Serie(int idSerie, String nome, String dataLancamento) {
		Random r = new Random();

		this.id = idSerie;
		this.nome = nome;
		this.dataLancamento = dataLancamento;
		this.genero = Midia.gerarGeneroAleatorio();
		this.idioma = Midia.gerarIdiomaAleatorio();
		this.quantidadeDeEpsodios = r.nextInt(23);
	}

	/**
	 * Construtor com parâmetros.
	 *
	 * @param nome                  o nome da série
	 * @param genero                o gênero da série
	 * @param idioma                o idioma da série
	 * @param quantidadeDeEpsodios  o número de episódios na série
	 * @param dataLancamento        a data de lançamento da série
	 */

	public Serie(String nome, Genero genero, Idioma idioma, int quantidadeDeEpsodios, String dataLancamento) {
		super();
		int novoId = Midia.getUltimoIdMidia() + 1;
		this.id = novoId;
		this.nome = nome;
		this.genero = genero;
		this.idioma = idioma;
		this.quantidadeDeEpsodios = quantidadeDeEpsodios;
		this.dataLancamento = dataLancamento;
		Midia.setUltimoId(novoId);
	}

	/**
	 * Obtém o ID da série.
	 *
	 * @return o ID da série
	 */

	public int getIdSerie() {
		return idSerie;
	}

	/**
	 * Define o ID da série.
	 *
	 * @param idSerie o ID da série
	 */

	public void setIdSerie(int idSerie) {
		this.idSerie = idSerie;
	}

	/**
	 * Obtém a quantidade de episódios da série.
	 *
	 * @return a quantidade de episódios da série
	 */

	public int getQuantidadeDeEpsodios() {
		return quantidadeDeEpsodios;
	}

	/**
	 * Define a quantidade de episódios da série.
	 *
	 * @param quantidadeDeEpsodios a quantidade de episódios da série
	 */

	public void setQuantidadeDeEpsodios(int quantidadeDeEpsodios) {
		this.quantidadeDeEpsodios = quantidadeDeEpsodios;
	}

	/**
	 * Retorna uma representação em formato de string da série.
	 *
	 * @return uma representação em formato de string da série
	 */

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("## ID ").append(id).append(" ##\n");
		sb.append("Série: ").append(nome).append("\n");
		sb.append("Gênero: ").append(genero).append("\n");
		sb.append("Idioma: ").append(idioma).append("\n");
		sb.append("Episódios: ").append(quantidadeDeEpsodios).append(" episódios").append("\n");
		sb.append("Data de lançamento: ").append(dataLancamento).append("\n");
		return sb.toString();
	}
}
