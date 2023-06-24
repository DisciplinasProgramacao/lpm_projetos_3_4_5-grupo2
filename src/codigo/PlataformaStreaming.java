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
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Classe que representa uma plataforma de streaming.
 */

public class PlataformaStreaming {
    private String nome;
    private List<Midia> midias;
    private List<Cliente> clientes;
    private Cliente clienteAtual;
    private HashMap<String, Cliente> usuarios;

    /**
     * Construtor padrão da classe PlataformaStreaming.
     * Inicializa as listas de mídias e clientes, e o mapa de usuários.
     */

    public PlataformaStreaming() {
        this.midias = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.usuarios = new HashMap<>();
        this.clienteAtual = null;
    }

    /**
     * Construtor da classe PlataformaStreaming que permite carregar os dados iniciais a partir de arquivos CSV.
     *
     * @param nome o nome da plataforma de streaming.
     * @throws FileNotFoundException se ocorrer um erro ao abrir o arquivo.
     */

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

    /**
     * Busca uma mídia com base no seu ID.
     *
     * @param idMidia o ID da mídia a ser buscada.
     * @return a mídia encontrada ou null se não for encontrada.
     */

    public Midia buscarMidia(int idMidia) {
        for (Midia midia : midias)
            if (midia.getIdMidia() == idMidia) {
                return midia;
            }
        return null;
    }

    /**
     * Carrega os dados dos espectadores a partir de um arquivo CSV.
     *
     * @param nomeArquivo o nome do arquivo CSV.
     * @throws FileNotFoundException se ocorrer um erro ao abrir o arquivo.
     */

    public void carregarEspectador(String nomeArquivo) throws FileNotFoundException {
        Scanner leitor = new Scanner(new File(nomeArquivo));
        String linha = leitor.nextLine();
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

    /**
     * Carrega as séries a partir de um arquivo CSV.
     *
     * @param nomeArquivo O nome do arquivo CSV contendo as séries a serem carregadas.
     * @throws FileNotFoundException Se o arquivo especificado não for encontrado.
     */

    public void carregarSeries(String nomeArquivo) throws FileNotFoundException {
        Scanner leitor = new Scanner(new File(nomeArquivo));
        String linha = leitor.nextLine();
        while (leitor.hasNextLine()) {
            linha = leitor.nextLine();
            String[] detalhes = linha.split(";");
            int idSerie = Integer.parseInt(detalhes[0]);
            String nome = detalhes[1];
            String dataLancamento = detalhes[2];
            this.midias.add(MidiaFactory.initMidia("Serie", idSerie, nome, dataLancamento, 0));
        }
    }

    /**
     * Carrega os filmes a partir de um arquivo CSV.
     *
     * @param nomeArquivo O nome do arquivo CSV contendo os filmes a serem carregados.
     * @throws FileNotFoundException Se o arquivo especificado não for encontrado.
     */

    public void carregarFilmes(String nomeArquivo) throws FileNotFoundException {
        Scanner leitor = new Scanner(new File(nomeArquivo));
        String linha = leitor.nextLine();
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

    /**
     * Carrega as audiências a partir de um arquivo CSV.
     *
     * @param nomeArquivo O nome do arquivo CSV contendo as audiências a serem carregadas.
     * @throws FileNotFoundException Se o arquivo especificado não for encontrado.
     */

    public void carregarAudiencia(String nomeArquivo) throws FileNotFoundException {
        Scanner leitor = new Scanner(new File(nomeArquivo));
        String linha = leitor.nextLine();
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
                String dataAleatoria = Data.gerarDataAleatoria();
                cliente.registrarAudiencia(serie, "21/04/2023");
            }
        }
        System.out.println("Audiência carregada com sucesso");
    }

    /**
     * Realiza o login de um cliente no sistema.
     *
     * @param nomeUsuario O nome de usuário do cliente.
     * @param senha A senha do cliente.
     * @return O cliente que efetuou o login, ou null se as credenciais forem inválidas.
     */

    public Cliente login(String nomeUsuario, String senha) {
        for (Cliente cliente : clientes) {
            if (nomeUsuario.equals(cliente.nomedeUsuario) && senha.equals(cliente.senha)) {
                this.clienteAtual = cliente;
                return clienteAtual;
            }
        }
        return null;
    }

    /**
     * Adiciona uma nova mídia ao catálogo.
     *
     * @param midia A mídia a ser adicionada.
     */

