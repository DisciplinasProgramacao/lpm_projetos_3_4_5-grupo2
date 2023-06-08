package codigo;

import java.util.Random;

public enum Idioma {
	INGLES("Inglês"),
	PORTUGUES("Português"),
	ESPANHOL("Espanhol"),
	FRANCES("Francês"),
	COREANO("Coreano"),
	JAPONES("Japonês");
	
	Idioma(String string) {
	}
	
    public static Idioma geraIdiomaAleatorio() {
    	Idioma[] values = Idioma.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }
}
