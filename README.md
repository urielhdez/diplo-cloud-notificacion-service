# Getting Started

## Project

Implementation of notification microservice for the Pixup application.
The notification will be created for the following event:
- User Register

The following scripts are provided for the MongoDB database/collections creation:
* notificaciondb_creation.js
* tipo_notificacion_collection.js

## Deploy

`// TODO `

## Test

Execute the next `curl` command to validate the deploy of the service. 

```shell
curl -X 'POST' \
  'http://localhost:8081/api/notificaciones/usuario' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
    "idUsuario": "64f76d1d08199c722d6bc041",
    "email": "urielhdezorozco@yahoo.com.mx"
}' 
```

The expected result should looks like:

```
{
    "id": "65172566daeae0673186f249",
    "fechaNotificacion": "2023-09-29T13:28:38.327-06:00",
    "idUsuario": "64f76d1d08199c722d6bc041",
    "email": "urielhdezorozco@yahoo.com.mx"
}
```
 
### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.15/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.15/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.15/reference/htmlsingle/index.html#web)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/2.7.15/reference/htmlsingle/index.html#data.nosql.mongodb)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

