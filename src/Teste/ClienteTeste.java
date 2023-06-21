package Teste;

import static org.junit.jupiter.api.Assertions.*;

import codigo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

class ClienteTeste {

	    Midia serie;
	    Cliente cliente;
	    PlataformaStreaming plataforma;
	    Genero genero;
	    Idioma idioma;

		@BeforeEach
		void init() throws FileNotFoundException {
	        this.serie = new Serie("Game of Thrones", Genero.ACAO, Idioma.INGLES, 100, "12/03/2008");
	        this.cliente = new Cliente("Roberto", "robertolmg", "123456");
	        this.plataforma = new PlataformaStreaming("Netflix");
	    }

	    @Test
		@DisplayName("Método que testa adicionar midia na lista do cliente")
	    public void testAdicionarNaLista(){
	        plataforma.adicionarCliente(cliente);
	        cliente.adicionarNaLista(serie);
	        assertEquals(1, cliente.getListaParaVer().size());
	    }

	    @Test
		@DisplayName("Método que testa o retirar midia da lista do cliente")
	    public void testRetirarDaLista(){
	    	plataforma.adicionarCliente(cliente);
	        cliente.adicionarNaLista(serie);
	        cliente.retirarDaLista("Game of Thrones");
	        assertEquals(0, cliente.getListaParaVer().size());
	    }

	    @Test
		@DisplayName("Método que testa registrar audiencia de midia já vista pelo cliente")
	    public void testRegistrarNaAudiencia(){
	        cliente.registrarAudiencia(serie, Data.gerarDataAleatoria());
	        assertFalse(cliente.getListaParaVer().contains(serie));
	    }

	    /*@Test
		@DisplayName("Método que testa o regitrar nota do cliente")
	    public void testRegistrarNota(){
	        Midia titanic = new Filme(1997, "Titanic", "16/01/1998", 194, Midia.gerarGeneroAleatorio());
	        cliente.registrarAudiencia(titanic);
	        titanic.avaliarMidia(5);
	        assertEquals(5, titanic.getNota());
	    }*/
	    
	    
	    @DisplayName("Método que testa a função de filtrarListaJaVistas")
		@Test
		public void testFiltrarListaJaVistas() {
			plataforma.adicionarCliente(cliente);
			cliente.registrarAudiencia(serie, "11/06/1997");
			List<Midia> midias = cliente.filtrarListaJaVistas("Game of Thrones");
			assertEquals(1, midias.size());
		}
	    
	    @DisplayName("Método que testa a função de filtrarJaVistasPorGenero")
		@Test
		public void testFiltrarJaVistasPorGenero() {
			plataforma.adicionarCliente(cliente);
			cliente.registrarAudiencia(serie, "11/06/1997");
			List<Midia> midias = cliente.filtrarJaVistasPorGenero("Ação");
			assertEquals(1, midias.size());
		}
	    
	    @DisplayName("Método que testa a função de filtrarJaVistasPorIdioma")
		@Test
		public void testFiltrarJaVistasPorIdioma() {
			plataforma.adicionarCliente(cliente);
			cliente.registrarAudiencia(serie, "11/06/1997");
			List<Midia> midias = cliente.filtrarJaVistasPorIdioma("Inglês");
			assertEquals(1, midias.size());
		}
	    
	    @DisplayName("Método que testa a função de filtrarListaParaVer")
		@Test
		public void testFiltrarListaParaVer() {
			plataforma.adicionarCliente(cliente);
			cliente.adicionarNaLista(serie);
			List<Midia> midias = cliente.filtrarListaParaVer("Game of Thrones");
			assertEquals(1, midias.size());
		}
	    
	    @DisplayName("Método que testa a função de filtrarParaVerPorGenero")
		@Test
		public void testFiltrarParaVerPorGenero() {
			plataforma.adicionarCliente(cliente);
			cliente.adicionarNaLista(serie);
			List<Midia> midias = cliente.filtrarParaVerPorGenero("Ação");
			assertEquals(1, midias.size());
		}
	    
	    @DisplayName("Método que testa a função de filtrarParaVerPorIdioma")
		@Test
		public void testFiltrarParaVerPorIdioma() {
			plataforma.adicionarCliente(cliente);
			cliente.adicionarNaLista(serie);
			List<Midia> midias = cliente.filtrarParaVerPorIdioma("Inglês");
			assertEquals(1, midias.size());
		}
	    
	    @DisplayName("Método que testa a função de calcularQntAvalCliente")
		@Test
		public void testCalcularQntAvalCliente() {
			plataforma.adicionarCliente(cliente);
			cliente.registrarAudiencia(serie, "11/06/1997");
			serie.registrarAvaliacao("robertolmg", 5);
			assertEquals(1, cliente.calcularQntAvalCliente());
		}
}
