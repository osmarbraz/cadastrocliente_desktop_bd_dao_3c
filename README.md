# Sistema de Cadastro de Clientes para Desktop em Banco de Dados em 3 camadas utilizando o padrão Abstract Factory.

## Contextualização

 - O projeto é uma versão do sistema para a IDE NetBeans.<br> 
 - O projeto no NetBeans deve ser chamado cadastrocliente_desktop_bd_dao_3c.<br>
 - Programa desenvolvido no Java Development Kit 1.8.
 - Utiliza o Apache Maven para a automatização da construção.
 - Os arquivos .bat permite sua compilação e execução via linha de comando, estando o java configurado.<br>
 - Este programa possui diversas classes organizada nos pacotes visão, controle, modelo e dao.<br>
 - Utiliza o padrão abstract factory para abstrair 3 formas de armazenamento:
	- 1 - Banco de Dados(Oracle)
	- 2 - HashMap
	- 3 - Arquivo Binário
 - A aplicação esta configurada para utilizar inicialmente memória principal(Hashmap) para armazenamento.
 - Se desejar utilizar outra fonte de dados, edite o arquivo src\dao\Factory.java alterando a FABRICA para outro valor.
 - Toda iteração com banco de dados é tratada diretamente pelo DAO(Data Access Object).<br>
 - Os dados de configuração (Servidor, Database, Usuario, Senha) da integração do java com o banco de dados estão no arquivo src/dao/OracleDAOFactory.java.<br>
 - A especificação da fábrica a ser utilizada é feita na interface Factory.java.
 - Crie o banco de dados antes de executar o projeto, as especificações das tabelas estão no arquivo banco_oracle.sql.<br>
 - A pasta src\main contêm os fontes do projeto.<br>
 - A pasta src\test contêm os testes unitários do projeto utilizando JUnit 4.<br>

## Arquivos

- *.sql - Script do banco de dados.
- build.xml - Arquivo de configuração da ferramenta de automação Ant.
- *.bat - Arquivos de lote(Batch) de console para tarefas compilar, executar, documentar, empacotar e limpar o projeto.