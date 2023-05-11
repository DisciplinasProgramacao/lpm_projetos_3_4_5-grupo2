package Teste;

import static org.junit.jupiter.api.Assertions.*;

import codigo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class ClienteTeste {

	    Midia serie;
	    Cliente cliente;
	    PlataformaStreaming plataforma;

		@BeforeEach
		void init() throws FileNotFoundException {
	        this.serie = new Serie("Game of Thrones", "Aventura", "Ingles", 100, "12/03/2008");
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
	        cliente.adicionarNaLista(serie);
	        cliente.retirarDaLista("Game of Trhones");
	        assertEquals(0, cliente.getListaParaVer().size());
	    }

	    @Test
		@DisplayName("Método que testa registrar audiencia de midia já vista pelo cliente")
	    public void testRegistrarNaAudiencia(){
	        cliente.registrarAudiencia(serie);
	        assertEquals(1, cliente.getListaJaVistas().size());
	    }

	    /*@Test
		@DisplayName("Método que testa o regitrar nota do cliente")
	    public void testRegistrarNota(){
	        Midia titanic = new Filme(1997, "Titanic", "16/01/1998", 194, Midia.gerarGeneroAleatorio());
	        cliente.registrarAudiencia(titanic);
	        titanic.avaliarMidia(5);
	        assertEquals(5, titanic.getNota());
	    }*/

}