    public void adicionarMidia(Midia midia) {
        midias.add(midia);
        String nomeArquivo = "";
        String novaLinhaMidia = "";
        if (midia.getClass().equals(Serie.class)) {
            nomeArquivo = "POO_Series.csv";
            novaLinhaMidia = midia.getIdMidia() + ";" + midia.getNome() + ";" + midia.getDataLancamento();
        } else {
            Filme filme = (Filme) midia;
            nomeArquivo = "POO_Filmes.csv";
            novaLinhaMidia = filme.getIdMidia() + ";" + filme.getNome() + ";" + midia.getDataLancamento() + ";" + filme.getDuracaoFilme();
        }
        atualizarArquivo(nomeArquivo, novaLinhaMidia);
    }

    /**
     * Adiciona um novo cliente ao sistema.
     *
     * @param cliente O cliente a ser adicionado.
     */

    public void adicionarCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getNomedeUsuario().equals(cliente.getNomedeUsuario())) {
                System.out.println("Esse nome de usuário já existe!");
                return;
            }
        }
        clientes.add(cliente);
        String novaLinhaEspectador = cliente.getNome() + ";" + cliente.getNomedeUsuario() + ";" + cliente.getSenha();
        atualizarArquivo("src/codigo/POO_Espectadores.csv", novaLinhaEspectador);
    }

    /**
     * Filtra as mídias por gênero.
     *
     * @param genero O gênero pelo qual as mídias serão filtradas.
     * @return Uma lista de mídias filtradas pelo gênero especificado.
     */

    public ArrayList<Midia> filtrarPorGenero(String genero) {
        ArrayList<Midia> aux = new ArrayList<>();
        for (Midia midia : midias) {
            if (midia.getGenero().name().equalsIgnoreCase(genero) || midia.getGenero().getDescricao().equalsIgnoreCase(genero)) {
                aux.add(midia);
            }
        }
        if (!aux.isEmpty()) {
            for (Midia midia : aux)
                System.out.printf("\n- %s (ID %d) - %s", midia.getNome(), midia.getIdMidia(), midia.getGenero());
        } else {
            System.out.println("Não foram encontradas mídias desse gênero.");
        }
        return aux;
    }

    /**
     * Filtra as mídias por nome.
     *
     * @param nomeMidia O nome da mídia pelo qual será filtrada.
     * @return Uma lista de mídias filtradas pelo nome especificado.
     */

    public ArrayList<Midia> filtrarPorNome(String nomeMidia) {
        ArrayList<Midia> aux = new ArrayList<>();
        for (Midia midia : midias) {
            if (nomeMidia.equals(midia.getNome())) {
                aux.add(midia);
            }
        }
        if (!aux.isEmpty()) {
            for (Midia midia : aux)
                System.out.printf("\n- %s (ID %d) - %s", midia.getNome(), midia.getIdMidia(), midia.getGenero());
        } else {
            System.out.println("Não foram encontradas mídias com esse nome.");
        }
        return aux;
    }

    /**
     * Filtra as mídias por idioma.
     *
     * @param idioma O idioma pelo qual as mídias serão filtradas.
     * @return Uma lista de mídias filtradas pelo idioma especificado.
     */

    public ArrayList<Midia> filtrarPorIdioma(String idioma) {
        ArrayList<Midia> aux = new ArrayList<>();
        for (Midia midia : midias) {
            if (midia.getIdioma().name().equalsIgnoreCase(idioma) || midia.getIdioma().getDescricao().equalsIgnoreCase(idioma)) {
                aux.add(midia);
            }
        }
        if (!aux.isEmpty()) {
            for (Midia midia : aux)
                System.out.printf("\n- %s (ID %d) - %s", midia.getNome(), midia.getIdMidia(), midia.getIdioma());
        } else {
            System.out.println("Não foram encontradas mídias com esse idioma.");
        }
        return aux;
    }

    /**
     * Registra uma audiência para uma mídia.
     *
     * @param m A mídia para a qual será registrada a audiência.
     * @return O número de audiências registradas para a mídia.
     */

    public int registrarAudiencia(Midia m) {
        return this.buscarMidia(m.getNome()).registraAudiencia();
    }

    /**
     * Realiza o logoff do cliente atualmente logado no sistema.
     */

    public void logoff() {
        this.clienteAtual = null;
    }

    /**
     * Busca uma mídia pelo nome.
     *
     * @param nomeMidia O nome da mídia a ser buscada.
     * @return A mídia encontrada, ou null se não for encontrada nenhuma mídia com o nome especificado.
     */

    public Midia buscarMidia(String nomeMidia) {
        for (Midia midia : midias) {
            if (nomeMidia.equals(midia.getNome())) {
                return midia;
            }
        }
        return null;
    }

    /**
     * Filtra as séries por quantidade de episódios.
     *
     * @param qntEps A quantidade de episódios pela qual as séries serão filtradas.
     * @return Uma lista de séries filtradas pela quantidade de episódios especificada.
     */

    public List<Serie> filtrarPorQntEps(int qntEps) {
        List<Serie> aux = new ArrayList<>();
        for (Midia midia : midias) {
            if (midia instanceof Serie && qntEps == ((Serie) midia).getQuantidadeDeEpsodios()) {
                aux.add((Serie) midia);
            }
        }
        return aux;
    }

    /**
     * Obtém o cliente atualmente logado no sistema.
     *
     * @return O cliente atualmente logado, ou null se nenhum cliente estiver logado.
     */

    public Cliente getClienteAtual() {
        return clienteAtual;
    }

    /**
     * Obtém a lista de clientes cadastrados no sistema.
     *
     * @return A lista de clientes cadastrados.
     */

    public List<Cliente> getClientes() {
        return clientes;
    }

    /**
     * Obtém a lista de todas as mídias do catálogo.
     *
     * @return A lista de mídias do catálogo.
     */

    public List<Midia> getMidias() {
        return midias;
    }

    /**
     * Obtém o nome do sistema.
     *
     * @return O nome do sistema.
     */

    public String getNome() {
        return nome;
    }

    /**
     * Obtém o maior ID de mídia presente no catálogo.
     *
     * @return O maior ID de mídia presente no catálogo.
     */

    public int getMaiorId() {
        int maxId = -1;
        for (Midia midia : midias) {
            if (midia.getIdMidia() > maxId) {
                maxId = midia.getIdMidia();
            }
        }
        return maxId;
    }

    /**
     * Atualiza um arquivo CSV com uma nova linha de dados.
     *
     * @param nomeArquivo O nome do arquivo CSV a ser atualizado.
     * @param novaLinha A nova linha a ser adicionada ao arquivo.
     */

    public void atualizarArquivo(String nomeArquivo, String novaLinha) {
        try {
            FileWriter fileWriter = new FileWriter(nomeArquivo, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(novaLinha);
            bufferedWriter.close();
            System.out.println("Registrado com sucesso!");
        } catch (
                IOException e) {
            System.out.println("Ocorreu um erro ao atualizar o registro: " + e.getMessage());
        }
    }

    /**
     * Calcula a porcentagem de clientes que possuem mais de 15 avaliações.
     *
     * @return A porcentagem de clientes com mais de 15 avaliações.
     */

    public double PorcentagemClientesMaisQue15Aval() {
        long qtdCLientesAval = this.clientes.stream()
                .filter(cliente -> cliente.calcularQntAvalCliente() > 15)
                .count();
        double porcentagemClientesAval = ((double) qtdCLientesAval / this.clientes.size());
        return porcentagemClientesAval;
    }

    /**
     * Busca as melhores mídias avaliadas com base na média de avaliações.
     *
     * @return Uma lista das melhores mídias avaliadas.
     */

    public String buscarMelhoresMidiasAvaliadas() {
        List<Midia> melhoresMidiasAvaliadas = midias.stream()
                .filter(midia -> midia.getQuantidadeAvaliacoes() >= 100)
                .sorted(Comparator.comparingDouble(Midia::getMediaAvaliacoes).reversed())
                .limit(10)
                .collect(Collectors.toList());
        
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < melhoresMidiasAvaliadas.size(); i++) {
            Midia midia = melhoresMidiasAvaliadas.get(i);
            resultado.append(String.format("%dº - %s - ", i + 1, midia.getNome()));
            resultado.append(midia.getNotasAvaliacoesMidia());
        }

        return resultado.toString();
    }

    /**
     * Busca as mídias mais avaliadas com base no número de avaliações recebidas.
     *
     * @return Uma lista das mídias mais avaliadas.
     */

    public String buscarMidiasMaisAvaliadas() {
        List<Midia> midiasMaisAvaliadas = midias.stream()
                .sorted(Comparator.comparingDouble(Midia::getMediaAvaliacoes).reversed())
                .limit(10)
                .collect(Collectors.toList());

        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < midiasMaisAvaliadas.size(); i++) {
            Midia midia = midiasMaisAvaliadas.get(i);
            resultado.append(String.format("%dº - %s - ", i + 1, midia.getNome()));
            resultado.append(midia.getNotasAvaliacoesMidia());
        }

        return resultado.toString();
    }

    /**
     * Busca as mídias mais avaliadas por gênero, com base no número de avaliações recebidas.
     *
     * @return Um mapa em que as chaves são os gêneros e os valores são as listas de mídias mais avaliadas para cada gênero.
     */

    public String buscarMidiasMaisAvaliadasPorGenero() {
        Map<Genero, List<Midia>> midiasMaisAvaliadasPorGenero = midias.stream()
                .sorted(Comparator.comparingDouble(Midia::getQuantidadeAvaliacoes).reversed())
                .limit(10)
                .collect(Collectors.groupingBy(Midia::getGenero));

        StringBuilder resultado = new StringBuilder();
        int posicao = 1;
        resultado.append("Mídias mais visualizadas por gênero\n");
        for (Map.Entry<Genero, List<Midia>> entry : midiasMaisAvaliadasPorGenero.entrySet()) {
            Genero genero = entry.getKey();
            List<Midia> midiasMaisAvaliadas = entry.getValue();
            resultado.append("Gênero: ").append(genero).append("\n");
            for (int i = 0; i < midiasMaisAvaliadas.size(); i++) {
                Midia midia = midiasMaisAvaliadas.get(i);
                resultado.append(String.format("%dº - %s - ", posicao++, midia.getNome()));
                resultado.append(midia.getNotasAvaliacoesMidia());
            }
            resultado.append("\n");
        }

        return resultado.toString();
    }

    /**
     * Busca as mídias mais visualizadas com base no número de audiências.
     *
     * @return Uma lista das mídias mais visualizadas.
     */

    public String buscarMidiasMaisVisu() {
        List<Midia> midiasMaisVisualizadas = midias.stream()
                .sorted(Comparator.comparingInt(Midia::getAudiencia).reversed())
                .limit(10)
                .collect(Collectors.toList());
        
        StringBuilder resultado = new StringBuilder();
        resultado.append("Mídias mais visualizadas\n");
        for (int i = 0; i < midiasMaisVisualizadas.size(); i++) {
            Midia midia = midiasMaisVisualizadas.get(i);
            resultado.append(String.format("%dº - %s \n", i + 1, midia.getNome()));
        }

        return resultado.toString();
    }

    /**
     * Busca as mídias mais visualizadas por gênero, com base no número de audiências.
     *
     * @return Um mapa em que as chaves são os gêneros e os valores são as listas de mídias mais visualizadas para cada gênero.
     */

    public String buscarMidiasMaisVisuPorGenero() {
        Map<Genero, List<Midia>> midiasMaisVisualizadas = midias.stream()
                .sorted(Comparator.comparingInt(Midia::getAudiencia).reversed())
                .limit(10)
                .collect(Collectors.groupingBy(Midia::getGenero));

        StringBuilder resultado = new StringBuilder();
        int posicao = 1;
        for (Map.Entry<Genero, List<Midia>> entry : midiasMaisVisualizadas.entrySet()) {
            Genero genero = entry.getKey();
            List<Midia> midiasMaisVisualizadasPorGenero = entry.getValue();
            resultado.append("Gênero: ").append(genero).append("\n");
            for (int i = 0; i < midiasMaisVisualizadasPorGenero.size(); i++) {
                Midia midia = midiasMaisVisualizadasPorGenero.get(i);
                resultado.append(String.format("%dº - %s - Audiência: %d\n", posicao++, midia.getNome(), midia.getAudiencia()));
            }
            resultado.append("\n");
        }

        return resultado.toString();
    }

    /**
     * Obtém o cliente que assistiu ao maior número de mídias.
     *
     * @return O cliente com o maior número de mídias assistidas.
     */

    public String getClienteComMaisMidiasAssistidas() {
        Optional<Cliente> clienteComMaisMidias = clientes.stream()
                .max(Comparator.comparingInt(cliente -> cliente.getListaJaVistas().size()));

        StringBuilder resultado = new StringBuilder();
        if (clienteComMaisMidias.isPresent()) {
            Cliente cliente = clienteComMaisMidias.get();
            resultado.append("Cliente com mais mídias assistidas:\n")
                    .append("Nome: ").append(cliente.getNome()).append("\n")
                    .append("Quantidade de mídias assistidas: ").append(cliente.getListaJaVistas().size()).append("\n");
        } else {
            resultado.append("Não há clientes registrados ou nenhuma mídia foi assistida por algum cliente.");
        }

        return resultado.toString();
    }

    /**
     * Obtém o cliente que realizou o maior número de avaliações.
     *
     * @return O cliente com o maior número de avaliações.
     */

    public String getClienteComMaisAvaliacoes() {
        Optional<Cliente> clienteComMaisAvaliacoes = clientes.stream()
                .max(Comparator.comparingInt(Cliente::calcularQntAvalCliente));

        StringBuilder resultado = new StringBuilder();
        if (clienteComMaisAvaliacoes.isPresent()) {
            Cliente cliente = clienteComMaisAvaliacoes.get();
            resultado.append("Cliente com mais avaliações:\n")
                    .append("Nome: ").append(cliente.getNome()).append("\n")
                    .append("Quantidade de avaliações: ").append(cliente.calcularQntAvalCliente()).append("\n");
        } else {
            resultado.append("Não há clientes registrados ou nenhum cliente fez avaliações.");
        }

        return resultado.toString();
    }
}

