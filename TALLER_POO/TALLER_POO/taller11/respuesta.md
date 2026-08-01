# Solución - Taller 2: Seguridad en Bases de Datos
**Estudiante:** Karol  
**Fecha:** 30 de Julio  
**SENA - ADSO**

---

### ① Completa el espacio en blanco (10 pts)
Escribe la palabra o valor que falta en cada instrucción SQL:

1. **Enunciado:** `CREATE ________ 'lector'@'localhost' IDENTIFIED BY 'Pass123!';`
   * **Respuesta:** `USER`
   * **Instrucción completa:** `CREATE USER 'lector'@'localhost' IDENTIFIED BY 'Pass123!';`

2. **Enunciado:** `GRANT SELECT ON taller_sena.* ________ 'lector'@'localhost';`
   * **Respuesta:** `TO`
   * **Instrucción completa:** `GRANT SELECT ON taller_sena.* TO 'lector'@'localhost';`

3. **Enunciado:** `REVOKE SELECT ________ taller_sena.* FROM 'lector'@'localhost';`
   * **Respuesta:** `ON`
   * **Instrucción completa:** `REVOKE SELECT ON taller_sena.* FROM 'lector'@'localhost';`

4. **Enunciado:** `ALTER USER 'lector'@'localhost' ACCOUNT ________;`
   * **Respuesta:** `LOCK` (o `UNLOCK`)
   * **Instrucción completa:** `ALTER USER 'lector'@'localhost' ACCOUNT LOCK;`

5. **Enunciado:** `SHOW ________ FOR 'lector'@'localhost';`
   * **Respuesta:** `GRANTS`
   * **Instrucción completa:** `SHOW GRANTS FOR 'lector'@'localhost';`

6. **Enunciado:** `CREATE ________ 'rol_soporte';`
   * **Respuesta:** `ROLE`
   * **Instrucción completa:** `CREATE ROLE 'rol_soporte';`

7. **Enunciado:** `GRANT 'rol_soporte' ________ 'lector'@'localhost';`
   * **Respuesta:** `TO`
   * **Instrucción completa:** `GRANT 'rol_soporte' TO 'lector'@'localhost';`

8. **Enunciado:** `SET DEFAULT ________ 'rol_soporte' FOR 'lector'@'localhost';`
   * **Respuesta:** `ROLE`
   * **Instrucción completa:** `SET DEFAULT ROLE 'rol_soporte' FOR 'lector'@'localhost';`

9. **Enunciado:** `________ PRIVILEGES; -- para aplicar cambios inmediatamente`
   * **Respuesta:** `FLUSH`
   * **Instrucción completa:** `FLUSH PRIVILEGES;`

10. **Enunciado:** `DROP ________ IF EXISTS 'lector'@'localhost';`
    * **Respuesta:** `USER`
    * **Instrucción completa:** `DROP USER IF EXISTS 'lector'@'localhost';`

---

### ② Encuentra el error (6 pts)
Cada línea tiene un error. Identifícalo y escribe la corrección:

* **a) `GRANT SELECT ON taller_sena TO 'app'@'localhost';`**
  * **Error:** Falta especificar a qué tablas de la base de datos se otorgan los permisos. En MySQL se requiere usar el comodín `.*` para referirse a todas las tablas de una base de datos.
  * **Corrección:** `GRANT SELECT ON taller_sena.* TO 'app'@'localhost';`

* **b) `GRANT ALL PRIVILEGES ON *.* TO 'app_web'@'localhost';`**
  * **Error:** Asignar `ALL PRIVILEGES` en `*.*` (todas las bases de datos y tablas de forma global) a un usuario de aplicación web (`app_web`) es una vulnerabilidad de seguridad grave que viola el principio de mínimo privilegio. Debe limitarse solo a la base de datos específica del aplicativo (ej. `taller_sena.*`).
  * **Corrección:** `GRANT ALL PRIVILEGES ON taller_sena.* TO 'app_web'@'localhost';` (o bien limitar a privilegios específicos como `SELECT, INSERT, UPDATE, DELETE` en lugar de `ALL PRIVILEGES`).

