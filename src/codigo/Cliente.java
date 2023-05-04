package codigo;

public class Cliente {
	String nome;
	String nomedeUsuario;
	String senha;
	Lista<Midia> listaParaVer;
	Lista<Midia> listaJaVistas;

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

	public String getSenha() {
		return senha;
	}

	public Lista<Midia> getListaParaVer() {
		return listaParaVer;
	}

	public Lista<Midia> getListaJaVistas() {
		return listaJaVistas;
	}


	public void adicionarNaLista(Midia midia) {
		this.listaParaVer.add(midia);
	}

	public void retirarDaLista(String nomeMidia) {
		Midia[] midias = this.listaParaVer.allElements(new Midia[this.listaParaVer.size()]);
		for (Midia item : midias) {
			if (item.getNome().equals(nomeMidia)) {
				this.listaParaVer.remove(item.hashCode());
			}
//			else {
//				StringBuilder sb = new StringBuilder();
//				sb.append("Está série não está n sua lista.\n");
//				sb.append("Sua lista está assim:"+ series.toString());
//			}
		}
	}

	public void registrarAudiencia (Midia midia) {
		this.listaJaVistas.add(midia);
	}

	public void imprimeListaParaVer() {
		System.out.printf("'Lista para Ver' de %s", getNome());

		Midia[] midiasParaVer = new Serie[listaParaVer.size()];
		midiasParaVer = listaParaVer.allElements(midiasParaVer);

		for (Midia midia : midiasParaVer)
			System.out.printf("\n- %s", midia.getNome());
	}



//	public Lista<Serie> filtrarPorGenero(String genero){
//		Serie[] series = this.listaJaVistas.allElements(new Serie[this.listaParaVer.size()]);
//		List<Serie> listSeries = new ArrayList<>(Arrays.asList(series));
//		return listSeries.stream().filter(s -> s.getGenero().equals(genero));
//		}
}
