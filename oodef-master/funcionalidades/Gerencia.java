package funcionalidades;

import java.util.ArrayList;
import java.util.Scanner;

import funcionarios.Funcionario;
import patterns.FuncionarioFactory;
import geral.Utils;

public class Gerencia{

    static int contafunc = 0;
    static int contasind = 0;
    static Scanner input = new Scanner(System.in);
    static String auxnome;
    static String auxmododepagto;
    static String auxtipodefunc;
    static String auxendereco;
    static int auxid;
    static int auxidsind;
    static int sind;
    static int auxfuncposition;
    static double auxtaxasind;
    static double auxsalariohora;
    static double auxsalariomensal;
    static double auxsalariocommensal;
    static double auxsalariobase;
    FuncionarioFactory factory = new FuncionarioFactory();

    public Gerencia(){
    }

    public  String forneceFuncInfo(String tipodeInfo){
        System.out.print("Digite o " + tipodeInfo + " do funcionario e pressione enter:");
        return input.nextLine();
    }
    
    public  void addFunc(ArrayList<Funcionario> list){
        auxid = contafunc;
        contafunc++;
        auxnome = forneceFuncInfo("nome");
        auxendereco = forneceFuncInfo("endereco");
        auxmododepagto = forneceFuncInfo("modo de pagamento");
        sind = Utils.forneceIntegerInfo("Se o funcionario desejar fazer parte do sindicato, digite 1. Caso contrário, digite 0 :");
        auxtaxasind = 0.0;
        if(sind == 1){
        auxidsind = contasind;
        contasind++;
        auxtaxasind = Utils.forneceDoubleInfo("Digite a taxa sindical e pressione enter:");
        System.out.printf("Seu id no sindicato e: %d\n", auxidsind);
        }
        System.out.printf("Seu id na empresa e: %d\n", auxid);
        System.out.print("Digite o tipo (h - horista, a - assalariado, c - comissionado) do funcionario e pressione enter:");
        auxtipodefunc = input.nextLine();
        auxsalariobase = Utils.forneceDoubleInfo("Digite o valor do salario-hora (horista) ou mensal fixo (demais tipos) e pressione enter:");
        list.add(factory.criaFuncionario(auxnome, auxendereco, auxtipodefunc, auxmododepagto, auxid, auxidsind, auxtaxasind, auxsalariobase));
        return;
    }

    public  void removeFunc(ArrayList<Funcionario> list) {
        int auxremove = 0;
        auxremove = Utils.forneceIntegerInfo("Digite o id do funcionario a ser removido:");
        int removivel = Utils.getPosicaoporId(list, auxremove);
        if(removivel == -1){
            System.out.print("Id nao encontrado (funcionario ja removido ou nunca adicionado)\n");
        } else {
            System.out.printf("O funcionario %s com id %d foi removido com sucesso!\n", list.get(removivel).getNome(),list.get(removivel).getId());
            list.remove(removivel);
        }
    }

    public  void mudaDados(ArrayList<Funcionario> list) {
        int auxid = 0;
        auxid = Utils.forneceIntegerInfo("Digite o id do funcionario cujos dados serao alterados:");
        auxfuncposition = Utils.getPosicaoporId(list, auxid);
        if(auxfuncposition == -1){
            System.out.print("Id nao encontrado (funcionario removido ou nunca adicionado)\n");
        } else {
            int auxmuda = 0;
            auxmuda = Utils.forneceIntegerInfo("Escolha uma das opcoes abaixo:\n1 - mudar nome\n2 - mudar endereco\n3 - mudar tipo de funcionario\n4 - mudar modo de pagamento\n5 - entrar ou sair do sindicato\n6 - mudar taxa sindical\n7 - mudar id no sindicato");
            switch(auxmuda){
                case 1:
                System.out.print("Digite o novo nome:");
                auxnome = input.nextLine();
                list.get(auxfuncposition).setNome(auxnome);
                System.out.printf("Nome modificado para %s.\n",list.get(auxfuncposition).getNome());
                break;
                case 2:
                System.out.print("Digite o novo endereco:");
                auxendereco = input.nextLine();
                list.get(auxfuncposition).setEndereco(auxendereco);
                System.out.printf("Endereco modificado para %s.\n",list.get(auxfuncposition).getEndereco());
                break;
                case 3: 
                System.out.print("Digite o novo tipo de funcionario:");
                auxtipodefunc = input.nextLine();
                auxsalariobase = Utils.forneceDoubleInfo("Digite o valor do salario-hora (horista) ou mensal fixo (demais tipos) e pressione enter:");
                list.add(factory.criaFuncionario(list.get(auxfuncposition).getNome(), list.get(auxfuncposition).getEndereco(), auxtipodefunc, list.get(auxfuncposition).getModoDePagto(), auxid, list.get(auxfuncposition).getIdSind(), list.get(auxfuncposition).getTaxaSind(),auxsalariobase));
                list.remove(auxfuncposition);
                System.out.print("Tipo de funcionario modificado com sucesso!\n");
                break;
                case 4:
                System.out.print("Digite o novo modo de pagamento:");
                auxmododepagto = input.nextLine();
                list.get(auxfuncposition).setModoDePagto(auxmododepagto);
                System.out.printf("Modo de pagamento modificado para %s.\n",list.get(auxfuncposition).getModoDePagto());
                break;
                case 5:
                sind = Utils.forneceIntegerInfo("Digite 1 para fazer parte do sindicato ou 0 para sair:");
                auxtaxasind = 0.0;
                if(sind == 1){
                    auxidsind = contasind;
                    contasind++;
                    auxtaxasind = Utils.forneceIntegerInfo("Digite a taxa sindical e pressione enter:");
                    System.out.printf("Seu id no sindicato e: %d\n", auxidsind);
                    list.get(auxfuncposition).setIdSind(auxidsind);
                }
                list.get(auxfuncposition).setTaxaSind(auxtaxasind);
                System.out.printf("Sua taxa sindical e de %.2f.\n",list.get(auxfuncposition).getTaxaSind());
                break;
                case 6:
                auxtaxasind = Utils.forneceDoubleInfo("Digite a nova taxa sindical e pressione enter:");
                list.get(auxfuncposition).setTaxaSind(auxtaxasind);
                System.out.printf("Sua taxa sindical e de %.2f.\n",list.get(auxfuncposition).getTaxaSind());
                break;
                case 7:
                auxidsind = contasind;
                contasind++;
                System.out.printf("Seu novo id no sindicato e: %d\n", auxidsind);
                list.get(auxfuncposition).setIdSind(auxidsind);
                break;
    
            }
        }
        
    }

    public void mostraLista(ArrayList<Funcionario> list){
        System.out.println("id -- Nome -- Tipo de funcionario -- salario total ate agora\n");
        for (int j = 0; j < list.size(); j++) {
            System.out.printf("%d -- %s -- %s -- %.2f\n", list.get(j).getId(), list.get(j).getNome(), list.get(j).getTipoDeFunc(), list.get(j).getSalarioTotal());
        }
    }
    
}