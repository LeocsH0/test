### 3.3.3 Processo 3 – Processo de Cadastro de Usuário

O Cadastro de Usuário é um dos processos centrais de qualquer sistema que requer autenticação e gestão de acesso. Ele envolve várias etapas, desde a coleta das informações básicas do usuário até a verificação de suas credenciais e a confirmação do email. Este processo garante que os usuários sejam devidamente autenticados e seus dados estejam corretos antes que possam acessar o sistema e seus recursos.

![Exemplo de um Modelo BPMN do PROCESSO 3](images/process.png "Modelo BPMN do Processo 3.")


#### Detalhamento das atividades

A Atividade de Cadastro de Usuário pode ser dividida nas seguintes subetapas:

1. Início do Processo
O processo de cadastro se inicia quando um usuário acessa a página de cadastro no sistema e escolhe começar o registro. Este ponto de partida dispara a sequência de ações que serão descritas a seguir.

2. Preenchimento do Formulário de Cadastro
A primeira ação do usuário é o preenchimento do formulário de cadastro. Este formulário deve coletar informações essenciais, incluindo:

Nome Completo: O nome do usuário.
CPF ou CNPJ: Documento de identificação pessoal ou empresarial.
Email: O email do usuário, que será usado para enviar a confirmação.
Telefone: Informações de contato.
Senha: O usuário deve escolher uma senha que atenda aos requisitos de segurança do sistema.
3. Escolha do Tipo de Cadastro
O usuário deverá selecionar o tipo de cadastro:

Disponibilizador de Resíduos: Indica que o usuário é responsável por disponibilizar resíduos. Nessa escolha, ele deverá fornecer o endereço onde o resíduo será disponibilizado.
Coletor de Resíduos: Se o usuário for um coletor de resíduos, ele deverá fornecer informações sobre a sua área de atuação, ou seja, a região em que ele opera.
Essa distinção entre os perfis de usuário garante que o sistema adapte suas funcionalidades de acordo com o papel de cada usuário na cadeia de gestão de resíduos.

4. Validação Inicial das Credenciais
Após o preenchimento do formulário, o sistema realiza uma validação inicial dos dados inseridos. O objetivo desta etapa é verificar se os campos obrigatórios estão corretamente preenchidos e se as informações fornecidas são válidas. Alguns pontos checados:

Formato do CPF/CNPJ: O sistema valida se o documento fornecido segue o formato correto e é válido.
Email: Verificação de formato e existência do domínio do email.
Telefone: Validação do formato do número de telefone.
Se algum dos dados estiver incorreto, o usuário será notificado para realizar as correções necessárias. Se todos os dados estiverem corretos, o processo segue adiante.

5. Envio do Formulário
Após a validação inicial, o usuário envia o formulário completo. Este é o ponto em que todas as informações fornecidas são transmitidas ao servidor do sistema para validações mais detalhadas.

6. Validação Final dos Dados
O sistema realiza uma validação final dos dados, garantindo que:

Todos os campos obrigatórios foram preenchidos.
Os dados fornecidos estão consistentes e dentro dos parâmetros permitidos pelo sistema (por exemplo, uma senha forte).
O CPF ou CNPJ é único no banco de dados, impedindo cadastros duplicados.
Caso haja algum erro ou informação faltando, o sistema notifica o usuário e solicita a correção dos dados.

7. Envio de Email de Confirmação
Com os dados validados, o sistema envia um email de confirmação para o endereço de email fornecido pelo usuário. O email contém um link de ativação que o usuário deve clicar para confirmar seu endereço de email e ativar sua conta.

Essa etapa é crucial para garantir que o email fornecido é válido e pertence ao usuário.

8. Confirmação do Email pelo Usuário
O usuário precisa acessar o email e clicar no link de confirmação. Esse link redireciona o usuário para o sistema, que marca o email como confirmado e prossegue para a ativação da conta.

9. Registro do Usuário no Sistema
Após a confirmação do email, o sistema registra o usuário como ativo no banco de dados. A partir desse momento, o usuário é oficialmente cadastrado e pode acessar o sistema com suas credenciais (email e senha).

10. Fim do Processo
Com o usuário devidamente cadastrado e ativo, o processo é finalizado. O usuário agora pode utilizar o sistema, seja como coletor ou como disponibilizador de resíduos, dependendo da escolha feita durante o cadastro.
