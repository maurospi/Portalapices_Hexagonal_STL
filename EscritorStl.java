/*
 * AVISO: Este archivo se elaboró con ayuda de la inteligencia artificial
 * Claude (Anthropic) como apoyo para programar. El código debe ser revisado,
 * probado y comprendido por quien lo utilice antes de usarlo o entregarlo.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

// Se encarga unicamente de escribir el archivo STL (formato ASCII).
class EscritorStl {
    public void escribir(String rutaArchivo, String nombreSolido, List<Triangulo> triangulos)
            throws IOException {
        PrintWriter escritor = new PrintWriter(new FileWriter(rutaArchivo));
        try {
            escritor.println("solid " + nombreSolido);
            for (int indice = 0; indice < triangulos.size(); indice++) {
                Triangulo triangulo = triangulos.get(indice);
                double[] normal = triangulo.calcularNormal();
                escritor.println(String.format(Locale.US, "  facet normal %e %e %e",
                        normal[0], normal[1], normal[2]));
                escritor.println("    outer loop");
                escribirVertice(escritor, triangulo.getPrimerVertice());
                escribirVertice(escritor, triangulo.getSegundoVertice());
                escribirVertice(escritor, triangulo.getTercerVertice());
                escritor.println("    endloop");
                escritor.println("  endfacet");
            }
            escritor.println("endsolid " + nombreSolido);
        } finally {
            escritor.close();
        }
    }

    private void escribirVertice(PrintWriter escritor, Punto punto) {
        escritor.println(String.format(Locale.US, "      vertex %e %e %e",
                punto.getCoordenadaX(), punto.getCoordenadaY(), punto.getCoordenadaZ()));
    }
}
