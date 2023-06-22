package codigo;

/**
 * Esta classe representa uma fábrica para criar instâncias da classe {@link Midia}.
 * Ela fornece métodos para criar objetos de mídia com base em diferentes parâmetros.
 */

public class MidiaFactory {

	/**
	 * Cria um objeto de mídia com base nos parâmetros fornecidos.
	 *
	 * @param tipo           O tipo de mídia (por exemplo, "Filme" ou "Série").
	 * @param nome           O nome da mídia.
	 * @param genero         O gênero da mídia.
	 * @param idioma         O idioma da mídia.
	 * @param tempo          A duração da mídia.
	 * @param dataLancamento A data de lançamento da mídia.
	 * @return Um objeto {@link Midia} representando a mídia criada, ou null se o tipo for desconhecido.
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
	 * Inicializa um objeto de mídia com base nos parâmetros fornecidos. Este método assume que a duração não está especificada.
	 *
	 * @param tipo           O tipo de mídia (por exemplo, "Filme" ou "Série").
	 * @param id             O ID da mídia.
	 * @param nome           O nome da mídia.
	 * @param dataLancamento A data de lançamento da mídia.
	 * @param duracao        A duração da mídia.
	 * @return Um objeto {@link Midia} representando a mídia inicializada, ou null se o tipo for desconhecido.
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