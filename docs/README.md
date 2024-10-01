# ReCiclo

**Ítalo Vitorino Batista Silva, italo.vitorinobs@hotmail.com**

**João Pedro Vitor de Oliveira, joao.pvo44@gmail.com**

**Leonardo Cesar da Silva, le0c3sar@gmail.com**

**Leonardo Lopes de Vasconcelos Paes, leolpaes@gmail.com**

**Matheus Ferreira Titton, matheustitton@gmail.com**

**Pedro Henrique Barbosa Montandon de Araujo, pedrobarbosa89@gmail.com**

**Rafael de Paiva Gomes, rafaeldepaivagomes@outlook.com**

---

Professores:

** Aline Norberta de Brito **

** Cleia Marcia Gomes Amaral **

** Cristiano de Macedo Neto **

---

_Curso de Engenharia de Software_

_Instituto de Informática e Ciências Exatas – Pontifícia Universidade Católica de Minas Gerais (PUC MINAS), Belo Horizonte – MG – Brasil_

---

_**Resumo**. O projeto ReCiclo busca conectar coletadores de resíduos recicláveis e seus produtores por meio de uma plataforma web, com o objetivo de melhorar a eficiência da coleta seletiva e a geração de renda sustentável. O projeto aborda a ineficiência do atual sistema de coleta seletiva, destacando desafios como cobertura geográfica limitada, falta de infraestrutura e baixa conscientização da população. A solução proposta é um sistema que otimiza a gestão, triagem e destinação dos resíduos, promovendo uma coleta mais eficaz e sustentável._

---


## 1. Introdução

O projeto ReCiclo visa desenvolver maneiras de coletadores de resíduos recicláveis e seus produtores se conectarem, auxiliando no processo de reciclagem e na geração de renda ambientalmente correta.

### 1.1 Contextualização

A coleta seletiva é um elemento fundamental na gestão dos resíduos sólidos urbanos, desempenhando um papel crucial na reciclagem e na redução dos impactos ambientais. Segundo o IBGE (Instituto Brasileiro de Geografia e Estatística), apenas 16% dos municípios brasileiros realizam a coleta seletiva de maneira adequada, o que evidencia um déficit significativo nesse serviço essencial. Apesar de sua importância, a eficiência desse processo é frequentemente comprometida por uma série de desafios.**[1.1]**  
A cobertura geográfica da coleta seletiva é muitas vezes limitada, deixando áreas significativas sem acesso a esse serviço essencial. De acordo com o relatório da Associação Brasileira de Empresas de Limpeza Pública e Resíduos Sólidos (ABRELPE), em 2020, 60% das cidades brasileiras não ofereciam coleta seletiva, o que demonstra a necessidade de expandir essa prática.**[1.2]** Além disso, a falta de infraestrutura adequada, como lixeiras apropriadas, veículos especializados e centros de triagem, impede a execução eficaz das operações de coleta. Um estudo realizado pelo Instituto de Estudos de Política Econômica (IEPE) destaca que a falta de infraestrutura resulta em desperdício e em uma taxa de recuperação de materiais recicláveis muito baixa, em torno de 3%.**[1.3]**
Outro fator relevante é a falta de conscientização e educação da população sobre a importância e os procedimentos corretos para a separação dos resíduos recicláveis. Pesquisas realizadas pela ONG Pacto pelo Riacho do Ipiranga revelaram que cerca de 70% da população ainda não sabe como separar corretamente os resíduos recicláveis, o que prejudica a eficácia da coleta seletiva.**[1.4]**
A diversidade nos modelos de coleta, que varia entre diferentes regiões, também contribui para a confusão e a ineficácia do sistema. A pesquisa da consultoria KPMG sobre Gestão de Resíduos Sólidos indica que as diferenças nos modelos de coleta (seletiva, coleta na porta, ecopontos, entre outros) dificultam a padronização e a compreensão por parte dos cidadãos.**[1.5]** Por fim, a ausência de monitoramento eficiente e de indicadores claros de desempenho dificulta a identificação de áreas problemáticas e a implementação de melhorias. A pesquisa de 2021 do Programa das Nações Unidas para o Meio Ambiente (PNUMA) mostrou que apenas 24% dos municípios brasileiros monitoram suas atividades de coleta seletiva, o que impede uma avaliação precisa das necessidades e dos impactos desse serviço.**[1.6]**


### 1.2 Problema

Esses fatores combinados resultam em uma ineficiência generalizada no sistema de coleta seletiva, afetando negativamente todo o ciclo de reciclagem, desde a coleta até a destinação final dos resíduos recicláveis. A falta de uma gestão eficiente, aliada a barreiras estruturais e educacionais, compromete a sustentabilidade ambiental e a eficácia do processo de reciclagem. 
O problema central é, portanto, a ineficiência multifacetada da coleta seletiva, que exige soluções integradas, como a implementação de uma aplicação Web que possa auxiliar na superação desses desafios, melhorando a gestão, triagem e destinação dos resíduos recicláveis, e, assim, promovendo uma coleta seletiva mais eficaz e sustentável.


