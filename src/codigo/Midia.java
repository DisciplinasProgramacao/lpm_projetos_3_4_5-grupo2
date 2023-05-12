package codigo;

import java.util.HashMap;
import java.util.Random;

public abstract class Midia {
    public final static String[] GENEROS = {"Drama", "Comédia", "Terror", "Ficção Científica", "Ação", "Policial",
            "Fantasia"};
    public final static String[] IDIOMAS = {"Inglês", "Português", "Espanhol", "Francês", "Coreano", "Japonês"};
    protected int id;
    protected String nome;
    protected String genero;
    protected String idioma;
    protected int audiencia;
    protected String dataLancamento;
    public HashMap <String, Integer> avaliacoes;


    /**
     * Construtor padrão
     */
    public Midia() {
        super();
        avaliacoes = new HashMap<>();
    }

    public static String gerarGeneroAleatorio(){
        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(6);

        return GENEROS[numeroAleatorio];
    }

    public static String gerarIdiomaAleatorio(){
        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(6);

        return IDIOMAS[numeroAleatorio];
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

    public int getQuantidadeAvaliacoes(){
        return this.avaliacoes.size();
    }

    public void registrarAvaliacao(String loginUsuario, int notaDada){
            this.avaliacoes.put(loginUsuario, notaDada);
    }

    public boolean verificaAvaliacaoRegistrada (String loginUsuario){
        if (this.avaliacoes.containsKey(loginUsuario)){
           return true;
        }
        return false;
    }

    public int getNotaAvaliacaoUsuario (String loginUsuario) {
        return this.avaliacoes.get(loginUsuario);
    }

    public double getMediaAvaliacoes(){
        int soma = 0;
        for (int nota : this.avaliacoes.values()){
            soma += nota;
        }
        double media = soma / (double) this.avaliacoes.size();
        return media;
    }



    
    


}
