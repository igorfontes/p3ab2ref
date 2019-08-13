package patterns;

import java.util.ArrayList;

import funcionalidades.Gerencia;
import funcionalidades.Undo;
import funcionarios.Funcionario;

public class AddFuncOnCommand implements Command {
    Gerencia gerencia;
    Undo undo;
  
	public AddFuncOnCommand(Gerencia gerencia, Undo undo) {
        this.gerencia = gerencia;
        this.undo = undo;
	}
 
	public void execute(ArrayList<Funcionario> list) {
        gerencia.addFunc(list);
        undo.saveState(list);
	}
}