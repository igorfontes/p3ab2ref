package patterns;

import java.util.ArrayList;

import funcionalidades.Salario;
import funcionalidades.Undo;
import funcionarios.Funcionario;

public class AddVendaCommand implements Command {
        Salario salario;
        Undo undo;
  
        public AddVendaCommand(Salario salario, Undo undo) {
                this.salario = salario;
                this.undo = undo;
	}
 
	public void execute(ArrayList<Funcionario> list) {
                salario.addVenda(list);
                undo.saveState(list);
	}
}