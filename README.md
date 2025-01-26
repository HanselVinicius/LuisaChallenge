# Desafio Técnico LuizaLabs
Este repositório contém a implementação do Desafio Técnico proposto pela LuizaLabs. O desafio visa testar habilidades de desenvolvimento utilizando boas práticas de arquitetura e ferramentas modernas.

## 1. Introdução
A linguagem de programação escolhida para o desenvolvimento deste projeto foi Kotlin, devido à sua simplicidade, expressividade e eficácia, proporcionando um código mais conciso e fácil de manter.

## 2. Arquitetura
A arquitetura adotada para o projeto foi Clean Architecture, que visa proporcionar maior testabilidade, desacoplamento e facilidade de manutenção. Essa abordagem organiza o código de maneira que as responsabilidades são bem definidas, e as dependências entre os módulos são mínimas.

Para mais detalhes sobre Clean Architecture, consulte os seguintes artigos:

Criando uma aplicação modular muito além do Clean Architecture
Descomplicando a Clean Architecture

## 3. Ferramentas Utilizadas
Para o desenvolvimento do projeto, foram utilizadas as seguintes ferramentas:

- Spring Boot: Framework para construção da aplicação, que oferece uma configuração simplificada e fácil de usar.
- Spring Security: Utilizado para garantir a segurança da aplicação, como autenticação e autorização.
- OpenAPI: Para a documentação da API de forma automatizada.
- JUnit: Framework para a realização de testes unitários e de integração.
- Mockito: Biblioteca para a criação de mocks nos testes.
- Docker: Utilizado para criar ambientes isolados, facilitando a execução e a implantação do projeto.
- Ktlint: Utilizado para padronização de code style
  
# 4. Como Executar o Projeto
Existem duas maneiras principais de rodar o projeto:

# 4.1. Usando Docker Compose
Você pode utilizar o Docker Compose para subir os containers necessários de forma simples e rápida. Para isso, siga os passos abaixo:

Crie um arquivo .env seguindo o modelo encontrado no arquivo env.example dentro do projeto.

Após configurar o .env, execute o seguinte comando para iniciar os containers:

```bash
docker compose up -d
```
OBS: no arquivo env deve ser linkado o nome do container para funcionamento
ex:
```
DB_HOST=mysql
```
# 4.2. Rodando na Sua Máquina Local
Alternativamente, é possível rodar o projeto diretamente na sua máquina. Para isso, você precisará ter o banco de dados configurado, seja localmente ou em um container.

Crie um arquivo .env conforme o exemplo fornecido.

```
DB_HOST=host
DB_PORT=port
DB_USER=user
DB_PASS=password
DB_NAME=dbname
MAIL_HOST=host
MAIL_PORT=port
MAIL_USER=user
MAIL_PASS=pass
MAIL_FROM=email@email.com
```

Certifique-se de ter o banco de dados corretamente configurado e rodando.
Versões do java 21
Em seguida, execute a aplicação normalmente.
