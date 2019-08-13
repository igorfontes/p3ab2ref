package patterns;

import java.util.ArrayList;

import funcionalidades.Undo;
import funcionarios.Funcionario;

public class OperaRedoCommand implements Command {
    Undo undo;
  
	public OperaRedoCommand(Undo undo) {
        this.undo = undo;
	}
 
	public void execute(ArrayList<Funcionario> list) {
        undo.operaRedo(list);
	}
}