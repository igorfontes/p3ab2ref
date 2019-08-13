package patterns;

import java.util.ArrayList;

import funcionalidades.Agenda;
import funcionalidades.Undo;
import funcionarios.Funcionario;

public class CriaAgendaCommand implements Command {
    Agenda agenda;
    Undo undo;
  
	public CriaAgendaCommand(Agenda agenda, Undo undo) {
        this.agenda = agenda;
        this.undo = undo;
	}
 
	public void execute(ArrayList<Funcionario> list) {
        agenda.criaAgenda(list);
        undo.saveState(list);
	}
}