# KAFKA SpringBoot

Solução para o agronegócio que coleta dados via sensores de temperatura e umidade.

A cada 10 segundos são enviados para o message broker os dados de temperatura e
umidade capturado naquele instante.

Além disso é possível acionar o rastreamento do drone.Esta funcionalidade resulta na localização do equipamento em um mapa.

![Diagrama](/diagrama.png)

## Docker compose

### kafka com docker
    docker-compose up

### running app with maven

environments
```
export consumer=true
export response=true
export server_port=8080

mvnw spring-boot:run
```
or
```
set JAVA_OPTS="-Xms128m -Xmx256m -d64"

set consumer=true
set response=false
set server_port=8081

mvnw spring-boot:run
```

