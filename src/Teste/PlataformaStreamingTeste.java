package Teste;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import codigo.Cliente;
import codigo.Filme;
import codigo.Midia;
import codigo.PlataformaStreaming;
import codigo.Serie;

class PlataformaStreamingTeste {

	Serie serie;
	PlataformaStreaming plataforma;
	Midia midia;
	Cliente cliente;
	Filme filme;

	@BeforeEach
	void init() throws FileNotFoundException {
		this.serie = new Serie("The Walking Dead", "Terror", "Inglês", 512, "12/11/2012");
		this.plataforma = new PlataformaStreaming("Netflix");
		this.cliente = new Cliente("Flávia", "flasriibeiro", "12345");
		this.filme = new Filme("Harry Potter", "Ficção Científica", "Inglês", 3500, "20/10/2001");
	}

	@DisplayName("Método que testa a função de buscarSerie")
	@Test
	void testBuscarSerie() {
		plataforma.adicionarMidia(serie);
		assertEquals("The Walking Dead", plataforma.buscarMidia(("The Walking Dead")).getNome());
	}

	@DisplayName("Método que testa a função de login")
	@Test
	public void testLogin() {
		plataforma.adicionarCliente(cliente);
		assertEquals(cliente, plataforma.login("flasriibeiro", "12345"));
	}

	@DisplayName("Método que testa a função de adicionarMidia")
	@Test
	public void testAdicionarMidia() {
		plataforma.adicionarMidia(filme);
		List<Midia> midias = plataforma.filtrarPorGenero("Ficção Científica");
		assertEquals(1, midias.size());
	}

	@DisplayName("Método que testa a função de filtrarPorGenero")
	@Test
	public void testFiltrarPorGenero() {
		plataforma.adicionarMidia(filme);
		List<Midia> midias = plataforma.filtrarPorGenero("Ficção Científica");
		assertEquals(1, midias.size());
	}

	@DisplayName("Método que testa a função de filtrarPorIdioma")
	@Test
	public void testFiltrarPorIdioma() {
		plataforma.adicionarMidia(serie);
		List<Midia> midias = plataforma.filtrarPorIdioma("Inglês");
		assertEquals(1, midias.size());
	}

	@DisplayName("Método que testa a função de logoff do Cliente")
	@Test
	public void testLogoff() {
		plataforma.adicionarCliente(cliente);
		plataforma.logoff();
		assertNull(plataforma.getClienteAtual());
	}

	@DisplayName("Método que testa a função de buscarPorMidia")
	@Test
	public void testBuscarPorMidia() {
		plataforma.adicionarMidia(filme);
		assertEquals(filme, plataforma.buscarMidia("Harry Potter"));
	}
	
	@DisplayName("Método que testa a função de filtrarPorQntdEps")
	@Test
	public void testfiltrarPorQntEps() {
		plataforma.adicionarMidia(serie);
		List<Serie> series = plataforma.filtrarPorQntEps(512);
		assertEquals(1, series.size());
	}
	
	@DisplayName("Método que testa a função de registrarAudiencia")
	@Test
	public void testRegistrarAudiencia() {
		serie.setAudiencia(32);
		plataforma.adicionarMidia(serie);
		assertEquals(32, plataforma.registrarAudiencia(serie));
	}

	@Test
	@DisplayName("Método que testa a função de adicionarCliente")
	void testAdicionarCliente() {
		plataforma.adicionarCliente(cliente);

		Cliente cliente2 = new Cliente("Flávia", "flasriibeiro", "12345");;
		plataforma.adicionarCliente(cliente2);

		assertEquals(1, plataforma.getClientes().size());
	}

}
