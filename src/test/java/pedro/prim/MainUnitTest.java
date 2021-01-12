package pedro.prim;

import org.junit.Test;

public class MainUnitTest {
    GraphGenerator graphGenerator = new GraphGenerator();

    @Test
    public void dadoUmGrafo_ExecutarPrim_PrintarArvoreGeradoraMinima() {
        Prim prim = new Prim(graphGenerator.createGraph(1));
        System.out.println("Grafo Original\n" + prim.printGraph());
        System.out.println("----------------");
        prim.execute();
        System.out.println("\nÁrvore geradora mínima\n" + prim.printMST());
    }
}