# Sistema DJ - Gerenciamento Profissional de Áudio

## Visão Geral
O Sistema DJ é uma aplicação de gerenciamento de áudio profissional construída com JavaFX que fornece uma interface moderna para DJs gerenciarem e reproduzirem suas faixas musicais.

## Funcionalidades
- Reprodução de arquivos MP3 com controles profissionais
- Controle de volume e ajuste de velocidade
- Carregamento e gerenciamento de faixas
- Interface moderna em JavaFX
- Processamento de áudio em tempo real

## Requisitos do Sistema
- Java 11 ou superior
- Maven 3.9.x
- JavaFX runtime

## Dependências
- JavaFX
- JLayer (decodificador MP3)
- Maven (ferramenta de build)

## Instalação
1. Clone o repositório:
```bash
git clone [repository-url]
cd best-Project-With-JAVA
```

2. Compile o projeto usando Maven:
```bash
mvn clean install
```

## Executando a Aplicação
1. Usando Maven:
```bash
mvn javafx:run
```

2. Usando o arquivo JAR:
```bash
java -jar target/djsystem.jar
```

## Estrutura do Projeto
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── djsystem/
│   │           ├── Main.java
│   │           └── audio/
│   │               └── DeckPlayer.java
│   └── resources/
│       └── fxml/
│           └── main.fxml
mp3/
└── [arquivos de áudio]
```

## Como Usar
1. Inicie a aplicação
2. Carregue um arquivo MP3 usando o navegador de arquivos
3. Use os controles de reprodução para:
   - Reproduzir/Pausar faixas
   - Ajustar volume
   - Controlar velocidade de reprodução
   - Parar reprodução

## Contribuindo
Contribuições são bem-vindas! Sinta-se à vontade para enviar um Pull Request.

## Licença
Este projeto está licenciado sob a Licença MIT - consulte o arquivo LICENSE para detalhes.

## Suporte
Para suporte, por favor abra uma issue no repositório do projeto.