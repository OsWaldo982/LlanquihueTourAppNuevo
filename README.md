![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# 🏔️ Llanquihue Tour - Actividad Formativa 6

## 👤 Autor del proyecto

* **Nombre completo:** Osvaldo González Olguín
* **Carrera:** Desarrollo de Aplicaciones
* **Sede:** Online / DUOC UC

---

## 📘 Descripción general del sistema

📘 Descripción general del sistema
Este proyecto corresponde a la (Semana 8) de la asignatura Desarrollo Orientado a Objetos I.

En esta etapa, el sistema incorpora interfaces, polimorfismo y estructuras dinámicas para gestionar distintas entidades de la agencia Llanquihue Tour. Se define una interfaz Registrable que establece un contrato común para todas las entidades gestionables. Las clases GuiaTuristico, Vehiculo y ColaboradorExterno implementan esta interfaz y sobrescriben el método mostrarResumen().

Se utiliza una colección ArrayList<Registrable> para almacenar objetos de distintos tipos, los cuales son recorridos y diferenciados mediante el operador instanceof. Además, se implementa una interfaz gráfica con JFrame que permite ingresar y visualizar las entidades del sistema.

Con esta actividad se aplican conceptos relacionados con:

Definición e implementación de interfaces

Polimorfismo en tiempo de ejecución

Colecciones genéricas (ArrayList)

Diferenciación de tipos con instanceof

Interfaz gráfica con JFrame y JOptionPane

Separación de responsabilidades por paquetes

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
│               │   ├── ExcursionCultural.java
│               │   ├── Registrable.java
│               │   ├── GuiaTuristico.java
│               │   ├── Vehiculo.java
│               │   └── ColaboradorExterno.java
│               ├── 📁 data/
│               │   ├── GestorServicios.java
│               │   └── GestorEntidades.java
│               ├── 📁 service/
│               │   └── ControladorDeTurismo.java
│               └── 📁 ui/
│                   ├── Main.java
│                   └── ScreenPrincipal.java

```

---

## 📚 Clases implementadas - Semana 7

| Clase                  | Paquete | Descripción                                                                                     |
| ---------------------- |---------| ----------------------------------------------------------------------------------------------- |
| `Registrable`    | `model` | Interfaz que define el contrato mostrarResumen() para todas las entidades.                           |
| `GuiaTuristico`     | `model` | Implementa Registrable. Atributos: nombre, especialidad, yearsExperiencia.     |
| `Vehiculo`        | `model` | Implementa Registrable. Atributos: patente, tipo, capacidad.  |
| `ColaboradorExterno`    | `model` | Implementa Registrable. Atributos: nombre, servicio, telefono.       |
| `GestorEntidades`      | `data`  | Contiene ArrayList<Registrable>, carga datos de prueba y recorre con instanceof. |
| `ScreenPrincipal` | `ui`    | Interfaz gráfica con JFrame para ingresar y visualizar entidades.                            |


## 🔧 Conceptos aplicados - Semana 7

| Concepto                            | Aplicación en el proyecto                                                                                                |
| ----------------------------------- | ------------------------------------------------------------------------------------------------------------------------ |
| **Interfaz**                    | Registrable define el método mostrarResumen() implementado por tres clases.       |
| **Polimorfismo**                   | ArrayList<Registrable> almacena distintos tipos y los recorre con referencia a la interfaz.                                   |
| **instanceof**              | 	Permite identificar el tipo de cada objeto y aplicar lógica diferenciada.                                                |
| **Colección genérica**                        | 	ArrayList<Registrable> permite agregar cualquier clase que implemente la interfaz.                                                      |

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


## 🎯 Objetivo de la Semana 8

Integrar interfaces, polimorfismo y estructuras dinámicas en el sistema de Llanquihue Tour. Se define una interfaz Registrable como contrato común, se implementa en múltiples clases, se almacenan objetos en una colección genérica y se diferencian mediante instanceof. Todo esto con una interfaz gráfica funcional.


---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Desarrollo Orientado a Objetos I
