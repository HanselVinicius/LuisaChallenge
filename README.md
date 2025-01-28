# Desafio Técnico LuizaLabs
Este repositório contém a implementação do Desafio Técnico proposto pela LuizaLabs. O desafio visa testar habilidades de desenvolvimento utilizando boas práticas de arquitetura e ferramentas modernas.

## 1. Introdução
A linguagem de programação escolhida para o desenvolvimento deste projeto foi Kotlin, devido à sua simplicidade, expressividade e eficácia, proporcionando um código mais conciso e fácil de manter.

## 2. Arquitetura
A arquitetura adotada no projeto foi baseada nos princípios da **Clean Architecture**, combinada com conceitos de **Domain-Driven Design (DDD)**.  
Essa abordagem visa proporcionar **maior testabilidade, desacoplamento e facilidade de manutenção**, organizando o código de forma modular e garantindo que as regras de negócio sejam o foco central da aplicação.

### **🔹 Clean Architecture e DDD**
A organização do código segue **os princípios da Clean Architecture**, garantindo um forte desacoplamento entre as camadas e facilitando testes automatizados. Além disso, alguns conceitos do **DDD (Domain-Driven Design)** foram aplicados para melhorar a modelagem do domínio:

- **Agregados:** Estruturas que agrupam entidades relacionadas e garantem a consistência das regras de negócio.
- **Interfaces Reveladoras de Intenção:** Uso de interfaces bem definidas para melhorar a expressividade e reduzir o acoplamento.
- **Orientação ao Domínio:** O código foi estruturado de forma a priorizar a lógica de negócio sobre detalhes técnicos.
- **Services:** Camada de **application services** responsável por orquestrar regras de negócio e coordenar operações.
- **Repositories:** Implementação de repositórios que encapsulam operações de acesso aos dados, garantindo um melhor isolamento da persistência.

### **🔹 Referências sobre Clean Architecture**
Se quiser aprofundar mais nesses conceitos, recomendamos a leitura dos seguintes artigos:

- [Criando uma aplicação modular muito além do Clean Architecture](https://medium.com/luizalabs/criando-uma-aplica%C3%A7%C3%A3o-modular-muito-al%C3%A9m-do-clean-architecture-5dde3687c5d6)
- [Descomplicando a Clean Architecture](https://medium.com/luizalabs/descomplicando-a-clean-architecture-cf4dfc4a1ac6)

---

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
OBS: no arquivo .env deve ser linkado o nome do container para funcionamento
ex:
```
DB_HOST=mysql
```
AVISO!!! O CONTEINER DO APP PODE DEMORAR UM POUCO PARA SER CONSTRUIDO

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

- Certifique-se de ter o banco de dados corretamente configurado e rodando.
- Versão do java: 21
- Em seguida, execute a aplicação normalmente.
