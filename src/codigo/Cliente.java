package codigo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Classe Cliente
 * @author Lucas Figueiredo
 *
 */
public class Cliente {
	private String nome;
	String nomedeUsuario;
	String senha;
	private Lista<Midia> listaParaVer;
	private Lista<Midia> listaJaVistas;
	private HashMap<Midia, Integer> notas;

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
		this.notas = new HashMap<>();
		//ARRUMAR ISSO
		/*for (Midia midia : listaJaVistas) {
            notas.put(midia, null);
        }*/

		this.nome = nome;
		this.nomedeUsuario = nomedeUsuario;
		this.senha = senha;

	}
	public void avaliarMidia(int idSerie, int nota) {
		for (Midia midia : notas.keySet()){
			if (midia.getIdMidia()== idSerie){
				notas.replace(midia, nota);
			}
		}
		
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

	public String getSenha() {
		return this.getSenha();
	}
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Cliente: ").append(this.nome).append("\n");
		sb.append("Nome de usuario: ").append(this.nomedeUsuario).append("\n");
		sb.append("Lista de midias para ver:\n");
		Midia[] midiasParaVer = this.listaParaVer.allElements(new Midia[this.listaParaVer.size()]);
		for (Midia midia : midiasParaVer) {
			sb.append("- ").append(midia.getNome()).append("\n");
		}
		sb.append("Lista de midias já vistas:\n");
		Midia[] midiasJaVistas = this.listaJaVistas.allElements(new Midia[this.listaJaVistas.size()]);
		for (Midia midia : midiasJaVistas) {
			sb.append("- ").append(midia.getNome()).append("\n");
		}
		return sb.toString();
	}
	
}
