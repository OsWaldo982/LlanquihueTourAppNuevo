![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# 🏔️ Llanquihue Tour - Actividad Formativa 5

## 👤 Autor del proyecto

* **Nombre completo:** Osvaldo González Olguín
* **Carrera:** Desarrollo de Aplicaciones
* **Sede:** Online / DUOC UC

---

## 📘 Descripción general del sistema

Este proyecto corresponde a la **Actividad Formativa 5** (Semana 7) de la asignatura *Desarrollo Orientado a Objetos I*.

En esta etapa, el sistema evoluciona para aplicar **polimorfismo** y **colecciones genéricas** sobre la jerarquía de servicios turísticos. Se utiliza una colección `ArrayList<ServicioTuristico>` para almacenar distintos tipos de servicios, los cuales son recorridos y mostrados invocando métodos sobrescritos desde referencias de la superclase.

Con esta actividad se aplican conceptos relacionados con:

* Polimorfismo en tiempo de ejecución
* Sobrescritura de métodos (`@Override`)
* Colecciones genéricas (`ArrayList`)
* Recorrido de colecciones con `for-each`
* Separación de responsabilidades por paquetes

---

## 🧱 Estructura del proyecto

```text
📁 LlanquihueTourApp/
├── 📁 src/
│   └── 📁 main/
│       └── 📁 java/
│           └── 📁 com.llanquihue/
│               ├── 📁 model/
│               │   ├── ServicioTuristico.java
│               │   ├── RutaGastronomica.java
│               │   ├── PaseoLacustre.java
│               │   └── ExcursionCultural.java
│               ├── 📁 data/
│               │   └── GestorServicios.java
│               ├── 📁 service/
│               │   └── ControladorDeTurismo.java
│               └── 📁 ui/
│                   └── Main.java
```

---

## 📚 Clases implementadas - Semana 7

| Clase                  | Paquete   | Descripción                                                                                     |
| ---------------------- | --------- | ----------------------------------------------------------------------------------------------- |
| `ServicioTuristico`    | `model`   | Superclase con método `mostrarInformacion()` que será sobrescrito.                              |
| `RutaGastronomica`     | `model`   | Subclase que sobrescribe `mostrarInformacion()` con detalles de paradas y degustaciones.        |
| `PaseoLacustre`        | `model`   | Subclase que sobrescribe `mostrarInformacion()` con tipo de embarcación y servicios incluidos.  |
| `ExcursionCultural`    | `model`   | Subclase que sobrescribe `mostrarInformacion()` con lugar histórico y guía especializado.       |
| `GestorServicios`      | `data`    | Crea y retorna un `ArrayList<ServicioTuristico>` con al menos 5 objetos de distintas subclases. |
| `ControladorDeTurismo` | `service` | Recorre la colección y muestra la información de forma polimórfica.                             |
| `Main`                 | `ui`      | Punto de entrada. Orquesta la creación y visualización de los servicios.                        |

---

## 🧬 Jerarquía de clases

```text
ServicioTuristico
├── RutaGastronomica
├── PaseoLacustre
└── ExcursionCultural
```

---

## 🔧 Conceptos aplicados - Semana 7

| Concepto                            | Aplicación en el proyecto                                                                                                |
| ----------------------------------- | ------------------------------------------------------------------------------------------------------------------------ |
| **Polimorfismo**                    | Recorrido de `ArrayList<ServicioTuristico>` invocando `mostrarInformacion()` desde la referencia de la superclase.       |
| **Sobrescritura**                   | Cada subclase implementa su propia versión de `mostrarInformacion()` con `@Override`.                                    |
| **Colección genérica**              | `ArrayList<ServicioTuristico>` almacena objetos de diferentes subclases.                                                 |
| **for-each**                        | Bucle que recorre la colección sin necesidad de usar `instanceof`.                                                       |
| **Separación de responsabilidades** | `model` contiene las clases del dominio, `data` crea los datos, `service` contiene la lógica y `ui` ejecuta el programa. |

---

## ⚙️ Instrucciones para compilar y ejecutar

### Desde IntelliJ IDEA

1. Clonar el repositorio desde GitHub:

```bash
git clone https://github.com/OsWaldo982/llanquihue-tour.git
```

2. Abrir el proyecto en IntelliJ IDEA.

3. Navegar hasta el paquete `ui`.

4. Abrir la clase `Main.java`.

5. Ejecutar el método `main()`.


## 🖥️ Salida esperada

```text
=== SERVICIOS TURÍSTICOS ===

RUTA GASTRONÓMICA
Nombre: Sabores del Sur
Duración: 3.5 horas
Número de paradas: 5
Incluye degustaciones en cada parada

RUTA GASTRONÓMICA
Nombre: Ruta del Asado Patagónico
Duración: 4.0 horas
Número de paradas: 3
Incluye degustaciones en cada parada

PASEO LACUSTRE
Nombre: Travesía Lago Llanquihue
Duración: 2.5 horas
Embarcación: Catamarán
Incluye chaleco salvavidas y guía

PASEO LACUSTRE
Nombre: Paseo en Kayak
Duración: 1.5 horas
Embarcación: Kayak doble
Incluye chaleco salvavidas y guía

EXCURSIÓN CULTURAL
Nombre: Museo Colonial
Duración: 2.0 horas
Lugar histórico: Fuerte San Antonio
Incluye guía especializado

EXCURSIÓN CULTURAL
Nombre: Ciudad Patrimonial
Duración: 3.0 horas
Lugar histórico: Iglesia de Piedra
Incluye guía especializado
```

---

## 🎯 Objetivo de la Semana 7

Aplicar polimorfismo y colecciones genéricas para gestionar dinámicamente distintos tipos de servicios turísticos, permitiendo que el sistema escale sin modificar el código existente.

Se implementa un método `mostrarInformacion()` sobrescrito en cada subclase y se recorre una colección `ArrayList<ServicioTuristico>` invocando dicho método desde referencias de la superclase.

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Desarrollo Orientado a Objetos I
