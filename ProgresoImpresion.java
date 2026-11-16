/*
 * AVISO: Este archivo se elaboró con ayuda de la inteligencia artificial
 * Claude (Anthropic) como apoyo para programar. El código debe ser revisado,
 * probado y comprendido por quien lo utilice antes de usarlo o entregarlo.
 */

// Guarda en que punto del proceso va la impresion: capa actual sobre el total de capas.
class ProgresoImpresion {
    private final int capaActual;
    private final int totalCapas;

    public ProgresoImpresion(int capaActual, int totalCapas) {
        if (totalCapas <= 0 || capaActual < 0 || capaActual > totalCapas) {
            throw new IllegalArgumentException("El progreso esta fuera de rango");
        }
        this.capaActual = capaActual;
        this.totalCapas = totalCapas;
    }

    public double calcularPorcentaje() {
        return 100.0 * capaActual / totalCapas;
    }

    public int getCapaActual() {
        return capaActual;
    }

    public int getTotalCapas() {
        return totalCapas;
    }
}
