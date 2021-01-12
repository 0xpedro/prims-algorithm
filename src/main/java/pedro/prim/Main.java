package pedro.prim;

public class Main
{
    public static void main(String[] args) {
        GraphGenerator graphGenerator = new GraphGenerator();
        Prim prim = new Prim(graphGenerator.createGraph(1));
        prim.printGraph();
        prim.execute();
        prim.printMST();
    }
}
