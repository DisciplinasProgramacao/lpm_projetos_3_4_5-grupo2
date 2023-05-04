package Teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import codigo.Serie;
import codigo.Cliente;

public class ClienteTeste {
    

    Serie serie;
    Cliente cliente;

	@BeforeEach
	void init() {
        serie = new Serie("Game of Trhones", "Aventura", "Ingles", 100, 10000);
        cliente = new Cliente("Roberto", "robertolmg", "123456");
    }


    @Test
    public void testAdicionarNaLista(){
        cliente.adicionarNaLista(serie);
        assertEquals(1, cliente.getListaParaVer().size());
    }

    @Test
    public void testRetirarDaLista(){
        cliente.adicionarNaLista(serie);
        cliente.retirarDaLista("Game of Trhones");
        assertEquals(0, cliente.getListaParaVer().size());
    }

    @Test
    public void testRegistrarNaAudiencia(){
        cliente.registrarAudiencia(serie);
        assertEquals(1, cliente.getListaJaVistas().size());
    }
}
