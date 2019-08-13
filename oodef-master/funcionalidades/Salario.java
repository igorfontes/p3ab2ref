package funcionalidades;

import java.util.ArrayList;
import java.util.Scanner;

import funcionarios.Funcionario;
import geral.Utils;

public class Salario {
    static Scanner input = new Scanner(System.in);

    public Salario(){
    }

    public void lancaPonto(ArrayList<Funcionario> list){
        int auxilid = 0;
        int dia = 0;
        int mes = 0;
        int ano = 0;
        int horastrabal = 0;
        auxilid = Utils.forneceIntegerInfo("Digite o id do funcionario:");
        dia = Utils.forneceIntegerInfo("Digite o dia atual:");
        mes = Utils.forneceIntegerInfo("Digite o mes atual:");
        ano = Utils.forneceIntegerInfo("Digite o ano atual com 4 digitos:");
        horastrabal = Utils.forneceIntegerInfo("Digite o numero de horas trabalhadas nessa data:"); 
       int auxfuncposition;
       for (int i = 0; i < list.size(); i++) {
           if (list.get(i).getId()==auxilid) {
            auxfuncposition = i;
            double auxsalary = 0;
            if(horastrabal>=8){
                auxsalary += (list.get(auxfuncposition).getSalarioBase()*(horastrabal-8)*1.5 + list.get(auxfuncposition).getSalarioBase()*8);
            } else {
                auxsalary += list.get(auxfuncposition).getSalarioBase()*horastrabal;
            }
            double auxsalariototal = list.get(auxfuncposition).getSalarioTotal() + auxsalary;
            list.get(auxfuncposition).setSalarioTotal(auxsalariototal);
            System.out.printf("O salario do funcionario com id %d e ate agora %.2f\n",list.get(auxfuncposition).getId(),list.get(auxfuncposition).getSalarioTotal());
            break;
           }
       }
    }

    public void addVenda(ArrayList<Funcionario> list){
        int auxilid = 0;
        double valorvenda = 0;
        double auxpercentcomis = 0;
        auxilid = Utils.forneceIntegerInfo("Digite o id do funcionario:");
        valorvenda = Utils.forneceDoubleInfo("Digite o valor da venda:");
        auxpercentcomis = Utils.forneceDoubleInfo("Digite o valor do percentual em comissoes(digite a porcentagem como um decimal com virgula. Exemplo: 25,7 para 25,7 por cento) e pressione enter:"); 
        int auxfuncposition;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId()==auxilid) {
                auxfuncposition = i;
                double auxsalary = 0;
                auxsalary += (valorvenda*auxpercentcomis/100);
                double auxsalariototal = list.get(auxfuncposition).getSalarioTotal() + auxsalary;
                list.get(auxfuncposition).setSalarioTotal(auxsalariototal);
                System.out.printf("O salario do funcionario com id %d e ate agora %.2f\n",list.get(auxfuncposition).getId(),list.get(auxfuncposition).getSalarioTotal());
                break;
            }
        }  
    }

    public void cobrarTaxa(ArrayList<Funcionario> list){
        int auxilid = 0;
        double taxaextra = 0.0;
        auxilid = Utils.forneceIntegerInfo("Digite o id do funcionario:");
        taxaextra = Utils.forneceDoubleInfo("Digite o valor da taxa extra de servico:"); 
        int auxfuncposition;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId()==auxilid) {
                auxfuncposition = i;
                double auxsalary = 0;
                auxsalary -= (taxaextra);
                double auxsalariototal = list.get(auxfuncposition).getSalarioTotal() + auxsalary;
                list.get(auxfuncposition).setSalarioTotal(auxsalariototal);
                System.out.printf("O salario do funcionario com id %d e ate agora %.2f\n",list.get(auxfuncposition).getId(),list.get(auxfuncposition).getSalarioTotal());
                break;
            }
        }
    }

    public void addBonus(ArrayList<Funcionario> list) {
        int auxilid = -1;
        auxilid = Utils.forneceIntegerInfo("Digite o id do funcionario:");
        int auxfuncposition = Utils.getPosicaoporId(list, auxilid);
        Funcionario bonificavel = list.get(auxfuncposition);
        bonificavel.calcBonus();
        System.out.printf("O salario do funcionario com id %d e ate agora %.2f\n",list.get(auxfuncposition).getId(),list.get(auxfuncposition).getSalarioTotal());
    }

}