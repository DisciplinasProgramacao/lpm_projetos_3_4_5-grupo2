package codigo;

import java.util.Random;

public class Serie extends Midia {
	private int idSerie;
	private int quantidadeDeEpsodios;

	/**
	 * Construtores padrão
	 */
	public Serie() {
	}

	public Serie(int idSerie, String nome, String dataLancamento, Genero genero) {
		Random r = new Random();

		this.id = idSerie;
		this.nome = nome;
		this.dataLancamento = dataLancamento;
		this.genero = genero;
		this.idioma = Midia.gerarIdiomaAleatorio();
		this.quantidadeDeEpsodios = r.nextInt(23);
	}

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
	 * Getters e Setters
	 *
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
