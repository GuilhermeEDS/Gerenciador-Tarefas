# Gerenciador de Tarefas

# Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina o:
* [JAVA 11](https://www.java.com/en/download/)
* [NODE](https://nodejs.org/en) 
* [PostgreSQL 16.0](https://www.postgresql.org/)

# Rodando o Projeto

## Para compilar o frontend:
Abra a pasta frontend e rode os seguintes comandos:
1. ```$ npm install```
2. ```$ npm start```

## para compilar o backend siga os passos:
Crie um banco local chamado tarefas.
No arquivo do backend 'backend//application.properties' do projeto altere as configurações do banco para seu banco local.
Abra a pasta backend e rode os seguintes comandos:
1. ```$ ./mvnw install```
2. ```$ ./mvnw spring-boot:run```
