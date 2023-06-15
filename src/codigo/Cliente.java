package codigo;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.HashMap;

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
	private HashMap<Midia, String> datasExibicao;
	private int quantAval;

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
		this.datasExibicao = new HashMap<>();


		this.nome = nome;
		this.nomedeUsuario = nomedeUsuario;
		this.senha = senha;

	}
	
	/**
	 * Método que verifica se o Cliente é admin
	 * @return
	 */
	public boolean ehAdmin(){
		if (getNomedeUsuario().equals("admin")){
			return true;
		}
		return false;
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
	public void registrarAudiencia (Midia midia, String dataExibicao) {
		this.listaJaVistas.add(midia);
		this.datasExibicao.put(midia, dataExibicao);
		midia.registraAudiencia();
	}

	public boolean ehClienteEspecialista () {

		int exibicoesMesAnterior = 0;

		for (HashMap.Entry<Midia, String> entrada : this.datasExibicao.entrySet()) {
			LocalDate dataExibicao = Data.converterStringParaData(entrada.getValue());

			if (Data.ehDataDoMesAnterior(dataExibicao)){
				exibicoesMesAnterior++;
			}
		}

		if (exibicoesMesAnterior >= 5){
			return true;
		}

		return false;
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
				System.out.printf("\n- %s (ID %d) - Vista em %s", midia.getNome(), midia.getIdMidia(), this.datasExibicao.get(midia));
		}
		System.out.println("\n");
	}

	public String getSenha() {
		return this.senha;
	}

	public ArrayList<Midia> filtrarListaParaVer(String nomeMidia) {
		ArrayList<Midia> aux = new ArrayList<>();
		for (Midia midia : this.listaParaVer){
			if (nomeMidia.equals(midia.getNome())){
				aux.add(midia);
			}
		}
		if (!aux.isEmpty()){
			for (Midia midia : aux)
				System.out.printf("\n- %s (ID %d) - %s", midia.getNome(), midia.getIdMidia(), midia.getGenero());
		} else {
			System.out.println("Não foram encontradas mídias com esse nome na lista 'Para Ver'.");
		}


		return aux;

	}

	public ArrayList<Midia> filtrarListaJaVistas(String nomeMidia) {
		ArrayList<Midia> aux = new ArrayList<>();
		for (Midia midia : this.listaJaVistas){
			if (nomeMidia.contains(midia.getNome())){
				aux.add(midia);
			}
		}
		if (!aux.isEmpty()){
			for (Midia midia : aux)
				System.out.printf("\n- %s (ID %d) - %s", midia.getNome(), midia.getIdMidia(), midia.getGenero());
		} else {
			System.out.println("Não foram encontradas mídias com esse nome na lista 'Já Vistas'.");
		}


		return aux;
	}
	/**
     * Método que filtra as mídias por genero
     * @param genero
     * @return
     */
    public ArrayList<Midia> filtrarJaVistasPorGenero(String genero) {
        ArrayList<Midia> aux = new ArrayList<>();
        for (Midia midia : this.listaJaVistas){
            if (genero.equals(midia.getGenero().name())){
                aux.add(midia);
            }
        }
        if (!aux.isEmpty()){
            for (Midia midia : aux)
                System.out.printf("\n- %s (ID %d) - %s", midia.getNome(), midia.getIdMidia(), midia.getGenero());
        } else {
            System.out.println("Não foram encontradas mídias desse gênero.");
        }

        return aux;
    }
    
    /**
     * Método que filtra as mídias por idioma
     * @param idioma
     * @return
     */
    public ArrayList<Midia> filtrarJaVistasPorIdioma(String idioma) {
        ArrayList<Midia> aux = new ArrayList<>();
        for (Midia midia : this.listaJaVistas){
            if (idioma.equals(midia.getIdioma().name())){
                aux.add(midia);
            }
        }
		if (!aux.isEmpty()){
            for (Midia midia : aux)
                System.out.printf("\n- %s (ID %d) - %s", midia.getNome(), midia.getIdMidia(), midia.getIdioma());
        } else {
            System.out.println("Não foram encontradas mídias com esse idioma.");
        }

        return aux;
    }
	/**
     * Método que filtra as mídias por genero
     * @param genero
     * @return
     */
    public ArrayList<Midia> filtrarParaVerPorGenero(String genero) {
        ArrayList<Midia> aux = new ArrayList<>();
        for (Midia midia : this.listaJaVistas){
            if (genero.equals(midia.getGenero().name())){
                aux.add(midia);
            }
        }
        if (!aux.isEmpty()){
            for (Midia midia : aux)
                System.out.printf("\n- %s (ID %d) - %s", midia.getNome(), midia.getIdMidia(), midia.getGenero());
        } else {
            System.out.println("Não foram encontradas mídias desse gênero.");
        }

        return aux;
    }

    
    /**
     * Método que filtra as mídias por idioma
     * @param idioma
     * @return
     */
    public ArrayList<Midia> filtrarParaVerPorIdioma(String idioma) {
        ArrayList<Midia> aux = new ArrayList<>();
        for (Midia midia : this.listaParaVer){
            if (idioma.equals(midia.getIdioma().name())){
                aux.add(midia);
            }
        }
		if (!aux.isEmpty()){
            for (Midia midia : aux)
                System.out.printf("\n- %s (ID %d) - %s", midia.getNome(), midia.getIdMidia(), midia.getIdioma());
        } else {
            System.out.println("Não foram encontradas mídias com esse idioma.");
        }

        return aux;
    }
	public int calcularQntAvalCliente(){

		for (Midia midia : listaJaVistas){
			if (midia.verificaAvaliacaoRegistrada(this.getNomedeUsuario())){
				this.quantAval++;

			}
		}
		return quantAval;
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
