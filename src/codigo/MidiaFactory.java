package codigo;

/**
 * Esta classe representa uma fábrica para criar instâncias da classe
 * {@link Midia}. Ela fornece métodos para criar objetos de mídia com base em
 * diferentes parâmetros.
 */
public class MidiaFactory {

	/**
	 * Cria um objeto de mídia com base nos parâmetros fornecidos.
	 *
	 * @param tipo           - o tipo de mídia (por exemplo, "Filme" ou "Série")
	 * @param nome           - o nome da mídia
	 * @param genero         - o gênero da mídia
	 * @param idioma         - o idioma da mídia
	 * @param tempo          - a duração da mídia
	 * @param dataLancamento - a data de lançamento da mídia
	 * @return um objeto {@link Midia} representando a mídia criada, ou null se o
	 *         tipo for desconhecido
	 */
	public static Midia criarMidia(String tipo, String nome, Genero genero, Idioma idioma, int tempo,
			String dataLancamento) {
		if (tipo == "Filme") {
			return new Filme(nome, genero, idioma, tempo, dataLancamento);
		} else if (tipo == "Serie") {
			return new Serie(nome, genero, idioma, tempo, dataLancamento);
		}
		return null;
	}

	/**
	 * Inicializa um objeto de mídia com base nos parâmetros fornecidos. Este método
	 * assume que a duração não está especificada.
	 *
	 * @param tipo           - o tipo de mídia (por exemplo, "Filme" ou "Série")
	 * @param id             - o ID da mídia
	 * @param nome           - o nome da mídia
	 * @param dataLancamento - a data de lançamento da mídia
	 * @return um objeto {@link Midia} representando a mídia inicializada, ou null
	 *         se o tipo for desconhecido
	 */
	public static Midia initMidia(String tipo, int id, String nome, String dataLancamento, int duracao) {
		if (tipo == "Filme") {
			return new Filme(id, nome, dataLancamento, duracao);
		} else if (tipo == "Serie") {
			return new Serie(id, nome, dataLancamento);
		}
		return null;
	}

}