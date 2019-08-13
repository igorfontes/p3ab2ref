package patterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import funcionarios.Funcionario;

//
// This is the invoker
//
public class RemoteControl {
	Map<String, Command>  menuItems = new HashMap<>();
 
	public RemoteControl() {}
 
	public void setCommand(String option, Command command) {
		menuItems.put(option, command);
	}
 
	public void buttonWasPressed(String option, ArrayList<Funcionario> list) {
		menuItems.get(option).execute(list);
	}
}