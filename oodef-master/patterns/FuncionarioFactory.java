package patterns;

import funcionarios.Comissioned;
import funcionarios.Funcionario;
import funcionarios.Horista;
import funcionarios.Salaried;

public class FuncionarioFactory {

    public Funcionario criaFuncionario(String auxnome, String auxendereco, String auxtipodefunc, String auxmododepagto, int auxid, int auxidsind, double auxtaxasind, double auxsalariobase){

        switch(auxtipodefunc){
            case "h":
            return new Horista(auxnome, auxendereco, auxtipodefunc, auxmododepagto, auxid, auxidsind, auxtaxasind, 0, auxsalariobase, "semanalmente", 0, "", 0);
            case "a":
            return new Salaried(auxnome, auxendereco, auxtipodefunc, auxmododepagto, auxid, auxidsind, auxtaxasind, 0, auxsalariobase, "mensalmente", 0, "", 0);
            case "c":
            return new Comissioned(auxnome, auxendereco, auxtipodefunc, auxmododepagto, auxid, auxidsind, auxtaxasind, 0, auxsalariobase, "bi-semanalmente", 0, "", 0);
        }

        return null;
    }
}