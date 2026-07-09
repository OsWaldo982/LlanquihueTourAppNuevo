![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# 🏔️ Llanquihue Tour - Actividad Formativa 4

## 👤 Autor del proyecto

* **Nombre completo:** Osvaldo González Olguín
* **Carrera:** Desarrollo de Aplicaciones
* **Sede:** Online / DUOC UC

---

## 📘 Descripción general del sistema

Este proyecto corresponde a la **Actividad Formativa 4** (Semana 6) de la asignatura *Desarrollo Orientado a Objetos I*.

En esta etapa, el sistema incorpora la **gestión de servicios turísticos** ofrecidos por la agencia **Llanquihue Tour**, ubicada en la Región de Los Lagos. Se implementa una jerarquía de clases que modela distintos tipos de servicios: **Rutas Gastronómicas**, **Paseos Lacustres** y **Excursiones Culturales**, todas heredando de una clase base `ServicioTuristico`.

Con esta actividad se aplican conceptos relacionados con:

* Organización modular en paquetes (`model`, `data`, `ui`)
* Programación Orientada a Objetos (herencia, superclases y subclases)
* Uso de `super()` en constructores
* Sobrescritura del método `toString()`
* Separación de responsabilidades

---
```
## 🧱 Estructura del proyecto
📁 LlanquihueTourApp/
├── 📁 src/
│ ├── 📁 model/
│ │ ├── ServicioTuristico.java
│ │ ├── RutaGastronomica.java
│ │ ├── PaseoLacustre.java
│ │ └── ExcursionCultural.java
│ ├── 📁 data/
│ │ └── GestorServicios.java
│ └── 📁 ui/
│ └── Main.java
```
---

## 📚 Clases implementadas (Semana 6)

| Clase | Paquete | Descripción |
|-------|---------|-------------|
| `ServicioTuristico` | `model` | Superclase con atributos comunes: `nombre` y `duracionHoras`. |
| `RutaGastronomica` | `model` | Subclase de `ServicioTuristico`. Añade atributo `numeroDeParadas`. |
| `PaseoLacustre` | `model` | Subclase de `ServicioTuristico`. Añade atributo `tipoEmbarcacion`. |
| `ExcursionCultural` | `model` | Subclase de `ServicioTuristico`. Añade atributo `lugarHistorico`. |
| `GestorServicios` | `data` | Crea instancias de prueba de cada subclase. |
| `Main` | `ui` | Punto de entrada. Ejecuta el programa y muestra los servicios por consola. |

---

## Jerarquía de clases
ServicioTuristico (superclase)
├── RutaGastronomica
├── PaseoLacustre
└── ExcursionCultural


## 🔧 Conceptos aplicados (Semana 6)

| Concepto | Aplicación en el proyecto |
|----------|---------------------------|
| **Paquetes** | Organización modular en `model`, `data`, `ui`. |
| **Herencia** | `RutaGastronomica`, `PaseoLacustre` y `ExcursionCultural` extienden `ServicioTuristico`. |
| **super()** | Cada subclase llama al constructor de la superclase con `super(nombre, duracionHoras)`. |
| **Sobrescritura** | Cada subclase sobrescribe `toString()` usando `super.toString()`. |
| **Encapsulamiento** | Atributos `private` o `protected` con acceso mediante constructores. |
| **Separación de responsabilidades** | `model` para datos, `data` para creación, `ui` para ejecución. |
| **Maven** | Gestión de dependencias y empaquetado JAR. |

---

## ⚙️ Instrucciones para ejecutar el proyecto

### Desde el código fuente (IntelliJ IDEA)

1. Clona el repositorio desde GitHub:
git clone https://github.com/OsWaldo982/llanquihue-tour.git


2. Abre el proyecto en IntelliJ IDEA.

3. Navega hasta el paquete `ui` y abre la clase `Main.java`.

4. Ejecuta el método `main()`.

### Salida esperada
=== SERVICIOS TURISTICOS ===
RUTA GASTRONÓMICA | Nombre: Sabores del Sur | Duración: 3.5 horas | Número de paradas: 5
RUTA GASTRONÓMICA | Nombre: Ruta del Asado Patagónico | Duración: 4.0 horas | Número de paradas: 3
PASEO LACUSTRE | Nombre: Travesía Lago Llanquihue | Duración: 2.5 horas | Embarcación: Catamarán
PASEO LACUSTRE | Nombre: Paseo en Kayak | Duración: 1.5 horas | Embarcación: Kayak doble
EXCURSIÓN CULTURAL | Nombre: Museo Colonial | Duración: 2.0 horas | Lugar histórico: Fuerte San Antonio
EXCURSIÓN CULTURAL | Nombre: Ciudad Patrimonial | Duración: 3.0 horas | Lugar histórico: Iglesia de Piedra


---

## 🎯 Objetivo de la semana 6

Implementar una jerarquía de clases para modelar los distintos servicios turísticos que ofrece la agencia Llanquihue Tour, aplicando herencia, uso de `super()` en constructores y sobrescritura del método `toString()` para mostrar la información completa de cada servicio.

---

## 📅 Fecha de entrega

**09/07/2026**

© Duoc UC | Escuela de Informática y Telecomunicaciones | Desarrollo Orientado a Objetos I
