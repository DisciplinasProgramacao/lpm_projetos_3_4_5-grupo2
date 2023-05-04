package codigo;

public class Filme extends Midia{
    private int idFilme;
    public int duracao;

    public Filme() {}
    
    public Filme(int idFilme, String nome, String dataLancamento, int duracao) {
        this.idFilme = idFilme;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
    }

    public Filme(String nome, String genero, String idioma, int duracao, int audiencia) {
        super();
        this.nome = nome;
        this.genero = genero;
        this.idioma = idioma;
        this.duracao = duracao;
        this.audiencia = audiencia;
    }

    public int getIdFilme() {
        return idFilme;
    }
    public int getDuracao() {
        return duracao;
    }
}