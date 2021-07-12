package util;

//import java.time.Duration;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Util {

    public static String gerarCodigo() {
        return UUID.randomUUID().toString().substring(0, 4).toUpperCase();
    }
    //public static String converterHoraParaString(LocalTime hora) {
        //DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm");
       // LocalTime lt = LocalTime.parse(hora, dt);
        //return lt;
   // }
   // public static double horas(LocalTime t1, LocalTime t2, double tempo) {
       // Duration t = Duration.between(t1, t2);
       // tempo = t.toHoursPart();
       //         System.out.println(tempo);
   // }
}