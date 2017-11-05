package com.example.java8.dates;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * Created by eduardo on 05/11/17.
 */
public class DateExample {

    public static void main(String[] args) {

        //hora agora
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        //inserir uma data
        LocalDate olimpiadas = LocalDate.of(2023, Month.APRIL, 5);

        //vrificar periodo entre datas
        Period period = Period.between(localDate, olimpiadas);
        System.out.println(period.getYears());

        //adicionar periodo na data
        LocalDate plusYears = olimpiadas.plusYears(5);
        System.out.println(plusYears);

        //formatar data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateFormat = plusYears.format(formatter);
        System.out.println(dateFormat);

        //formatar data e hora
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        LocalDateTime localDateTime = LocalDateTime.now();
        final String formatDateTime = localDateTime.format(dateTimeFormatter);
        System.out.println(formatDateTime);

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.SHORT)
                .withLocale(new Locale("pt", "br"));
        agora.format(formatador); //08/04/14 10:02

        //hora de computador
        Instant agora2 = Instant.now();
        System.out.println(agora2); //2014-04-08T10:02:52.036Z (formato ISO-8601)

        Instant inicio = Instant.now();
        Instant fim = Instant.now();
        Duration duracao = Duration.between(inicio, fim);
        long duracaoEmMilissegundos = duracao.toMillis();
        System.out.println(duracaoEmMilissegundos);


        //time zone
        ZoneId fusoHorarioDeSaoPaulo = ZoneId.of("America/Sao_Paulo");
        ZoneId fusoHorarioDeNovaYork = ZoneId.of("America/New_York");

        ZonedDateTime agoraEmSaoPaulo = ZonedDateTime.now(fusoHorarioDeSaoPaulo);
        System.out.println(agoraEmSaoPaulo); //2014-04-08T10:02:57.838-03:00[America/Sao_Paulo]

        LocalDateTime saidaDeSaoPauloSemFusoHorario =
                LocalDateTime.of(2014, Month.APRIL, 4, 22, 30);
        LocalDateTime chegadaEmNovaYorkSemFusoHorario =
                LocalDateTime.of(2014, Month.APRIL, 5, 7, 10);

        ZonedDateTime saidaDeSaoPauloComFusoHorario =
                ZonedDateTime.of(saidaDeSaoPauloSemFusoHorario, fusoHorarioDeSaoPaulo);
        System.out.println(saidaDeSaoPauloComFusoHorario); //2014-04-04T22:30-03:00[America/Sao_Paulo]

        ZonedDateTime chegadaEmNovaYorkComFusoHorario =
                ZonedDateTime.of(chegadaEmNovaYorkSemFusoHorario, fusoHorarioDeNovaYork);
        System.out.println(chegadaEmNovaYorkComFusoHorario); //2014-04-05T07:10-04:00[America/New_York]

        Duration duracaoDoVoo =
                Duration.between(saidaDeSaoPauloComFusoHorario, chegadaEmNovaYorkComFusoHorario);
        System.out.println(duracaoDoVoo); //PT9H40M

    }
}
