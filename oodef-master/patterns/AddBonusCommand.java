package patterns;

import java.util.ArrayList;

import funcionalidades.Salario;
import funcionalidades.Undo;
import funcionarios.Funcionario;

public class AddBonusCommand implements Command {
    Salario salario;
    Undo undo;
  
	public AddBonusCommand(Salario salario, Undo undo) {
        this.salario = salario;
        this.undo = undo;
	}
 
	public void execute(ArrayList<Funcionario> list) {
        salario.addBonus(list);
        undo.saveState(list);
	}
}