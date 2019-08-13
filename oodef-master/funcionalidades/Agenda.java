package funcionalidades;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Scanner;

import funcionarios.Funcionario;
import geral.Utils;

public class Agenda{

    static Scanner input = new Scanner(System.in);
    static LocalDate localdate, auxdate;
    static int contaagenda = 0;
    static String[] matagenda = new String[100];

    public void escolheAgenda(ArrayList<Funcionario> list){
        int auxescolhe = 0;
        auxescolhe = Utils.forneceIntegerInfo("Digite o id do funcionario:");
        int auxfuncposition = Utils.getPosicaoporId(list, auxescolhe);
        if(auxfuncposition == -1){
            System.out.print("Id nao encontrado (funcionario removido ou nunca adicionado)\n");
        } else {
            System.out.print("Digite o intervalo de pagamento(semanalmente, bi-semanalmente, semanal, mensalmente, mensal ou mensal$(para receber no ultimo dia util do mes)):\n");
            String auxagendainterval = input.nextLine();
            list.get(auxfuncposition).setAgendaInterval(auxagendainterval);
            int auxagendaday = 0;
            switch(auxagendainterval){
                case("bi-semanalmente"):
                list.get(auxfuncposition).setContaDia(0);
                break;
                case("semanal"):
                list.get(auxfuncposition).setContaDia(0);
                auxagendaday = Utils.forneceIntegerInfo("Digite 1 para ser pago toda semana, 2 a cada duas semanas etc:");
                list.get(auxfuncposition).setAgendaDay(auxagendaday);
                System.out.print("Digite o dia da semana em que deseja ser pago(seg - segunda, ter - terca, qua - quarta, qui - quinta, sex - sexta):");
                String auxagendadayofweek = input.nextLine();
                list.get(auxfuncposition).setAgendaDayofWeek(auxagendadayofweek);
                break;
                case("mensal"):
                auxagendaday = Utils.forneceIntegerInfo("Digite o dia do mes(de 1 a 28) em que deseja ser pago:");
                list.get(auxfuncposition).setAgendaDay(auxagendaday);
                break;
                default: break;

            }
        }  
        
    }

    public void verificaDiadaSemana(int i, int auxDayofWeek, int auxContaDia, ArrayList<Funcionario> list) {
        if(localdate.getDayOfWeek().ordinal() == auxDayofWeek){ 
            list.get(i).setContaDia(list.get(i).getContaDia()+1);
            if(list.get(i).getContaDia()%auxContaDia == 0){
                payFunc(i, list);
            }    
        }
    }

    public void auxRodaFolha(int i, ArrayList<Funcionario> list) {
            switch(list.get(i).getAgendaDayofWeek()){
                case("seg"):
                verificaDiadaSemana(i,0,list.get(i).getAgendaDay(),list);
                break;
                case("ter"):
                verificaDiadaSemana(i,1,list.get(i).getAgendaDay(),list);
                break;
                case("qua"):
                verificaDiadaSemana(i,2,list.get(i).getAgendaDay(),list);
                break;
                case("qui"):
                verificaDiadaSemana(i,3,list.get(i).getAgendaDay(),list);
                break;
                case("sex"):
                verificaDiadaSemana(i,4,list.get(i).getAgendaDay(),list);
                break;
                }
    }

    public void rodaFolha(ArrayList<Funcionario> list){
            int dia = 0;
            int mes = 0;
            int ano = 0;
            dia = Utils.forneceIntegerInfo("Digite o dia atual:");
            mes = Utils.forneceIntegerInfo("Digite o mes atual:");
            ano = Utils.forneceIntegerInfo("Digite o ano atual com 4 digitos:");
            localdate = LocalDate.of(ano,mes,dia); 
            auxdate = localdate.withMonth(mes).with(TemporalAdjusters.lastDayOfMonth());
            int lastday = auxdate.getDayOfWeek().ordinal();
            while(lastday==5 || lastday==6){ 
                auxdate = auxdate.minusDays(1); 
                lastday--;
            }
            for (int i = 0; i < list.size(); i++) {

                switch(list.get(i).getTipoDeFunc()){
                    case("a"):
                    list.get(i).setSalarioTotal(list.get(i).getSalarioTotal()+(list.get(i).getSalarioBase())/30);
                    break;
                    case("c"):
                    list.get(i).setSalarioTotal(list.get(i).getSalarioTotal()+(list.get(i).getSalarioBase())/30);
                    break;
                }

                switch(list.get(i).getAgendaInterval()){
                    case("mensalmente"):
                    if(auxdate.isEqual(localdate)){ 
                        payFunc(i, list);
                    }
                    break;
                    case("mensal$"):
                    if(auxdate.isEqual(localdate)){ 
                        payFunc(i, list);
                    }
                    break;
                    case("mensal"):
                    if(list.get(i).getAgendaDay() == dia){ 
                        payFunc(i, list);
                    }
                    break;
                    case("semanalmente"):
                    if(localdate.getDayOfWeek().ordinal() == 4){ 
                        payFunc(i, list);    
                    }
                    break;
                    case("bi-semanalmente"):
                    if(localdate.getDayOfWeek().ordinal() == 4){ 
                        list.get(i).setContaDia(list.get(i).getContaDia()+1);
                        if(list.get(i).getContaDia()%2 == 0){
                            payFunc(i, list);
                        }    
                    }
                    break;
                    case("semanal"):
                    auxRodaFolha(i, list);
                    break;
                }
            }
    }

    public void payFunc(int i, ArrayList<Funcionario> list) {
        list.get(i).setSalarioTotal(list.get(i).getSalarioTotal()-list.get(i).getTaxaSind());
        System.out.printf("O funcionario com id %d recebeu %.2f reais hoje\n", list.get(i).getId(), list.get(i).getSalarioTotal());
        list.get(i).setSalarioTotal(0.0);
    }

    public void criaAgenda(ArrayList<Funcionario> list){
        System.out.print("Digite a string correspondente à nova agenda (Exemplo: mensal$, semanal 1 ter, etc):\n");
        String auxnovaagenda = input.nextLine();
        matagenda[contaagenda]=auxnovaagenda;
        System.out.printf("Agendas disponiveis abaixo:\nmensalmente\nsemanalmente\nbi-semanalmente\n");
        for(int i = 0; i <= contaagenda; i++){
            System.out.printf("%s\n", matagenda[i]);
        }
        contaagenda++;
    }

}