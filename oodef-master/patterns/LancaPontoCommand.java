package patterns;

import java.util.ArrayList;

import funcionalidades.Salario;
import funcionalidades.Undo;
import funcionarios.Funcionario;

public class LancaPontoCommand implements Command {
    Salario salario;
    Undo undo;
  
	public LancaPontoCommand(Salario salario, Undo undo) {
        this.salario = salario;
        this.undo = undo;
	}
 
	public void execute(ArrayList<Funcionario> list) {
        salario.lancaPonto(list);
        undo.saveState(list);
	}
}