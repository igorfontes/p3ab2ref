package patterns;

import java.util.ArrayList;

import funcionalidades.Gerencia;
import funcionalidades.Undo;
import funcionarios.Funcionario;

public class RemoveFuncOnCommand implements Command {
    Gerencia gerencia;
    Undo undo;
  
	public RemoveFuncOnCommand(Gerencia gerencia, Undo undo) {
        this.gerencia = gerencia;
        this.undo = undo;
	}
 
	public void execute(ArrayList<Funcionario> list) {
        gerencia.removeFunc(list);
        undo.saveState(list);
	}
}