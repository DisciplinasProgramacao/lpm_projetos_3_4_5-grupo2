package codigo;

import java.util.ArrayList;
import java.util.List;

public class PlataformaStreaming {
    private String nome;
    private List<Midia> midias;
    private List<Cliente> clientes;
    private Cliente clienteAtual;
 
    /*
     * Construtor padrão
     */
    public PlataformaStreaming() {
    }
    public PlataformaStreaming(String nome) {
        this.nome = nome;
        this.midias = new ArrayList<Midia>();
        this.clientes = new ArrayList<Cliente>();
        this.clienteAtual = null;
        
    }
    
    /**
     * Método que faz login do Cliente
     * @param nomeUsuario
     * @param senha
     * @return
     */
    public Cliente login(String nomeUsuario, String senha) {
        for (Cliente cliente : clientes){
            if (nomeUsuario.equals(cliente.nomedeUsuario) && senha.equals(cliente.senha)){
                this.clienteAtual=cliente;
                return clienteAtual;
            }
        }
        return null;
        
    }
    
    /**
     * Método que adiciona midia na Plataforma
     * @param midia
     */
    public void adicionarMidia(Midia midia) {
        midias.add(midia);
 
    }
    
    /**
     * Método que adiciona Cliente na Plataforma
     * @param cliente
     */
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
 
    }
    
    /**
     * Método que filtra as mídias por genero
     * @param genero
     * @return
     */
    public List<Midia> filtrarPorGenero(String genero) {
        List aux = new ArrayList<>();
        for (Midia midia : midias){
            if (genero.equals(midia.getGenero())){
                aux.add(midias);
            }
        }

        return aux;
    }
    
    /**
     * Método que filtra as mídias por idioma
     * @param idioma
     * @return
     */
    public List<Midia> filtrarPorIdioma(String idioma) {
        ArrayList aux = new ArrayList<>();
        for (Midia midia : midias){
            if (idioma.equals(midia.getIdioma())){
                aux.add(midias);
            }
        }

        return aux;
    }
    
    /**
     * Método que registra audiencia de determinada midia
     * @param m
     * @return
     */
    public int registrarAudiencia(Midia m) {
    	return this.buscarMidia(m.getNome()).registraAudiencia();
    }
    
    /**
     * Método que faz logoff do Cliente logado 
     */
    public void logoff() {
        this.clienteAtual=null;
    }
    
    /**
     * Método que busca midia
     * @param nomeMidia
     * @return
     */
    public Midia buscarMidia(String nomeMidia) {
        for (Midia midia : midias){
            if (nomeMidia.equals(midia.getNome())){
                return midia;
            }
        }
        return null;
    }
    
    /**
     * Método que filtra Serie por quantidade de epsódios
     * @param qntEps
     * @return
     */
	public List<Serie> filtrarPorQntEps(int qntEps) {
        List<Serie> aux = new ArrayList<>();
        for (Midia midia : midias){
            if (midia instanceof Serie && qntEps == ((Serie) midia).getQuantidadeDeEpsodios()){
                aux.add((Serie) midia);
            }
        }

        return aux;
    }
    
    /**
     * Get e set de ClienteAtual para testar na classe PlataformaStreamingteste
     * @return
     */
	public Cliente getClienteAtual() {
		return clienteAtual;
	}
	public void setClienteAtual(Cliente clienteAtual) {
		this.clienteAtual = clienteAtual;
	}
}

