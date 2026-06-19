# API PEDIDOS

Proyecto desarrollado para el Examen de Spring Boot.

## Tecnologías utilizadas

- Java 21
- Spring Boot 3
- PostgreSQL
- Maven
- JPA / Hibernate
- JUnit 5
- Mockito
- Postman

---

## Funcionalidades

### Clientes

- Registrar cliente
- Listar clientes
- Buscar cliente por ID

### Productos

- Registrar producto
- Listar productos
- Buscar producto por ID

### Pedidos

- Registrar pedido
- Calcular total automáticamente
- Validar stock disponible
- Actualizar stock al generar pedido

---

## Manejo de excepciones

### StockInsuficienteException

Se genera cuando la cantidad solicitada supera el stock disponible.

### PedidoNotFoundException

Se genera cuando se consulta un pedido inexistente.

---

## Endpoints

### Clientes

POST /clientes

GET /clientes

GET /clientes/{id}

---

### Productos

POST /productos

GET /productos

GET /productos/{id}

---

### Pedidos

POST /pedidos

GET /pedidos

GET /pedidos/{id}

---

## Pruebas unitarias

Pruebas realizadas con:

- JUnit 5
- Mockito

Resultado:

```text
BUILD SUCCESS
Tests run: 10
Failures: 0
Errors: 0
Skipped: 0
