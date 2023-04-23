package Teste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import codigo.Serie;

class SerieTeste {

	Serie serie;

	@BeforeEach
	void init() {
		this.serie = new Serie();
	}

	@Test
	@DisplayName("Método que testa o registro de audiência de uma série")
	void testRegistraAudiencia() {
		this.serie.setAudiencia(4);
		Assertions.assertEquals(8, this.serie.registraAudiencia());
	}

}
