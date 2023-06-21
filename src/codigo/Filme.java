package codigo;

/**
 * Esta classe representa um objeto de mídia do tipo Filme, que estende a classe {@link Midia}.
 * Um Filme possui uma duração específica.
 */

public class Filme extends Midia{
    public int duracao;

    /**
     * Construtor padrão da classe Filme.
     */

    public Filme() {}

    /**
     * Construtor da classe Filme que inicializa os atributos com os valores fornecidos.
     *
     * @param idFilme        - O ID do filme.
     * @param nome           - O nome do filme.
     * @param dataLancamento - A data de lançamento do filme.
     * @param duracao        - A duração do filme em minutos.
     */


    public Filme(int idFilme, String nome, String dataLancamento, int duracao) {
        super();
        this.id = idFilme;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
        this.idioma = Midia.gerarIdiomaAleatorio();
		this.genero = Midia.gerarGeneroAleatorio();
    }

    /**
     * Construtor da classe Filme que inicializa os atributos com os valores fornecidos.
     * Um novo ID é gerado automaticamente.
     *
     * @param nome           - O nome do filme.
     * @param genero         - O gênero do filme.
     * @param idioma         - O idioma do filme.
     * @param duracao        - A duração do filme em minutos.
     * @param dataLancamento - A data de lançamento do filme.
     */

    public Filme(String nome, Genero genero, Idioma idioma, int duracao, String dataLancamento) {
        super();
        int novoId = Midia.getUltimoIdMidia() + 1;
        this.id = novoId;
        this.nome = nome;
        this.genero = genero;
        this.idioma = idioma;
        this.duracao = duracao;
        this.dataLancamento = dataLancamento;
        Midia.setUltimoId(novoId);
    }

    /**
     * Obtém a duração do filme.
     *
     * @return A duração do filme em minutos.
     */

    public int getDuracaoFilme() {
        return this.duracao;
    }

    /**
     * Retorna uma representação em formato de string do objeto Filme.
     *
     * @return Uma string contendo os detalhes do filme, incluindo ID, nome, gênero, idioma, duração e data de lançamento.
     */

    @Override
    public String toString() {
        return "## ID " + id + " ##\n" +
                "Filme: " + this.nome + "\n" +
                "Gênero: " + this.genero + "\n" +
                "Idioma: " + idioma + "\n" +
                "Duração: " + this.duracao + " minutos" + "\n" +
                "Data de lançamento: " + this.dataLancamento + "\n";
    }
}