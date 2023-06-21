package codigo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cliente {
    private String nome;
    String nomedeUsuario;
    String senha;
    private final List<Midia> listaParaVer;
    private final List<Midia> listaJaVistas;
    private HashMap<Midia, String> datasExibicao;
    private int quantAval;

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

    public boolean ehAdmin() {
        return getNomedeUsuario().equals("admin");
    }

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

    public void adicionarNaLista(Midia midia) {
        this.listaParaVer.add(midia);
    }

    public void retirarDaLista(String nomeMidia) {
        this.listaParaVer.removeIf(midia -> midia.getNome().equals(nomeMidia));
    }

    public void registrarAudiencia(Midia midia, String dataExibicao) {
        this.listaJaVistas.add(midia);
        this.datasExibicao.put(midia, dataExibicao);
        midia.registraAudiencia();
    }

    public boolean ehClienteEspecialista() {
        int exibicoesMesAnterior = 0;

        for (HashMap.Entry<Midia, String> entrada : this.datasExibicao.entrySet()) {
            LocalDate dataExibicao = Data.converterStringParaData(entrada.getValue());
            if (Data.ehDataDoMesAnterior(dataExibicao)) {
                exibicoesMesAnterior++;
            }
        }
        return exibicoesMesAnterior >= 5;
    }

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

    public ArrayList<Midia> filtrarListaJaVistas(String nomeMidia) {
        ArrayList<Midia> aux = new ArrayList<>();
        for (Midia midia : this.listaJaVistas) {
            if (nomeMidia.contains(midia.getNome())) {
                aux.add(midia);
            }
        }
        if (!aux.isEmpty()) {
            for (Midia midia : aux)
                System.out.printf("\n- %s (ID %d) - %s", midia.getNome(), midia.getIdMidia(), midia.getGenero());
        } else {
            System.out.println("Não foram encontradas mídias com esse nome na lista 'Já Vistas'.");
        }
        return aux;
    }

    public ArrayList<Midia> filtrarJaVistasPorGenero(String genero) {
        ArrayList<Midia> aux = new ArrayList<>();
        for (Midia midia : this.listaJaVistas) {
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

    public ArrayList<Midia> filtrarJaVistasPorIdioma(String idioma) {
        ArrayList<Midia> aux = new ArrayList<>();
        for (Midia midia : this.listaJaVistas) {
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

    public ArrayList<Midia> filtrarListaParaVer(String nomeMidia) {
        ArrayList<Midia> aux = new ArrayList<>();
        for (Midia midia : this.listaParaVer) {
            if (nomeMidia.equals(midia.getNome())) {
                aux.add(midia);
            }
        }
        if (!aux.isEmpty()) {
            for (Midia midia : aux)
                System.out.printf("\n- %s (ID %d) - %s", midia.getNome(), midia.getIdMidia(), midia.getGenero());
        } else {
            System.out.println("Não foram encontradas mídias com esse nome na lista 'Para Ver'.");
        }
        return aux;
    }

    public ArrayList<Midia> filtrarParaVerPorGenero(String genero) {
        ArrayList<Midia> aux = new ArrayList<>();
        for (Midia midia : this.listaParaVer) {
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

    public ArrayList<Midia> filtrarParaVerPorIdioma(String idioma) {
        ArrayList<Midia> aux = new ArrayList<>();
        for (Midia midia : this.listaParaVer) {
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

    public int calcularQntAvalCliente() {

        for (Midia midia : listaJaVistas) {
            if (midia.verificaAvaliacaoRegistrada(this.getNomedeUsuario())) {
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
