/*
 * AVISO: Este archivo se elaboró con ayuda de la inteligencia artificial
 * Claude (Anthropic) como apoyo para programar. El código debe ser revisado,
 * probado y comprendido por quien lo utilice antes de usarlo o entregarlo.
 */

import java.util.ArrayList;
import java.util.List;

// Portalapices: prisma hexagonal hueco con base cerrada.
class PrismaHexagonalHueco extends Forma3D {
    private static final int CANTIDAD_LADOS = 6;

    private final double radioExterior;
    private final double altoTotal;
    private final double grosorPared;
    private final double grosorBase;

    public PrismaHexagonalHueco(double radioExterior, double altoTotal,
                                double grosorPared, double grosorBase) {
        super("Portalapices hexagonal");
        this.radioExterior = radioExterior;
        this.altoTotal = altoTotal;
        this.grosorPared = grosorPared;
        this.grosorBase = grosorBase;
    }

    // Sobrecarga: constructor con las medidas aprobadas por defecto.
    public PrismaHexagonalHueco() {
        this(40.0, 100.0, 3.0, 4.0);
    }

    // El grosor de pared se mide entre caras planas (apotema), no entre vertices.
    public double calcularRadioInterior() {
        double apotemaExterior = radioExterior * Math.cos(Math.PI / CANTIDAD_LADOS);
        double apotemaInterior = apotemaExterior - grosorPared;
        return apotemaInterior / Math.cos(Math.PI / CANTIDAD_LADOS);
    }

    private Punto crearVertice(double radio, int indice, double alturaZ) {
        double angulo = 2.0 * Math.PI * indice / CANTIDAD_LADOS;
        return new Punto(radio * Math.cos(angulo), radio * Math.sin(angulo), alturaZ);
    }

    @Override
    public List<Triangulo> generarTriangulos() {
        List<Triangulo> triangulos = new ArrayList<Triangulo>();
        double radioInterior = calcularRadioInterior();
        Punto centroBase = new Punto(0, 0, 0);
        Punto centroCavidad = new Punto(0, 0, grosorBase);

        for (int indice = 0; indice < CANTIDAD_LADOS; indice++) {
            int siguiente = (indice + 1) % CANTIDAD_LADOS;

            Punto exteriorAbajoActual = crearVertice(radioExterior, indice, 0);
            Punto exteriorAbajoSiguiente = crearVertice(radioExterior, siguiente, 0);
            Punto exteriorArribaActual = crearVertice(radioExterior, indice, altoTotal);
            Punto exteriorArribaSiguiente = crearVertice(radioExterior, siguiente, altoTotal);

            Punto interiorFondoActual = crearVertice(radioInterior, indice, grosorBase);
            Punto interiorFondoSiguiente = crearVertice(radioInterior, siguiente, grosorBase);
            Punto interiorArribaActual = crearVertice(radioInterior, indice, altoTotal);
            Punto interiorArribaSiguiente = crearVertice(radioInterior, siguiente, altoTotal);

            // Base inferior (normal hacia abajo).
            triangulos.add(new Triangulo(centroBase, exteriorAbajoSiguiente, exteriorAbajoActual));

            // Cara exterior (normal hacia afuera).
            triangulos.add(new Triangulo(exteriorAbajoActual, exteriorAbajoSiguiente, exteriorArribaSiguiente));
            triangulos.add(new Triangulo(exteriorAbajoActual, exteriorArribaSiguiente, exteriorArribaActual));

            // Borde superior: anillo entre el exterior y el interior (normal hacia arriba).
            triangulos.add(new Triangulo(exteriorArribaActual, exteriorArribaSiguiente, interiorArribaSiguiente));
            triangulos.add(new Triangulo(exteriorArribaActual, interiorArribaSiguiente, interiorArribaActual));

            // Cara interior (normal hacia el centro de la cavidad).
            triangulos.add(new Triangulo(interiorFondoActual, interiorArribaSiguiente, interiorFondoSiguiente));
            triangulos.add(new Triangulo(interiorFondoActual, interiorArribaActual, interiorArribaSiguiente));

            // Fondo de la cavidad (normal hacia arriba).
            triangulos.add(new Triangulo(centroCavidad, interiorFondoActual, interiorFondoSiguiente));
        }
        return triangulos;
    }

    @Override
    public double[] calcularCajaDelimitadora() {
        double anchoEsquinaAEsquina = 2.0 * radioExterior;
        double anchoEntreCaras = 2.0 * radioExterior * Math.cos(Math.PI / CANTIDAD_LADOS);
        return new double[] {anchoEsquinaAEsquina, anchoEntreCaras, altoTotal};
    }
}
