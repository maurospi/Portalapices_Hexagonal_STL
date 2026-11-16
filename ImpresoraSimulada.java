/*
 * AVISO: Este archivo se elaboró con ayuda de la inteligencia artificial
 * Claude (Anthropic) como apoyo para programar. El código debe ser revisado,
 * probado y comprendido por quien lo utilice antes de usarlo o entregarlo.
 */

// Simula la impresion capa por capa y avisa al controlador cada 5 % de avance.
class ImpresoraSimulada {
    private static final double ALTURA_CAPA_MILIMETROS = 0.2;
    private static final int REPORTES_POR_IMPRESION = 20;

    private final ControladorImpresion controlador;

    public ImpresoraSimulada(ControladorImpresion controlador) {
        this.controlador = controlador;
    }

    public void imprimir(Forma3D forma) {
        double alto = forma.calcularCajaDelimitadora()[2];
        int totalCapas = (int) Math.round(alto / ALTURA_CAPA_MILIMETROS);
        int capasPorReporte = Math.max(1, totalCapas / REPORTES_POR_IMPRESION);

        for (int capa = 0; capa <= totalCapas; capa++) {
            if (capa % capasPorReporte == 0 || capa == totalCapas) {
                controlador.reportar(new ProgresoImpresion(capa, totalCapas));
            }
        }
    }
}
