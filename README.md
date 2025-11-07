# Photos API - Integração com The Cat API

Este projeto consome dados da **[The Cat API](https://thecatapi.com/)** para buscar imagens de gatos e armazená-las em um banco **PostgreSQL**, utilizando **Spring Boot**, **WebClient** e **Docker**.  
Também expõe uma **API RESTful** para consultar os dados salvos.

---

## Tecnologias Utilizadas
- **Java 21**
-  **Spring Boot 3**
-  **PostgreSQL 16**
-  **Docker & Docker Compose**
-  **WebClient** (para requisição à API externa)
-  **Swagger/OpenAPI** (para documentação da API)

---

## Funcionalidades

- Buscar imagens de gatos via **GET** na The Cat API  
- Definir dinamicamente o número de imagens retornadas (`limit`)  
- Armazenar as imagens no banco PostgreSQL  
- Consultar todas as fotos salvas  
- Consultar uma foto por ID  

---

## Endpoints 
1. POST /photos/fetch?limit={número}
   Exemplo: <br>
   POST http://localhost:9000/photos/fetch?limit=5 <br>  
2. GET /photos 
   Exemplo: <br>
   http://localhost:9000/photos <br>  
3. GET /photos/{id}
   Exemplo: <br>
   http://localhost:9000/photos/bss <br>
