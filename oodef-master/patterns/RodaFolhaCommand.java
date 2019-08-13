package patterns;

import java.util.ArrayList;

import funcionalidades.Agenda;
import funcionalidades.Undo;
import funcionarios.Funcionario;

public class RodaFolhaCommand implements Command {
    Agenda agenda;
    Undo undo;
  
	public RodaFolhaCommand(Agenda agenda, Undo undo) {
        this.agenda = agenda;
        this.undo = undo;
	}
 
	public void execute(ArrayList<Funcionario> list) {
        agenda.rodaFolha(list);
        undo.saveState(list);
	}
}