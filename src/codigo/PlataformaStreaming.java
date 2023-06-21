package codigo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlataformaStreaming {
    private String nome;
    private final List<Midia> midias;
    private final List<Cliente> clientes;
    private Cliente clienteAtual;
    private final HashMap<String, Cliente> usuarios;

    public PlataformaStreaming() {
        this.midias = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.usuarios = new HashMap<>();
        this.clienteAtual = null;
    }

    public PlataformaStreaming(String nome) throws FileNotFoundException {
        this.nome = nome;
        this.midias = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.usuarios = new HashMap<>();
        this.clienteAtual = null;

        System.out.println("Carregando dados...");
        carregarSeries("src/codigo/POO_Series.csv");
        carregarFilmes("src/codigo/POO_Filmes.csv");
        carregarEspectador("src/codigo/POO_Espectadores.csv");
        Midia.setUltimoId(getMaiorId());

        System.out.println("Carregando audiência...");
        carregarAudiencia("src/codigo/POO_Audiencia.csv");

    }

    public Midia buscarMidia(int idMidia) {

        for (Midia midia : midias)
            if (midia.getIdMidia() == idMidia) {
                return midia;
            }
        return null;
    }

    public void carregarEspectador(String nomeArquivo) throws FileNotFoundException {

        Scanner leitor = new Scanner(new File(nomeArquivo));
        String linha;
        while (leitor.hasNextLine()) {

            linha = leitor.nextLine();
            String[] detalhes = linha.split(";");
            String nome = detalhes[0];
            String login = detalhes[1];
            String senha = detalhes[2];

            Cliente c = new Cliente(nome, login, senha);
            this.clientes.add(c);
            this.usuarios.put(login, c);
        }
    }

    public void carregarSeries(String nomeArquivo) throws FileNotFoundException {
        Scanner leitor = new Scanner(new File(nomeArquivo));
        String linha;
        while (leitor.hasNextLine()) {
            linha = leitor.nextLine();
            String[] detalhes = linha.split(";");
            int idSerie = Integer.parseInt(detalhes[0]);
            String nome = detalhes[1];
            String dataLancamento = detalhes[2];
            this.midias.add(MidiaFactory.initMidia("Serie", idSerie, nome, dataLancamento));
        }
    }

    public void carregarFilmes(String nomeArquivo) throws FileNotFoundException {
        Scanner leitor = new Scanner(new File(nomeArquivo));
        String linha;
        while (leitor.hasNextLine()) {
            linha = leitor.nextLine();
            String[] detalhes = linha.split(";");
            int idFilme = Integer.parseInt(detalhes[0]);
            String nome = detalhes[1];
            String dataLancamento = detalhes[2];
            int duracao = Integer.parseInt(detalhes[3]);
            midias.add(MidiaFactory.initMidia("Filme", idFilme, nome, dataLancamento, duracao));
        }
    }

    public void carregarAudiencia(String nomeArquivo) throws FileNotFoundException {
        Scanner leitor = new Scanner(new File(nomeArquivo));

        String linha;
        while (leitor.hasNextLine()) {
            linha = leitor.nextLine();
            String[] detalhes = linha.split(";");
            String login = detalhes[0];
            String tipoLista = detalhes[1];

            int idSerie = Integer.parseInt(detalhes[2]);
            Midia serie = buscarMidia(idSerie);
            Cliente cliente = this.usuarios.get(login);
            if (tipoLista.equals("F")) {
                cliente.adicionarNaLista(serie);
            } else {
                cliente.registrarAudiencia(serie, "21/04/2023");
            }
        }
        System.out.println("Audiência carregada com sucesso");
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

        String nomeArquivo;
        String novaLinhaMidia;

        if (midia.getClass().equals(Serie.class)){
            nomeArquivo = "POO_Series.csv";
            novaLinhaMidia = midia.getIdMidia() + ";" + midia.getNome() + ";" + midia.getDataLancamento();
        } else {
            Filme filme = (Filme) midia;
            nomeArquivo = "POO_Filmes.csv";
            novaLinhaMidia = filme.getIdMidia() + ";" + filme.getNome() + ";" + midia.getDataLancamento() + ";" + filme.getDuracaoFilme();
        }
        atualizarArquivo(nomeArquivo, novaLinhaMidia);
    }

    public void adicionarCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getNomedeUsuario().equals(cliente.getNomedeUsuario())) {
                System.out.println("Esse nome de usuário já existe!");
                return;
            }
        }
        clientes.add(cliente);
        String novaLinhaEspectador = cliente.getNome() + ";" + cliente.getNomedeUsuario() + ";" + cliente.getSenha();
        atualizarArquivo("POO_Espectadores.csv", novaLinhaEspectador);
    }

    public ArrayList<Midia> filtrarPorGenero(String genero) {
        ArrayList<Midia> aux = new ArrayList<>();
        for (Midia midia : midias){
            if (midia.getGenero().name().equalsIgnoreCase(genero) || midia.getGenero().getDescricao().equalsIgnoreCase(genero)){
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

    public ArrayList<Midia> filtrarPorNome(String nomeMidia) {
        ArrayList<Midia> aux = new ArrayList<>();
        for (Midia midia : midias){
            if (nomeMidia.equals(midia.getNome())){
                aux.add(midia);
            }
        }
        if (!aux.isEmpty()){
            for (Midia midia : aux)
                System.out.printf("\n- %s (ID %d) - %s", midia.getNome(), midia.getIdMidia(), midia.getGenero());
        } else {
            System.out.println("Não foram encontradas mídias com esse nome.");
        }
        return aux;
    }

    public ArrayList<Midia> filtrarPorIdioma(String idioma) {
        ArrayList<Midia> aux = new ArrayList<>();
        for (Midia midia : midias){
            if (midia.getIdioma().name().equalsIgnoreCase(idioma) || midia.getIdioma().getDescricao().equalsIgnoreCase(idioma)){
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

    public int registrarAudiencia(Midia m) {
    	return this.buscarMidia(m.getNome()).registraAudiencia();
    }

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

	public List<Serie> filtrarPorQntEps(int qntEps) {
        List<Serie> aux = new ArrayList<>();
        for (Midia midia : midias){
            if (midia instanceof Serie && qntEps == ((Serie) midia).getQuantidadeDeEpsodios()){
                aux.add((Serie) midia);
            }
        }
        return aux;
    }

    public Cliente getClienteAtual() {
        return clienteAtual;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Midia> getMidias() {
        return midias;
    }

    public String getNome() {
        return nome;
    }

    public int getMaiorId() {
        int maxId = -1;
        for (Midia midia : midias){
            if (midia.getIdMidia() > maxId){
                maxId = midia.getIdMidia();
            }
        }
        return maxId;
    }

    public void atualizarArquivo(String nomeArquivo, String novaLinha) {

        try {
            FileWriter fileWriter = new FileWriter(nomeArquivo, true); // true para modo de adição
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.newLine(); // Adicionar uma nova linha
            bufferedWriter.write(novaLinha);

            bufferedWriter.close(); // Fechar o BufferedWriter
            System.out.println("Nova linha adicionada com sucesso ao arquivo " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao adicionar a nova linha: " + e.getMessage());
        }
    }

    public double PorcentagemClientesMaisQue15Aval(){
        long qtdCLientesAval = this.clientes.stream()
                                        .filter(cliente -> cliente.calcularQntAvalCliente()>15)
                                        .count();

        double porcentagemClientesAval = ((double) qtdCLientesAval / this.clientes.size());

        return porcentagemClientesAval;
    }

    public List<Midia> buscarMelhoresMidiasAvaliadas (){
        List<Midia> melhoresMidiasAvaliadas = midias.stream()
        .filter(midia -> midia.getQuantidadeAvaliacoes()>=100)
        .sorted(Comparator.comparingDouble(Midia::getMediaAvaliacoes).reversed())
        .limit(10)
        .collect(Collectors.toList());

        return melhoresMidiasAvaliadas;
    }

    public List<Midia> buscarMidiasMaisAvaliadas (){
        List<Midia> midiasMaisAvaliadas = midias.stream()
        .sorted(Comparator.comparingDouble(Midia::getQuantidadeAvaliacoes).reversed())
        .limit(10)
        .collect(Collectors.toList());

        return midiasMaisAvaliadas;
    }

    public Map<Genero, List<Midia>> buscarMidiasMaisAvaliadasPorGenero() { //TODO TESTAR STREAM
        Map<Genero, List<Midia>> midiasMaisAvaliadasPorGenero = midias.stream()
        .sorted(Comparator.comparingDouble(Midia::getQuantidadeAvaliacoes).reversed())
        .limit(10)
        .collect(Collectors.groupingBy(Midia::getGenero));
        return midiasMaisAvaliadasPorGenero;
    }

    public List<Midia> buscarMidiasMaisVisu(){
        List<Midia> midiasMaisVisualizadas = midias.stream()
                                            .sorted(Comparator.comparingInt(Midia:: getAudiencia).reversed())
                                            .limit(10)
                                            .collect(Collectors.toList());
    
        return midiasMaisVisualizadas;
    }

    public Map<Genero, List<Midia>> buscarMidiasMaisVisuPorGenero(){
        Map<Genero, List<Midia>> midiasMaisVisualizadas = midias.stream()
                                            .sorted(Comparator.comparingInt(Midia:: getAudiencia).reversed())
                                            .limit(10)
                                            .collect(Collectors.groupingBy(Midia::getGenero));
    
        return midiasMaisVisualizadas;
    }
}

