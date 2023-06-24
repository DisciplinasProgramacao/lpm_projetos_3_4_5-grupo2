package codigo;

import java.util.HashMap;

/**
 * A classe abstrata que representa uma mídia.
 */

public abstract class Midia {
    Genero genero;
    Idioma idioma;
    protected int id;
    protected static int ultimoId;
    protected String nome;
    protected int audiencia;
    protected String dataLancamento;
    public HashMap<String, Avaliacao> avaliacoes;

    /**
     * Construtor padrão da classe Midia.
     */

    public Midia() {
        super();
        avaliacoes = new HashMap<>();
    }

    /**
     * Gera um gênero aleatório para a mídia.
     *
     * @return O gênero gerado aleatoriamente.
     */

    public static Genero gerarGeneroAleatorio() {
        return Genero.geraGeneroAleatorio();
    }

    /**
     * Gera um idioma aleatório para a mídia.
     *
     * @return O idioma gerado aleatoriamente.
     */

    public static Idioma gerarIdiomaAleatorio() {
        return Idioma.geraIdiomaAleatorio();
    }

    /**
     * Registra a audiência da mídia.
     *
     * @return A audiência atualizada.
     */

    public int registraAudiencia() {
        return this.audiencia++;
    }

    /**
     * Obtém o nome da mídia.
     *
     * @return O nome da mídia.
     */

    public String getNome() {
        return this.nome;
    }

    /**
     * Obtém a audiência da mídia.
     *
     * @return A audiência da mídia.
     */

    public int getAudiencia() {
        return this.audiencia;
    }

    /**
     * Define a audiência da mídia.
     *
     * @param audiencia A nova audiência da mídia.
     */

    public void setAudiencia(int audiencia) {
        this.audiencia = audiencia;
    }

    /**
     * Obtém o idioma da mídia.
     *
     * @return O idioma da mídia.
     */

    public Idioma getIdioma() {
        return idioma;
    }

    /**
     * Define o idioma da mídia.
     *
     * @param idioma O novo idioma da mídia.
     */

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    /**
     * Define o nome da mídia.
     *
     * @param nome O novo nome da mídia.
     */

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o ID da mídia.
     *
     * @return O ID da mídia.
     */

    public int getIdMidia() {
        return this.id;
    }

    /**
     * Obtém a data de lançamento da mídia.
     *
     * @return A data de lançamento da mídia.
     */

    public String getDataLancamento() {
        return this.dataLancamento;
    }

    /**
     * Obtém o último ID de mídia.
     *
     * @return O último ID de mídia.
     */

    public static int getUltimoIdMidia() {
        return ultimoId;
    }

    /**
     * Define o último ID de mídia.
     *
     * @param ultimoIdMidia O novo último ID de mídia.
     */

    public static void setUltimoId(int ultimoIdMidia) {
        ultimoId = ultimoIdMidia;
    }

    /**
     * Obtém a quantidade de avaliações da mídia.
     *
     * @return A quantidade de avaliações da mídia.
     */

    public int getQuantidadeAvaliacoes() {
        return this.avaliacoes.size();
    }

    /**
     * Obtém o gênero da mídia.
     *
     * @return O gênero da mídia.
     */

    public Genero getGenero() {
        return genero;
    }

    /**
     * Define o gênero da mídia.
     *
     * @param genero O novo gênero da mídia.
     */

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Registra uma avaliação para a mídia.
     *
     * @param loginUsuario O login do usuário responsável pela avaliação.
     * @param notaDada     A nota dada na avaliação.
     */

    public void registrarAvaliacao(String loginUsuario, int notaDada) {
        Avaliacao avaliacao = new Avaliacao(notaDada);
        if (notaDada > 1 && notaDada <= 5)
            this.avaliacoes.put(loginUsuario, avaliacao);
        else
            System.out.println("Nota inválida. Ela deve ser de 1 a 5.");
    }

    /**
     * Registra uma avaliação com comentário para a mídia.
     *
     * @param loginUsuario O login do usuário responsável pela avaliação.
     * @param notaDada     A nota dada na avaliação.
     * @param comentario   O comentário da avaliação.
     */

    public void registrarAvaliacaoComentario(String loginUsuario, int notaDada, String comentario) {
        Avaliacao avaliacao = new Avaliacao(notaDada, comentario);
        if (notaDada > 1 && notaDada <= 5)
            this.avaliacoes.put(loginUsuario, avaliacao);
        else
            System.out.println("Nota inválida. Ela deve ser de 1 a 5.");
    }

    /**
     * Verifica se uma avaliação foi registrada para o usuário especificado.
     *
     * @param loginUsuario O login do usuário.
     * @return true se uma avaliação foi registrada, caso contrário, false.
     */

    public boolean verificaAvaliacaoRegistrada(String loginUsuario) {
        if (this.avaliacoes.containsKey(loginUsuario)) {
            return true;
        }
        return false;
    }

    /**
     * Obtém a nota da avaliação para o usuário especificado.
     *
     * @param loginUsuario O login do usuário.
     * @return A nota da avaliação.
     */

    public int getNotaAvaliacaoUsuario(String loginUsuario) {
        return this.avaliacoes.get(loginUsuario).getNota();
    }

    /**
     * Calcula a média das notas de todas as avaliações da mídia.
     *
     * @return A média das notas das avaliações.
     */

    public double getMediaAvaliacoes() {
        int soma = 0;
        double media = 0;
        for (Avaliacao avaliacao : this.avaliacoes.values()) {
            soma += avaliacao.getNota();
        }
        if (!this.avaliacoes.isEmpty()) {
            media = soma / (double) this.avaliacoes.size();
        }
        return media;
    }


    /**
     * Exibe as notas das avaliações da mídia.
     */

    public String getNotasAvaliacoesMidia() {
        StringBuilder notasAvaliacoes = new StringBuilder();

        if (!this.avaliacoes.isEmpty()) {
            notasAvaliacoes.append("Notas dessa mídia:\n");
            for (HashMap.Entry<String, Avaliacao> entrada : this.avaliacoes.entrySet()) {
                String comentario = entrada.getValue().getComentario();
                if (comentario == null)
                    comentario = "(Sem comentário)";
                notasAvaliacoes.append("Nota: ").append(entrada.getValue().getNota())
                    .append(" | Comentário: ").append(comentario)
                    .append(" | Usuário responsável pela nota: ").append(entrada.getKey())
                    .append("\n\n");
            }
        } else {
            notasAvaliacoes.append("Não há notas registradas para essa mídia.\n");
        }

        return notasAvaliacoes.toString();
    }
    
//    public String toStringMelhoresAvaliações() {
//		StringBuilder str = new StringBuilder();
//    	for(int i = 1; i <= 10; i++) {
//    		str.append(i + "º-");
//    		str.append(getNome() + " - " + getQuantidadeAvaliacoes());
//    		str.append("\n");
//    	}
//    	return str.toString();
//    }
}
