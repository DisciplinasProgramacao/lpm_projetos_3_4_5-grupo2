package codigo;

import java.util.Arrays;

/**
 * Classe Cliente
 * @author Lucas Figueiredo
 *
 */
public class Cliente {
	String nome;
	String nomedeUsuario;
	String senha;
	Lista<Midia> listaParaVer;
	Lista<Midia> listaJaVistas;

	/**
	 * Construtores padrão
	 */
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
	
	/**
	 * Getters e Setters
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	public String getNomedeUsuario() {
		return nomedeUsuario;
	}

	public Lista<Midia> getListaParaVer() {
		return listaParaVer;
	}

	public Lista<Midia> getListaJaVistas() {
		return listaJaVistas;
	}

	
	/**
	 * Método que adiciona midia na lista do Cliente
	 * @param midia
	 */
	public void adicionarNaLista(Midia midia) {
		this.listaParaVer.add(midia);
	}

	/**
	 * Método que remove midia na lista do Cliente
	 * @param nomeMidia
	 */
	public void retirarDaLista(String nomeMidia) {
		Midia[] midias = this.listaParaVer.allElements(new Midia[this.listaParaVer.size()]);
		for (Midia item : midias) {
			if (item.getNome().equals(nomeMidia)) {
				this.listaParaVer.remove(Arrays.asList(midias).indexOf(item));
			}
		}
	}
	/**
	 * Método que registra audiencia das midias já vistas pelo Cliente
	 * @param midia
	 */
	public void registrarAudiencia (Midia midia) {
		this.listaJaVistas.add(midia);
	}
	
	/**
	 * Imprime Lista
	 */
	public void imprimeListaParaVer() {
		System.out.printf("'Lista para Ver' de %s", getNome());

		Midia[] midiasParaVer = new Serie[listaParaVer.size()];
		midiasParaVer = listaParaVer.allElements(midiasParaVer);

		for (Midia midia : midiasParaVer)
			System.out.printf("\n- %s", midia.getNome());
	}

}
