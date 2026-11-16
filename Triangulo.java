/*
 * AVISO: Este archivo se elaboró con ayuda de la inteligencia artificial
 * Claude (Anthropic) como apoyo para programar. El código debe ser revisado,
 * probado y comprendido por quien lo utilice antes de usarlo o entregarlo.
 */

// Un triangulo: la unidad basica de todo archivo STL.
class Triangulo {
    private final Punto primerVertice;
    private final Punto segundoVertice;
    private final Punto tercerVertice;

    public Triangulo(Punto primerVertice, Punto segundoVertice, Punto tercerVertice) {
        this.primerVertice = primerVertice;
        this.segundoVertice = segundoVertice;
        this.tercerVertice = tercerVertice;
    }

    // La normal se calcula con el producto cruz de dos aristas.
    // El orden de los vertices (antihorario visto desde afuera) define hacia donde apunta.
    public double[] calcularNormal() {
        double aristaUnoX = segundoVertice.getCoordenadaX() - primerVertice.getCoordenadaX();
        double aristaUnoY = segundoVertice.getCoordenadaY() - primerVertice.getCoordenadaY();
        double aristaUnoZ = segundoVertice.getCoordenadaZ() - primerVertice.getCoordenadaZ();
        double aristaDosX = tercerVertice.getCoordenadaX() - primerVertice.getCoordenadaX();
        double aristaDosY = tercerVertice.getCoordenadaY() - primerVertice.getCoordenadaY();
        double aristaDosZ = tercerVertice.getCoordenadaZ() - primerVertice.getCoordenadaZ();

        double normalX = aristaUnoY * aristaDosZ - aristaUnoZ * aristaDosY;
        double normalY = aristaUnoZ * aristaDosX - aristaUnoX * aristaDosZ;
        double normalZ = aristaUnoX * aristaDosY - aristaUnoY * aristaDosX;

        double longitud = Math.sqrt(normalX * normalX + normalY * normalY + normalZ * normalZ);
        if (longitud == 0) {
            return new double[] {0, 0, 0};
        }
        return new double[] {normalX / longitud, normalY / longitud, normalZ / longitud};
    }

    public Punto getPrimerVertice() {
        return primerVertice;
    }

    public Punto getSegundoVertice() {
        return segundoVertice;
    }

    public Punto getTercerVertice() {
        return tercerVertice;
    }
}
