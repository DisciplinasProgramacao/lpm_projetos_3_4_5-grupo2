package codigo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public PlataformaStreaming(String nome) throws FileNotFoundException {
        this.nome = nome;
        this.midias = new ArrayList<Midia>();
        this.clientes = new ArrayList<Cliente>();
        this.clienteAtual = null;

        System.out.println("Carregando dados...");
        carregarSeries("POO_Series.csv");
        carregarFilmes("POO_Filmes.csv");
        carregarEspectador("POO_Espectadores.csv");

        //System.out.println("Carregando audiência...");
        //carregarAudiencia("POO_Audiencia.csv");
        
    }

    /**
     * Método que busca uma série de acordo com seu ID, para ser adicionado na lista do cliente
     * @param idSerie
     * @throws FileNotFoundException
     */
    public Midia buscarSerie(int idSerie){

        for (Midia serie : midias)
            if(serie.getIdMidia() == idSerie){
                return serie;
            }
        return null;
    }

    /**
     * Método que carrega um arquivo e cria as listas contendo informações de Espectadores
     * @param nomeArquivo
     */
    public void carregarEspectador(String nomeArquivo) throws FileNotFoundException {

        Scanner leitor = new Scanner(new File(nomeArquivo));
        String linha = leitor.nextLine();
        while(leitor.hasNextLine()){

            linha = leitor.nextLine();
            String [] detalhes = linha.split(";");
            String nome = detalhes[0];
            String login = detalhes[1];
            String senha = detalhes[2];

            Cliente c = new Cliente(nome, login, senha);
            this.clientes.add(c);
            //System.out.println("Usuário " + nome + " adicionado com sucesso. Login: " + login);

        }
    }

    /**
     * Método que carrega Serie
     * @param nomeArquivo
     * @throws FileNotFoundException
     */
    public void carregarSeries(String nomeArquivo) throws FileNotFoundException {
        Scanner leitor = new Scanner(new File(nomeArquivo));
        String linha = leitor.nextLine();
        while(leitor.hasNextLine()){
            linha = leitor.nextLine();
            String [] detalhes = linha.split(";");
            int idSerie = Integer.parseInt(detalhes[0]);
            String nome = detalhes[1];
            String dataLancamento = detalhes[2];
            String genero = Midia.gerarGeneroAleatorio();

            Serie s = new Serie(idSerie, nome, dataLancamento, genero);
            this.midias.add(s);

        }
    }

    /**
     * Método que carrega filme
     * @param nomeArquivo
     * @throws FileNotFoundException
     */
    public void carregarFilmes(String nomeArquivo) throws FileNotFoundException {
        Scanner leitor = new Scanner(new File(nomeArquivo));
        String linha = leitor.nextLine();
        while(leitor.hasNextLine()){
            linha = leitor.nextLine();
            String [] detalhes = linha.split(";");
            int idFilme = Integer.parseInt(detalhes[0]);
            String nome = detalhes[1];
            String dataLancamento = detalhes[2];
            int duracao = Integer.parseInt(detalhes[3]);
            String genero = Midia.gerarGeneroAleatorio();

            Filme f = new Filme (idFilme, nome, dataLancamento, duracao, genero);
            midias.add(f);

        }
    }

    /**
     * Método que carrega Audiencia
     * @param nomeArquivo
     * @throws FileNotFoundException
     */
    public void carregarAudiencia(String nomeArquivo) throws FileNotFoundException {
//        if (clientes.size() == 0 || clientes.size() == 0) {
//            System.out.println("Audiência não carregada. As listas estão vazias. É necessário fazer a carga dos arquivos primeiro.");
//        } else {
            Scanner leitor = new Scanner(new File(nomeArquivo));
            //Cliente[] clientesComAudiencia = new Cliente[clientes.size()];
            //clientesComAudiencia = clientes.toArray();

            String linha;
            while(leitor.hasNextLine()) {
                linha = leitor.nextLine();
                String[] detalhes = linha.split(";");
                String login = detalhes[0];
                String tipoLista = detalhes[1];

                //TODO
                //Verificar porque está dando loop infinito quando coloco um else na linha 113.
                int idSerie = Integer.parseInt(detalhes[2]);
                Midia serie = buscarSerie(idSerie);
//                if (serie == null){
//                    System.out.println("Série ID " + idSerie + " não encontrada\nDados: " + linha);
//                }

                for (Cliente cliente : clientes)
                    if (cliente.getNomedeUsuario().equals(login)){
                        if (tipoLista.equals("F")) {
                            cliente.adicionarNaLista(serie);
                            //System.out.printf("Série %s adicionada na lista 'Para ver' do cliente %s\n", serie.getNome(), cliente.getNome());
                        } else {
                            cliente.registrarAudiencia(serie);
                            //System.out.printf("\nSérie %s adicionada na lista 'Já assistidas' do cliente %s\n", serie.getNome(), cliente.getNome());
                        }
                    }
            }
            System.out.println("Audiência carregada com sucesso");

        }
   // }
    
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
        for (Cliente c : clientes) {
            if (c.getNomedeUsuario().equals(cliente.getNomedeUsuario())) {
                System.out.println("Esse nome de usuário já existe!");
                return;
            }
        }
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
     * Get e set de ClienteAtual e Clientes para testar na classe PlataformaStreamingteste
     * @return
     */
    public Cliente getClienteAtual() {
        return clienteAtual;
    }
    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Get lista de mídias
     * @return
     */
    public List<Midia> getMidias() {
        return midias;
    }

    public String getNome() {
        return nome;
    }
}

