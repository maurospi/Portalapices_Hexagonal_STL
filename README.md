# Portalápices hexagonal: generador de STL en Java

Programa en Java que genera, sin librerías externas, el archivo **STL** (formato ASCII) de un portalápices con forma de prisma hexagonal hueco y simula el progreso de su impresión 3D capa por capa.

> **Aviso:** este proyecto se elaboró con ayuda de la inteligencia artificial **Claude** (Anthropic) como apoyo para programar. El código debe ser revisado, probado y comprendido por quien lo utilice antes de usarlo o entregarlo.

## Datos del proyecto

| | |
|---|---|
| **Materia** | Fundamentos de Software |
| **Profesor** | Andrés Maldonado |
| **Integrantes** | Paula Noguera, Samuel Céspedes, Ángel Romero, Fabián Ospina |

## Qué hace

1. Calcula los 48 triángulos que forman el portalápices (base, caras exteriores, borde superior, caras interiores y fondo de la cavidad).
2. Calcula la normal de cada triángulo con el producto cruz.
3. Escribe el archivo `portalapices_hexagonal.stl`.
4. Simula la impresión: 500 capas de 0.2 mm, con un mensaje cada 5 % de avance.

## Medidas de la pieza

| Parámetro | Valor |
|---|---|
| Radio exterior | 40 mm |
| Alto total | 100 mm |
| Grosor de pared | 3 mm (medido entre caras planas) |
| Grosor de base | 4 mm |
| Caja delimitadora | 80.0 × 69.3 × 100.0 mm |

Los valores por defecto están en el constructor sin parámetros de `PrismaHexagonalHueco`. También puedes crear la pieza con tus propias medidas:

```java
new PrismaHexagonalHueco(radioExterior, altoTotal, grosorPared, grosorBase);
```

## Estructura del proyecto

| Archivo | Responsabilidad |
|---|---|
| `Main.java` | Punto de entrada: crea la fábrica, agrega la forma y produce. |
| `Punto.java` | Un punto 3D (x, y, z) en milímetros. |
| `Triangulo.java` | Tres puntos y el cálculo de su normal. |
| `Forma3D.java` | Clase abstracta: toda forma genera triángulos y su caja delimitadora. |
| `PrismaHexagonalHueco.java` | Forma concreta: el portalápices hexagonal. |
| `EscritorStl.java` | Escribe el archivo STL en formato ASCII. |
| `ProgresoImpresion.java` | Capa actual sobre el total de capas y su porcentaje. |
| `ControladorImpresion.java` | Elige el mensaje según el porcentaje de avance. |
| `ImpresoraSimulada.java` | Recorre las capas y avisa al controlador. |
| `FabricaPiezas.java` | Coordina: generar, guardar el STL e imprimir. |

### Conceptos de POO que se usan

- **Encapsulamiento:** atributos privados con *getters*.
- **Abstracción y herencia:** `Forma3D` y `PrismaHexagonalHueco`.
- **Polimorfismo:** `FabricaPiezas` trata a cualquier `Forma3D` igual.
- **Sobrecarga de constructores:** medidas por defecto o personalizadas.
- **Responsabilidad única:** cada clase hace una sola tarea.

## Cómo ejecutarlo

Requisitos: **JDK 8 o superior**.

```bash
javac *.java
java Main
```

Salida esperada (resumida):

```
Forma: Portalapices hexagonal
Triangulos generados: 48
Caja delimitadora (mm): 80.0 x 69.3 x 100.0
Archivo STL creado correctamente.
[  0.0%] Capa 0 de 500: impresion iniciada
...
[ 15.0%] Capa 75 de 500: realizando impresion
...
[ 90.0%] Capa 450 de 500: impresion finalizada
[100.0%] Capa 500 de 500: impresion finalizada
```

## Fases de la impresión simulada

| Avance | Mensaje |
|---|---|
| Menos del 15 % | impresión iniciada |
| Del 15 % al 85 % (incluidos) | realizando impresión |
| Más del 85 % | impresión finalizada |

## Ver y usar el STL

El archivo `portalapices_hexagonal.stl` se crea en la carpeta desde donde ejecutes el programa. Puedes abrirlo en cualquier visor o laminador, por ejemplo Ultimaker Cura, PrusaSlicer, Bambu Studio o el visor 3D de Windows.