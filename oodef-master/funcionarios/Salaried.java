package funcionarios;

import java.util.Scanner;
import java.util.ArrayList;

public class Salaried extends Funcionario {

    private double salariomensal;

    public Salaried(String nome, String endereco, String tipodefunc, String mododepagto, int id, int idsind, double taxasind, double salariototal, double salariomensal, String agendainterval, int agendaday, String agendadayofweek, int contadia){
        super(nome, endereco, tipodefunc, mododepagto, id, idsind, taxasind, salariototal, agendainterval, agendaday, agendadayofweek, contadia);
        this.salariomensal = salariomensal;
    }

    public double getSalarioBase(){
        return salariomensal;
    }

    public void setSalarioBase(double salariomensal){
        this.salariomensal = salariomensal;
    }

    public void somaFerias(){
        this.setSalarioTotal(this.getSalarioTotal() + this.getSalarioBase()/5);
    }

    public void deduzImposto(){
        this.setSalarioTotal(0.90*this.getSalarioTotal());
    }

}