package codigo;

import java.util.Random;

public abstract class Midia {
    public final static String[] GENEROS = {"Drama", "Comédia", "Terror", "Ficção Científica", "Ação", "Policial",
            "Fantasia"};
    protected int id;
    protected String nome;
    protected String genero;
    protected String idioma;
    protected int audiencia;
    protected String dataLancamento;

    protected int nota;

    /**
     * Construtor padrão
     */
    public Midia() {
        super();
    }

    public static String gerarGeneroAleatorio(){
        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(6);

        return GENEROS[numeroAleatorio];
    }

    /**
     * Método que registra audiência de determinada série
     */
    public int  registraAudiencia() {
        return this.audiencia ++;
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

    public int getIdMidia(){
        return this.id;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNota() {
        return this.nota;
    }
    
    /**
     * Método que avalia midia
     * @param nota
     */
    public void avaliarMidia(int nota){
        this.nota = nota;
    }

}
