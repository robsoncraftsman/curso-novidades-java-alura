# Java Platform Module System (JPMS) - Java 9

Recurso de módulos do Java 9 foi projetado para permitir uma melhor separação e encapsulamento da aplicação.

# Instruções

Para criar um módulo:

- Na pasta `src`, criar um diretório no formato (br.com.\<empresa\>.\<app\>.\<modulo\>). Ou seja, é o mesmo formato de nomes de pacotes, mas tudo concatenado como o nome do diretório.
- Criar um arquivo `module-info.java` na raíz do diretório do módulo.

# Exemplos de arquivos `module-info.java`

- Módulo para objetos de domínio:

```
module br.com.empresa.app.modelo {
	exports br.com.empresa.app.modelo.dominio;
}
```

- Módulo para objetos de acesso a dados DAO:

```
module br.com.empresa.app.dao {
	requires transitive br.com.empresa.app.modelo;
	exports br.com.alura.empresa.app.dao;
}
```
