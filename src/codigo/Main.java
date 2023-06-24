package codigo;


import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe principal que contém o método main para executar o programa.
 */

public class Main {

    /**
     * Método principal que inicia a execução do programa.
     *
     * @param args argumentos de linha de comando (não utilizados neste programa)
     * @throws FileNotFoundException se o arquivo de entrada não for encontrado
     */

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        System.out.print("\nDigite o nome da plataforma: ");
        String nomePlataforma = scanner.nextLine();
        PlataformaStreaming plataforma = new PlataformaStreaming(nomePlataforma);

        while (opcao != 0) {
            System.out.printf("\nBem-vindo a plataforma %s!\nSelecione uma opção no menu abaixo\n", plataforma.getNome());
            Cliente clienteAtual = plataforma.getClienteAtual();
            if (plataforma.getClienteAtual() != null) {
                System.out.printf("\nUsuário logado: %s (%s)\nHorário atual: %s\n", clienteAtual.getNome(), clienteAtual.getNomedeUsuario(), Data.agoraString());
            }
            System.out.println("*****************************************************");
            System.out.println("*                                                   *");
            System.out.println("*                        MENU                       *");
            System.out.println("*                                                   *");
            System.out.println("*****************************************************");
            System.out.println("*  1. Imprimir lista de mídias...                   *");
            if (clienteAtual != null && clienteAtual.ehAdmin())
                System.out.println("*  2. Imprimir lista de clientes...                 *");
            if (clienteAtual != null && clienteAtual.ehAdmin())
                System.out.println("*  3. Adicionar cliente                             *");
            if (clienteAtual != null && clienteAtual.ehAdmin())
                System.out.println("*  4. Adicionar série                               *");
            if (clienteAtual != null && clienteAtual.ehAdmin())
                System.out.println("*  5. Adicionar filme                               *");
            if (clienteAtual == null)
                System.out.println("*  6. Login                                         *");
            if (clienteAtual != null)
                System.out.println("*  6. Logoff                                        *");
            if (clienteAtual != null)
                System.out.println("*  7. Minha lista 'Para Ver'                        *");
            if (clienteAtual != null)
                System.out.println("*  8. Minha lista de itens 'Já Vistos'              *");
            if (clienteAtual != null)
                System.out.println("*  9. Avaliar mídia assistida                       *");
            if (clienteAtual != null)
                System.out.println("*  10. Acessar menu de filtros                      *");
            System.out.println("*  0. Sair                                          *");
            System.out.println("*****************************************************");

            System.out.print("\nDigite o número da opção desejada: ");
            try {
                opcao = scanner.nextInt();
            } catch (
                    InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número inteiro.");
                scanner.nextLine(); // Consumir a quebra de linha após a leitura do número
                continue;
            }

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
                try {
                    scanner.nextLine();
                    System.out.println("Digite o nome da série");
                    nome = scanner.nextLine();

                    System.out.println("Digite o gênero da série");
                    String generoStr = scanner.nextLine();
                    Genero genero = Genero.findByValue(generoStr);

                    System.out.println("Digite o idioma");
                    String idiomaStr = scanner.nextLine();
                    Idioma idioma = Idioma.findByValue(idiomaStr);

                    System.out.println("Digite a quantidade de episódios");
                    int qntEps = Integer.parseInt(scanner.nextLine());
                    System.out.println("Digite a data de lançamento de série");
                    String dataLancamento = scanner.nextLine();

                    Midia serie = MidiaFactory.criarMidia("Serie", nome, genero, idioma, qntEps, dataLancamento);

                    plataforma.adicionarMidia(serie);
                } catch (
                        EnumException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 5:
                try {
                    scanner.nextLine();
                    System.out.println("Digite o nome do filme");
                    nome = scanner.nextLine();
                    System.out.println("Digite o gênero do filme");
                    String generoStr = scanner.nextLine();
                    Genero genero = Genero.findByValue(generoStr);

                    System.out.println("Digite o idioma do filme");
                    String idiomaStr = scanner.nextLine();
                    Idioma idioma = Idioma.findByValue(idiomaStr);

                    System.out.println("Digite a duração do filme");
                    int duracao = Integer.parseInt(scanner.nextLine());
                    System.out.println("Digite a data de lançamento do filme");
                    String dataLancamento = scanner.nextLine();

                    Midia filme = MidiaFactory.criarMidia("Filme", nome, genero, idioma, duracao, dataLancamento);

                    plataforma.adicionarMidia(filme);
                } catch (
                        EnumException e) {
                    System.out.println(e.getMessage());
                }
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
                Midia midiaParaAvaliar = plataforma.buscarMidia(idMidia);
                if (clienteAtual.getListaJaVistas().contains(midiaParaAvaliar)) {
                    if (!midiaParaAvaliar.verificaAvaliacaoRegistrada(clienteAtual.getNomedeUsuario())) {
                        int nota = -1;
                        while (!(nota > 0 && nota <= 5)) {
                            System.out.println("Você está avaliando a mídia '" + midiaParaAvaliar.getNome() + "'. Digite sua avaliação (de 1 a 5)");
                            nota = scanner.nextInt();
                            if (!clienteAtual.ehClienteEspecialista()) {
                                midiaParaAvaliar.registrarAvaliacao(clienteAtual.getNomedeUsuario(), nota);
                            } else {
                                String comentario;
                                System.out.println("Você é um cliente especialista! Digite seu comentário");
                                comentario = scanner.nextLine();
                                midiaParaAvaliar.registrarAvaliacaoComentario(clienteAtual.getNomedeUsuario(), nota, comentario);
                            }
                        }
                        System.out.println("Média de notas de '" + midiaParaAvaliar.getNome() + "': " + midiaParaAvaliar.getMediaAvaliacoes() + " (" + midiaParaAvaliar.getQuantidadeAvaliacoes() + " avaliações)");
                        if (clienteAtual.ehAdmin()) {
                            midiaParaAvaliar.getNotasAvaliacoesMidia();
                        }
                    } else {
                        System.out.println("Você já avaliou a mídia '" + midiaParaAvaliar.getNome() + "' com a nota " + midiaParaAvaliar.getNotaAvaliacaoUsuario(clienteAtual.getNomedeUsuario()));
                    }
                } else {
                    System.out.println("Essa mídia não foi assistida por você");
                }
                break;

            case 10:
                clearConsole();
                if (clienteAtual != null) {
                    System.out.println("*  1. Filtrar mídias por nome na lista 'Para Ver'   *");
                    System.out.println("*  2. Filtrar mídias por nome na lista 'Já Vistas'  *");
                    System.out.println("*  3. Filtrar mídias por nome no catálogo geral     *");
                    System.out.println("*  4. Filtrar mídias por gênero na lista 'Para Ver' *");
                    System.out.println("*  5. Filtrar mídias por gênero na lista 'Já Vistas'*");
                    System.out.println("*  6. Filtrar mídias por gênero no catálogo geral   *");
                    System.out.println("*  7. Filtrar mídias por idioma na lista 'Para Ver' *");
                    System.out.println("*  8. Filtrar mídias por idioma na lista 'Já Vistas'*");
                    System.out.println("*  9. Filtrar mídias por idioma no catálogo geral   *");
                    System.out.println("*  10.Buscar porcentagem dos clientes com pelo menos 15 avaliações *");
                    System.out.println("*  11. Buscar melhores Mídias avaliadas *");
                    System.out.println("*  12. Buscar Mídias mais avaliadas *");
                    System.out.println("*  13. Buscar Mídias mais avaliadas por gênero *");
                    System.out.println("*  14. Buscar Mídias mais visualizadas *");
                    System.out.println("*  15. Buscar Mídias mais visualizadas por gênero *");
                    System.out.println("*  16. Buscar Cliente com mais avaliações *");
                    System.out.println("*  17. Buscar Cliente com mais Mídias assistidas *");
                }
                System.out.print("\nDigite o número da opção desejada: ");
                int op;
                try {
                    op = scanner.nextInt();
                } catch (
                        InputMismatchException e) {
                    System.out.println("Entrada inválida! Digite um número inteiro.");
                    scanner.nextLine();
                    continue;
                }
                switch (op) {

                case 1:
                    scanner.nextLine();
                    System.out.println("Digite o nome da mídia para procurar na lista 'Para Ver':");
                    String nomeMidia = scanner.nextLine();
                    clienteAtual.filtrarListaParaVer(nomeMidia);
                    break;

                case 2:
                    scanner.nextLine();
                    System.out.println("Digite o nome da mídia para procurar na lista 'Já Vistas':");
                    nomeMidia = scanner.nextLine();
                    clienteAtual.filtrarListaJaVistas(nomeMidia);
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.println("Digite o nome da mídia a ser procurada no catálogo de mídias:");
                    nomeMidia = scanner.nextLine();
                    plataforma.filtrarPorNome(nomeMidia);
                    break;

                case 4:
                    scanner.nextLine();
                    System.out.println("Gêneros disponíveis: \n" + Arrays.asList(Genero.values()));
                    System.out.println("Digite o gênero da mídia para procurar na lista 'Para Ver':");
                    String generoMidia = scanner.nextLine();
                    clienteAtual.filtrarParaVerPorGenero(generoMidia);
                    break;

                case 5:
                    scanner.nextLine();
                    System.out.println("Gêneros disponíveis: \n" + Arrays.asList(Genero.values()));
                    System.out.println("Digite o gênero da mídia para procurar na lista 'Já vistas':");
                    generoMidia = scanner.nextLine();
                    clienteAtual.filtrarJaVistasPorGenero(generoMidia);
                    break;

                case 6:
                    scanner.nextLine();
                    System.out.println("Gêneros disponíveis: \n" + Arrays.asList(Genero.values()));
                    System.out.println("Digite o gênero da mídia a ser procurada no catálogo de mídias:");
                    generoMidia = scanner.nextLine();
                    plataforma.filtrarPorGenero(generoMidia);
                    break;

                case 7:
                    scanner.nextLine();
                    System.out.println("Idiomas disponíveis: \n" + Arrays.asList(Idioma.values()));
                    System.out.println("Digite o idioma da mídia para procurar na lista 'Para Ver':");
                    String idiomaMidia = scanner.nextLine();
                    clienteAtual.filtrarParaVerPorIdioma(idiomaMidia);
                    break;

                case 8:
                    scanner.nextLine();
                    System.out.println("Idiomas disponíveis: \n" + Arrays.asList(Idioma.values()));
                    System.out.println("Digite o idioma da mídia para procurar na lista 'Já vistas':");
                    idiomaMidia = scanner.nextLine();
                    clienteAtual.filtrarJaVistasPorIdioma(idiomaMidia);
                    break;

                case 9:
                    scanner.nextLine();
                    System.out.println("Idiomas disponíveis: \n" + Arrays.asList(Idioma.values()));
                    System.out.println("Digite o idioma da mídia a ser procurada no catálogo de mídias:");
                    idiomaMidia = scanner.nextLine();
                    plataforma.filtrarPorIdioma(idiomaMidia);
                    break;

                case 10:
                    System.out.println(plataforma.PorcentagemClientesMaisQue15Aval());
                    break;

                case 11:
                    System.out.println(plataforma.buscarMelhoresMidiasAvaliadas());
                    break;

                case 12:
                    System.out.println(plataforma.buscarMidiasMaisAvaliadas());
                    break;

                case 13:
                    System.out.println(plataforma.buscarMidiasMaisAvaliadasPorGenero());
                    break;

                case 14:
                    System.out.println(plataforma.buscarMidiasMaisVisu());
                    break;

                case 15:
                    System.out.println(plataforma.buscarMidiasMaisVisuPorGenero());
                    break;

                case 16:
                    System.out.println(plataforma.getClienteComMaisAvaliacoes());
                    break;

                case 17:
                    System.out.println(plataforma.getClienteComMaisMidiasAssistidas());
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
                }
                break;

            default:
                System.out.println("Opção inválida! Tente novamente.");
                break;
            }
        }
        scanner.close();
    }

    /**
     * Limpa a saída do console.
     */

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final
        Exception e) {
            // Tratamento de exceção omitido
        }
    }
}