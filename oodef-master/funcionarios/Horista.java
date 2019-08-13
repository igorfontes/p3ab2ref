package funcionarios;

import java.util.ArrayList;
import java.util.Scanner;

public class Horista extends Funcionario {

    private double salariohora;

    public Horista(String nome, String endereco, String tipodefunc, String mododepagto, int id, int idsind, double taxasind, double salariototal, double salariohora, String agendainterval, int agendaday, String agendadayofweek, int contadia){
        super(nome, endereco, tipodefunc, mododepagto, id, idsind, taxasind, salariototal, agendainterval, agendaday, agendadayofweek, contadia);
        this.salariohora = salariohora;
    }

    public double getSalarioBase(){
        return salariohora;
    }

    public void setSalarioBase(double salariohora){
        this.salariohora = salariohora;
    }

    public void somaFerias(){
        this.setSalarioTotal(this.getSalarioTotal() + 8*this.getSalarioBase());
    }

    public void deduzImposto(){
        this.setSalarioTotal(0.99*this.getSalarioTotal());
    }

}