* **c) `CREATE USER 'ana' IDENTIFIED BY 'pass';`**
  * **Error:** Falta especificar el host de conexión (por ejemplo, `'localhost'` o `'%'`). Aunque MySQL asume `'%'` por defecto si se omite, en seguridad de bases de datos siempre se debe restringir el origen explícitamente. Además, la contraseña `'pass'` es extremadamente débil y no cumple con políticas de seguridad.
  * **Corrección:** `CREATE USER 'ana'@'localhost' IDENTIFIED BY 'ContrasenaSegura_2026!';`

* **d) `REVOKE DELETE FROM taller_sena.* TO 'lector'@'localhost';`**
  * **Error:** La sintaxis de `REVOKE` utiliza la palabra clave `ON` para indicar el objeto de la base de datos (en lugar de `FROM`) y la palabra clave `FROM` para indicar el usuario (en lugar de `TO`).
  * **Corrección:** `REVOKE DELETE ON taller_sena.* FROM 'lector'@'localhost';`

* **e) `SHOW GRANTS 'lector'@'localhost';`**
  * **Error:** Falta la palabra clave `FOR` antes del nombre del usuario.
  * **Corrección:** `SHOW GRANTS FOR 'lector'@'localhost';`

* **f) `GRANT 'rol_soporte' ON taller_sena.* TO 'ana'@'%';`**
  * **Error:** Los roles no se pueden otorgar especificando un objeto o base de datos con la cláusula `ON`. Los roles son contenedores globales de privilegios y se asignan directamente al usuario.
  * **Corrección:** `GRANT 'rol_soporte' TO 'ana'@'%';`

---

### ③ Del escenario a la instrucción SQL (12 pts)
Lee cada situación y escribe la instrucción SQL que la resuelve:

1. **El DBA necesita crear un usuario llamado vendedor que solo pueda conectarse desde la red interna (192.168.1.%).**
   * **Instrucción SQL:**
     ```sql
     CREATE USER 'vendedor'@'192.168.1.%' IDENTIFIED BY 'ClaveSeguraVendedor2026!';
     ```

2. **El usuario vendedor solo debe poder insertar y actualizar filas en la tabla pedidos de taller_sena.**
   * **Instrucción SQL:**
     ```sql
     GRANT INSERT, UPDATE ON taller_sena.pedidos TO 'vendedor'@'192.168.1.%';
     ```

3. **Se descubre que vendedor no debería poder actualizar pedidos. Quita ese permiso.**
   * **Instrucción SQL:**
     ```sql
     REVOKE UPDATE ON taller_sena.pedidos FROM 'vendedor'@'192.168.1.%';
     ```

4. **Crea un rol llamado rol_ventas y asígnale los mismos permisos que tiene vendedor.**
   * **Instrucción SQL:**
     ```sql
     CREATE ROLE 'rol_ventas';
     GRANT INSERT ON taller_sena.pedidos TO 'rol_ventas';
     ```

5. **El gerente pide que todos los cambios de permisos se apliquen de inmediato sin reiniciar el servidor.**
   * **Instrucción SQL:**
     ```sql
     FLUSH PRIVILEGES;
     ```

6. **La cuenta de vendedor debe bloquearse temporalmente durante el fin de semana.**
   * **Instrucción SQL:**
     ```sql
     ALTER USER 'vendedor'@'192.168.1.%' ACCOUNT LOCK;
     ```
     *(Nota: para desbloquearla se usaría `ACCOUNT UNLOCK`)*.

---

### ④ Diseña una vista de seguridad (8 pts)
La tabla `empleados` tiene: `empleado_id`, `nombre`, `cargo`, `salario`, `cedula`, `fecha_ingreso`, `activo`.

* **4.1 Escribe la vista para el usuario de Nómina (3 pts):**
  * **Instrucción SQL:**
    ```sql
    CREATE VIEW v_empleados_nomina AS
    SELECT nombre, cargo, salario
    FROM empleados;
    ```

* **4.2 Escribe la vista para el usuario de Auditoría (3 pts):**
  * **Instrucción SQL:**
    ```sql
    CREATE VIEW v_empleados_auditoria AS
    SELECT nombre, cedula, fecha_ingreso
    FROM empleados;
    ```

