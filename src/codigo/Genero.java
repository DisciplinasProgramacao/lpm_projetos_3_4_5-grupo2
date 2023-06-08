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

	Genero(String string) {
	}
	
    public static Genero geraGeneroAleatorio() {
    	Genero[] values = Genero.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }
	
}