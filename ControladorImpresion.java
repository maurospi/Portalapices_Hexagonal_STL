/*
 * AVISO: Este archivo se elaboró con ayuda de la inteligencia artificial
 * Claude (Anthropic) como apoyo para programar. El código debe ser revisado,
 * probado y comprendido por quien lo utilice antes de usarlo o entregarlo.
 */

import java.util.Locale;

// Decide que mensaje mostrar segun el porcentaje de avance, sin saber que ocurre afuera.
class ControladorImpresion {
    private static final double LIMITE_INICIO = 15.0;
    private static final double LIMITE_FINAL = 85.0;

    // Antes del 15 %.
    public void inicioImpresion(ProgresoImpresion progreso) {
        System.out.println(crearPrefijo(progreso) + "impresion iniciada");
    }

    // Entre el 15 % y el 85 % (ambos incluidos).
    public void estadoActual(ProgresoImpresion progreso) {
        System.out.println(crearPrefijo(progreso) + "realizando impresion");
    }

    // Despues del 85 % y hasta el 100 %.
    public void finalImpresion(ProgresoImpresion progreso) {
        System.out.println(crearPrefijo(progreso) + "impresion finalizada");
    }

    // Infiere en que fase esta el proceso y ejecuta el metodo correspondiente.
    public void reportar(ProgresoImpresion progreso) {
        double porcentaje = progreso.calcularPorcentaje();
        if (porcentaje < LIMITE_INICIO) {
            inicioImpresion(progreso);
        } else if (porcentaje <= LIMITE_FINAL) {
            estadoActual(progreso);
        } else {
            finalImpresion(progreso);
        }
    }

    private String crearPrefijo(ProgresoImpresion progreso) {
        return String.format(Locale.US, "[%5.1f%%] Capa %d de %d: ",
                progreso.calcularPorcentaje(), progreso.getCapaActual(), progreso.getTotalCapas());
    }
}
