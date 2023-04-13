package src;

public class Cliente {
	String nomedeUsuario;
	String senha;
	Lista<Serie> listaParaVer;
	Lista<Serie> listaJaVistas;
	
	public Cliente() {
		this.listaParaVer = new Lista<Serie>();
		this.listaJaVistas = new Lista<Serie>();
		
	}
	
	public void adicionarNaLista (Serie serie) {
		this.listaParaVer.add(serie);
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
