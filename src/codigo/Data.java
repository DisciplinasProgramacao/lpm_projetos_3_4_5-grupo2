package codigo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Data {
    public static void formatarData(LocalDateTime data, boolean semHora) {

        // Definir o formato da data e hora
        DateTimeFormatter formatador;
        if (semHora)
            formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        else
            formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        // Formatar a data e hora atual em uma String
        String dataHoraAtual = data.format(formatador);

        // Imprimir a data e hora atual formatada
        System.out.println("Data e hora atual: " + dataHoraAtual);
    }

    public static String agora() {
        // Obter a data e hora atual
        LocalDateTime agora = LocalDateTime.now();

        // Definir o formato da data e hora
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        // Formatar a data e hora atual em uma String
        String dataHoraAtual = agora.format(formatador);

        // Retorna a data e hora atual formatada
        return dataHoraAtual;
    }
}
