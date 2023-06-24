package Teste;



import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import codigo.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class DataTeste {
	@Test
	@DisplayName("Teste do método formatarData")
	public void testFormatarData() {
		assertEquals("13/01/2017", Data.formatarData(LocalDate.of(2017, 1, 13), true));	
	}
	
	@Test
	@DisplayName("Teste do método agoraString")
	public void testAgoraString() {
		assertEquals("24/06/2023", Data.agoraString());	
	}//É necessário mudar a data para a data atual para o teste dar certo.
	
	@Test
	@DisplayName("Teste do método converterStringParaData")
	public void testConverterStringParaData() {
		assertEquals(LocalDate.of(2017, 1, 13), Data.converterStringParaData("13/01/2017"));	
	}
	
	@Test
	@DisplayName("Teste do método ehDataDoMesAnterior para falso")
	public void testEhDataDoMesAnteriorFalse() {
		assertEquals(false, Data.ehDataDoMesAnterior(LocalDate.of(2017, 1, 13)));
	}
	
	@Test
	@DisplayName("Teste do método ehDataDoMesAnterior para verdadeiro")
	public void testEhDataDoMesAnteriorTrue() {
		assertEquals(true, Data.ehDataDoMesAnterior(LocalDate.of(2023, 05, 15)));
	}
}
