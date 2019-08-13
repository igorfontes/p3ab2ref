package patterns;

import java.util.ArrayList;

import funcionarios.Funcionario;


public interface Command {
	public void execute(ArrayList<Funcionario> list);
}