package codigo;

import java.util.Random;

/**
 * Enumeração que representa diferentes idiomas.
 */
public enum Idioma {
	INGLES("Inglês"), PORTUGUES("Português"), ESPANHOL("Espanhol"), FRANCES("Francês"), COREANO("Coreano"),
	JAPONES("Japonês");

	private final String descricao;

	/**
	 * Construtor da enumeração Idioma.
	 *
	 * @param descricao - a descrição do idioma
	 */
    private Idioma(String descricao) {
        this.descricao = descricao;
    }

	/**
	 * Obtém a descrição do idioma.
	 *
	 * @return descricao
	 */
    public String getDescricao() {
        return descricao;
    }
    
	/**
	 * Gera um idioma aleatório.
	 *
	 * @return um idioma aleatório
	 */
	public static Idioma geraIdiomaAleatorio() {
		Idioma[] values = Idioma.values();
		int length = values.length;
		int randIndex = new Random().nextInt(length);
		return values[randIndex];
	}

	/**
	 * Encontra um idioma pelo seu valor.
	 *
	 * @param value - o valor do idioma a ser encontrado
	 * @return o idioma correspondente ao valor especificado
	 * @throws EnumException se o idioma não for encontrado na lista
	 */
	public static Idioma findByValue(String value) {
		for (Idioma idioma : Idioma.values()) {
			if (idioma.name().equalsIgnoreCase(value)) {
				return idioma;
			}
		}
		throw new EnumException("Este idioma não foi inserido na lista!");
	}
}
