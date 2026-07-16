# 🚀 Proyecto Elitec

Sistema web desarrollado como proyecto académico utilizando una arquitectura cliente-servidor.

* **Backend:** Java + Spring Boot
* **Frontend:** Angular
* **Base de datos:** PostgreSQL
* **Control de versiones:** Git y GitHub

## 📋 Descripción

Proyecto desarrollado para implementar una aplicación web moderna siguiendo buenas prácticas de desarrollo de software, separación entre frontend y backend, consumo de servicios REST y trabajo colaborativo mediante Git y GitHub.

## 🛠️ Tecnologías utilizadas

### Backend

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* Maven
* PostgreSQL

### Frontend

* Angular
* TypeScript
* HTML5
* CSS3
* Bootstrap / Angular Material (según corresponda)

### Herramientas

* Git
* GitHub
* Postman
* Visual Studio Code
* IntelliJ IDEA

## 📂 Estructura del proyecto

```text
elitec/
├── backend/      # API REST desarrollada con Spring Boot
├── frontend/     # Aplicación Angular
└── README.md
```

## 👥 Integrantes del equipo

| Integrante                        | GitHub                               |
| --------------------------------- | ------------------------------------ |
| Josue Jesús Ibáñez Campos         | https://github.com/ibca2994-dev      |
| Luis Miguel De la Fuente Felipa   | https://github.com/Jocker934         |
| Bryan Alexander Quintanilla Gómez | https://github.com/BQuintanillaGomez |
| Benavente Arestegui,Alexander  	  | https://github.com/alexbena20		     
| Mazo Tabares,Emanuel  	          | https://github.com/emanuelmazotabares-ctrl		     

## ▶️ Ejecución del proyecto

### Backend

```bash
cd backend
mvn spring-boot:run
```

El servidor estará disponible en:

```
http://localhost:8080
```

### Frontend

```bash
cd frontend
npm install
ng serve
```

La aplicación estará disponible en:

```
http://localhost:4200
```

## 🌿 Flujo de trabajo con Git

El proyecto utiliza GitFlow para facilitar el desarrollo colaborativo mediante ramas.

* `main` → Versión estable.
* `develop` → Integración de nuevas funcionalidades.
* `feature/*` → Desarrollo de nuevas características.
* `bugfix/*` → Corrección de errores.

## 📄 Licencia

Proyecto desarrollado con fines académicos.
