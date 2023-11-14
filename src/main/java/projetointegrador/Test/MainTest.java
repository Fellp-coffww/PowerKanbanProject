package projetointegrador.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainTest {

    public static void main(String[] args) {


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate lcd = LocalDate.now();
        LocalDate lcf = LocalDate.parse("11/11/2023", dateTimeFormatter);
        LocalDate lci = LocalDate.parse("07/11/2023", dateTimeFormatter);

        int percent = (lcd.getDayOfMonth()- lci.getDayOfMonth()) * 100 / (lcf.getDayOfMonth() - lci.getDayOfMonth());

        System.out.println(percent + "%");

        System.out.println("JM");




    }


}
