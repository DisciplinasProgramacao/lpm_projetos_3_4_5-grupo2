package codigo;


import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        System.out.print("\nDigite o nome da plataforma: ");
        String nomePlataforma = scanner.nextLine();
        PlataformaStreaming plataforma = new PlataformaStreaming(nomePlataforma);

        while (opcao != 0) {
            System.out.printf("Bem-vindo a plataforma %s!\n", plataforma.getNome());
            System.out.println("*****************************************************");
            System.out.println("*                                                   *");
            System.out.println("*                        MENU                       *");
            System.out.println("*                                                   *");
            System.out.println("*****************************************************");
            System.out.println("*  1. Imprimir lista de mídias...                   *");
            System.out.println("*  2. Imprimir lista de clientes...                 *");
            System.out.println("*  3. Adicionar cliente                             *");
            System.out.println("*  4. Adicionar série                               *");
            System.out.println("*  5. Adicionar filme                               *");
            System.out.println("*  0. Sair                                          *");
            System.out.println("*****************************************************");

            System.out.print("\nDigite o número da opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    System.out.println("*** Lista de Mídias ***");

                    for (Midia midia : plataforma.getMidias()) {
                        System.out.println(midia.toString());
                    }
                    break;
                case 2:
                    System.out.println("*** Lista de Clientes ***");

                    for (Cliente cliente : plataforma.getClientes()){
                        System.out.println(cliente.toString());
                    }
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Digite o nome do cliente");
                    String nome=scanner.nextLine();
                    System.out.println("Digite o nome de usuário do cliente");
                    String nomeUsuario = scanner.nextLine();
                    System.out.println("Digite a senha de usuário do cliente");
                    String senha=scanner.nextLine();
                    Cliente cliente = new Cliente(nome, nomeUsuario, senha);
                    plataforma.adicionarCliente(cliente);
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Digite o nome da série");
                    nome = scanner.nextLine();
                    System.out.println("Digite o gênero da série");
                    String genero = scanner.nextLine();
                    System.out.println("Digite o idioma");
                    String idioma = scanner.nextLine();
                    System.out.println("Digite a quantidade de episódios");
                    int qntEps=Integer.parseInt(scanner.nextLine());
                    System.out.println("Digite a data de lançamento de série");
                    String dataLancamento = scanner.nextLine();
                    Midia serie = new Serie(nome, genero, idioma, qntEps, dataLancamento);
                    plataforma.adicionarMidia(serie);
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Digite o nome do filme");
                    nome=scanner.nextLine();
                    System.out.println("Digite o gênero do filme");
                    genero=scanner.nextLine();
                    System.out.println("Digite o idioma do filme");
                    idioma=scanner.nextLine();
                    System.out.println("Digite a duração do filme");
                    int duracao=Integer.parseInt(scanner.nextLine());
                    System.out.println("Digite a data de lançamento do filme");
                    dataLancamento=scanner.nextLine();
                    Midia filme = new Filme(nome, genero, idioma, duracao, dataLancamento);
                    plataforma.adicionarMidia(filme);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }


        }
        scanner.close();
    }
}