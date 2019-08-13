package geral;

import java.util.ArrayList;
import java.util.Scanner;

import funcionalidades.Agenda;
import funcionalidades.Gerencia;
import funcionalidades.Salario;
import funcionalidades.Undo;
import funcionarios.Funcionario;
import patterns.AddBonusCommand;
import patterns.AddFuncOnCommand;
import patterns.AddVendaCommand;
import patterns.CobrarTaxaCommand;
import patterns.CriaAgendaCommand;
import patterns.EscolheAgendaCommand;
import patterns.LancaPontoCommand;
import patterns.MostraListaCommand;
import patterns.MudaDadosOnCommand;
import patterns.OperaRedoCommand;
import patterns.OperaUndoCommand;
import patterns.RemoteControl;
import patterns.RemoveFuncOnCommand;
import patterns.RodaFolhaCommand;

public class Menu{

    String option = "start";
    Scanner input = new Scanner(System.in);
    ArrayList<Funcionario> list = new ArrayList<>();
    Gerencia gerencia = new Gerencia();
    Salario salario = new Salario();
    Agenda agenda = new Agenda();
    Undo undo = new Undo();
    RemoteControl remote = new RemoteControl();

    public void callMenu() {
        remote.setCommand("1", new AddFuncOnCommand(gerencia, undo));
        remote.setCommand("2", new RemoveFuncOnCommand(gerencia,undo));
        remote.setCommand("3", new LancaPontoCommand(salario, undo));
        remote.setCommand("4", new AddVendaCommand(salario, undo));
        remote.setCommand("5", new CobrarTaxaCommand(salario, undo));
        remote.setCommand("6", new MudaDadosOnCommand(gerencia, undo));
        remote.setCommand("7", new RodaFolhaCommand(agenda, undo));
        remote.setCommand("8", new OperaUndoCommand(undo));
        remote.setCommand("9", new OperaRedoCommand(undo));
        remote.setCommand("10", new EscolheAgendaCommand(agenda, undo));
        remote.setCommand("11", new CriaAgendaCommand(agenda, undo));
        remote.setCommand("12", new AddBonusCommand(salario, undo));
        remote.setCommand("13", new MostraListaCommand(gerencia));

        while(true){
            try {
                System.out.print("\nDigite uma das opcoes abaixo:\n1 - adicionar funcionario\n2 - remover funcionario\n3 - lancar ponto\n4 - adicionar venda\n5 - cobrar taxa extra\n6 - mudar dados do funcionario\n7 - rodar folha\n8 - undo\n9 - redo\n10 - escolher agenda de pagamento\n11 - criar agenda\n12 - adicionar bonus\n13 - mostrar lista de funcionários\n14 - sair\n");
                option = input.nextLine();
                if(!(String.valueOf(option)).equals("14")){
                    remote.buttonWasPressed(String.valueOf(option), list);
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.print("Tipo invalido! Use uma das opções do menu!\n");
            }
        }
    }
        
}