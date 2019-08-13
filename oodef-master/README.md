# Refatoramento

Projeto Refatoramento - Descrição

Inicialmente, é fornecido o menu de operações possíveis que podem ser escolhidas pelo número do comando indicado até que a opção de saída seja pressionada. Toda vez que um novo empregado é adicionado, o id (empresarial ou sindical) é fornecido ao usuário do sistema. Quando o tipo de empregado é definido pela primeira vez, as agendas de pagamento padrão são selecionadas (podendo ser modificadas posteriormente). A maior parte das operações é regida pelo id do funcionário na empresa, sendo este id solicitado sempre que necessário. Ao escolher uma agenda de pagamento diferente da admitida como padrão para o tipo de funcionário, o funcionário será orientado pelas instruções impressas na tela, sendo admitida qualquer combinação no formato das agendas propostas pela descrição geral. A data é solicitada ao rodar a folha de pagamento e em outros métodos(o ano deve ser fornecido com 4 dígitos (Exemplo:2019), o mês e o dia na forma de inteiros). Daí, o id de cada funcionário e o valor do salário pago são fornecidos.

As demais instruções são fornecidas à medida que os comandos são executados. Ao fim de cada comando, um novo menu de operações é oferecido (exceto após o comando de saída). Para testar a folha de pagamento, rode a folha nos dias desejados e verifique o salário pago a cada funcionário segundo suas agendas. Exemplo: Horista pago às sextas por padrão, etc. Também é possível verificar a lista de funcionários numa das opções do menu.

DESIGN PATTERNS APLICADOS (no pacote patterns):

O TEMPLATE METHOD foi usado na classe abstrata Funcionario com a implementação da funcionalidade chamada calculaBonus, na qual temos os seguintes aspectos:

- Cada tipo de funcionário recebe uma bonificação no seu salário, no qual é deduzido um imposto. No entanto, a bonificação e a taxa de imposto é diferente para cada tipo de funcionário. Desse modo, cada subclasse de funcionário implementa os métodos descritos no template:

- Horista: Recebe um bônus equivalente a 8 horas de trabalho, sendo um imposto de 1% deduzido do salário total após a inclusão do bônus;
- Comissionado: Recebe um bônus equivalente ao valor de seu salário mensal fixo, sendo um imposto de 5% deduzido do salário total após a inclusão do bônus;
- Assalariado: Recebe um bônus equivalente a 1/5 valor de seu salário mensal fixo, sendo um imposto de 10% deduzido do salário total após a inclusão do bônus;

- O método calcBonus criado no template foi usado na classe Salario na funcionalidade chamada addBonus.

O COMMAND PATTERN foi usado para fazer o menu na classe main, usando as classes Command e RemoteControl (para vincular as funcionalidades selecionadas pelo usuário aos comandos); 

O FACTORY METHOD foi implementado por meio da classe FuncionarioFactory, sendo usado para gerenciar a criação de instâncias de funcionários dos diversos tipos de modo mais eficiente e não repetitivo. O método criado na classe factory foi usado nos métodos addFunc e mudaDados da classe Gerencia;

O SINGLETON PATTERN foi usado para lidar com a instância da classe Menu (no pacote geral);

Foi criada a classe Utils (no pacote geral) para criação de métodos usados em várias partes do código, os quais incluem recebimento de informações do usuário com o tratamento das exceptions incluso de forma modularizada, localização da posição de um funcionário no ArrayList, etc. Isso evitou a duplicação de código em grande parte das classes usadas, principalmente nas classes Gerencia, Salario e Agenda (no pacote funcionalidades).

IC - UFAL 2019
