

import java.util.ArrayList;
import java.util.List;

public class PlataformaStreaming {
    private String nome;
    private ArrayList<Serie> series;
    private ArrayList<Cliente> clientes;
    private Cliente clienteAtual;
 
    
    public PlataformaStreaming(String nome) {
        this.nome = nome;
        this.series = new ArrayList<Serie>();
        this.clientes = new ArrayList<Cliente>();
        this.clienteAtual = null;
        
    }
    
    /*public void login(String nomeUsuario, String senha) {
        
        for (Cliente: clientes){
            if (nomeUsuario.equals(clientes.nomedeUsuario) && senha.equals(clientes.senha)){
                login = true;

            }
        }
    }*/
    
    public void adicionarSerie(Serie serie) {
        series.add(serie);
 
    }
    
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
 
    }
    
    public List<Serie> filtrarPorGenero(String genero) {
        ArrayList aux = new ArrayList();
        for (Serie serie : series){
            if (genero.equals(serie.getGenero())){
                aux.add(series);
            }
        }

        return aux;
    }
    
    public List<Serie> filtrarPorIdioma(String idioma) {
        ArrayList aux = new ArrayList();
        for (Serie serie : series){
            if (idioma.equals(serie.getIdioma())){
                aux.add(series);
            }
        }

        return aux;
    }
    
    public List<Serie> filtrarPorQntEps(int qntEps) {
        ArrayList aux = new ArrayList();
        for (Serie serie : series){
            if (qntEps == serie.getQuantidadeDeEpsodios()){
                aux.add(series);
            }
        }

        return aux;
    }
    
    /*public void registrarAudiencia(Serie serie) {
        int audiencia;
        for(Serie s : this.series) {
            audiencia += s.registraAudiencia();    
        }
    }*/
    
    public void logoff() {

    }
    
    /*public Serie buscarSerie(String nomeSerie) {
        for (Serie serie : series){
            if (nomeSerie.equals(serie.getNome())){
                return serie;
            }
        }

        
    }*/
}

