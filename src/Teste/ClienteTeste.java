package Teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import codigo.Serie;
import codigo.Cliente;

public class ClienteTeste {
    
    Serie serie = new Serie("Game of Trhones", "Aventura", "Ingles", 100, 10000);
    Cliente cliente = new Cliente("Roberto", "robertolmg", "123456");
    

    @Test
    public void adicionarNaListaTeste(){
        cliente.adicionarNaLista(serie);
        assertEquals(cliente.getListaParaVer(), serie);
    }

}
