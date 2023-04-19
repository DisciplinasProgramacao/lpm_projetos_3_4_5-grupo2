

public class Serie {
	 private final String[] GENEROS = {"Drama", "Comédia", "Terror", "Ficção Científica", "Ação", "Policial", "Fantasia"};
	 private String nome;
	 private String genero;
	private String idioma;
	 private int quantidadeDeEpsodios;
	private int audiencia;


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
