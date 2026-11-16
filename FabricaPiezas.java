/*
 * AVISO: Este archivo se elaboró con ayuda de la inteligencia artificial
 * Claude (Anthropic) como apoyo para programar. El código debe ser revisado,
 * probado y comprendido por quien lo utilice antes de usarlo o entregarlo.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Coordina todo el proceso de una pieza: generar, guardar el STL e imprimir.
class FabricaPiezas {
    private final List<Forma3D> formas = new ArrayList<Forma3D>();
    private final EscritorStl escritorStl = new EscritorStl();
    private final ImpresoraSimulada impresora = new ImpresoraSimulada(new ControladorImpresion());

    public void agregarForma(Forma3D forma) {
        formas.add(forma);
    }

    public void producir() {
        // Polimorfismo: cada Forma3D genera sus triangulos a su manera.
        for (int indice = 0; indice < formas.size(); indice++) {
            producirForma(formas.get(indice));
        }
    }

    private void producirForma(Forma3D forma) {
        List<Triangulo> triangulos = forma.generarTriangulos();
        double[] caja = forma.calcularCajaDelimitadora();
        String nombreArchivo = forma.getNombre().toLowerCase().replace(" ", "_");

        System.out.println("Forma: " + forma.getNombre());
        System.out.println("Triangulos generados: " + triangulos.size());
        System.out.println(String.format(Locale.US,
                "Caja delimitadora (mm): %.1f x %.1f x %.1f", caja[0], caja[1], caja[2]));

        try {
            escritorStl.escribir(nombreArchivo + ".stl", nombreArchivo, triangulos);
            System.out.println("Archivo STL creado correctamente.");
        } catch (IOException excepcion) {
            System.out.println("Error al escribir el archivo: " + excepcion.getMessage());
            return;
        }
        impresora.imprimir(forma);
    }
}
