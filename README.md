# LABORATORIO - CASO 5: PRUEBAS UNITARIAS TABLA TYPES

## CONSTRUCCIÓN Y PRUEBAS DE SOFTWARE
**Semana 11 - Pruebas Unitarias con Base de Datos**

---

## 1. OBJETIVO

Realizar pruebas unitarias para la tabla **types** (tipos de mascotas) en la aplicación petclinic_test, implementando las operaciones CRUD: creación, actualización, búsqueda y eliminación de tipos de mascotas.

---

## 2. ESTRUCTURA DE ARCHIVOS IMPLEMENTADOS

### 2.1 Capa DTO
```
src/main/java/com/tecsup/petclinic/dtos/TypeDTO.java
```

### 2.2 Capa de Entidades
```
src/main/java/com/tecsup/petclinic/entities/Type.java
```

### 2.3 Capa de Excepciones
```
src/main/java/com/tecsup/petclinic/exceptions/TypeNotFoundException.java
```

### 2.4 Capa de Mappers
```
src/main/java/com/tecsup/petclinic/mappers/TypeMapper.java
```

### 2.5 Capa de Repositorios
```
src/main/java/com/tecsup/petclinic/repositories/TypeRepository.java
```

### 2.6 Capa de Servicios
```
src/main/java/com/tecsup/petclinic/services/TypeService.java
src/main/java/com/tecsup/petclinic/services/TypeServiceImpl.java
```

### 2.7 Capa de Pruebas
```
src/test/java/com/tecsup/petclinic/services/TypeServiceTest.java
```


---
## 3. PRUEBAS UNITARIAS IMPLEMENTADAS

### 3.1 testFindTypeById
*Objetivo:* Verificar la búsqueda de un tipo de mascota por ID.
- *ID esperado:* 1
- *Nombre esperado:* "cat"
- *Resultado:* ✅ EXITOSO

### 3.2 testFindTypeByName
*Objetivo:* Verificar la búsqueda de tipos por nombre.
- *Nombre buscado:* "dog"
- *Cantidad esperada:* 1
- *Resultado:* ✅ EXITOSO

### 3.3 testFindAllTypes
*Objetivo:* Verificar la recuperación de todos los tipos de mascotas.
- *Cantidad esperada:* 8
- *Resultado:* ✅ EXITOSO

### 3.4 testCreateType
*Objetivo:* Verificar la creación de un nuevo tipo de mascota.
- *Datos creados:*
  - Nombre: "guinea pig"
  - Descripción: "Small domestic rodent"
  - Categoría tamaño: "small"
  - Esperanza vida: 5 años
  - Nivel cuidado: "medium"
- *Resultado:* ✅ EXITOSO

### 3.5 testUpdateType
*Objetivo:* Verificar la actualización de un tipo existente.
- *Tipo inicial:* "parrot"
- *Tipo actualizado:* "parrot-updated"
- *Resultado:* ✅ EXITOSO

### 3.6 testDeleteType
*Objetivo:* Verificar la eliminación de un tipo de mascota.
- *Tipo creado:* "ferret"
- *Validación:* Verificación de que el registro no existe después de eliminar
- *Resultado:* ✅ EXITOSO

### 3.7 testFindTypesByActive
*Objetivo:* Verificar la búsqueda de tipos por estado activo.
- *Estado:* true
- *Cantidad mínima esperada:* 6
- *Resultado:* ✅ EXITOSO

---

## 4. EVIDENCIAS DE EJECUCIÓN

### 4.1 Comando de Ejecución
bash
mvn test -Dtest=TypeServiceTest


### 4.2 Resumen de Resultados

[INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
[INFO] Total time: 16.876 s


### 4.3 Logs de Ejecución Detallados

*Inicio de Spring Boot:*

Spring Boot :: (v3.5.6)
Starting TypeServiceTest using Java 17.0.12
The following 1 profile is active: "h2"


*Inicialización de Base de Datos H2:*

HikariPool-1 - Starting...
HikariPool-1 - Start completed.
H2 console available at '/h2'. Database available at 'jdbc:h2:mem:testdb'


*Ejecución de Pruebas:*

Total types found: 8
Creating type: TypeDTO(id=null, name=parrot, ...)
Type created: TypeDTO(id=9, name=parrot, ...)
Type updated: TypeDTO(id=9, name=parrot-updated, ...)
Types found: 1
Type found: TypeDTO(id=1, name=cat, ...)
TYPE CREATED: TypeDTO(id=10, name=guinea pig, ...)
Active types found: 8
Type created for deletion: TypeDTO(id=11, name=ferret, ...)
Type deleted with id: 11
Validation successful: Type not found after deletion

---

## 5. CONSULTAS SQL EJECUTADAS

### 5.1 SELECT
sql
select t1_0.id, t1_0.active, t1_0.average_lifespan, t1_0.care_level, 
       t1_0.description, t1_0.name, t1_0.size_category 
from types t1_0


### 5.2 INSERT
sql
insert into types (active, average_lifespan, care_level, description, 
                   name, size_category, id) 
values (?, ?, ?, ?, ?, ?, default)


### 5.3 UPDATE
sql
update types 
set active=?, average_lifespan=?, care_level=?, 
    description=?, name=?, size_category=? 
where id=?


### 5.4 DELETE
sql
delete from types where id=?


---

## 6. TECNOLOGÍAS UTILIZADAS

- *Java:* 17.0.12
- *Spring Boot:* 3.5.6
- *Spring Data JPA:* Gestión de persistencia
- *Hibernate:* 6.6.29.Final (ORM)
- *H2 Database:* Base de datos en memoria para pruebas
- *JUnit 5:* Framework de pruebas unitarias
- *Lombok:* Reducción de código boilerplate
- *Maven:* Gestión de dependencias y construcción
- *Git:* Control de versiones

---

## 7. PATRÓN DE ARQUITECTURA

El proyecto implementa una arquitectura en capas:

1. *Capa de Presentación (DTO):* Transferencia de datos
2. *Capa de Negocio (Service):* Lógica de negocio
3. *Capa de Persistencia (Repository):* Acceso a datos
4. *Capa de Dominio (Entity):* Modelo de datos
5. *Capa de Mapeo (Mapper):* Conversión DTO ↔ Entity
6. *Capa de Pruebas (Test):* Validación de funcionalidad

---

## 8. CONTROL DE VERSIONES GIT

### 8.1 Comandos Utilizados
bash
git checkout -b feature/caso5-type-tests
git add .
git commit -m "Implementación CASO 5: Pruebas unitarias para tabla types"
git push origin feature/caso5-type-tests


### 8.2 Archivos Versionados
- 7 archivos Java principales
- 1 archivo de pruebas
- Configuración Maven (pom.xml)

---

## CONCLUSIONES

1. Se implementaron exitosamente las pruebas unitarias CRUD completas para la tabla types, logrando una cobertura del 100% en las operaciones básicas de creación, actualización, búsqueda y eliminación de tipos de mascotas.

2. El uso del patrón DTO-Mapper-Service-Repository permite una separación clara de responsabilidades, facilitando el mantenimiento del código y la escalabilidad del sistema. Esta arquitectura en capas mejora la testabilidad y reduce el acoplamiento entre componentes.

3. La utilización de la base de datos H2 en memoria para las pruebas unitarias garantiza la independencia de los tests respecto al entorno de producción, permitiendo pruebas rápidas, reproducibles y sin efectos secundarios en la base de datos real.

4. El framework JUnit 5 junto con Spring Boot Test proporciona un entorno robusto para la ejecución de pruebas, permitiendo la inyección de dependencias y la configuración automática del contexto de Spring, lo que simplifica significativamente el proceso de testing.

5. La implementación siguió exitosamente el patrón establecido en PetServiceTest, demostrando consistencia en el código y facilitando la comprensión del proyecto para futuros desarrolladores o mantenedores del sistema.

---

## RECOMENDACIONES

1. Implementar pruebas de integración adicionales que validen el comportamiento de múltiples componentes trabajando juntos.

2. Agregar pruebas de validación de datos para verificar restricciones de negocio como valores nulos, longitudes de campo y formatos específicos.

3. Considerar la implementación de pruebas de rendimiento para evaluar el comportamiento del sistema bajo carga.

4. Documentar el código con Javadoc para mejorar la mantenibilidad y facilitar la comprensión del sistema.

---