### 1.3 Objetivo geral

No caso específico deste projeto, o objetivo deste trabalho é desenvolver um sistema web que aumente a eficiência da coleta seletiva, enfrentando os desafios de cobertura geográfica limitada, falta de infraestrutura adequada, e a ausência de monitoramento eficaz.

#### 1.3.1 Objetivos específicos

a) Disponibilizar uma plataforma onde o coletor de resíduos recicláveis poderá mapear as ofertas dos mesmos resíduos;
b) Disponibilizar um local onde o produtor de resíduo reciclável poderá evacuar os resíduos;
c) Criar e otimizar uma rede de reciclagem em que os usuários possam se conhecer, se avaliar e, então, ter confiança no uso do sistema e no processo de reciclagem.

### 1.4 Justificativas

O desenvolvimento deste aplicativo é justificado pela necessidade urgente de otimizar a gestão de resíduos, uma área essencial para a sustentabilidade e a eficiência urbana. Atualmente, a comunicação fragmentada entre produtores de lixo e transportadores resulta em ineficiências operacionais, altos custos e dificuldades logísticas que impactam negativamente tanto o meio ambiente quanto a economia.

Além disso, a ausência de uma plataforma centralizada que conecte esses atores de maneira eficaz cria barreiras para a formação de parcerias estáveis e para a utilização otimizada dos recursos, como veículos de coleta. Ao resolver esses problemas, o aplicativo não apenas melhora a eficiência na coleta de resíduos, mas também promove práticas mais sustentáveis, beneficiando a sociedade como um todo.

## 2. Participantes do processo

Os Produtores de Lixo são responsáveis por identificar e sinalizar os resíduos que precisam ser coletados, fornecendo informações como tipo de material e localização. Já os Coletores de Lixo utilizam o aplicativo para receber essas informações em tempo real, planejar rotas de coleta e otimizar o processo, garantindo um serviço eficiente e sustentável para a comunidade.

## 3. Modelagem do processo de negócio

### 3.1. Análise da situação atual

Atualmente, a conexão entre produtores de lixo e transportadores é realizada de forma fragmentada e ineficiente. Muitos produtores dependem de contatos informais, como ligações telefônicas ou indicações pessoais, para encontrar transportadores disponíveis. Esse processo é demorado, pouco confiável e geralmente não permite a comparação de preços ou a escolha da melhor opção.

Transportadores, por sua vez, muitas vezes operam com base em demanda instável e irregular, recebendo chamadas esporádicas que resultam em rotas subótimas e veículos subutilizados. Não existe uma plataforma centralizada que facilite essa comunicação, o que leva a dificuldades na coordenação e negociação, impactando diretamente nos custos e na eficiência operacional.

A falta de um sistema estruturado também dificulta o estabelecimento de parcerias de longo prazo, tornando o processo mais vulnerável a falhas de comunicação e a atrasos no recolhimento de resíduos. Em resumo, o processo atual é manual, fragmentado e carece de eficiência, o que torna evidente a necessidade de uma solução integrada e tecnológica.

### 3.2. Descrição geral da proposta de solução

A proposta da Reciclo visa simplificar o processo de coleta e reciclagem de resíduos, atuando como um intermediário centralizado entre coletores de lixo e produtores de resíduos. A plataforma centralizará vários processos essenciais, cada um projetado para resolver aspectos específicos do problema de forma eficiente e prática. Aqui estão os principais processos e suas respectivas funções:

Registro de Resíduo:
Pelo produtor – Este processo permite que os produtores de resíduos registrem informações detalhadas sobre o lixo que precisam descartar. Eles especificam a quantidade, o tipo de resíduo e o local de busca. Esse processo é crucial para garantir que os coletores recebam informações precisas e completas, facilitando a logística da coleta e assegurando que os resíduos sejam manuseados adequadamente.

Aceitar Coleta:
Pelo coletor – Neste estágio, os coletores podem visualizar os registros de resíduos disponíveis e selecionar os lotes de interesse. Eles manifestam sua disponibilidade para realizar a coleta, o que otimiza a distribuição do trabalho e evita sobrecarga para os coletores. Isso garante uma coleta mais rápida e eficiente, além de reduzir o tempo de espera para os produtores de resíduos.

Gestão de Contas:
Para todos os usuários – A plataforma permite o cadastro de contas tanto para coletores quanto para produtores de resíduos. Esse processo facilita o gerenciamento de perfis, garantindo que os usuários possam acessar e interagir com o sistema de maneira personalizada e organizada.

Avaliação:
Entre usuários – A avaliação mútua entre produtores de resíduos e coletores é fundamental para manter a qualidade do serviço na plataforma. Após a coleta, ambas as partes podem avaliar sua experiência, ranqueando os melhores classificados na filtragem. Esse sistema de feedback contínuo promove a confiança na plataforma, incentiva a melhoria contínua dos serviços e ajuda novos usuários a tomar decisões baseadas em experiências reais.