* **4.3 ¿Cómo le darías acceso a cada vista al usuario correspondiente sin acceso a la tabla base? (2 pts)**
  * **Explicación:** Se deben otorgar privilegios de lectura (`SELECT`) únicamente sobre la vista correspondiente y evitar dar cualquier permiso sobre la tabla base (`empleados`). En MySQL, por defecto las vistas se ejecutan con la seguridad del definidor (`SQL SECURITY DEFINER`), lo que permite que el usuario acceda a los datos de la vista autorizada sin necesidad de tener acceso directo a la tabla original.
  * **Instrucciones SQL de ejemplo:**
    ```sql
    -- Otorgar acceso al usuario de Nómina
    GRANT SELECT ON taller_sena.v_empleados_nomina TO 'usuario_nomina'@'localhost';

    -- Otorgar acceso al usuario de Auditoría
    GRANT SELECT ON taller_sena.v_empleados_auditoria TO 'usuario_auditoria'@'localhost';
    ```

---

### ⑤ Caso completo — Clínica MediSENA (4 pts)
La clínica MediSENA necesita un esquema de seguridad para su base de datos `clinica_sena`.

#### Script SQL Completo de Implementación:

```sql
-- =========================================================
-- 1. CREACIÓN DE ROLES
-- =========================================================
CREATE ROLE 'rol_medico';
CREATE ROLE 'rol_recepcionista';
CREATE ROLE 'rol_contador';
CREATE ROLE 'rol_administrador';

-- =========================================================
-- 2. ASIGNACIÓN DE PRIVILEGIOS A LOS ROLES
-- =========================================================

-- Médico: Registrar diagnósticos y leer historiales
GRANT INSERT ON clinica_sena.diagnosticos TO 'rol_medico';
GRANT SELECT ON clinica_sena.historiales TO 'rol_medico';

-- Recepcionista: Agendar y cancelar citas (INSERT, UPDATE, DELETE)
GRANT INSERT, UPDATE, DELETE ON clinica_sena.citas TO 'rol_recepcionista';

-- Contador: Solo leer el reporte de facturación (vista v_facturacion)
GRANT SELECT ON clinica_sena.v_facturacion TO 'rol_contador';

-- Administrador: Control total sobre la base de datos
GRANT ALL PRIVILEGES ON clinica_sena.* TO 'rol_administrador';

-- =========================================================
-- 3. CREACIÓN DE USUARIOS
-- =========================================================
CREATE USER 'medico_user'@'localhost' IDENTIFIED BY 'MedPassSecure2026!';
CREATE USER 'recep_user'@'localhost' IDENTIFIED BY 'RecepPassSecure2026!';
CREATE USER 'conta_user'@'localhost' IDENTIFIED BY 'ContaPassSecure2026!';
CREATE USER 'admin_user'@'localhost' IDENTIFIED BY 'AdminPassSecure2026!';

-- =========================================================
-- 4. ASIGNACIÓN DE ROLES A LOS USUARIOS
-- =========================================================
GRANT 'rol_medico' TO 'medico_user'@'localhost';
GRANT 'rol_recepcionista' TO 'recep_user'@'localhost';
GRANT 'rol_contador' TO 'conta_user'@'localhost';
GRANT 'rol_administrador' TO 'admin_user'@'localhost';

-- =========================================================
-- 5. CONFIGURACIÓN DE ROLES POR DEFECTO
-- =========================================================
-- Permite que los roles asignados se activen automáticamente al iniciar sesión
SET DEFAULT ROLE 'rol_medico' FOR 'medico_user'@'localhost';
SET DEFAULT ROLE 'rol_recepcionista' FOR 'recep_user'@'localhost';
SET DEFAULT ROLE 'rol_contador' FOR 'conta_user'@'localhost';
SET DEFAULT ROLE 'rol_administrador' FOR 'admin_user'@'localhost';

-- =========================================================
-- 6. APLICAR CAMBIOS
-- =========================================================
FLUSH PRIVILEGES;
```
