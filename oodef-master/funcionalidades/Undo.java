package funcionalidades;

import java.util.ArrayList;
import java.util.Scanner;

import funcionarios.Funcionario;

public class Undo{
    static int contaestados = 0;
    static Scanner input = new Scanner(System.in);
    static String[][] undonome = new String[50][50];
    static String[][] undomododepagto = new String[50][50];
    static String[][] undotipodefunc = new String[50][50];
    static String[][] undoendereco = new String[50][50];
    static int[][] undoid = new int[50][50];
    static int[][] undoidsind = new int[50][50];
    static double[][] undotaxasind = new double[50][50];
    static double[][] undosalariobase = new double[50][50];
    static double[][] undosalariototal = new double[50][50];
    static String[][] undoagendainterval = new String[50][50];
    static int[][] undoagendaday = new int[50][50];
    static String[][] undoagendadayofweek = new String[50][50];
    static int[][] undocontadia = new int[50][50];
    static int[] tamanholist = new int[50];
    public ArrayList<Funcionario> undolist = new ArrayList<>();

    public void saveState(ArrayList<Funcionario> list){
        contaestados++;
        tamanholist[contaestados] = list.size();
        for(int i = 0; i < tamanholist[contaestados]; i++){
            undonome[contaestados][i] = list.get(i).getNome();
            undomododepagto[contaestados][i] = list.get(i).getModoDePagto();
            undotipodefunc[contaestados][i] = list.get(i).getTipoDeFunc();
            undoendereco[contaestados][i] = list.get(i).getEndereco();
            undoid[contaestados][i] = list.get(i).getId();
            undoidsind[contaestados][i] = list.get(i).getIdSind();
            undotaxasind[contaestados][i] = list.get(i).getTaxaSind();
            undosalariobase[contaestados][i] = list.get(i).getSalarioBase();
            undosalariototal[contaestados][i] = list.get(i).getSalarioTotal();
            undoagendainterval[contaestados][i] = list.get(i).getAgendaInterval();
            undoagendaday[contaestados][i] = list.get(i).getAgendaDay();
            undoagendadayofweek[contaestados][i] = list.get(i).getAgendaDayofWeek();
            undocontadia[contaestados][i] = list.get(i).getContaDia();
        }
    }

    public void operaUndo(ArrayList<Funcionario> list){
        contaestados--;
        for(int i = 0; i < tamanholist[contaestados]; i++){
            list.get(i).setNome(undonome[contaestados][i]);
            list.get(i).setModoDePagto(undomododepagto[contaestados][i]);
            list.get(i).setTipoDeFunc(undoendereco[contaestados][i]);
            list.get(i).setId(undoid[contaestados][i]);
            list.get(i).setIdSind(undoidsind[contaestados][i]);
            list.get(i).setTaxaSind(undotaxasind[contaestados][i]);
            list.get(i).setSalarioBase(undosalariobase[contaestados][i]);
            list.get(i).setSalarioTotal(undosalariototal[contaestados][i]);
            list.get(i).setAgendaInterval(undoagendainterval[contaestados][i]);
            list.get(i).setAgendaDay(undoagendaday[contaestados][i]);
            list.get(i).setAgendaDayofWeek(undoagendadayofweek[contaestados][i]);
            list.get(i).setContaDia(undocontadia[contaestados][i]);
        }
    }

    public void operaRedo(ArrayList<Funcionario> list){
        contaestados++;
        for(int i = 0; i < tamanholist[contaestados]; i++){
            list.get(i).setNome(undonome[contaestados][i]);
            list.get(i).setModoDePagto(undomododepagto[contaestados][i]);
            list.get(i).setTipoDeFunc(undoendereco[contaestados][i]);
            list.get(i).setId(undoid[contaestados][i]);
            list.get(i).setIdSind(undoidsind[contaestados][i]);
            list.get(i).setTaxaSind(undotaxasind[contaestados][i]);
            list.get(i).setSalarioBase(undosalariobase[contaestados][i]);
            list.get(i).setSalarioTotal(undosalariototal[contaestados][i]);
            list.get(i).setAgendaInterval(undoagendainterval[contaestados][i]);
            list.get(i).setAgendaDay(undoagendaday[contaestados][i]);
            list.get(i).setAgendaDayofWeek(undoagendadayofweek[contaestados][i]);
            list.get(i).setContaDia(undocontadia[contaestados][i]);
        }
    }

}