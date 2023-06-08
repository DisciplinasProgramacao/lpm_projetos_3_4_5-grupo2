package codigo;

import java.util.HashMap;

public abstract class Midia {
    Genero genero;
	Idioma idioma;
    protected int id;
    protected static int ultimoId;
    protected String nome;
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

    /**
     * Método que gera generos aleatórios para cada mídia
     * @return
     */
    public static Genero gerarGeneroAleatorio(){
        return Genero.geraGeneroAleatorio();
    }
    
    /**
     * Método que gera idiomas aleatórios para cada mídia
     * @return
     */
    public static Idioma gerarIdiomaAleatorio(){
        return Idioma.geraIdiomaAleatorio();
    }


    /**
     * Método que registra audiência de determinada série
     */
    public int  registraAudiencia() {
        return this.audiencia ++;
    }

    /**
     * Getters e setters
     * @return
     */
    public String getNome() {
        return this.nome;
    }

    public int getAudiencia() {
        return audiencia;
    }

    public void setAudiencia(int audiencia) {
        this.audiencia = audiencia;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public int getQuantidadeAvaliacoes(){
        return this.avaliacoes.size();
    }
    
    public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

    /**
     * Método que registra avaliação
     * @param loginUsuario
     * @param notaDada
     */
    public void registrarAvaliacao(String loginUsuario, int notaDada){
        Avaliacao avaliacao = new Avaliacao(notaDada);
        if (notaDada > 1 && notaDada <=5)
            this.avaliacoes.put(loginUsuario, avaliacao);
        else
            System.out.println("Nota inválida. Ela deve ser de 1 a 5.");
    }

    /**
     * Método que registra avaliação com comentário 
     * 
     * @param loginUsuario
     * @param notaDada
     * @param comentario
     */
    public void registrarAvaliacaoComentario(String loginUsuario, int notaDada, String comentario){
        Avaliacao avaliacao = new Avaliacao(notaDada, comentario);
        if (notaDada > 1 && notaDada <=5)
            this.avaliacoes.put(loginUsuario, avaliacao);
        else
            System.out.println("Nota inválida. Ela deve ser de 1 a 5.");
    }

    /**
     * Método que validade avaliação
     * @param loginUsuario
     * @return
     */
    public boolean verificaAvaliacaoRegistrada (String loginUsuario){
        if (this.avaliacoes.containsKey(loginUsuario)){
           return true;
        }
        return false;
    }

    /**
     * Método get que acessa a avaliação do usuario
     * 
     * @param loginUsuario
     * @return
     */
    public int getNotaAvaliacaoUsuario (String loginUsuario) {
        return this.avaliacoes.get(loginUsuario).getNota();
    }

    /**
     * Método que calcula a media de avaliações
     * @return
     */
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

    /**
     * Método que calcula a média das notas dadas nas avaliações
     */
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
