package codigo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cliente {
	String nomedeUsuario;
	String senha;
	Lista<Serie> listaParaVer;
	Lista<Serie> listaJaVistas;

	public Cliente() {
		this.listaParaVer = new Lista<Serie>();
		this.listaJaVistas = new Lista<Serie>();

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
	
//	public Lista<Serie> filtrarPorGenero(String genero){
//		Serie[] series = this.listaJaVistas.allElements(new Serie[this.listaParaVer.size()]);
//		List<Serie> listSeries = new ArrayList<>(Arrays.asList(series));
//		return listSeries.stream().filter(s -> s.getGenero().equals(genero));
//		}
}
