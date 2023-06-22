package codigo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class Data {

    /**
     * Formata a data no formato especificado.
     *
     * @param data     A data a ser formatada.
     * @param semHora  Define se a hora deve ser omitida no formato.
     * @return A data formatada.
     */

    public static String formatarData(LocalDate data, boolean semHora) {
        DateTimeFormatter formatador;
        if (semHora)
            formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        else
            formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = data.format(formatador);
        return dataHoraFormatada;
    }

    /**
     * Obtém a representação da data e hora atual como uma string.
     *
     * @return A data e hora atual formatada como string.
     */

    public static String agoraString() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataHoraAtual = agora.format(formatador);
        return dataHoraAtual;
    }

    /**
     * Gera uma data aleatória no intervalo de 1º de janeiro de 2023 a 30 de abril de 2023.
     *
     * @return A data aleatória formatada como string.
     */

    public static String gerarDataAleatoria() {
        long diaMin = LocalDate.of(2023, 1, 1).toEpochDay();
        long diaMax = LocalDate.of(2023, 4, 30).toEpochDay();
        long diaAleatorio = ThreadLocalRandom.current().nextLong(diaMin, diaMax);
        LocalDate dataAleatoria = LocalDate.ofEpochDay(diaAleatorio);
        return formatarData(dataAleatoria, true);
    }

    /**
     * Converte uma string no formato "dd/MM/yyyy" para um objeto LocalDate.
     *
     * @param data A string contendo a data.
     * @return O objeto LocalDate correspondente à data fornecida.
     */

    public static LocalDate converterStringParaData(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formatter);
    }

    /**
     * Verifica se uma data está no mês anterior ao mês atual.
     *
     * @param date A data a ser verificada.
     * @return true se a data estiver no mês anterior, caso contrário, false.
     */

    public static boolean ehDataDoMesAnterior(LocalDate date) {
        LocalDate dataAtual = LocalDate.now();
        LocalDate mesAnterior = dataAtual.minusMonths(1);
        return date.isAfter(mesAnterior.withDayOfMonth(1)) && date.isBefore(dataAtual.withDayOfMonth(1));
    }
}
