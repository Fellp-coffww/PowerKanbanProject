package projetointegrador.Model.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import projetointegrador.Model.Entities.Quadro;
import projetointegrador.Model.Entities.Projeto;
import projetointegrador.Model.Entities.Atividade;
import projetointegrador.Model.Entities.Ação;
public class MainTest {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);



       DateTimeFormatter dft1 =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
       SimpleDateFormat sdt1 = new SimpleDateFormat("dd/MM/yyyy");
       
       Quadro quadro = new Quadro();
       quadro.addObject(new Projeto( LocalDate.parse("10/12/2002",dft1), LocalDate.parse("25/12/2002",dft1),"Fellipe"));
       quadro.retornaProjeto().get(0).addObject(new Atividade(LocalDate.parse("10/12/2002",dft1), LocalDate.parse("12/12/2002",dft1),"Atv01"));
       quadro.retornaProjeto().get(0).addObject(new Atividade(LocalDate.parse("10/12/2002",dft1), LocalDate.parse("15/12/2002",dft1),"Atv02"));
       quadro.retornaProjeto().get(0).addObject(new Atividade(LocalDate.parse("15/12/2002",dft1), LocalDate.parse("20/12/2002",dft1),"Atv03"));

       quadro.retornaProjeto().get(0).retornaAtividade().get(0).addObject(new Ação(LocalDate.parse("10/12/2002",dft1), LocalDate.parse("10/12/2002",dft1),"A","Fellipe","RH"));
       quadro.retornaProjeto().get(0).retornaAtividade().get(0).addObject(new Ação(LocalDate.parse("11/12/2002",dft1), LocalDate.parse("11/12/2002",dft1),"B","Edielson","RH"));
       quadro.retornaProjeto().get(0).retornaAtividade().get(0).addObject(new Ação(LocalDate.parse("12/12/2002",dft1), LocalDate.parse("12/12/2002",dft1),"C","Jose","RH"));
       quadro.retornaProjeto().get(0).retornaAtividade().get(0).addObject(new Ação(LocalDate.parse("12/12/2002",dft1), LocalDate.parse("12/12/2002",dft1),"D","Lucas","RH"));
       
       quadro.retornaProjeto().get(0).retornaAtividade().get(1).addObject(new Ação(LocalDate.parse("10/12/2002",dft1), LocalDate.parse("12/12/2002",dft1),"A","Fellipe","Financa"));
       quadro.retornaProjeto().get(0).retornaAtividade().get(1).addObject(new Ação(LocalDate.parse("11/12/2002",dft1), LocalDate.parse("12/12/2002",dft1),"B","Edielson","Financa"));
       quadro.retornaProjeto().get(0).retornaAtividade().get(1).addObject(new Ação(LocalDate.parse("12/12/2002",dft1), LocalDate.parse("13/12/2002",dft1),"C","Jose","Financa"));
       quadro.retornaProjeto().get(0).retornaAtividade().get(1).addObject(new Ação(LocalDate.parse("13/12/2002",dft1), LocalDate.parse("15/12/2002",dft1),"D","Lucas","Financa"));
       
       quadro.retornaProjeto().get(0).retornaAtividade().get(2).addObject(new Ação(LocalDate.parse("15/12/2002",dft1), LocalDate.parse("16/12/2002",dft1),"A","Fellipe","Compras"));
       quadro.retornaProjeto().get(0).retornaAtividade().get(2).addObject(new Ação(LocalDate.parse("16/12/2002",dft1), LocalDate.parse("17/12/2002",dft1),"B","Edielson","Compras"));
       quadro.retornaProjeto().get(0).retornaAtividade().get(2).addObject(new Ação(LocalDate.parse("17/12/2002",dft1), LocalDate.parse("18/12/2002",dft1),"C","Jose","Compras"));
       quadro.retornaProjeto().get(0).retornaAtividade().get(2).addObject(new Ação(LocalDate.parse("19/12/2002",dft1), LocalDate.parse("20/12/2002",dft1),"D","Lucas","Compras"));
       
       
        System.out.println("Digite um departamento: ");
        String filtroDep = sc.nextLine();
       
        for (int i = 0; i <= 0; i++) {
            for (int j = 0; j < 3 ; j++) {
                for (int k = 0; k <= 3; k++) {
                    
                
                    if (filtroDep.equals(quadro.retornaProjeto().get(i).retornaAtividade().get(j).retornaAcao().get(k).getDepartamento())) {
                        System.out.println(quadro.retornaProjeto().get(i).retornaAtividade().get(j).retornaAcao().get(k));
                    }
                }
            }
        }
        



       System.out.println("Digite um Responsavel: ");
        String filtroResp = sc.nextLine();
       
        for (int i = 0; i <= 0; i++) {
            for (int j = 0; j < 3 ; j++) {
                for (int k = 0; k <= 3; k++) {
                    
                
                    if (filtroResp.equals(quadro.retornaProjeto().get(i).retornaAtividade().get(j).retornaAcao().get(k).getResponsavel())) {
                        System.out.println(quadro.retornaProjeto().get(i).retornaAtividade().get(j).retornaAcao().get(k));
                    }
                }
            }
        }
       
       System.out.println("Digite uma data de inicio: ");
        String filtroDataInicio = sc.nextLine();
       
        for (int i = 0; i <= 0; i++) {
            for (int j = 0; j < 3 ; j++) {
                for (int k = 0; k <= 3; k++) {
                    
                
                    if (filtroDataInicio.equals(quadro.retornaProjeto().get(i).retornaAtividade().get(j).retornaAcao().get(k).retornaStringInicio())) {
                        System.out.println(quadro.retornaProjeto().get(i).retornaAtividade().get(j).retornaAcao().get(k));
                    }
                }
            }
        }
        System.out.println("");
        System.out.println("Digite uma data de Fim: ");
        String filtroDataFim = sc.nextLine();
       
        for (int i = 0; i <= 0; i++) {
            for (int j = 0; j < 3 ; j++) {
                for (int k = 0; k <= 3; k++) {
                    
                
                    if (filtroDataFim.equals(quadro.retornaProjeto().get(i).retornaAtividade().get(j).retornaAcao().get(k).retornaStringFim())) {
                        System.out.println(quadro.retornaProjeto().get(i).retornaAtividade().get(j).retornaAcao().get(k));
                    }
              }
            }
        }
        
        System.out.println("Digite um periodo: ");
        System.out.println("Digite o dia de inicio: ");
        Date dataPeriodoInicio = sdt1.parse(sc.nextLine());
        System.out.println("Digite o dia de termino: ");
        Date dataPeriodoFim = sdt1.parse(sc.nextLine());
        
        for (int i = 0; i < 0; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k <= 3; k++) {
                    Date comparativoDataInicio = sdt1.parse(quadro.retornaProjeto().get(i).retornaAtividade().get(j).retornaAcao().get(k).retornaStringInicio());
                    System.out.println(comparativoDataInicio);
                    Date comparativoDataFim = sdt1.parse(quadro.retornaProjeto().get(i).retornaAtividade().get(j).retornaAcao().get(k).retornaStringFim());
                    if(dataPeriodoInicio.after(comparativoDataInicio)){
                        System.out.println(quadro.retornaProjeto().get(i).retornaAtividade().get(j).retornaAcao().get(k));
                        
                    }
                }
            }
        }
        
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate lcd = LocalDate.now();
        LocalDate lcf = LocalDate.parse("11/11/2023", dateTimeFormatter);
        LocalDate lci = LocalDate.parse("07/11/2023", dateTimeFormatter);

        int percent = (lcd.getDayOfMonth()- lci.getDayOfMonth()) * 100 / (lcf.getDayOfMonth() - lci.getDayOfMonth());

        System.out.println(percent + "%");

        System.out.println("JM");   
    }
}
