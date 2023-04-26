package codigo;

/**
 * Classe Serie
 * 
 * @author Ana Flavia
 *
 */
public class Serie extends Midia {
	private int idSerie;
	private int quantidadeDeEpsodios;

	public Serie() {
	}

	public Serie(int idSerie, String nome, String dataLancamento) {
		this.idSerie = idSerie;
		this.nome = nome;
		this.dataLancamento = dataLancamento;
	}
	
	public Serie(String nome, String genero, String idioma, int quantidadeDeEpsodios, int audiencia) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.idioma = idioma;
		this.quantidadeDeEpsodios = quantidadeDeEpsodios;
		this.audiencia = audiencia;
	}

	public int getIdSerie() {
		return idSerie;
	}

	public int getQuantidadeDeEpsodios() {
		return quantidadeDeEpsodios;
	}

	public void setQuantidadeDeEpsodios(int quantidadeDeEpsodios) {
		this.quantidadeDeEpsodios = quantidadeDeEpsodios;
	}

}
