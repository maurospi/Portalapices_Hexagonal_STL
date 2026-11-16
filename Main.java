/*
 * AVISO: Este archivo se elaboró con ayuda de la inteligencia artificial
 * Claude (Anthropic) como apoyo para programar. El código debe ser revisado,
 * probado y comprendido por quien lo utilice antes de usarlo o entregarlo.
 */

public class Main {
    public static void main(String[] args) {
        FabricaPiezas fabrica = new FabricaPiezas();
        fabrica.agregarForma(new PrismaHexagonalHueco());
        fabrica.producir();
    }
}
