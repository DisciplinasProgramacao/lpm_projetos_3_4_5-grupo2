package Teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import codigo.PlataformaStreaming;
import codigo.Serie;

class PlataformaStreamingTeste {

	Serie serie;
	PlataformaStreaming plataforma;

	@BeforeEach
	void init() {
		this.serie = new Serie("The Walking Dead", "Terror", "Inglês", 512, 5);
		this.plataforma = new PlataformaStreaming("Netflix");
	}

	@DisplayName("Método que testa a classe buscarSerie")
	@Test
	void testBuscarSerie() {
		plataforma.adicionarSerie(serie);
		assertEquals("The Walking Dead", plataforma.buscarSerie(("The Walking Dead")).getNome());
	}

}
