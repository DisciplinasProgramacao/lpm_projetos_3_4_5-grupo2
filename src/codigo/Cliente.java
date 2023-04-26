package codigo;

public class Cliente {
	String nome;
	String nomedeUsuario;
	String senha;
	Lista<Serie> listaParaVer;
	Lista<Serie> listaJaVistas;

	public Cliente() {
		this.listaParaVer = new Lista<>();
		this.listaJaVistas = new Lista<>();

	}

	public Cliente(String nome, String nomedeUsuario, String senha) {

		this.listaParaVer = new Lista<>();
		this.listaJaVistas = new Lista<>();

		this.nome = nome;
		this.nomedeUsuario = nomedeUsuario;
		this.senha = senha;

	}

	public String getNome() {
		return nome;
	}

	public String getNomedeUsuario() {
		return nomedeUsuario;
	}

	public Lista<Serie> getListaParaVer() {
		return listaParaVer;
	}

	public Lista<Serie> getListaJaVistas() {
		return listaJaVistas;
	}


	public void adicionarNaLista(Serie serie) {
		this.listaParaVer.add(serie);
	}

	public void retirarDaLista(String nomeSerie) {
		Serie[] series = this.listaParaVer.allElements(new Serie[this.listaParaVer.size()]);
		for (Serie item : series) {
			if (item.getNome().equals(nomeSerie)) {
				this.listaParaVer.remove(item.hashCode());
			}
//			else {
//				StringBuilder sb = new StringBuilder();
//				sb.append("Está série não está n sua lista.\n");
//				sb.append("Sua lista está assim:"+ series.toString());
//			}
		}
	}

	public void registrarAudiencia (Serie serie) {
		this.listaJaVistas.add(serie);
	}

	public void imprimeListaParaVer() {
		System.out.printf("'Lista para Ver' de %s", getNome());

		Serie[] seriesParaVer = new Serie[listaParaVer.size()];
		seriesParaVer = listaParaVer.allElements(seriesParaVer);

		for (Serie serie : seriesParaVer)
			System.out.printf("\n- %s", serie.getNome());
	}



//	public Lista<Serie> filtrarPorGenero(String genero){
//		Serie[] series = this.listaJaVistas.allElements(new Serie[this.listaParaVer.size()]);
//		List<Serie> listSeries = new ArrayList<>(Arrays.asList(series));
//		return listSeries.stream().filter(s -> s.getGenero().equals(genero));
//		}
}
