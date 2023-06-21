package codigo;

import java.util.HashMap;

/**
 * A classe abstrata Midia representa uma mídia genérica.
 */

public abstract class Midia {

    Genero genero; // Gênero da mídia
    Idioma idioma; // Idioma da mídia
    protected int id; // ID da mídia
    protected static int ultimoId; // Último ID de mídia atribuído
    protected String nome; // Nome da mídia
    protected int audiencia; // Audiência da mídia
    protected String dataLancamento; // Data de lançamento da mídia
    public HashMap<String, Avaliacao> avaliacoes; // Avaliações da mídia (usuário -> avaliação)


    /**
     * Construtor padrão da classe Midia.
     * Inicializa a estrutura de avaliações.
     */

    public Midia() {
        super();
        avaliacoes = new HashMap<>();
    }

    /**
     * Gera um gênero aleatório.
     *
     * @return Um gênero aleatório.
     */

    public static Genero gerarGeneroAleatorio() {
        return Genero.geraGeneroAleatorio();
    }

    /**
     * Gera um idioma aleatório.
     *
     * @return Um idioma aleatório.
     */

    public static Idioma gerarIdiomaAleatorio() {
        return Idioma.geraIdiomaAleatorio();
    }

    /**
     * Registra a audiência da mídia e retorna o valor atualizado.
     *
     * @return A audiência atualizada da mídia.
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
     * @param audiencia - A audiência da mídia.
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
     * @param idioma - O idioma da mídia.
     */

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    /**
     * Define o nome da mídia.
     *
     * @param nome - O nome da mídia.
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
     * Obtém o último ID da mídia.
     *
     * @return O último ID da mídia.
     */

    public static int getUltimoIdMidia() {
        return ultimoId;
    }

    /**
     * Define o último ID da mídia.
     *
     * @param ultimoIdMidia - O último ID da mídia.
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
     * @param genero O gênero da mídia.
     */

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * Registra uma avaliação para a mídia.
     *
     * @param loginUsuario - O login do usuário que fez a avaliação.
     * @param notaDada     - A nota dada na avaliação.
     */

    public void registrarAvaliacao(String loginUsuario, int notaDada) {
        Avaliacao avaliacao = new Avaliacao(notaDada);
        if (notaDada > 1 && notaDada <= 5) {
            this.avaliacoes.put(loginUsuario, avaliacao);
        } else {
            System.out.println("Nota inválida. Ela deve ser de 1 a 5.");
        }
    }

    /**
     * Registra uma avaliação com comentário para a mídia.
     *
     * @param loginUsuario - O login do usuário que fez a avaliação.
     * @param notaDada     - A nota dada na avaliação.
     * @param comentario   - O comentário da avaliação.
     */

    public void registrarAvaliacaoComentario(String loginUsuario, int notaDada, String comentario) {
        Avaliacao avaliacao = new Avaliacao(notaDada, comentario);
        if (notaDada > 1 && notaDada <= 5) {
            this.avaliacoes.put(loginUsuario, avaliacao);
        } else {
            System.out.println("Nota inválida. Ela deve ser de 1 a 5.");
        }
    }

    /**
     * Verifica se uma avaliação foi registrada para um usuário.
     *
     * @param loginUsuario - O login do usuário.
     * @return true se a avaliação foi registrada, caso contrário, false.
     */

    public boolean verificaAvaliacaoRegistrada(String loginUsuario) {
        return this.avaliacoes.containsKey(loginUsuario);
    }

    /**
     * Obtém a nota da avaliação dada por um usuário.
     *
     * @param loginUsuario - O login do usuário.
     * @return A nota da avaliação dada pelo usuário.
     */

    public int getNotaAvaliacaoUsuario(String loginUsuario) {
        return this.avaliacoes.get(loginUsuario).getNota();
    }

    /**
     * Calcula a média das avaliações da mídia.
     *
     * @return A média das avaliações da mídia.
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
     * Obtém as notas e comentários das avaliações da mídia.
     */

    public void getNotasAvaliacoesMidia() {
        if (!this.avaliacoes.isEmpty()) {
            System.out.println("Notas dessa mídia:");
            for (HashMap.Entry<String, Avaliacao> entrada : this.avaliacoes.entrySet()) {
                String comentario = entrada.getValue().getComentario();
                if (comentario == null) {
                    comentario = "(Sem comentário)";
                    System.out.println("Nota: " + entrada.getValue().getNota() + " | Comentário: " + comentario + " | Usuário responsável pela nota: " + entrada.getKey() + "\n");
                } else {
                    System.out.println("Nota: " + entrada.getValue().getNota() + " | Comentário: " + comentario + " | Usuário responsável pela nota: " + entrada.getKey() + "\n");
                }
            }
        } else {
            System.out.println("Não há notas registradas para essa mídia.");
        }
    }
}
