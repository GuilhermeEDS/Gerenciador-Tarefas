# Gerenciador de Tarefas

## Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina o:
* [Git](https://git-scm.com)
* JAVA11
* NODE 
* ANGULAR
* [PostgreSQL](https://www.postgresql.org/)

## Rodando o Projeto

```bash
# Clone o seguinte repositório:
$ git clone https://github.com/GuilhermeEDS/Gerenciador-Tarefas.git

# Para compilar o front:
1. Abra a pasta frontend e rode os seguintes comandos:
	2. npm install
	3. npm start

# para compilar o back siga os passos:
1. Abra a pasta backend e rode os seguintes comandos:
	2. ./mvnw install
	3. ./mvnw spring-boot:run

# Para configurar o banco local siga os passos:
1. Crie um banco local vazio.
2. No arquivo 'application.properties' do projeto altere as configurações do banco para seu banco local.
```