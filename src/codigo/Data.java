package codigo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class Data {
    public static String formatarData(LocalDate data, boolean semHora) {

        // Definir o formato da data e hora
        DateTimeFormatter formatador;
        if (semHora)
            formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        else
            formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        // Formatar a data em uma String
        String dataHoraFormatada = data.format(formatador);

        // Imprimir a data e hora formatada
        //System.out.println("Data e hora atual: " + dataHoraAtual);

        return dataHoraFormatada;
    }

    public static String agoraString() {
        // Obter a data e hora atual
        LocalDateTime agora = LocalDateTime.now();

        // Definir o formato da data e hora
        //DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Formatar a data e hora atual em uma String
        String dataHoraAtual = agora.format(formatador);

        // Retorna a data e hora atual formatada
        return dataHoraAtual;
    }

    public static String gerarDataAleatoria() {
        long diaMin = LocalDate.of(2023, 1, 1).toEpochDay();
        long diaMax = LocalDate.of(2023, 4, 30).toEpochDay();
        long diaAleatorio = ThreadLocalRandom.current().nextLong(diaMin, diaMax);

        LocalDate dataAleatoria = LocalDate.ofEpochDay(diaAleatorio);

        return formatarData(dataAleatoria, true);
    }

    public static LocalDate converterStringParaData(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formatter);
    }

    public static boolean ehDataDoMesAnterior(LocalDate date) {
        LocalDate dataAtual = LocalDate.now();
        LocalDate mesAnterior = dataAtual.minusMonths(1);

        return date.isAfter(mesAnterior.withDayOfMonth(1)) && date.isBefore(dataAtual.withDayOfMonth(1));
    }
}
