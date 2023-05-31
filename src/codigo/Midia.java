package codigo;

import java.util.HashMap;
import java.util.Random;

public abstract class Midia {
    public final static String[] GENEROS = {"Drama", "Comédia", "Terror", "Ficção Científica", "Ação", "Policial",
            "Fantasia"};
    public final static String[] IDIOMAS = {"Inglês", "Português", "Espanhol", "Francês", "Coreano", "Japonês"};
    protected int id;
    protected static int ultimoId;
    protected String nome;
    protected String genero;
    protected String idioma;
    protected int audiencia;
    protected String dataLancamento;
    public HashMap <String, Avaliacao> avaliacoes;


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

    public String getDataLancamento() {return this.dataLancamento; }

    public static int getUltimoIdMidia(){
        return ultimoId;
    }
    public static void setUltimoId(int ultimoIdMidia) {
        ultimoId = ultimoIdMidia;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getQuantidadeAvaliacoes(){
        return this.avaliacoes.size();
    }

    public void registrarAvaliacao(String loginUsuario, int notaDada){
        Avaliacao avaliacao = new Avaliacao(notaDada);
        if (notaDada > 1 && notaDada <=5)
            this.avaliacoes.put(loginUsuario, avaliacao);
        else
            System.out.println("Nota inválida. Ela deve ser de 1 a 5.");
    }

    public void registrarAvaliacaoComentario(String loginUsuario, int notaDada, String comentario){
        Avaliacao avaliacao = new Avaliacao(notaDada, comentario);
        if (notaDada > 1 && notaDada <=5)
            this.avaliacoes.put(loginUsuario, avaliacao);
        else
            System.out.println("Nota inválida. Ela deve ser de 1 a 5.");
    }

    public boolean verificaAvaliacaoRegistrada (String loginUsuario){
        if (this.avaliacoes.containsKey(loginUsuario)){
           return true;
        }
        return false;
    }

    public int getNotaAvaliacaoUsuario (String loginUsuario) {
        return this.avaliacoes.get(loginUsuario).getNota();
    }

    public double getMediaAvaliacoes(){
        int soma = 0;
        double media = 0;
        for (Avaliacao avaliacao : this.avaliacoes.values()){
            soma += avaliacao.getNota();
        }

        if (!this.avaliacoes.isEmpty()) {
            media = soma / (double) this.avaliacoes.size();
        }

        return media;
    }

    public void getNotasAvaliacoesMidia() {
        if (!this.avaliacoes.isEmpty()) {
            System.out.println("Notas dessa mídia:");
            for (HashMap.Entry<String, Avaliacao> entrada : this.avaliacoes.entrySet()) {
                String comentario = entrada.getValue().getComentario();
                if (comentario == null) comentario = "(Sem comentário)";
                System.out.println("Nota: " + entrada.getValue().getNota() + " | Comentário: " + comentario +  " | Usuário responsável pela nota: " + entrada.getKey() + "\n");
            }
        } else {
            System.out.println("Não há notas registradas para essa mídia.");
        }
    }




    
    


}
