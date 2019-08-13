package patterns;

import java.util.ArrayList;

import funcionalidades.Undo;
import funcionarios.Funcionario;

public class OperaUndoCommand implements Command {
    Undo undo;
  
	public OperaUndoCommand(Undo undo) {
        this.undo = undo;
	}
 
	public void execute(ArrayList<Funcionario> list) {
        undo.operaUndo(list);
	}
}