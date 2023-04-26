package codigo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dados {

    private static Lista<Cliente> listaEspectadores;

    private static Cliente[] listaClientes;
    private static Lista<Serie> listaSeries;

    public Dados(){
        listaEspectadores = new Lista<>();
        listaSeries = new Lista<>();
    }


    /**
     * Método que carrega um arquivo e cria as listas contendo informações de Espectadores
     * , Séries e Audiências
     * @param nomeArquivo
     */
    public void carregarEspectador(String nomeArquivo) throws FileNotFoundException {
        int i;
        Scanner leitor = new Scanner(new File(nomeArquivo));
        String linha = leitor.nextLine();
        while(leitor.hasNextLine()){
            linha = leitor.nextLine();
            String [] detalhes = linha.split(";");
            String nome = detalhes[0];
            String login = detalhes[1];
            String senha = detalhes[2];

            Cliente c = new Cliente(nome, login, senha);
            this.listaEspectadores.add(c);
            System.out.println("Usuário " + nome + " adicionado com sucesso. Login: " + login);

        }
    }

    public static Cliente[] getListaClientes() {
        return listaClientes;
    }

    public Lista<Cliente> getListaEspectadores() {
        return listaEspectadores;
    }

    public Lista<Serie> getListaSeries() {
        return listaSeries;
    }

    public static Serie buscarSerie(int idSerie){
        Serie[] series = new Serie[listaSeries.size()];
        series = listaSeries.allElements(series);

        for (Serie serie : series)
            if(serie.getIdSerie() == idSerie){
                return serie;
            }
        return null;
    }

    public static void atualizaClientes(Cliente[] clientes){
        listaEspectadores = new Lista<>();

        for (Cliente cliente : clientes)
            listaEspectadores.add(cliente);

        System.out.println("Lista de clientes atualizada com informações de audiência.");
    }

    public void carregarSeries(String nomeArquivo) throws FileNotFoundException {
        Scanner leitor = new Scanner(new File(nomeArquivo));
        String linha = leitor.nextLine();
        while(leitor.hasNextLine()){
            linha = leitor.nextLine();
            String [] detalhes = linha.split(";");
            int idSerie = Integer.parseInt(detalhes[0]);
            String nome = detalhes[1];
            String dataLancamento = detalhes[2];

            Serie s = new Serie(idSerie, nome, dataLancamento);
            this.listaSeries.add(s);
            System.out.println("Série " + nome + ", lançada em " + dataLancamento + ", cadastrada com ID " + idSerie);

        }
    }

    public void carregarAudiencia(String nomeArquivo) throws FileNotFoundException {
        if (listaEspectadores.size() == 0 || listaSeries.size() == 0) {
            System.out.println("Audiência não carregada. As listas estão vazias. É necessário fazer a carga dos arquivos primeiro.");
        } else {
            Scanner leitor = new Scanner(new File(nomeArquivo));
            Cliente[] clientesComAudiencia = new Cliente[listaEspectadores.size()];
            clientesComAudiencia = listaEspectadores.allElements(clientesComAudiencia);

            String linha;
            while(leitor.hasNextLine()) {
                linha = leitor.nextLine();
                String[] detalhes = linha.split(";");
                String login = detalhes[0];
                String tipoLista = detalhes[1];

                //TODO
                //Verificar porque está dando loop infinito quando coloco um else na linha 113.
                int idSerie = Integer.parseInt(detalhes[2]);
                Serie serie = buscarSerie(idSerie);
                if (serie == null){
                    System.out.println("Série ID " + idSerie + " não encontrada\nDados: " + linha);
                }

                for (Cliente cliente : clientesComAudiencia)
                    if (cliente.getNomedeUsuario().equals(login)){
                        if (tipoLista.equals("F")) {
                            cliente.adicionarNaLista(serie);
                            System.out.printf("Série %s adicionada na lista 'Para ver' do cliente %s\n", serie.getNome(), cliente.getNome());
                        } else {
                            cliente.registrarAudiencia(serie);
                            System.out.printf("\nSérie %s adicionada na lista 'Já assistidas' do cliente %s\n", serie.getNome(), cliente.getNome());
                        }
                    }
            }
            atualizaClientes(clientesComAudiencia);
            listaClientes = clientesComAudiencia;
            System.out.println("Audiência carregada com sucesso");

        }
    }

}
