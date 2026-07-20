![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# 🏔️ Llanquihue Tour

## 👤 Autor del proyecto

- **Nombre completo:** Osvaldo González Olguín
- **Carrera:** Desarrollo de Aplicaciones
- **Sede:** Online / Duoc UC
- **Asignatura:** Desarrollo Orientado a Objetos I
- **Evaluación:** Evaluación Final Transversal - Semana 9

---

## 📘 Descripción general

Llanquihue Tour es un prototipo Java para apoyar la gestión de una agencia de turismo. El programa carga desde archivos TXT los guías, vehículos, colaboradores y servicios disponibles. Desde una interfaz gráfica se pueden registrar nuevas entidades, mostrar, buscar y eliminar datos, consultar servicios y crear reservas turísticas.

La solución aplica encapsulamiento, herencia, polimorfismo, abstracción, composición, interfaces, colecciones genéricas, sobrecarga, excepciones personalizadas y separación por paquetes.

## ✅ Funcionalidades

- Carga automática de entidades desde `entidades.txt`.
- Carga automática de servicios desde `servicios.txt`.
- Registro de guías, vehículos y colaboradores externos.
- Validación de campos, números positivos, patentes y teléfonos.
- Visualización de una colección polimórfica `ArrayList<Registrable>`.
- Búsqueda por nombre, patente, especialidad o servicio.
- Filtrado por tipo mediante un método sobrecargado.
- Eliminación de entidades.
- Consulta de rutas gastronómicas, paseos lacustres y excursiones culturales.
- Creación y visualización de reservas compuestas por un servicio y un guía.
- Interfaz gráfica desarrollada con Java Swing.

## 🧱 Estructura del proyecto

```text
LlanquihueTourAppNuevo/
├── src/
│   ├── main/
│   │   ├── java/com/LlanquihueTour/
│   │   │   ├── data/       # Lectura TXT y gestores de colecciones
│   │   │   ├── exception/  # Excepción personalizada
│   │   │   ├── model/      # Entidades y jerarquías del dominio
│   │   │   ├── service/    # Controlador de servicios turísticos
│   │   │   ├── ui/         # Ventana principal y punto de entrada
│   │   │   └── utils/      # Librería propia de validaciones
│   │   └── resources/datos/
│   │       ├── entidades.txt
│   │       └── servicios.txt
├── build.gradle.kts
└── settings.gradle.kts
```

## 📚 Clases principales

| Clase | Paquete | Responsabilidad |
| --- | --- | --- |
| `Registrable` | `model` | Contrato común para las entidades registrables. |
| `ServicioTuristico` | `model` | Clase abstracta base de los servicios turísticos. |
| `RutaGastronomica` | `model` | Especializa un servicio con número de paradas. |
| `PaseoLacustre` | `model` | Especializa un servicio con tipo de embarcación. |
| `ExcursionCultural` | `model` | Especializa un servicio con un lugar histórico. |
| `GuiaTuristico` | `model` | Representa un guía con especialidad y experiencia. |
| `Vehiculo` | `model` | Representa un vehículo y su capacidad. |
| `ColaboradorExterno` | `model` | Representa un proveedor o colaborador de la agencia. |
| `ReservaTuristica` | `model` | Compone un servicio turístico con un guía y un cliente. |
| `LectorDatos` | `data` | Lee archivos TXT y convierte sus filas en objetos. |
| `GestorEntidades` | `data` | Agrega, recorre, busca, filtra y elimina entidades. |
| `GestorReservas` | `data` | Crea y consulta reservas durante la ejecución. |
| `Validaciones` | `utils` | Librería reutilizable de reglas para los atributos. |
| `ScreenPrincipal` | `ui` | Presenta las funciones mediante Java Swing. |

## 🧠 Conceptos de POO aplicados

- **Encapsulamiento:** los atributos son privados y se accede mediante getters y setters validados.
- **Herencia:** `RutaGastronomica`, `PaseoLacustre` y `ExcursionCultural` heredan de `ServicioTuristico`.
- **Polimorfismo:** una misma lista de `Registrable` almacena guías, vehículos y colaboradores.
- **Abstracción:** `ServicioTuristico` es abstracta y obliga a especializar el comportamiento.
- **Interfaz:** `Registrable` define el contrato `mostrarResumen()`.
- **Composición:** `ReservaTuristica` contiene un `ServicioTuristico` y un `GuiaTuristico`.
- **Sobreescritura:** las subclases usan `@Override` en `mostrarInformacion()` y `toString()`.
- **Sobrecarga:** `GestorEntidades` permite buscar por texto o por tipo de clase.
- **Colecciones genéricas:** se utilizan `ArrayList<Registrable>`, `ArrayList<ServicioTuristico>` y `ArrayList<ReservaTuristica>`.
- **Excepción personalizada:** `DatoInvalidoException` informa datos incorrectos.

## 🗂️ Formato de los archivos TXT

Los datos se separan con punto y coma. Las líneas que comienzan con `#` son comentarios.

```text
# entidades.txt
GUIA;Pedro Muñoz;Montaña;8
VEHICULO;ABCD12;Van;12

# servicios.txt
GASTRONOMICA;3.5;Sabores del Sur;5
LACUSTRE;2.5;Travesía Lago Llanquihue;Catamarán
```

## ⚙️ Requisitos

- JDK 17 o superior.
- IntelliJ IDEA recomendado.
- No es necesario instalar Gradle porque el proyecto incluye Gradle Wrapper.

## ▶️ Clonar y ejecutar

### Desde IntelliJ IDEA

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/OsWaldo982/LlanquihueTourAppNuevo.git
   ```

2. Abrir la carpeta del proyecto en IntelliJ IDEA.
3. Esperar que Gradle termine de sincronizar.
4. Abrir `src/main/java/com/LlanquihueTour/ui/Main.java`.
5. Ejecutar el método `main()`.

### Desde una terminal

En macOS o Linux:

```bash
./gradlew run
```

En Windows:

```bat
gradlew.bat run
```

## 🧪 Pruebas y distribución

Ejecutar las pruebas automáticas:

```bash
./gradlew test
```

Compilar el proyecto y generar el archivo JAR:

```bash
./gradlew build
```

Generar una versión distribuible con sus scripts de ejecución:

```bash
./gradlew installDist
```

Los resultados se generan dentro de la carpeta `build/`.

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Desarrollo Orientado a Objetos I
