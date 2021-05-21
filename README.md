
# Simple Token Generator

Um gerador de UUID com cache de 5 segundos.


## Tech Stack

**Server:** Spring Boot, Maven, Java 11 e Redis(spring e lettuce)



## Run Locally

Clone the project

```bash
  git clone https://github.com/felipejsm/simple-token-generator.git
```

Go to the project directory

```bash
  cd simple-token-generator
```

Change branch
```bash
 checkout maven-dependency
```

Install dependencies

```bash
  mvn clean install
```

Dependency created as follow

```bash
    <dependency>
            <groupId>com.nssp</groupId>
            <artifactId>token</artifactId>
            <version>0.0.1</version>
    </dependency>
```