/*
 * AVISO: Este archivo se elaboró con ayuda de la inteligencia artificial
 * Claude (Anthropic) como apoyo para programar. El código debe ser revisado,
 * probado y comprendido por quien lo utilice antes de usarlo o entregarlo.
 */

import java.util.List;

// Clase abstracta: toda forma 3D sabe generar sus triangulos, cada una a su manera.
abstract class Forma3D {
    private final String nombre;

    public Forma3D(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract List<Triangulo> generarTriangulos();

    // Dimensiones de la caja delimitadora: {ancho X, largo Y, alto Z}.
    public abstract double[] calcularCajaDelimitadora();
}
