# Winery - Checkpoint 1 - Arquitetura SOA e Web Services

## Disciplina
Arquitetura SOA e Web Services

## Professor
Carlos Eduardo Machado de Oliveira

## Objetivo
Desenvolver um Webservice SOAP do lado da publicação (Publisher) e do lado do consumo (Consumer) dos serviços, aplicando os conceitos iniciais de arquitetura orientada a serviços (SOA).

## Integrantes do Grupo
- Higor Kauan Bezerra Batista - RM558907
- Eric Yuji Ito - RM554869
- Bento Rangel da Silva - RM559124
- Ricardo Cerazi di Tilia - RM555155
- Kaue Pires Moreira - RM554403

## Estrutura do Projeto

```
Winery/
├── Publisher/
│   └── WinerySys/                          # Servidor SOAP (publicação dos serviços)
│       ├── pom.xml
│       └── src/main/java/br/com/fiap/winery/
│           ├── WineStockService.java               # Interface do serviço de estoque
│           ├── WineStockServiceImplementation.java  # Implementação do serviço de estoque
│           ├── WineWarningService.java              # Interface do serviço de aviso
│           ├── WineWarningServiceImplementation.java# Implementação do serviço de aviso
│           └── Loader.java                          # Classe driver (publica os endpoints)
│
├── Consumer/
│   ├── WineStockClient/                    # Cliente SOAP - consulta menu de vinhos
│   │   ├── pom.xml
│   │   └── src/main/java/br/com/fiap/winery/
│   │       └── ApplicationClient1.java
│   │
│   └── WineOrderClient/                    # Cliente SOAP - faz pedido e recebe avisos
│       ├── pom.xml
│       └── src/main/java/br/com/fiap/winery/
│           └── ApplicationClient2.java
│
└── README.md
```

## Tecnologias Utilizadas
- **Linguagem:** Java 17+
- **Build:** Maven
- **Framework SOAP:** Jakarta XML Web Services (jaxws-rt 4.0.2)
- **Plugin:** jaxws-maven-plugin (wsimport)

## Como Executar

### 1. Publicar os Serviços (Server)
```bash
cd Publisher/WinerySys
mvn clean compile exec:java -Dexec.mainClass="br.com.fiap.winery.Loader"
```
Ou compile e execute o `Loader.java` diretamente pela IDE.

Após executar, os serviços estarão disponíveis em:
- http://localhost:8085/WineStockService?wsdl
- http://localhost:8086/WineWarningService?wsdl

### 2. Gerar classes do cliente (wsimport)
Com o servidor rodando, execute o build Maven nos projetos clientes:
```bash
cd Consumer/WineStockClient
mvn clean generate-sources

cd ../WineOrderClient
mvn clean generate-sources
```

### 3. Executar os Clientes
```bash
# Cliente 1 - Consulta menu de vinhos
cd Consumer/WineStockClient
mvn compile exec:java -Dexec.mainClass="br.com.fiap.winery.ApplicationClient1"

# Cliente 2 - Faz pedido e recebe aviso de estoque
cd Consumer/WineOrderClient
mvn compile exec:java -Dexec.mainClass="br.com.fiap.winery.ApplicationClient2"
```

## Serviços Disponíveis

| Serviço | Porta | Endpoint | Descrição |
|---------|-------|----------|-----------|
| WineStockService | 8085 | /WineStockService | Menu de vinhos e pedidos |
| WineWarningService | 8086 | /WineWarningService | Aviso de estoque insuficiente |

## Métodos Expostos

### WineStockService
| Método | Retorno | Parâmetros | Descrição |
|--------|---------|------------|-----------|
| `getMenu()` | String | - | Retorna a lista de vinhos disponíveis |
| `placeOrder(name, quantity)` | String | String name, int quantity | Realiza um pedido de vinho |

### WineWarningService
| Método | Retorno | Parâmetros | Descrição |
|--------|---------|------------|-----------|
| `sendWarn()` | String | - | Retorna aviso de estoque insuficiente |
