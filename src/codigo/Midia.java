package codigo;
/**
 * Classe Midia
 *
 * @author Lucas Figueira
 *
 */
public abstract class Midia {
    private final String[] GENEROS = {"Drama", "Comédia", "Terror", "Ficção Científica", "Ação", "Policial",
            "Fantasia"};
    protected String nome;
    protected String genero;
    protected String idioma;
    protected int audiencia;
    protected String dataLancamento;

    public Midia() {
        super();
    }

    /**
     * Método que registra audiência de determinada série
     */
    public int  registraAudiencia() {
        return this.audiencia += this.audiencia;
    }

    public String getNome() {
        return this.nome;
    }

    public int getAudiencia() {
        return audiencia;
    }

    public void setAudiencia(int audiencia) {
        this.audiencia = audiencia;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
