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