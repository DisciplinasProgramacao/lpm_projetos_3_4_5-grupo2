package Teste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import codigo.Filme;
import codigo.Midia;

class FilmeTeste {

	Midia filme;

	@BeforeEach
	void init() {
		this.filme = new Filme();
	}

	@Test
	@DisplayName("Método que testa o registro de audiência de um filme")
	void testRegistraAudiencia() {
		this.filme.setAudiencia(4);
		Assertions.assertEquals(4, this.filme.registraAudiencia());
	}

}
