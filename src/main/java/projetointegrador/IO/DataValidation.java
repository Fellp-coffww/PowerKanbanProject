package projetointegrador.IO;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DataValidation {


    private Scanner sc = new Scanner(System.in);
    public boolean ValidaDouble(String string) {
        try {
            double var = 0;
            var = Double.parseDouble(string);
            return true;
        } catch (Exception e){
            return false;
        }
    }
    public boolean ValidaInteger(String string) {
        try {
            int var = 0;
            var = Integer.parseInt(string);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Integer isInteger(String string){
        System.out.print(string);
        String temp = "";
        temp = sc.nextLine();
        while (ValidaInteger(temp) == false) {
            System.out.println("Digite novamente, formato inválido!  \n");
            System.out.print(string);
            temp = sc.nextLine();
        }
        return Integer.parseInt(temp);
    }



    public double isDouble(String string){

        System.out.print(string);
        String temp = "";
        temp = sc.nextLine();
        while (ValidaDouble(temp) == false) {
            System.out.println("Digite novamente, formato inválido!  \n");
            System.out.print(string);
            temp = sc.nextLine();
        }
        return Double.parseDouble(temp);
    }

    public boolean sizeIsTrue(int number, int size){
        int copy = 0;
        while (number!=0){
            number = number/10;
            copy++;
        }
        if (copy == size){

            return true;
        }
        else {
            return false;
        }
    }

    public boolean listisTrue(int number, int size){
        int copy = 0;
        while (number!=0){
            number = number/10;
            copy++;
        }
        if (copy == size){
            return true;
        }
        else {
            return false;
        }
    }
    public int validateSizeNumber(int size, String message){

        int number = isInteger(message);
        while (sizeIsTrue(number,size) == false){
            System.out.println("Digite novamente, tamanho insuficiente, digite um número de tamanho: " + size);
            number = isInteger("");
        }
        return number;
    }
    public int validateSizeNumber(int sizea, int sizeb, String message){

        int number = isInteger(message);
        while (sizeIsTrue(number,sizea) == false){
            System.out.println("Digite novamente, indice insuficiente! ");
            number = isInteger("");
        }
        return number;
    }
    public boolean listIsValid(int listSize, int position){
        if (position<= listSize){
            return true;
        }
        else {
            return false;
        }
    }


    public Integer isInteger(String string, int position, int sizeList){
        System.out.print(string);
        String temp = "";
        temp = sc.nextLine();
        while (ValidaInteger(temp) == false){
            System.out.println("Digite novamente, formato inválido!  \n");
            System.out.print(string);
            temp = sc.nextLine();
        }
        return Integer.parseInt(temp);
    }
    
    public boolean ValidaData(String data) {
        try{
            boolean bool = false; 
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            formatter.parse(data);
            int dia = Integer.parseInt(data.substring(0,2));
            int mes = Integer.parseInt(data.substring(3,5));
            int ano = Integer.parseInt(data.substring(6));
            if(mes == 2 ){
                if(ano % 4 == 0){
                            if(dia <= 29){
                                
                            }else{
                                return false;
                            }
                        }
                    }
            if(mes == 2){
                if(dia <= 28){
                    
                }else{
                    return false;
                }
            }
            if(mes == 4 || mes == 6 || mes == 9 || mes == 11){
                if(dia <= 30){
                    
                }else{
                    return false;
                }
            }
            
                return true;
            }
            catch (Exception e){
            return false;
            }
    }


}
