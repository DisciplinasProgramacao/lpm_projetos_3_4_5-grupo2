package codigo;

public class Filme extends Midia{
    private int idFilme;
    public int duracao;

    /**
     * Contrutores padrão
     */
    public Filme() {}
    
    public Filme(int idFilme, String nome, String dataLancamento, int duracao, String genero) {
        super();
        this.id = idFilme;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
        this.genero = genero;
    }

    public Filme(String nome, String genero, String idioma, int duracao, String dataLancamento) {
        super();
        this.nome = nome;
        this.genero = genero;
        this.idioma = idioma;
        this.duracao = duracao;
        this.dataLancamento = dataLancamento;
    }
    
    /**
     * Getters e Setters
     * @return
     */
    public int getIdFilme() {
        return idFilme;
    }
    public int getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.nome).append("\n");
        sb.append("Gênero: ").append(this.genero).append("\n");
        sb.append("Idioma: ").append(this.idioma).append("\n");
        sb.append("Duração: ").append(this.duracao).append(" minutos").append("\n");
        sb.append("Data de lançamento: ").append(this.dataLancamento).append("\n");
        sb.append("Audiência: ").append(this.audiencia).append("\n");
        sb.append("Nota: ").append(this.nota).append("\n");
        return sb.toString();
    }
}