package funcionarios;

public class Comissioned extends Funcionario {

    private double salariocommensal;

    public Comissioned(String nome, String endereco, String tipodefunc, String mododepagto, int id, int idsind, double taxasind, double salariototal, double salariocommensal, String agendainterval, int agendaday, String agendadayofweek, int contadia){
        super(nome, endereco, tipodefunc, mododepagto, id, idsind, taxasind, salariototal, agendainterval, agendaday, agendadayofweek, contadia);
        this.salariocommensal = salariocommensal;
    }

    public double getSalarioBase(){
        return salariocommensal;
    }

    public void setSalarioBase(double salariocommensal){
        this.salariocommensal = salariocommensal;
    }

    public void somaFerias(){
        this.setSalarioTotal(2*this.getSalarioTotal());
    }

    public void deduzImposto(){
        this.setSalarioTotal(0.95*this.getSalarioTotal());
    }

}