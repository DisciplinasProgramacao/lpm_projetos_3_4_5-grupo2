package codigo;

import java.util.Random;

/**
 * Classe que representa uma série de TV.
 */

public class Serie extends Midia {
	private final int quantidadeDeEpsodios; // Armazena a quantidade de episódios da série

	/**
	 * Construtor para criar uma instância de uma série com um ID específico, nome e data de lançamento.
	 *
	 * @param idSerie        - O ID da série.
	 * @param nome           - O nome da série.
	 * @param dataLancamento - A data de lançamento da série.
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
	 * Construtor para criar uma instância de uma série com nome, gênero, idioma, quantidade de episódios e data de lançamento.
	 *
	 * @param nome                  - O nome da série.
	 * @param genero                - O gênero da série.
	 * @param idioma                - O idioma da série.
	 * @param quantidadeDeEpsodios  - A quantidade de episódios da série.
	 * @param dataLancamento        - A data de lançamento da série.
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
	 * Obtém a quantidade de episódios da série.
	 *
	 * @return A quantidade de episódios da série.
	 */

	public int getQuantidadeDeEpsodios() {
		return quantidadeDeEpsodios;
	}

	/**
	 * Retorna uma representação em string da série.
	 *
	 * @return A representação em string da série.
	 */

	@Override
	public String toString() {
		return "## ID " + id + " ##\n" +
				"Série: " + nome + "\n" +
				"Gênero: " + genero + "\n" +
				"Idioma: " + idioma + "\n" +
				"Episódios: " + quantidadeDeEpsodios + " episódios" + "\n" +
				"Data de lançamento: " + dataLancamento + "\n";
	}
}
