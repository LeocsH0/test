### 3.3.1 Processo 1 – Gestão de Resíduos

Atualmente, o produtor de resíduos enfrenta dificuldades para coordenar a coleta dos recicláveis, pois não há um sistema estruturado para informar os locais e volumes de resíduos disponíveis. Muitas vezes, a comunicação sobre os pontos de coleta é feita de forma informal, através de contatos pessoais, ou de maneira aleatória. Isso pode resultar em atrasos e ineficiências na coleta dos materiais recicláveis.

No ReCiclo, o registro da demanda de resíduos otimizará o processo de coleta ao fornecer uma visão detalhada dos locais e volumes de resíduos. Com isso, tanto produtores quanto coletores irão se beneficiar de uma maior previsibilidade e eficiência, possibilitando um atendimento mais ágil às necessidades de coleta.

![Exemplo de um Modelo BPMN do PROCESSO 1](images/processo-1-gestao-de-residuos.png "Modelo BPMN do Processo de Registrar Resíduos.")

#### Detalhamento das atividades

**Realizar login no sistema**

| **Campo**       | **Tipo**         | **Restrições**         | **Valor default** |
| --------------- | ---------------- | ---------------------- | ----------------- |
| login           | Caixa de Texto   | formato de e-mail      |                   |
| senha           | Caixa de Texto   | mínimo de 8 caracteres |                   |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| -------------------- | ------------------------------ | ----------------- |
| Entrar               | Página inicial do sistema      | default           |
| Cadastrar            | Início do proceso de cadastro  |                   |

**Registrar resíduo**

| **Campo**                      | **Tipo**         | **Restrições**                                                 | **Valor default** |
| ------------------------------ | ---------------- | -------------------------------------------------------------- | ----------------- |
| Tipo de Resíduo                | Seleção Única    | Plástico, papel, vidro, metal, resíduos eletrônicos e tetrapak |                   |
| Quantidade                     | Número           | Número decimal positivo                                        |                   |
| Unidade de Medida              | Seleção Única    | UN, KG, L e m³                                                 |                   |
| Data Disponível para Coleta    | Data             |                                                                |                   |
| Horário Disponível para Coleta | Hora             |                                                                |                   |
| Observações Adicionais         | Área de Texto    | Máximo de 300 caracteres                                       |                   |
| CEP                            | Caixa de Texto   | Formato de CEP                                                 |                   |
| Logradouro                     | Caixa de Texto   |                                                                |                   |
| Número                         | Número           | Número inteiro positivo                                        |                   |
| Complemento                    | Caixa de Texto   |                                                                |                   |
| Bairro                         | Caixa de Texto   |                                                                |                   |
| Cidade                         | Caixa de Texto   |                                                                |                   |
| Estado                         | Seleção Única    | Lista dos estados brasileiros                                  |                   |

| **Comandos**         |  **Destino**                                 | **Tipo**          |
| ---------------------| ---------------------------------------------| ------------------|
| Registrar            | Publicar demanda de coleta do resíduo        | default           |
| Cancelar             | Página inicial                               | cancel            |

**Editar resíduo**

| **Campo**                      | **Tipo**         | **Restrições**                                                 | **Valor default** |
| ------------------------------ | ---------------- | -------------------------------------------------------------- | ----------------- |
| Tipo de Resíduo                | Seleção Única    | Plástico, papel, vidro, metal, resíduos eletrônicos e tetrapak |                   |
| Quantidade                     | Número           | Número decimal positivo                                        |                   |
| Unidade de Medida              | Seleção Única    | UN, KG, L e m³                                                 |                   |
| Data Disponível para Coleta    | Data             |                                                                |                   |
| Horário Disponível para Coleta | Hora             |                                                                |                   |
| Observações Adicionais         | Área de Texto    | Máximo de 300 caracteres                                       |                   |
| CEP                            | Caixa de Texto   | Formato de CEP                                                 |                   |
| Logradouro                     | Caixa de Texto   |                                                                |                   |
| Número                         | Número           | Número inteiro positivo                                        |                   |
| Complemento                    | Caixa de Texto   |                                                                |                   |
| Bairro                         | Caixa de Texto   |                                                                |                   |
| Cidade                         | Caixa de Texto   |                                                                |                   |
| Estado                         | Seleção Única    | Lista dos estados brasileiros                                  |                   |

| **Comandos**         |  **Destino**                                 | **Tipo**          |
| ---------------------| ---------------------------------------------| ------------------|
| Atualizar            | Publicar alterações do resíduo               | default           |
| Cancelar             | Página inicial                               | cancel            |

**Excluir resíduo**

| **Comandos**         |  **Destino**                                 | **Tipo**          |
| ---------------------| ---------------------------------------------| ------------------|
| Excluir              | Excluir resíduo                              |                   |
| Cancelar             | Página inicial                               | cancel            |
