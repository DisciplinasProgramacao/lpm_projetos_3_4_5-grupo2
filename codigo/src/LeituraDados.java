import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeituraDados {

    public static Lista<Cliente> listaEspectadores;
    public static Lista<Serie> listaSeries;

    public LeituraDados(){
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

    public void carregarSeries(String nomeArquivo) throws FileNotFoundException {
        int i;
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
            System.out.println("ID " + idSerie + " - Série " + nome + ", lançada em " + dataLancamento);

        }
    }

    public void carregarAudiencia(String nomeArquivo) throws FileNotFoundException {
        //TODO
    }

}
