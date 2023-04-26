package codigo;


import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Dados l = new Dados();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        while (true) {
            System.out.println("*****************************************************");
            System.out.println("*                                                   *");
            System.out.println("*                        MENU                       *");
            System.out.println("*                                                   *");
            System.out.println("*****************************************************");
            System.out.println("*  1. Carregar dados...                             *");
            System.out.println("*  2. Carregar audiência...                         *");
            System.out.println("*  3. Opção 2                                       *");
            System.out.println("*  4. Opção 3                                       *");
            System.out.println("*  0. Sair                                          *");
            System.out.println("*****************************************************");

            System.out.print("\nDigite o número da opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Carregando dados...");

                    l.carregarEspectador("POO_Espectadores.csv");
                    l.carregarSeries("POO_Series.csv");
                    l.carregarFilmes("POO_Filmes.csv");
                    break;
                case 2:
                    System.out.println("Carregando audiência...");
                    l.carregarAudiencia("POO_Audiencia.csv");
                    break;
                case 3:
                    System.out.println("Imprimindo 'Lista para Ver' de um cliente");
                    Cliente[] clientes = l.getListaClientes();
                    clientes[3].imprimeListaParaVer();
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }


        }
    }
}