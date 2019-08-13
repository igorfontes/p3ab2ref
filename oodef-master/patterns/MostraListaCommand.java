package patterns;

import java.util.ArrayList;

import funcionalidades.Gerencia;
import funcionarios.Funcionario;

public class MostraListaCommand implements Command {
    Gerencia gerencia;
  
	public MostraListaCommand(Gerencia gerencia) {
        this.gerencia = gerencia;
	}
 
	public void execute(ArrayList<Funcionario> list) {
        gerencia.mostraLista(list);
	}
}