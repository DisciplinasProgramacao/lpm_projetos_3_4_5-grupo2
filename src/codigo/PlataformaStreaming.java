package codigo;

import java.util.ArrayList;
import java.util.List;

public class PlataformaStreaming {
    private String nome;
    private List<Midia> midias;
    private List<Cliente> clientes;
    private Cliente clienteAtual;
 
    public PlataformaStreaming() {
    }
    public PlataformaStreaming(String nome) {
        this.nome = nome;
        this.midias = new ArrayList<Midia>();
        this.clientes = new ArrayList<Cliente>();
        this.clienteAtual = null;
        
    }
    
    public Cliente login(String nomeUsuario, String senha) {
        for (Cliente cliente : clientes){
            if (nomeUsuario.equals(cliente.nomedeUsuario) && senha.equals(cliente.senha)){
                this.clienteAtual=cliente;
                return clienteAtual;
            }
        }
        return null;
        
    }
    
    public void adicionarMidia(Midia midia) {
        midias.add(midia);
 
    }
    
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
 
    }
    
    public List<Midia> filtrarPorGenero(String genero) {
        List aux = new ArrayList<>();
        for (Midia midia : midias){
            if (genero.equals(midia.getGenero())){
                aux.add(midias);
            }
        }

        return aux;
    }
    
    public List<Midia> filtrarPorIdioma(String idioma) {
        ArrayList aux = new ArrayList<>();
        for (Midia midia : midias){
            if (idioma.equals(midia.getIdioma())){
                aux.add(midias);
            }
        }

        return aux;
    }
  /* 
    public List<Midia> filtrarPorQntEps(int qntEps) {
        List aux = new ArrayList<>();
        for (Midia midia : midias){
            if (qntEps == midia.getQuantidadeDeEpsodios()){
                aux.add(midias);
            }
        }

        return aux;
    }
    /*
    /*public void registrarAudiencia(Serie serie) {
        int audiencia;
        for(Serie s : this.series) {
            audiencia += s.registraAudiencia();    
        }
    }*/
    
    public void logoff() {
        this.clienteAtual=null;

    }

    public Midia buscarMidia(String nomeMidia) {
        for (Midia midia : midias){
            if (nomeMidia.equals(midia.getNome())){
                return midia;
            }
        }
        return null;
    }

//    public List<Serie> filtrarPorQntEps(int qntEps) {
//        List<Serie> aux = new ArrayList<>();
//        for (Midia midia : midias){
//            if (midia instanceof Serie && qntEps == midia.getQuantidadeDeEpsodios()){
//                aux.add(midias);
//            }
//        }
//
//        return aux;
//    }
}

