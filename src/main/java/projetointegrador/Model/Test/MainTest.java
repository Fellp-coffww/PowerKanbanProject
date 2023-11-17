package projetointegrador.Model.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import projetointegrador.Model.Entities.Quadro;
import projetointegrador.Model.Entities.Projeto;
import projetointegrador.Model.Entities.Atividade;
import projetointegrador.Model.Entities.Ação;
public class MainTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        DateTimeFormatter dft1 =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Quadro quadro = new Quadro();
       quadro.addObject(new Projeto( LocalDate.parse("10/12/2002",dft1), LocalDate.parse("25/12/2002",dft1),"Fellipe"));
       quadro.retornaProjeto().get(0).addObject(new Atividade(LocalDate.parse("10/12/2002",dft1), LocalDate.parse("12/12/2002",dft1),"Atv01"));
       quadro.retornaProjeto().get(0).addObject(new Atividade(LocalDate.parse("10/12/2002",dft1), LocalDate.parse("15/12/2002",dft1),"Atv02"));
       quadro.retornaProjeto().get(0).addObject(new Atividade(LocalDate.parse("15/12/2002",dft1), LocalDate.parse("20/12/2002",dft1),"Atv03"));
       
       
       
       quadro.retornaProjeto().get(0).retornaAtividade().get(0).addObject(new Ação(LocalDate.parse("10/12/2002",dft1), LocalDate.parse("10/12/2002",dft1),"A","RH","Fellipe"));
       quadro.retornaProjeto().get(0).retornaAtividade().get(0).addObject(new Ação(LocalDate.parse("11/12/2002",dft1), LocalDate.parse("11/12/2002",dft1),"B","RH","Edielson"));
       quadro.retornaProjeto().get(0).retornaAtividade().get(0).addObject(new Ação(LocalDate.parse("12/12/2002",dft1), LocalDate.parse("12/12/2002",dft1),"C","RH","Jose"));
       quadro.retornaProjeto().get(0).retornaAtividade().get(0).addObject(new Ação(LocalDate.parse("12/12/2002",dft1), LocalDate.parse("12/12/2002",dft1),"D","RH","Lucas"));
       
       quadro.retornaProjeto().get(0).retornaAtividade().get(1).addObject(new Ação(LocalDate.parse("10/12/2002",dft1), LocalDate.parse("12/12/2002",dft1),"A","Financa","Fellipe"));
       quadro.retornaProjeto().get(0).retornaAtividade().get(1).addObject(new Ação(LocalDate.parse("11/12/2002",dft1), LocalDate.parse("12/12/2002",dft1),"B","Financa","Edielson"));
       quadro.retornaProjeto().get(0).retornaAtividade().get(1).addObject(new Ação(LocalDate.parse("12/12/2002",dft1), LocalDate.parse("13/12/2002",dft1),"C","Financa","Jose"));
       quadro.retornaProjeto().get(0).retornaAtividade().get(1).addObject(new Ação(LocalDate.parse("13/12/2002",dft1), LocalDate.parse("15/12/2002",dft1),"D","Financa","Lucas"));
       
       quadro.retornaProjeto().get(0).retornaAtividade().get(2).addObject(new Ação(LocalDate.parse("15/12/2002",dft1), LocalDate.parse("16/12/2002",dft1),"A","Compras","Fellipe"));
       quadro.retornaProjeto().get(0).retornaAtividade().get(2).addObject(new Ação(LocalDate.parse("16/12/2002",dft1), LocalDate.parse("17/12/2002",dft1),"B","Compras","Edielson"));
       quadro.retornaProjeto().get(0).retornaAtividade().get(2).addObject(new Ação(LocalDate.parse("17/12/2002",dft1), LocalDate.parse("18/12/2002",dft1),"C","Compras","Jose"));
       quadro.retornaProjeto().get(0).retornaAtividade().get(2).addObject(new Ação(LocalDate.parse("19/12/2002",dft1), LocalDate.parse("20/12/2002",dft1),"D","Compras","Lucas"));
       
       
        System.out.println("Digite um departamento: ");
        String filtroDep = sc.nextLine();
       
        for (int i = 0; i <= 0; i++) {
            for (int j = 0; j < 3 ; j++) {
                for (int k = 0; k <= 3; k++) {
                    
                
                    if (filtroDep.equalsIgnoreCase(quadro.retornaProjeto().get(i).retornaAtividade().get(j).retornaAção().get(k).getDepartamento())) {
                        System.out.println(quadro.retornaProjeto().get(i).retornaAtividade().get(j).retornaAção().get(k));
                    }
                }
            }
        }

       System.out.println("Digite um Responsavel: ");
        String filtroResp = sc.nextLine();
       
        for (int i = 0; i <= 0; i++) {
            for (int j = 0; j < 3 ; j++) {
                for (int k = 0; k <= 3; k++) {
                    
                
                    if (filtroResp.equalsIgnoreCase(quadro.retornaProjeto().get(i).retornaAtividade().get(j).retornaAção().get(k).getResponsavel())) {
                        System.out.println(quadro.retornaProjeto().get(i).retornaAtividade().get(j).retornaAção().get(k));
                    }
                }
            }
        }
       
       System.out.println("Digite uma data de inicio: ");
        String filtroDataIn = sc.nextLine();
       
        for (int i = 0; i <= 0; i++) {
            for (int j = 0; j < 3 ; j++) {
                for (int k = 0; k <= 3; k++) {
                    
                
                    if (filtroDataIn.equals(quadro.retornaProjeto().get(i).retornaAtividade().get(j).retornaAção().get(k).retornaStringIn())) {
                        System.out.println(quadro.retornaProjeto().get(i).retornaAtividade().get(j).retornaAção().get(k));
                    }
                }
            }
        }
        
        System.out.println("Digite uma data de Fim: ");
        String filtroDataFim = sc.nextLine();
       
        for (int i = 0; i <= 0; i++) {
            for (int j = 0; j < 3 ; j++) {
                for (int k = 0; k <= 3; k++) {
                    
                
                    if (filtroDataFim.equals(quadro.retornaProjeto().get(i).retornaAtividade().get(j).retornaAção().get(k).retornaStringFin())) {
                        System.out.println(quadro.retornaProjeto().get(i).retornaAtividade().get(j).retornaAção().get(k));
                    }
                }
            }
        }
       
    }


}
