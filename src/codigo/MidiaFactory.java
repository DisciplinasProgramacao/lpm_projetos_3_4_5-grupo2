package codigo;

public class MidiaFactory {

	public static Midia criarMidia(String tipo, String nome, Genero genero, Idioma idioma, int tempo,
			String dataLancamento) {
		if (tipo == "Filme") {
			return new Filme(nome, genero, idioma, tempo, dataLancamento);
		} else if (tipo == "Serie") {
			return new Serie(nome, genero, idioma, tempo, dataLancamento);
		}
		return null;
	}

	public static Midia initMidia(String tipo, int id, String nome, String dataLancamento, int duracao) {
		if (tipo == "Filme") {
			return new Filme(id, nome, dataLancamento, duracao);
		} else if(tipo == "Serie") {
			return new Serie(id, nome, dataLancamento);
		}
		return null;
	}

}