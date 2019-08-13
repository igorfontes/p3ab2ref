package patterns;

import java.util.ArrayList;

import funcionalidades.Gerencia;
import funcionalidades.Undo;
import funcionarios.Funcionario;

public class MudaDadosOnCommand implements Command {
    Gerencia gerencia;
    Undo undo;
  
	public MudaDadosOnCommand(Gerencia gerencia, Undo undo) {
        this.gerencia = gerencia;
        this.undo = undo;
	}
 
	public void execute(ArrayList<Funcionario> list) {
        gerencia.mudaDados(list);
        undo.saveState(list);
	}
}