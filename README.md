# Projeto Calculadora com RMI

Este é um projeto de uma calculadora usando Remote Method Invocation (RMI) em Java. A calculadora permite realizar operações de soma, subtração, multiplicação, divisão e outras operações personalizadas fornecidas pelo cliente. O cliente se conecta ao servidor RMI para executar as operações de cálculo remotamente.

## Estrutura do Projeto

O projeto possui a seguinte estrutura de diretórios:

```css
├── src
│   ├── client
│   │   └── ClienteCalculadora.java
│   ├── server
│   │   └── ServidorCalculadora.java
│   ├── interfaces
│   │   ├── Calculadora.java
│   │   └── Numero.java
│   └── classes
│       ├── CalculadoraImplAvancada.java
│       ├── CalculadoraImplBasica.java
│       └── NumeroImpl.java
└── README.md
```

- O diretório `client` contém o arquivo `ClienteCalculadora.java`, responsável pela implementação do cliente que faz as chamadas à calculadora remota.
- O diretório `server` contém o arquivo `ServidorCalculadora.java`, responsável pela implementação do servidor que disponibiliza os métodos da calculadora remotamente.
- O diretório `interfaces` contém as interfaces `Calculadora.java` e `Numero.java`, que definem os métodos disponíveis na calculadora e a interface para representar um número.
- O diretório `classes` contém as classes de implementação `CalculadoraImplAvancada.java`, `CalculadoraImplBasica.java` e `NumeroImpl.java`, que são as implementações concretas das interfaces.

### Executando o Projeto (Geral)

Para executar o projeto, siga os passos abaixo:

1. Compile todos os arquivos Java presentes no diretório `src`:

```shell
javac -d bin src/*.java src/client/*.java src/server/*.java src/interfaces/*.java src/classes/*.java
```

1. Inicie o registro RMI no servidor:

```shell
rmiregistry
```

1. Execute o servidor:

```shell
java -classpath bin server.ServidorCalculadora <nome_servidor>
```

1. Execute o cliente:

```shell
java -classpath bin client.ClienteCalculadora <nome_repositorio>
```

### Customização da Calculadora

Caso deseje adicionar novas operações ou funcionalidades à calculadora, siga os passos abaixo:

1. Edite a interface `Calculadora.java` presente no diretório `interfaces` e adicione os métodos desejados.
2. Implemente os novos métodos na classe `CalculadoraImplAvancada.java` presente no diretório `classes`.
3. No cliente, chame os novos métodos da calculadora de acordo com as necessidades do projeto.

### Considerações Finais

Este projeto demonstra a implementação básica de uma calculadora remota usando RMI em Java. É importante ressaltar que este é um exemplo simples e pode ser expandido para atender requisitos específicos do seu projeto.

Sinta-se à vontade para explorar e personalizar o código de acordo com suas necessidades.
