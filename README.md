## Score Checker API
> Aims to study and apply the current best practices on Micro Services and distributed systems approach
### Technology stack
* Java v.17
* Spring Boot (Tomcat server), Security (JWT auth)
* Eureka - Service Discovery 
* Resilience4J - Circuit Breaker

## Useful commands

### Running app locally 
* ```mvn clean install```
* ```cd /target```
* ```java -jar score-checker-api-0.0.01-SNAPSHOT.jar```
### Docker
* Building docker image:
```docker build [DOCKER_FILE_PATH] -T {tag}:{version}```
* Running Docker container:
``` docker run --name score-checker-api -d -p 80:8080 score-checker-api:{version}```
*  Getting other container IP:
``` docker inspect {container_name}} | grep IPAddress```