

public class Serie {
	 private final String[] GENEROS = {"Drama", "Comédia", "Terror", "Ficção Científica", "Ação", "Policial", "Fantasia"};

	 private int idSerie;
	 private String nome;
	 private String dataLancamento;
	 private String genero;
	private String idioma;
	 private int quantidadeDeEpsodios;
	private int audiencia;

	public Serie(int idSerie, String nome, String dataLancamento) {
		this.idSerie = idSerie;
		this.nome = nome;
		this.dataLancamento = dataLancamento;
	}


	public void registraAudiencia() {
	 this.audiencia+=this.audiencia;
	 }
	 
	 public String getNome() {
		 return this.nome;
	 }
	 public String getGenero() {
		return genero;
	}
	public String getIdioma() {
		return idioma;
	}
	public int getQuantidadeDeEpsodios() {
		return quantidadeDeEpsodios;
	}

	

}
