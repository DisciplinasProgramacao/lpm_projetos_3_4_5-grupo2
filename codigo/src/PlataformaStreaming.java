

import codigo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class PlataformaStreaming {
    private String nome;
    private List<Serie> series;
    private List<Cliente> clientes;
    private Cliente clienteAtual;
 
    
    public PlataformaStreaming(String nome) {
        this.nome = nome;
        this.series = new ArrayList<Serie>();
        this.clientes = new ArrayList<Cliente>();
        this.clienteAtual = null;
        
    }
    
    public Cliente login(String nomeUsuario, String senha) {
        for (Cliente cliente : clientes){
            if (nomeUsuario.equals(cliente.getNomedeUsuario()) && senha.equals(cliente.getSenha())){
                this.clienteAtual=cliente;
                return clienteAtual;
            }
        }
        return null;
        
    }
    
    public void adicionarSerie(Serie serie) {
        series.add(serie);
 
    }
    
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
 
    }
    
    public List<Serie> filtrarPorGenero(String genero) {
        List aux = new ArrayList<>();
        for (Serie serie : series){
            if (genero.equals(serie.getGenero())){
                aux.add(series);
            }
        }

        return aux;
    }
    
    public List<Serie> filtrarPorIdioma(String idioma) {
        ArrayList aux = new ArrayList<>();
        for (Serie serie : series){
            if (idioma.equals(serie.getIdioma())){
                aux.add(series);
            }
        }

        return aux;
    }
    
    public List<Serie> filtrarPorQntEps(int qntEps) {
        List aux = new ArrayList<>();
        for (Serie serie : series){
            if (qntEps == serie.getQuantidadeDeEpsodios()){
                aux.add(series);
            }
        }

        return aux;
    }
    
//    public void registrarAudiencia(Serie serie) {
//        int soma;
//         return soma = series.stream()
//                    .mapToInt(Serie::audiencia)
//                    .sum(); // Soma dos números filtrados
//    }
    
    public void logoff() {
        this.clienteAtual=null;

    }
    
    /*public Serie buscarSerie(String nomeSerie) {
        for (Serie serie : series){
            if (nomeSerie.equals(serie.getNome())){
                return serie;
            }
        }

        
    }*/
}