Cada um desses processos foi pensado para abordar os principais desafios do setor, desde a eficiência logística até a confiabilidade do serviço. Ao integrar essas funcionalidades, a Reciclo não apenas facilita a interação entre produtores de resíduos e coletores, mas também promove práticas de descarte sustentável e eficaz, contribuindo para um ambiente mais limpo e seguro.

### 3.3. Modelagem dos processos

[PROCESSO 1 - Gestão de Resíduos](processo-1-gestao-de-residuos.md "Detalhamento do Processo 1.")

[PROCESSO 2 - Realizar Coleta](processo-2-realizar-coleta.md "Detalhamento do Processo 2.")

[PROCESSO 3 - Registro de Usuário](processo-3-registro-de-usuario.md "Detalhamento do Processo 3.")

[PROCESSO 4 - Avaliação](processo-4-Avaliacao.md "Detalhamento do Processo 4.")

## 4. Projeto da solução

_O documento a seguir apresenta o detalhamento do projeto da solução. São apresentadas duas seções que descrevem, respectivamente: modelo relacional e tecnologias._

[Projeto da solução](solution-design.md "Detalhamento do projeto da solução: modelo relacional e tecnologias.")


## 5. Indicadores de desempenho

_O documento a seguir apresenta os indicadores de desempenho dos processos._

[Indicadores de desempenho dos processos](performance-indicators.md)


## 6. Interface do sistema

_A sessão a seguir apresenta a descrição do produto de software desenvolvido._ 

[Documentação da interface do sistema](interface.md)

## 7. Conclusão

_Apresente aqui a conclusão do seu trabalho. Deve ser apresentada aqui uma discussão dos resultados obtidos no trabalho, local em que se verifica as observações pessoais de cada aluno. Essa seção poderá também apresentar sugestões de novas linhas de estudo._

# REFERÊNCIAS

**[1.1]** - _INSTITUTO BRASILEIRO DE GEOGRAFIA E ESTATÍSTICA (IBGE). **Estatísticas do Registro Civil**. Disponível em: https://www.ibge.gov.br._

**[1.2]** - _ASSOCIAÇÃO BRASILEIRA DE EMPRESAS DE LIMPEZA PÚBLICA E RESÍDUOS SÓLIDOS (ABRELPE). **Panorama dos Resíduos Sólidos no Brasil.** Disponível em: https://www.abrelpe.org.br._

**[1.3]** - _INSTITUTO DE ESTUDOS DE POLÍTICA ECONÔMICA (IEPE). **Estudo sobre a Infraestrutura de Resíduos Sólidos**. Disponível em: http://www.iepe.org.br._

**[1.4]** - _PACTO PELO RIACHO DO IPIRANGA. **Pesquisa sobre Conscientização da População em Relação à Coleta Seletiva.** Disponível em: https://pactopeloriachodoi.com.br._

**[1.5]** - _KPMG. **Gestão de Resíduos Sólidos: Desafios e Oportunidades.** Disponível em: https://home.kpmg._

**[1.6]** - _PROGRAMA DAS NAÇÕES UNIDAS PARA O MEIO AMBIENTE (PNUMA). **Relatório Mundial sobre Resíduos Sólidos.** Disponível em: https://www.unep.org_

_Como um projeto de software não requer revisão bibliográfica, a inclusão das referências não é obrigatória. No entanto, caso você deseje incluir referências relacionadas às tecnologias, padrões, ou metodologias que serão usadas no seu trabalho, relacione-as de acordo com a ABNT._

_Verifique no link abaixo como devem ser as referências no padrão ABNT:_

http://portal.pucminas.br/imagedb/documento/DOC_DSC_NOME_ARQUI20160217102425.pdf

**[1.1]** - _ELMASRI, Ramez; NAVATHE, Sham. **Sistemas de banco de dados**. 7. ed. São Paulo: Pearson, c2019. E-book. ISBN 9788543025001._

**[1.2]** - _COPPIN, Ben. **Inteligência artificial**. Rio de Janeiro, RJ: LTC, c2010. E-book. ISBN 978-85-216-2936-8._

**[1.3]** - _CORMEN, Thomas H. et al. **Algoritmos: teoria e prática**. Rio de Janeiro, RJ: Elsevier, Campus, c2012. xvi, 926 p. ISBN 9788535236996._

**[1.4]** - _SUTHERLAND, Jeffrey Victor. **Scrum: a arte de fazer o dobro do trabalho na metade do tempo**. 2. ed. rev. São Paulo, SP: Leya, 2016. 236, [4] p. ISBN 9788544104514._

**[1.5]** - _RUSSELL, Stuart J.; NORVIG, Peter. **Inteligência artificial**. Rio de Janeiro: Elsevier, c2013. xxi, 988 p. ISBN 9788535237016._



# APÊNDICES


_Atualizar os links e adicionar novos links para que a estrutura do código esteja corretamente documentada._


## Apêndice A - Código fonte

[Código do front-end](../src/front) -- repositório do código do front-end

[Código do back-end](../src/back)  -- repositório do código do back-end


## Apêndice B - Apresentação final


[Slides da apresentação final](presentations/)


[Vídeo da apresentação final](video/)






