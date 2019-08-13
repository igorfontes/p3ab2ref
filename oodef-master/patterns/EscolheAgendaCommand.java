package patterns;

import java.util.ArrayList;

import funcionalidades.Agenda;
import funcionalidades.Undo;
import funcionarios.Funcionario;

public class EscolheAgendaCommand implements Command {
    Agenda agenda;
    Undo undo;
  
	public EscolheAgendaCommand(Agenda agenda, Undo undo) {
        this.agenda = agenda;
        this.undo = undo;
	}
 
	public void execute(ArrayList<Funcionario> list) {
        agenda.escolheAgenda(list);
        undo.saveState(list);
	}
}