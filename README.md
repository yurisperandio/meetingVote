# Meeting Vote


## Configurando o Ambiente

Para executar a aplicação localmente, é necessário possuir instalado e configurado os seguintes programas:

- [Java JDK 11](https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=hotspot)
- [IDE IntelliJ](https://www.jetbrains.com/pt-br/idea/download/#section=windows) (Ou outra IDE de preferência)


## Código Fonte

Para executar a aplicação é necessário clonar o projeto:

```shell
git clone https://github.com/yurisperandio/meetingVote.git
```

## ENDPOINTS

A documentação da API pode ser encontrada no [Swagger](https://meetingvote.herokuapp.com/swagger-ui.html)

## Ferramentas

### Banco de Dados

O Banco de dados utilizado no projeto é o MySQL

### Heroku

A aplicação foi hospedada no Keroku, pela compatibilidade com aplicações Java e repositório para o MySQL, utilizando o ClearDB, e RabbitMQ através do CloudAMQP.

### RabbitMQ

Executar o RabbitMQ localhost, é necessário baixar o Docker, e executar o arquivo a seguir, na pasta onde está o arquivo docker-compose.yml (Disponível neste projeto).
Além disso, é necessário alterar os dados no application.properties, deixando as configurações para localhost descomentadas.
Executar o seguinte comando:

```shell
docker-compose up -d
```
