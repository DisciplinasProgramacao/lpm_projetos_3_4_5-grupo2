package codigo;


import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        System.out.print("\nDigite o nome da plataforma: ");
        String nomePlataforma = scanner.nextLine();
        PlataformaStreaming plataforma = new PlataformaStreaming(nomePlataforma);

        while (opcao != 0) {
            System.out.printf("\nBem-vindo a plataforma %s!\nSelecione uma opção no menu abaixo\n", plataforma.getNome());
            Cliente clienteAtual = plataforma.getClienteAtual();
            if (plataforma.getClienteAtual() != null){
                System.out.printf("\nUsuário logado: %s (%s)\nHorário atual: %s\n", clienteAtual.getNome(), clienteAtual.getNomedeUsuario(), Data.agora());
            }
            System.out.println("*****************************************************");
            System.out.println("*                                                   *");
            System.out.println("*                        MENU                       *");
            System.out.println("*                                                   *");
            System.out.println("*****************************************************");
            System.out.println("*  1. Imprimir lista de mídias...                   *");
            if (clienteAtual != null && clienteAtual.ehAdmin()) System.out.println("*  2. Imprimir lista de clientes...                 *");
            if (clienteAtual != null && clienteAtual.ehAdmin()) System.out.println("*  3. Adicionar cliente                             *");
            if (clienteAtual != null && clienteAtual.ehAdmin()) System.out.println("*  4. Adicionar série                               *");
            if (clienteAtual != null && clienteAtual.ehAdmin()) System.out.println("*  5. Adicionar filme                               *");
            if (clienteAtual == null) System.out.println("*  6. Login                                         *");
            if (clienteAtual != null) System.out.println("*  6. Logoff                                        *");
            if (clienteAtual != null) System.out.println("*  7. Minha lista 'Para Ver'                        *");
            if (clienteAtual != null) System.out.println("*  8. Minha lista de itens 'Já Vistos'              *");
            if (clienteAtual != null) System.out.println("*  9. Avaliar mídia assistida                       *");
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

                    for (Cliente cliente : plataforma.getClientes()) {
                        System.out.println(cliente.toString());
                    }
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Digite o nome do cliente");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o nome de usuário do cliente");
                    String nomeUsuario = scanner.nextLine();
                    System.out.println("Digite a senha de usuário do cliente");
                    String senha = scanner.nextLine();
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
                    int qntEps = Integer.parseInt(scanner.nextLine());
                    System.out.println("Digite a data de lançamento de série");
                    String dataLancamento = scanner.nextLine();
                    Midia serie = new Serie(nome, genero, idioma, qntEps, dataLancamento);
                    plataforma.adicionarMidia(serie);
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Digite o nome do filme");
                    nome = scanner.nextLine();
                    System.out.println("Digite o gênero do filme");
                    genero = scanner.nextLine();
                    System.out.println("Digite o idioma do filme");
                    idioma = scanner.nextLine();
                    System.out.println("Digite a duração do filme");
                    int duracao = Integer.parseInt(scanner.nextLine());
                    System.out.println("Digite a data de lançamento do filme");
                    dataLancamento = scanner.nextLine();
                    Midia filme = new Filme(nome, genero, idioma, duracao, dataLancamento);
                    plataforma.adicionarMidia(filme);
                    break;
                case 6:
                    scanner.nextLine();

                    if (plataforma.getClienteAtual() == null) {
                        cliente = null;
                        while (cliente == null) {
                            System.out.println("Digite o usuário");
                            String usuario = scanner.nextLine();
                            System.out.println("Digite a senha");
                            senha = scanner.nextLine();
                            cliente = plataforma.login(usuario, senha);

                            if (cliente != null) {
                                System.out.printf("Bem-vindo(a), %s!", cliente.getNome());
                            } else {
                                System.out.println("Acesso negado. Tente novamente.");
                            }

                        }
                    } else {
                        plataforma.logoff();
                        System.out.println("Logoff efetuado com sucesso.");
                    }
                    break;
                case 7:
                    clienteAtual.imprimeListaParaVer();
                    break;
                case 8:
                    clienteAtual.imprimeListaJaVistas();
                    break;
                case 9:
                        scanner.nextLine();
                        System.out.println("Selecione a mídia a avaliar, digitando o ID correspondente.");
                        clienteAtual.imprimeListaJaVistas();
                        int idMidia = scanner.nextInt();

                        // Busca a mídia na plataforma pelo ID
                        Midia midiaParaAvaliar = plataforma.buscarMidia(idMidia);

                        // Verifica se o cliente possui na lista lista 'Para avaliar' aquela mídia
                        if (clienteAtual.getListaJaVistas().contains(midiaParaAvaliar)) {
                            // Verifica se o cliente já não avaliou essa mídia
                            if (!midiaParaAvaliar.verificaAvaliacaoRegistrada(clienteAtual.getNomedeUsuario())) {

                                int nota = -1;
                                // Pede a nota a ser dada até que esteja certa.
                                while (!(nota > 0 && nota <= 5)) {
                                    System.out.println("Você está avaliando a mídia '" + midiaParaAvaliar.getNome() + "'. Digite sua avaliação (de 1 a 5)");
                                    nota = scanner.nextInt();
                                    // Registra a avaliação, passando junto o nome do usuário
                                    midiaParaAvaliar.registrarAvaliacao(clienteAtual.getNomedeUsuario(), nota);
                                }
                                System.out.println("Média de notas de '" + midiaParaAvaliar.getNome() + "': " + midiaParaAvaliar.getMediaAvaliacoes() + " (" + midiaParaAvaliar.getQuantidadeAvaliacoes() + " avaliações)");
                                ;
                                // Se o usuário for administrador, serão exibidas as notas dadas para essa mídia.
                                if (clienteAtual.ehAdmin()) {
                                    midiaParaAvaliar.getNotasAvaliacoesMidia();
                                }

                                // Se o cliente já avaliou a mídia, retorna a mensagem abaixo com a nota.
                            } else {
                                System.out.println("Você já avaliou a mídia '" + midiaParaAvaliar.getNome() + "' com a nota " + midiaParaAvaliar.getNotaAvaliacaoUsuario(clienteAtual.getNomedeUsuario()));
                            }
                            // Se o cliente não assistiu a mídia, retorna a mensagem abaixo.
                        } else {
                            System.out.println("Essa mídia não foi assistida por você");
                        }
                        break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }


        }
        scanner.close();
    }

}