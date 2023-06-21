package codigo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A classe Data fornece métodos relacionados a manipulação e formatação de datas.
 */

public class Data {

    /**
     * Formata uma data para string.
     *
     * @param semHora - indica se a hora deve ser incluída na formatação
     * @return a data formatada como uma string
     */

    public static String formatarData(boolean semHora) {
        if (semHora)
            return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now());
        else
            return DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now());
    }

    /**
     * Obtém a data e hora atual como uma string formatada.
     *
     * @return a data e hora atual como uma string no formato "dd/MM/yyyy"
     */

    public static String agoraString() {
        LocalDateTime agora = LocalDateTime.now();

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return agora.format(formatador);
    }

    /**
     * Gera uma data aleatória formatada como string.
     *
     * @return uma data aleatória formatada como string no formato "dd/MM/yyyy"
     */

    public static String gerarDataAleatoria() {
        return formatarData(true);
    }

    /**
     * Converte uma string em uma instância de LocalDate.
     *
     * @param data - a string contendo a data no formato "dd/MM/yyyy"
     * @return a data convertida para o tipo LocalDate
     */

    public static LocalDate converterStringParaData(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formatter);
    }

    /**
     * Verifica se uma data está no mês anterior ao mês atual.
     *
     * @param date - a data a ser verificada
     * @return true se a data está no mês anterior, caso contrário, false
     */

    public static boolean ehDataDoMesAnterior(LocalDate date) {
        LocalDate dataAtual = LocalDate.now();
        LocalDate mesAnterior = dataAtual.minusMonths(1);
        return date.isAfter(mesAnterior.withDayOfMonth(1)) && date.isBefore(dataAtual.withDayOfMonth(1));
    }
}
