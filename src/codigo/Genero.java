package codigo;

import java.util.Random;

/**
 * Enumeração que representa os gêneros de um filme.
 */

public enum Genero {
    ANIME("Anime"),
    AVENTURA("Aventura"),
    SUSPENSE("Suspense"),
    COMEDIA("Comédia"),
    ACAO("Ação"),
    POLICIAL("Policial"),
    ROMANCE("Romance"),
    DOCUMENTARIO("Documentário"),
    DRAMA("Drama");

    private final String descricao;

    /**
     * Construtor da enumeração Genero.
     *
     * @param descricao - a descrição do gênero.
     */

    Genero(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém a descrição do gênero.
     *
     * @return a descrição do gênero.
     */

    public String getDescricao() {
        return descricao;
    }

    /**
     * Gera um gênero aleatório.
     *
     * @return um gênero aleatório.
     */

    public static Genero geraGeneroAleatorio() {
        Genero[] values = Genero.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }

    /**
     * Busca um gênero pelo seu valor.
     *
     * @param value - o valor do gênero a ser buscado.
     * @return o gênero correspondente ao valor.
     * @throws EnumException se o gênero não for encontrado na lista.
     */

    public static Genero findByValue(String value) throws EnumException {
        for (Genero genero : Genero.values()) {
            if (genero.name().equalsIgnoreCase(value)) {
                return genero;
            }
        }
        throw new EnumException("Este gênero não foi inserido na lista!");
    }
}
