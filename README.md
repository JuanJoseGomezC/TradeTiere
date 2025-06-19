# TradeTiere

TFG tienda venta animales

---

## Índice

1. [Introducción](#introducción)
2. [Análisis DAFO](#análisis-dafo)
3. [Objetivos](#objetivos)
4. [Metodología](#metodología)
5. [Fases del Proyecto](#fases-del-proyecto)
6. [Temporización](#temporización)
7. [Medios y Recursos](#medios-y-recursos)
8. [Tecnologías Usadas](#tecnologías-usadas)
9. [Presupuesto](#presupuesto)
10. [Arquitectura General](#arquitectura-general)
11. [Frontend](#frontend)
12. [Backend](#backend)
13. [Base de Datos](#base-de-datos)
14. [Alojamiento y Seguridad](#alojamiento-y-seguridad)
15. [Pruebas Generales](#pruebas-generales)
16. [Mejoras Futuras](#mejoras-futuras)
17. [Conclusiones](#conclusiones)
18. [Bibliografía](#bibliografía)
19. [Anexos](#anexos)

---

## Introducción

TradeTiere es una plataforma web orientada a la digitalización del sector ganadero, permitiendo la compraventa de animales de granja de forma segura, eficiente y transparente. Nace de la necesidad de modernizar un sector tradicionalmente basado en el trato presencial, ofreciendo un entorno digital centralizado donde vendedores y compradores pueden interactuar, publicar anuncios, gestionar ofertas y realizar transacciones bajo un marco de seguridad y cumplimiento normativo.

El proyecto está dividido en dos partes principales:
- **Backend**: Desarrollado en Java con Spring Boot, expone una API RESTful, gestiona la lógica de negocio, la seguridad y la persistencia de datos en PostgreSQL.
- **Frontend**: Construido en Angular, proporciona una SPA (Single Page Application) moderna, responsiva y fácil de usar, conectada al backend mediante HTTP y JWT.

TradeTiere apuesta por la usabilidad, la escalabilidad y la seguridad, integrando buenas prácticas de desarrollo y tecnologías actuales. El modelo de negocio se basa en la monetización por anuncios y comisiones, con vistas a una futura expansión internacional y la integración de servicios adicionales (veterinaria, transporte, seguros, etc.).

---

## Análisis DAFO

**Debilidades**
- Dependencia de una conexión a internet estable para el uso óptimo de la plataforma.
- Necesidad de moderación y control de calidad del contenido publicado por los usuarios.
- Falta de contenido inicial (anuncios y usuarios reales) en el lanzamiento.
- Requiere formación básica en tecnología para usuarios menos digitalizados.

**Amenazas**
- Barreras legales y normativas sobre la compraventa de animales según la región.
- Desconfianza inicial de los usuarios hacia las plataformas digitales.
- Posible entrada de grandes competidores generalistas (Wallapop, Milanuncios).
- Riesgo de mal uso de la plataforma (anuncios ilegales, fraude).

**Fortalezas**
- Plataforma especializada en un nicho poco explotado: compraventa de animales de granja.
- Base de datos relacional sólida y escalable.
- Uso de tecnologías modernas (Angular, Spring Boot, PostgreSQL).
- Diseño multiplataforma adaptable a distintos dispositivos.
- Posibilidad de multilingüismo e implementación por regiones.

**Oportunidades**
- Digitalización progresiva del sector agropecuario.
- Escasa competencia directa especializada en este tipo de compraventa.
- Facilidad para integrar servicios adicionales (veterinaria, transporte, seguros).
- Potencial de expansión a nivel nacional e internacional.

---

## Objetivos

- Crear una plataforma web robusta y segura para la compraventa de animales de granja.
- Establecer una marca confiable y reconocida en el sector agropecuario digital.
- Desarrollar una interfaz intuitiva y accesible para usuarios con distintos niveles de experiencia digital.
- Garantizar la seguridad y privacidad de los datos mediante buenas prácticas y protocolos de protección.
- Optimizar la gestión y escalabilidad de la base de datos, permitiendo un alto volumen de publicaciones y usuarios.
- Facilitar la publicación y visualización de anuncios, con herramientas de búsqueda filtrada, favoritos y mensajería directa.
- Mejorar la experiencia del usuario con una interfaz clara, tiempos de carga rápidos y navegación fluida.
- Ampliar progresivamente la oferta de especies y razas disponibles, adaptadas a cada región.
- Fomentar la sostenibilidad y el comercio responsable, promoviendo buenas prácticas y el cumplimiento legal.
- Sentar las bases para una futura expansión internacional, con soporte multilingüe y multimoneda.

---

## Metodología

El desarrollo de TradeTiere se ha basado en una metodología ágil, permitiendo una adaptación continua a los cambios y una mejora progresiva del producto. Se han utilizado sprints semanales para organizar el trabajo, priorizar tareas y revisar avances.

Las herramientas principales para la gestión del proyecto han sido:
- **Trello:** Para la organización de tareas, seguimiento del progreso y asignación de responsabilidades.
- **Git y GitHub:** Para el control de versiones, trabajo colaborativo y gestión de incidencias.
- **Reuniones periódicas:** Para la revisión de objetivos, resolución de bloqueos y toma de decisiones técnicas.

Esta metodología ha permitido una comunicación fluida, una rápida detección de problemas y una entrega incremental de funcionalidades, asegurando la calidad y la alineación con los objetivos del proyecto.

---

## Fases del Proyecto

1. **Análisis y planificación:**  
   - Estudio del problema y definición de requisitos funcionales y no funcionales.
   - Investigación del sector ganadero y análisis de plataformas similares.
   - Definición del modelo de negocio (publicidad y comisiones).
   - Diseño preliminar del modelo de datos (ERD) y estructura de entidades.

2. **Diseño del sistema:**  
   - Diseño detallado de la base de datos en PostgreSQL.
   - Estructuración de relaciones, normalización y definición de claves.
   - Bocetos de la interfaz y prototipos de pantallas clave.
   - Elección de tecnologías y herramientas definitivas.

3. **Desarrollo backend (API REST):**  
   - Implementación del backend en Spring Boot.
   - Creación de controladores, servicios y repositorios.
   - Gestión de la seguridad básica (JWT, cifrado de contraseñas).
   - Conexión con la base de datos (PostgreSQL).
   - Pruebas unitarias de endpoints.

4. **Desarrollo frontend:**  
   - Implementación de la interfaz con Angular.
   - Conexión con la API REST.
   - Desarrollo de funcionalidades: login, registro, publicación, búsqueda, contacto.
   - Diseño responsivo y pruebas en distintos navegadores.

5. **Integración y pruebas:**  
   - Pruebas funcionales completas del sistema.
   - Revisión de flujos de navegación, validaciones y formularios.
   - Solución de errores y mejora de la experiencia de usuario.
   - Verificación del rendimiento y de la base de datos.

6. **Documentación y entrega final:**  
   - Redacción de la memoria del proyecto.
   - Preparación de la presentación.
   - Documentación técnica del código, base de datos y arquitectura.
   - Backup del proyecto y despliegue local o en servidor de pruebas.

---

## Temporización

La planificación temporal del proyecto se ha estructurado en función de las fases descritas, distribuyendo el trabajo a lo largo de tres meses:

| Fase                               | Fechas estimadas         |
|------------------------------------|-------------------------|
| Análisis y planificación           | 15 - 22 de marzo        |
| Diseño del sistema                 | 23 de marzo - 5 de abril|
| Desarrollo backend                 | 6 - 25 de abril         |
| Desarrollo frontend                | 26 de abril - 15 de mayo|
| Integración y pruebas              | 16 - 31 de mayo         |
| Documentación y entrega final      | 1 - 15 de junio         |

Cada fase incluye revisiones y entregables parciales, permitiendo una evaluación continua del avance y la calidad del proyecto.

---

## Medios y Recursos

### Recursos Humanos
- **Desarrollador Full Stack:** Responsable del análisis, diseño, desarrollo y pruebas tanto del backend como del frontend.
- **Tutor del proyecto:** Supervisión, orientación técnica y validación de entregables.

### Recursos Materiales
- **Hardware:**  
  - Ordenador personal con procesador Intel i5 o superior, 8GB de RAM, 256GB SSD.
  - Acceso a conexión a Internet de banda ancha.
- **Software:**  
  - Sistema operativo Windows 10/11.
  - Visual Studio Code (editor de código).
  - IntelliJ IDEA Community (IDE para Java/Spring Boot).
  - Node.js y Angular CLI.
  - PostgreSQL (gestor de base de datos).
  - DBeaver (administrador de bases de datos).
  - Postman (pruebas de API).
  - Git y GitHub (control de versiones).
  - Trello (gestión de tareas).
  - Navegadores web (Chrome, Firefox, Edge) para pruebas.

### Recursos Online
- Documentación oficial de Angular, Spring Boot, PostgreSQL.
- Tutoriales, foros y comunidades de desarrollo.
- Servicios de hosting gratuitos o de prueba para despliegue temporal.

---

## Tecnologías Usadas

### Frontend
- **Angular:** Framework SPA para el desarrollo de la interfaz de usuario.
- **HTML5 y CSS3:** Estructura y estilos de la aplicación.
- **Bootstrap:** Framework CSS para diseño responsivo.
- **TypeScript:** Lenguaje principal del frontend.
- **Jasmine/Karma:** Herramientas para pruebas unitarias en Angular.

### Backend
- **Spring Boot:** Framework Java para el desarrollo de la API REST.
- **Spring Security:** Gestión de autenticación y autorización (JWT).
- **PostgreSQL:** Sistema de gestión de bases de datos relacional.
- **Maven:** Gestión de dependencias y construcción del proyecto.
- **JUnit:** Pruebas unitarias en Java.

### Herramientas de Desarrollo
- **Visual Studio Code:** Edición de código frontend.
- **IntelliJ IDEA:** Desarrollo backend.
- **DBeaver:** Administración de la base de datos.
- **Postman:** Pruebas de endpoints REST.
- **Git y GitHub:** Control de versiones y colaboración.
- **Trello:** Organización y seguimiento de tareas.

---

## Presupuesto

### Recursos Humanos

| Concepto                  | Horas estimadas | Coste/hora (€) | Total (€) |
|---------------------------|-----------------|---------------|-----------|
| Análisis y diseño         | 40              | 20            | 800       |
| Desarrollo backend        | 80              | 20            | 1.600     |
| Desarrollo frontend       | 80              | 20            | 1.600     |
| Pruebas e integración     | 30              | 20            | 600       |
| Documentación             | 20              | 20            | 400       |
| **Total recursos humanos**| **250**         |               | **5.000** |

### Recursos Materiales y Software

| Concepto                         | Licencia/mes | Meses | Total (€) |
|----------------------------------|--------------|-------|-----------|
| Ordenador personal (amortización)| 50           | 3     | 150       |
| Licencias software (IDE, etc.)   | 0            | 3     | 0         |
| Hosting/despliegue (pruebas)     | 10           | 3     | 30        |
| Dominio web (opcional)           | 12           | 1     | 12        |
| **Total materiales/software**    |              |       | **192**   |

### Otros Gastos

| Concepto                  | Total (€) |
|---------------------------|-----------|
| Formación y documentación | 50        |
| Gastos imprevistos        | 100       |
| **Total otros gastos**    | **150**   |

### Resumen del Presupuesto

| Concepto                  | Total (€) |
|---------------------------|-----------|
| Recursos humanos          | 5.000     |
| Materiales y software     | 192       |
| Otros gastos              | 150       |
| **TOTAL**                 | **5.342** |

> **Nota:** Este presupuesto es orientativo y se basa en tarifas estándar para proyectos de desarrollo web. El uso de software open source y recursos gratuitos permite reducir costes significativamente.

---

## Arquitectura General

TradeTiere está basado en una arquitectura cliente-servidor moderna, desacoplada y escalable, que facilita el mantenimiento, la evolución y la integración de nuevas funcionalidades.  
La comunicación entre el frontend y el backend se realiza mediante una API RESTful, utilizando el formato JSON para el intercambio de datos.

### Esquema General

```
[ Usuario ]
    |
    v
[ Frontend Angular SPA ]
    |
    v
[ API REST - Spring Boot ]
    |
    v
[ PostgreSQL ]
```

- **Frontend:** Aplicación Angular (SPA) que se ejecuta en el navegador del usuario. Gestiona la interfaz, la navegación, la autenticación y la comunicación con la API.
- **Backend:** API REST desarrollada en Spring Boot. Expone endpoints para todas las operaciones de negocio, gestiona la seguridad, la lógica y la persistencia.
- **Base de datos:** PostgreSQL almacena toda la información estructurada (usuarios, anuncios, especies, razas, ubicaciones, historial de compras, etc.).

### Seguridad

- **Autenticación:** Basada en JWT (JSON Web Token). El usuario obtiene un token al iniciar sesión, que debe incluir en cada petición protegida.
- **Autorización:** Roles de usuario (usuario, administrador) gestionados desde el backend.
- **Cifrado:** Contraseñas almacenadas cifradas (BCrypt).
- **Comunicación:** Uso de HTTPS recomendado para proteger los datos en tránsito.

### Despliegue

- **Frontend:** Puede desplegarse en cualquier servidor web estático (por ejemplo, Netlify, Vercel, GitHub Pages, o un servidor propio).
- **Backend:** Desplegable en servidores cloud, VPS o localmente para pruebas.
- **Base de datos:** PostgreSQL alojado localmente o en la nube (Heroku, Clever Cloud, etc.).

---

## Frontend

### Descripción General

El frontend de TradeTiere está desarrollado con Angular, un framework SPA que permite crear aplicaciones web dinámicas, modulares y escalables.  
El diseño es responsivo gracias a Bootstrap y CSS personalizado, garantizando una experiencia óptima en dispositivos móviles, tabletas y ordenadores.

### Estructura de Carpetas

La estructura del proyecto Angular sigue las mejores prácticas recomendadas:

```
front-TradeTiere/
├── src/
│   ├── app/
│   │   ├── components/      # Componentes reutilizables (navbar, footer, cards, etc.)
│   │   ├── pages/           # Páginas principales (home, anuncios, perfil, login, etc.)
│   │   ├── services/        # Servicios para comunicación con la API REST
│   │   ├── guards/          # Guardas de rutas (protección de rutas privadas)
│   │   ├── models/          # Interfaces y modelos de datos
│   │   └── app.module.ts    # Módulo principal de la aplicación
│   ├── assets/              # Imágenes, estilos globales, etc.
│   └── environments/        # Configuración de entornos (dev, prod)
├── angular.json             # Configuración del proyecto Angular
└── package.json             # Dependencias y scripts
```

### Componentes y Servicios

#### Componentes principales

- **NavbarComponent:** Barra de navegación superior, adaptativa según el rol y el estado de sesión.
- **FooterComponent:** Pie de página con enlaces de interés y contacto.
- **HomeComponent:** Página de inicio con resumen de funcionalidades y acceso rápido.
- **LoginComponent / RegisterComponent:** Formularios de autenticación y registro.
- **AdvertismentListComponent:** Listado de anuncios con filtros y paginación.
- **AdvertismentDetailComponent:** Vista detallada de un anuncio.
- **ProfileComponent:** Gestión del perfil de usuario.
- **AdminPanelComponent:** Panel de administración (solo para usuarios con rol admin).

#### Servicios principales

- **AuthService:** Manejo de login, registro, logout, persistencia de sesión y gestión del token JWT.
- **AdvertismentService:** CRUD de anuncios, búsqueda y filtrado.
- **SpecieService:** Gestión de especies.
- **RaceService:** Gestión de razas.
- **LocationService:** Gestión de ubicaciones.
- **UserService:** Gestión de usuarios y perfiles.
- **LanguageService:** Soporte multilingüe (internacionalización).

### Manejo de la API

- Uso de `HttpClient` de Angular para consumir la API REST.
- Interceptores para añadir el token JWT a las cabeceras de las peticiones protegidas.
- Manejo centralizado de errores y mensajes al usuario.
- Servicios desacoplados para cada entidad del dominio.

### Gestión de Sesión y Seguridad

- Almacenamiento del token JWT y datos del usuario en `localStorage`.
- Guardas de rutas (`AuthGuard`, `AdminGuard`) para proteger páginas privadas y de administración.
- Expiración automática de sesión y redirección al login si el token es inválido o caduca.

### Diseño Responsivo

- Uso de Bootstrap y media queries para adaptar la interfaz a cualquier dispositivo.
- Pruebas en dispositivos reales y simuladores para garantizar la usabilidad.

### Pruebas de Frontend

- Pruebas manuales de todos los flujos de usuario.
- Validación de formularios y navegación.
- Pruebas de usabilidad con usuarios reales.
- Pruebas unitarias con Jasmine/Karma para componentes y servicios críticos.

---

## Backend

El backend de TradeTier está desarrollado en **Java 17** usando **Spring Boot** y sigue una arquitectura en capas (MVC):

- **Controladores (controller/):** Exponen la API REST y gestionan las peticiones HTTP para usuarios, anuncios, especies, razas, ubicaciones, historial de compras, etc. Cada entidad principal tiene su propio controlador, siguiendo buenas prácticas REST.
- **Servicios (service/):** Contienen la lógica de negocio, validaciones, orquestan operaciones entre controladores y repositorios, y gestionan la seguridad y la integridad de los datos.
- **Modelos (model/):** Entidades JPA que representan las tablas de la base de datos (User, Advertisment, Specie, Race, Location, Language, Image, etc.), con relaciones entre ellas (por ejemplo, un anuncio tiene una especie, una raza, una localización, un usuario, etc.).
- **Repositorios (repository/):** Interfaces de acceso a datos usando Spring Data JPA, con métodos personalizados para búsquedas y filtrados.
- **Excepciones (exceptions/):** Manejo centralizado de errores personalizados y validaciones, con un GlobalExceptionHandler para respuestas uniformes.
- **Seguridad (config/security/):** Implementación de autenticación y autorización con JWT y Spring Security, filtros personalizados y gestión de roles.

### Principales características
- **API RESTful** para todas las operaciones CRUD y búsquedas avanzadas.
- **Validación de datos** en DTOs y servicios (por ejemplo, email, contraseña, edad mínima, unicidad de email, etc.).
- **Autenticación JWT**: El login devuelve un token JWT que se usa para acceder a endpoints protegidos.
- **Roles y permisos**: Control de acceso a endpoints según el rol del usuario (usuario, admin), con anotaciones y filtros.
- **Contraseñas cifradas** con BCrypt.
- **Documentación automática** con Swagger/OpenAPI.
- **Pruebas unitarias y de integración** con JUnit y Mockito.
- **Gestión de imágenes**: Los anuncios pueden tener imágenes asociadas, almacenadas en la base de datos como BLOB o en el sistema de archivos.
- **Historial de compras**: Registro y consulta de compras realizadas por los usuarios.
- **Soporte multilingüe**: Entidades y endpoints para gestionar idiomas.

### Validación de registro de usuario
El registro de usuario valida:
- Formato de email correcto y no repetido.
- Contraseña de al menos 8 caracteres, con mayúsculas, minúsculas y dígitos.
- Edad mínima de 18 años.
- Otros campos obligatorios (nombre, apellidos, etc.).
- Si se añaden campos como especie, raza, localización o idioma, se valida que existan en la base de datos.

```java
public void validateRegisterFields(RegisterDto registerDto) {
    if (!registerDto.getMail().matches("^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
        throw new InvalidTokenException("Invalid email format");
    }
    if (registerDto.getBirthdate().isAfter(LocalDate.now().minusYears(18))) {
        throw new InvalidTokenException("You must be at least 18 years old to update your profile");
    }
    if (registerDto.getPassword().length() < 8) {
        throw new InvalidTokenException("Password must be at least 8 characters long");
    }
    if (!registerDto.getPassword().matches(".*[A-Z].*") || !registerDto.getPassword().matches(".*[a-z].*")
            || !registerDto.getPassword().matches(".*\\d.*")) {
        throw new InvalidTokenException(
                "Password must contain at least one uppercase letter, one lowercase letter, and one digit");
    }
    // Validación de especie, raza, localización, idioma si corresponde
}
```

### Seguridad
- **Spring Security** protege los endpoints.
- **JWT** para autenticación sin estado.
- **Filtros** para validar el token en cada petición.
- **Roles**: Acceso diferenciado para usuarios y administradores.

### Estructura de carpetas
```
TradeTier/
├── src/
│   ├── main/
│   │   ├── java/com/back/tradetier/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── exceptions/
│   │   │   └── config/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
└── pom.xml
```

### Tecnologías principales
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security + JWT
- PostgreSQL
- Lombok
- Swagger/OpenAPI
- JUnit, Mockito

### Ejemplo de endpoint
```java
@GetMapping("/getAll")
public ResponseEntity<List<UserDto>> getAll() {
    return ResponseEntity.ok(userService.getAll());
}
```

### Ejemplo de entidad y DTO
```java
@Entity
public class User {
    @Id @GeneratedValue
    private Integer id;
    private String mail;
    private String name;
    private String lastname;
    private LocalDate birthdate;
    private String password;
    private String role;
    private Boolean enabled;
    // Relaciones con anuncios, historial, etc.
}

public class UserDto {
    private Integer id;
    private String mail;
    private String name;
    private String lastname;
    private LocalDate birthday;
    // Otros campos relevantes
}
```

### Ejemplo de repositorio
```java
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByMail(String mail);
    boolean existsByMail(String mail);
}
```

### Ejemplo de servicio
```java
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public UserDto register(RegisterDto registerDto) {
        if (userRepository.existsByMail(registerDto.getMail())) {
            throw new UserExistException();
        }
        validateRegisterFields(registerDto);
        User user = toUser(registerDto, passwordEncoder);
        userRepository.save(user);
        return toDto(user);
    }
    // ...otros métodos...
}
```

### Gestión de errores y excepciones
El backend cuenta con un manejador global de excepciones (`@RestControllerAdvice`) que captura y responde con mensajes claros y estructurados ante errores de validación, autenticación, acceso denegado, etc.

### Seguridad avanzada
- **JWT**: Generación y validación de tokens para sesiones seguras.
- **Roles y permisos**: Control de acceso a endpoints según el rol.
- **Cifrado de contraseñas**: BCrypt.
- **Filtros personalizados**: Para validar el token en cada petición.

### Documentación automática
- **Swagger/OpenAPI**: Documentación interactiva de la API generada automáticamente.

### Pruebas
- **JUnit y Mockito**: Pruebas unitarias y de integración para servicios y controladores.

### Otras características
- **Gestión de imágenes**: Los anuncios pueden tener imágenes asociadas.
- **Historial de compras**: Registro y consulta de compras realizadas.
- **Soporte multilingüe**: Entidades y endpoints para gestionar idiomas.

Para más detalles, consulta el código fuente en cada carpeta y la documentación Swagger generada automáticamente al levantar el backend.
---

## Base de Datos

La base de datos de TradeTiere está desarrollada en **PostgreSQL** y sigue un modelo relacional robusto, normalizado y preparado para la escalabilidad. El diseño refleja fielmente el dominio de la compraventa de animales de granja, permitiendo búsquedas eficientes, integridad referencial y soporte multilingüe.

### Modelo Entidad-Relación (ERD)

Las entidades principales y sus relaciones son:
- **User**: Usuarios registrados (ganaderos, compradores, administradores). Incluye datos personales, credenciales, rol y estado.
- **Advertisment**: Anuncios de compraventa de animales. Relacionados con usuario, especie, raza, localización, idioma e imágenes.
- **Specie**: Especies animales (vaca, cerdo, oveja, etc.).
- **Race**: Razas asociadas a cada especie. Cada raza pertenece a una especie y puede estar asociada a un idioma para soporte multilingüe.
- **Location**: Ubicaciones geográficas (comunidades autónomas, provincias, países). Permite filtrar anuncios por región.
- **PurchaseHistory**: Historial de compras realizadas por los usuarios.
- **Language**: Idiomas soportados en la plataforma.
- **Image**: Imágenes asociadas a anuncios, almacenadas como BLOB o URL.

#### Relaciones clave
- Un **User** puede publicar varios **Advertisment** y tener varias compras (**PurchaseHistory**).
- Un **Advertisment** pertenece a una **Specie**, una **Race**, una **Location** y un **User**.
- Un **Advertisment** puede tener varias **Image**.
- **Race** está relacionada con **Specie** (una especie tiene varias razas).
- **Location**, **Specie**, **Race** y **Language** pueden estar asociadas a anuncios y usuarios para búsquedas y filtrados avanzados.

#### Diagrama ERD (descripción textual)
```
User (id) 1---N Advertisment (id)
User (id) 1---N PurchaseHistory (id)
Advertisment (id) N---1 Specie (id)
Advertisment (id) N---1 Race (id)
Advertisment (id) N---1 Location (id)
Advertisment (id) 1---N Image (id)
Race (id) N---1 Specie (id)
```

### Scripts de creación de tablas principales

```sql
CREATE TABLE "user" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    mail VARCHAR(150) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL, -- Ej: USER, ADMIN
    enabled BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE language (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE location (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    language_id INTEGER REFERENCES language(id)
);

CREATE TABLE specie (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    language_id INTEGER REFERENCES language(id)
);

CREATE TABLE race (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    specie_id INTEGER REFERENCES specie(id),
    language_id INTEGER REFERENCES language(id)
);

CREATE TABLE advertisment (
    id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    price NUMERIC(10,2) NOT NULL,
    birthdate DATE,
    gender VARCHAR(20),
    state BOOLEAN DEFAULT TRUE,
    create_at DATE DEFAULT CURRENT_DATE,
    user_id INTEGER REFERENCES "user"(id),
    specie_id INTEGER REFERENCES specie(id),
    race_id INTEGER REFERENCES race(id),
    location_id INTEGER REFERENCES location(id),
    language_id INTEGER REFERENCES language(id)
);

CREATE TABLE image (
    id SERIAL PRIMARY KEY,
    image_data BYTEA,
    name VARCHAR(255),
    content_type VARCHAR(100),
    advertisment_id INTEGER REFERENCES advertisment(id)
);

CREATE TABLE purchase_history (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES "user"(id),
    advertisment_id INTEGER REFERENCES advertisment(id),
    purchase_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    price NUMERIC(10,2) NOT NULL
);
```

### Características destacadas
- **Integridad referencial**: Todas las relaciones están protegidas por claves foráneas.
- **Soporte multilingüe**: Tablas de idioma y referencias en entidades clave.
- **Escalabilidad**: Modelo preparado para añadir nuevas entidades o relaciones.
- **Consultas avanzadas**: Búsqueda de anuncios por especie, raza, localización, idioma, precio, etc.
- **Historial de compras**: Registro de todas las transacciones entre usuarios.
- **Gestión de imágenes**: Imágenes asociadas a anuncios, almacenadas como BLOB o URL.

### Ejemplo de consulta avanzada
```sql
-- Buscar anuncios activos de una especie y localización concreta
SELECT a.* FROM advertisment a
JOIN specie s ON a.specie_id = s.id
JOIN location l ON a.location_id = l.id
WHERE s.name = 'Bovino' AND l.name = 'Andalucía' AND a.state = TRUE;
```

Para más detalles, consulta los scripts SQL completos en la carpeta `/resources` o el código fuente de las entidades JPA en `/model`.
---

## Alojamiento y Seguridad

### Alojamiento

Actualmente, TradeTiere **no está alojado en producción**. Todo el desarrollo, pruebas y uso de la aplicación se realiza de forma local en los equipos de desarrollo.

- **Backend (Spring Boot + PostgreSQL):**
  - El backend se ejecuta localmente usando herramientas como IntelliJ IDEA o VS Code.
  - La base de datos PostgreSQL se instala y gestiona localmente o mediante Docker.
  - No hay despliegue en servidores cloud ni VPS.
  - La configuración de la base de datos y la aplicación se realiza en el archivo `application.properties`.

- **Frontend (Angular):**
  - El frontend se ejecuta localmente con Angular CLI (`ng serve`).
  - No se realiza despliegue en servidores web ni servicios de hosting.

### Seguridad

- **Autenticación y Autorización:**
  - Uso de **JWT (JSON Web Token)** para autenticar usuarios y proteger endpoints sensibles.
  - Roles de usuario (USER, ADMIN) gestionados en la base de datos y validados en cada petición.
  - Endpoints públicos (login, registro) y privados (gestión de anuncios, compras, administración).
- **Cifrado de Contraseñas:**
  - Las contraseñas de los usuarios se almacenan cifradas con **BCrypt**.
- **Protección contra ataques comunes:**
  - **CSRF:** Deshabilitado en APIs REST, ya que el frontend y backend están desacoplados y se usa JWT.
  - **XSS y SQL Injection:**
    - Validación y saneamiento de entradas en el backend.
    - Uso de JPA/Hibernate para evitar inyecciones SQL.
    - Filtros y validaciones en el frontend para evitar scripts maliciosos.
- **Gestión de errores y logs:**
  - Manejo centralizado de excepciones para evitar la exposición de información sensible.
  - Logs de acceso y errores para auditoría y detección de incidentes.

- **Protección de rutas en frontend:**
  - Uso de guards (`AuthGuard`, `AdminGuard`) para evitar el acceso a páginas privadas sin autenticación o sin permisos.
  - Redirección automática al login si el token JWT es inválido o ha expirado.
- **Almacenamiento seguro:**
  - El token JWT y los datos mínimos del usuario se almacenan en `localStorage` o `sessionStorage`.
  - No se almacenan contraseñas ni datos sensibles en el navegador.
- **Comunicación:**
  - Al ejecutarse en local, no se utiliza HTTPS, pero se recomienda para entornos de producción.

---

## Pruebas Generales

El aseguramiento de la calidad en TradeTiere se ha realizado mediante diferentes tipos de pruebas, tanto manuales como automáticas, abarcando frontend, backend, integración y seguridad.

### Pruebas Funcionales

#### Backend
- **Pruebas unitarias:**  
  - Uso de **JUnit** y **Mockito** para probar los servicios y la lógica de negocio.
  - Ejemplo: test de registro de usuario, validación de login, creación y consulta de anuncios.
- **Pruebas de integración:**  
  - Uso de **Postman** para validar los endpoints REST.
  - Se han probado todos los endpoints principales: registro, login, CRUD de anuncios, gestión de especies, razas, ubicaciones y compras.
  - Pruebas de flujos completos: registro → login → publicación de anuncio → compra.

#### Frontend
- **Pruebas manuales:**  
  - Navegación por todas las páginas y flujos de usuario.
  - Validación de formularios (campos obligatorios, formatos, mensajes de error).
  - Pruebas de usabilidad en dispositivos móviles y escritorio.
- **Pruebas unitarias:**  
  - Uso de **Jasmine/Karma** para componentes y servicios críticos.
  - Ejemplo: test de AuthService, validación de guards, renderizado de componentes.

### Pruebas de Integración
- **Comunicación Frontend-Backend:**  
  - Verificación de la correcta integración entre Angular y la API REST.
  - Pruebas de login, registro, publicación y consulta de anuncios desde la interfaz.
  - Manejo de errores y mensajes al usuario en caso de fallos de red o validaciones.
- **Persistencia de sesión:**  
  - Comprobación de la validez y expiración del token JWT.
  - Pruebas de acceso a rutas protegidas y redirección automática al login si la sesión expira.

### Pruebas de Rendimiento
- **Carga de la base de datos:**  
  - Inserción masiva de anuncios y usuarios para comprobar la escalabilidad.
  - Medición de tiempos de respuesta de los endpoints bajo carga.
- **Simulación de usuarios concurrentes:**  
  - Uso de herramientas como **Apache JMeter** para simular múltiples usuarios accediendo simultáneamente.

### Pruebas de Seguridad
- **Acceso a endpoints protegidos:**  
  - Verificación de que solo usuarios autenticados pueden acceder a recursos privados.
  - Pruebas de acceso con diferentes roles (usuario, admin).
- **Validación de JWT:**  
  - Pruebas con tokens inválidos, expirados o manipulados para asegurar el rechazo de peticiones.
- **Pruebas de inyección y XSS:**  
  - Intentos de inyección SQL y scripts en formularios para comprobar la robustez de las validaciones.

### Pruebas de Usabilidad
- **Testing con usuarios reales:**  
  - Se han realizado sesiones de prueba con usuarios para evaluar la facilidad de uso, la navegación y la comprensión de la interfaz.
  - Recogida de feedback para mejoras en la experiencia de usuario.

### Registro y Gestión de Errores
- **Logs de backend:**  
  - Registro de errores y eventos importantes en archivos de log para su posterior análisis.
- **Gestión de errores en frontend:**  
  - Mensajes claros y amigables para el usuario final en caso de errores de validación o fallos de red.

---

## Mejoras Futuras

- Filtros avanzados de búsqueda.
- Sistema de mensajería interna.
- Notificaciones en tiempo real.
- Valoraciones y reputación.
- Pasarela de pago integrada.
- Internacionalización completa.
- App móvil nativa.
- Panel de administración avanzado.
- Auditoría y trazabilidad.
- Cumplimiento RGPD.
- Monitorización y alertas.

---

## Conclusiones

El desarrollo de TradeTiere ha supuesto un reto técnico y organizativo, permitiendo aplicar y consolidar conocimientos en arquitectura de software, desarrollo full stack, seguridad y gestión de proyectos.  
La plataforma responde a una necesidad real del sector agropecuario, aportando digitalización, eficiencia y transparencia a la compraventa de animales de granja.

Durante el proyecto se han superado desafíos como la integración de tecnologías modernas (Angular, Spring Boot, PostgreSQL), la implementación de seguridad robusta (JWT, roles, cifrado), y la creación de una experiencia de usuario intuitiva y accesible.

TradeTiere sienta las bases para una futura expansión, tanto en funcionalidades como en alcance geográfico, y demuestra la viabilidad de soluciones tecnológicas en sectores tradicionalmente poco digitalizados.  
El aprendizaje obtenido y la experiencia adquirida serán de gran valor para futuros proyectos profesionales y personales.

---

## Bibliografía

- [Documentación oficial de Angular](https://angular.io/docs)
- [Documentación oficial de Spring Boot](https://spring.io/projects/spring-boot)
- [Documentación oficial de PostgreSQL](https://www.postgresql.org/docs/)
- [Bootstrap](https://getbootstrap.com/)
- [DBeaver](https://dbeaver.io/)
- [GitHub](https://github.com/)
- [JWT Introduction](https://jwt.io/introduction)
- [Baeldung - Spring Security](https://www.baeldung.com/spring-security)
- [Baeldung - Spring Boot REST](https://www.baeldung.com/building-a-restful-web-service-with-spring-and-java-based-configuration)
- [MDN Web Docs](https://developer.mozilla.org/)
- [Dbdiagram.io](https://dbdiagram.io/)
- [YouTube - Tutoriales de Angular y Spring Boot]
- [Foros y comunidades de Stack Overflow](https://stackoverflow.com/)
- [Trello](https://trello.com/)
- [Postman](https://www.postman.com/)

---

## Anexos

### Ejemplo de Código: Endpoint de Registro de Usuario (Spring Boot)

```java
@PostMapping("/register")
public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
    UserDTO createdUser = userService.register(userDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
}
```

### Ejemplo de Código: Servicio de Autenticación (Angular)

```typescript
login(email: string, password: string): Observable<any> {
  return this.http.post(`${this.apiUrl}/user/login`, { email, password })
    .pipe(
      tap((response: any) => {
        localStorage.setItem('token', response.token);
        localStorage.setItem('user', JSON.stringify(response.user));
      })
    );
}
```

### Script SQL: Creación de Tabla de Anuncios

```sql
CREATE TABLE advertisment (
    id SERIAL PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    price NUMERIC(10,2) NOT NULL,
    date_posted TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id INTEGER REFERENCES "user"(id),
    specie_id INTEGER REFERENCES specie(id),
    race_id INTEGER REFERENCES race(id),
    location_id INTEGER REFERENCES location(id),
    status VARCHAR(20) DEFAULT 'ACTIVE'
);
```

### Capturas de Pantalla

- Página principal de TradeTiere (Angular)
- Formulario de registro de usuario
- Listado de anuncios
- Panel de administración
- Pruebas de endpoints en Postman
- Modelo entidad-relación en DBeaver

*(Incluir imágenes en el documento Word final)*

### Diagrama ERD (Dbdiagram.io)

*(Adjuntar imagen o exportar el diagrama generado en la herramienta)*

### Manual de Usuario

- **Registro e inicio de sesión:**  
  Acceder a la plataforma, crear una cuenta y autenticarse.
- **Publicación de anuncios:**  
  Completar el formulario de alta de anuncio, adjuntar imágenes y seleccionar especie, raza y ubicación.
- **Búsqueda y filtrado:**  
  Utilizar los filtros para encontrar animales por especie, raza, ubicación o precio.
- **Gestión de perfil:**  
  Editar datos personales, cambiar contraseña y consultar historial de compras.
- **Administración:**  
  Acceso a funcionalidades exclusivas para administradores: gestión de usuarios, anuncios y moderación de contenido.

---
