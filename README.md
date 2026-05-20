# Gerenciador de Estoque

Aplicação simples em Spring Boot para gerenciar produtos 

## Como rodar

Pré-requisitos: Java 11+, Maven, e um banco PostgreSQL disponível.

1. Configure as variáveis de ambiente (opcional) ou edite `src/main/resources/application.properties`:

```
DB_USERNAME=postgres
DB_PASSWORD=suasenha
```

2. Rodar com Maven:

```bash
mvn spring-boot:run
```

## Observações de segurança

- O repositório contém apenas código fonte e arquivos de configuração de exemplo. Não comite senhas ou tokens.
- Use variáveis de ambiente ou um gerenciador de segredos para valores sensíveis (ex.: `DB_PASSWORD`).

## Estrutura

- `src/main/java` — código fonte
- `src/main/resources` — configurações e recursos estáticos

## Licença

Uso pessoal / educacional.
