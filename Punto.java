/*
 * AVISO: Este archivo se elaboró con ayuda de la inteligencia artificial
 * Claude (Anthropic) como apoyo para programar. El código debe ser revisado,
 * probado y comprendido por quien lo utilice antes de usarlo o entregarlo.
 */

// Un punto en el espacio 3D (milimetros).
class Punto {
    private final double coordenadaX;
    private final double coordenadaY;
    private final double coordenadaZ;

    public Punto(double coordenadaX, double coordenadaY, double coordenadaZ) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.coordenadaZ = coordenadaZ;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public double getCoordenadaZ() {
        return coordenadaZ;
    }
}
