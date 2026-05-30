# Stock Manager

Aplicacao simples de controle de estoque feita com Spring Boot, JPA e PostgreSQL.

O projeto possui uma API REST para cadastrar, listar, atualizar e remover produtos. Tambem inclui uma pagina web simples em `src/main/resources/static/index.html`.

## Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

## Estrutura

```text
src/main/java/com/estoque
|-- GerenciadorApplication.java
|-- controller/ProductController.java
|-- model/Product.java
`-- repository/ProductRepository.java

src/main/resources
|-- application.properties
`-- static/index.html
```

## Banco de dados

Por padrao, a aplicacao tenta conectar em:

```text
jdbc:postgresql://localhost:5432/meubanco
```

Crie o banco no PostgreSQL:

```sql
CREATE DATABASE meubanco;
```

Configure usuario e senha por variaveis de ambiente:

```powershell
$env:DB_USERNAME="postgres"
$env:DB_PASSWORD="sua_senha"
```

## Como rodar

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

Em Linux/macOS:

```bash
./mvnw spring-boot:run
```

Depois acesse:

```text
http://localhost:8080
```

## Testes

Os testes usam H2 em memoria, entao nao precisam do PostgreSQL local:

```powershell
.\mvnw.cmd test
```

## Rotas da API

| Metodo | Rota | Descricao |
| --- | --- | --- |
| `GET` | `/api/produtos` | Lista todos os produtos |
| `POST` | `/api/produtos` | Cadastra um produto |
| `PUT` | `/api/produtos/{id}` | Atualiza um produto |
| `DELETE` | `/api/produtos/{id}` | Remove um produto |

Exemplo de JSON para cadastro:

```json
{
  "nome": "Monitor",
  "quantidade": 10,
  "preco": 799.9
}
```

## Observacoes

- A tabela `produtos` e criada/atualizada automaticamente pelo Hibernate.
- Nao salve senhas diretamente no codigo.
- Use as variaveis `DB_USERNAME` e `DB_PASSWORD` para credenciais locais.
