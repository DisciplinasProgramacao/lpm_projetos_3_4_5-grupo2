package codigo;

import java.util.Random;

public enum Idioma {
	INGLES("Inglês"), PORTUGUES("Português"), ESPANHOL("Espanhol"), FRANCES("Francês"), COREANO("Coreano"),
	JAPONES("Japonês");

	private final String descricao;

    private Idioma(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

	public static Idioma geraIdiomaAleatorio() {
		Idioma[] values = Idioma.values();
		int length = values.length;
		int randIndex = new Random().nextInt(length);
		return values[randIndex];
	}

	public static Idioma findByValue(String value) {
		for (Idioma idioma : Idioma.values()) {
			if (idioma.name().equalsIgnoreCase(value)) {
				return idioma;
			}
		}
		throw new EnumException("Este idioma não foi inserido na lista!");
	}
}
