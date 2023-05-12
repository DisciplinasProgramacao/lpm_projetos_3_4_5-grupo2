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
	private List<Midia> listaParaVer;
	private List<Midia> listaJaVistas;
	private HashMap<Midia, Integer> notas;

	/**
	 * Construtores padrão
	 */
	public Cliente() {
		this.listaParaVer = new ArrayList<>();
		this.listaJaVistas = new ArrayList<>();

	}

	public Cliente(String nome, String nomedeUsuario, String senha) {

		this.listaParaVer = new ArrayList<>();
		this.listaJaVistas = new ArrayList<>();
		this.notas = new HashMap<>();
		//ARRUMAR ISSO
		/*for (Midia midia : listaJaVistas) {
            notas.put(midia, null);
        }*/

		this.nome = nome;
		this.nomedeUsuario = nomedeUsuario;
		this.senha = senha;

	}

	public boolean ehAdmin(){
		if (getNomedeUsuario().equals("admin")){
			return true;
		}
		return false;
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

	public List<Midia> getListaParaVer() {
		return listaParaVer;
	}

	public List<Midia> getListaJaVistas() {
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

		for (Midia midia : this.listaParaVer)
			if (midia.getNome().equals(nomeMidia))
				this.listaParaVer.remove(midia);

//		Midia[] midias = this.listaParaVer.allElements(new Midia[this.listaParaVer.size()]);
//		for (Midia item : midias) {
//			if (item.getNome().equals(nomeMidia)) {
//				this.listaParaVer.remove(Arrays.asList(midias).indexOf(item));
//			}
//		}
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
		if (this.listaParaVer.isEmpty()) {
			System.out.println("Lista 'Para Ver' vazia");
		} else {
			System.out.println("*** Minha Lista 'Para Ver' ***");
			for (Midia midia : this.listaParaVer)
				System.out.printf("\n- %s (ID %d)", midia.getNome(), midia.getIdMidia());
		}
		System.out.println("\n");
	}

	public void imprimeListaJaVistas() {
		if (this.listaJaVistas.isEmpty()) {
			System.out.println("Lista 'Já Vistos' vazia");
		} else {
			System.out.println("*** Minha Lista 'Já Vistos' ***");
			for (Midia midia : this.listaJaVistas)
				System.out.printf("\n- %s (ID %d)", midia.getNome(), midia.getIdMidia());
		}
		System.out.println("\n");
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

		for (Midia midia : this.listaParaVer) {
			sb.append("- ").append(midia.getNome()).append("\n");
		}
		sb.append("Lista de midias já vistas:\n");

		for (Midia midia : this.listaJaVistas) {
			sb.append("- ").append(midia.getNome()).append("\n");
		}
		return sb.toString();
	}

	
}
