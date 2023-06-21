package codigo;

public class Filme extends Midia{
    private int idFilme;
    public int duracao;

    /**
     * Contrutores padrão
     */
    public Filme() {}
    
    public Filme(int idFilme, String nome, String dataLancamento, int duracao) {
        super();
        this.id = idFilme;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
        this.idioma = Midia.gerarIdiomaAleatorio();
		this.genero = Midia.gerarGeneroAleatorio();
    }

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
     * Getters e Setters
     * @return
     */
    public int getIdFilme() {
        return idFilme;
    }
    public int getDuracaoFilme() {
        return this.duracao;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("## ID ").append(id).append(" ##\n");
        sb.append("Filme: ").append(this.nome).append("\n");
        sb.append("Gênero: ").append(this.genero).append("\n");
        sb.append("Idioma: ").append(idioma).append("\n");
        sb.append("Duração: ").append(this.duracao).append(" minutos").append("\n");
        sb.append("Data de lançamento: ").append(this.dataLancamento).append("\n");
        return sb.toString();
    }
}