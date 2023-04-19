

public class Cliente {
	public String nome;
	public String nomedeUsuario;
	String senha;
	Lista<Serie> listaParaVer;
	Lista<Serie> listaJaVistas;



	public Cliente(String nome, String nomeDeUsuario, String senha) {
		this.listaParaVer = new Lista<Serie>();
		this.listaJaVistas = new Lista<Serie>();
		this.nome = nome;
		this.nomedeUsuario = nomeDeUsuario;
		this.senha = senha;
	}
	
	public void adicionarNaLista (Serie serie) {
		this.listaParaVer.add(serie);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomedeUsuario() {
		return nomedeUsuario;
	}

	public void setNomedeUsuario(String nomedeUsuario) {
		this.nomedeUsuario = nomedeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void retirarDaLista (String nomeSerie) {
		Serie[] series = new Serie[this.listaParaVer.size()];
		series = this.listaParaVer.allElements(series);
				
		for (Serie a : series) {
			if(a.getNome().equals(nomeSerie)) {
				System.out.println(a.getNome());
			}
		}
			
	}
}
