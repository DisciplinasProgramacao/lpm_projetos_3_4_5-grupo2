package codigo;

import java.util.Random;

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

    private Genero(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
	
    public static Genero geraGeneroAleatorio() {
    	Genero[] values = Genero.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }
    
    public static String geraDescricaoAleatoria() {
        Genero generoAleatorio = geraGeneroAleatorio();
        return generoAleatorio.getDescricao();
    }
    
    public static Genero findByValue(String value) {
        for (Genero genero : Genero.values()) {
            if (genero.name().equalsIgnoreCase(value)) {
                return genero;
            }
        }
        throw new EnumException("Este gênero não foi inserido na lista!");
    }
}