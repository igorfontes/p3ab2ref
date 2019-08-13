package geral;

import java.util.ArrayList;
import java.util.Scanner;

import funcionarios.Funcionario;

public final class Utils{
    static Scanner input = new Scanner(System.in);

    private Utils(){
    }

    public static int forneceIntegerInfo(String message) {
        int continua = 1;
        int data = 0;
        while(continua == 1){
            try{
                System.out.print(message + "\n");
                data = input.nextInt();
                continua = 0;
            } catch(Exception e){
                printMsgErro();
            }
        }
        return data;
    }

    public static double forneceDoubleInfo(String message) {
        int continua = 1;
        double data = 0.0;
        while(continua == 1){
            try{
                System.out.print(message + "\n");
                data = input.nextDouble();
                continua = 0;
            } catch(Exception e){
                printMsgErro();
            }
        }
        return data;
    }

    public static void printMsgErro(){
        System.out.print("Tipo invalido! Tente novamente!\n");
        input.nextLine();
    }

    public static int getPosicaoporId(ArrayList<Funcionario> list, int i){
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).getId()==i) {
                return j;
            }
        }
        return -1;
    }

}