Boa tarde, Adriano!



Nas últimas 24h não tive tempo hábil para realizar os tópicos da avaliação prática com precisão. Estou com uma demanda muito alta no trabalho para executar projetos paralelos ("incêndio atrás de incêndio"). 

Desenvolvi no fim desta manhã uma aplicação para enviar o mais próximo ao prazo que consigo, nela fiz a captação dos candidatos utilizando Spring Boot em sua versão 2.5.2, para a persistência dos dados utilizei JPA com os dados do banco solicitados (SGBD PostgreSQL), a própria aplicação já ira criar a estrutura no BD.

As páginas web contam com estilização em bootstrap e js para validação de CPF, data de nascimento e envio dos arquivos. a IDE utilizada foi o IntelliJ IDEA em sua última versão com as configurações em .gradle

A ideia para as tratativas de login era desenvolver a segurança com o Spring Boot Security Authentication com JPA, junto com as validações de sessão do usuário.

A retomada do candidato ao site após 24h para verificar se sua candidatura foi aceita ou não seria validada através do campo dt_solicitacao na tabela usuario, que salvaria a informação utilizando a função NOW() do postgre que já retorna a data no formato 2023-02-02 13:08:19.542212-03. 
Para suprir o item "O candidato que for reprovado, poderá fazer uma segunda solicitação, devendo essa ser tratada como uma nova solicitação;" seria criado um campo na tabela usuario:
 st_usuario (Situação do usuário [ck 1, 2, 3]
contaria com as opções 1 - Primeira solicitação
                                           2 - Segunda solicitação 
                                           3 - Reprovado.
A aplicação iria tratar o campo para realizar ou não a solicitação de cadastro
