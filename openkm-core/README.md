# openkm-core

The core module of openkm

## Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#web)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#using.devtools)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#appendix.configuration-metadata.annotation-processor)

## Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

## Install

### Bash

```bash
./build.sh
```

### PowerShell

```bash
pwsh ./build.ps1
```

## Usage

This project is used for plugin only , please add the following code in `pom.xml`

```xml
<dependency>
    <groupId>space.terwer</groupId>
    <artifactId>openkm-core</artifactId>
    <version>1.0.2</version>
</dependency>
```

## Run

1. Navigate to `OpenkmCoreApplication` via `openkm-core/src/main/java/space/terwer/openkm/core/OpenkmCoreApplication.java` , then start the `main` method.

2. View url is:

http://localhost:8888