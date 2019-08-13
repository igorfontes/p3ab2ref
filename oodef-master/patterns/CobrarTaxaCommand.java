package patterns;

import java.util.ArrayList;

import funcionalidades.Salario;
import funcionalidades.Undo;
import funcionarios.Funcionario;

public class CobrarTaxaCommand implements Command {
    Salario salario;
    Undo undo;
  
	public CobrarTaxaCommand(Salario salario, Undo undo) {
        this.salario = salario;
        this.undo = undo;
	}
 
	public void execute(ArrayList<Funcionario> list) {
        salario.cobrarTaxa(list);
        undo.saveState(list);
	}
}