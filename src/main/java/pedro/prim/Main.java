package pedro.prim;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main
{
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Entrada inválida. Digite: java Main <arquivo_grafo>");
            System.exit(-1);
        }

        Map<String, Vertex> graph = new HashMap<String, Vertex>();
        String file_path = args[0];
        String this_line = null;
        String pieces[];

        try {
            FileReader graph_file = new FileReader(file_path);
            BufferedReader br1 = new BufferedReader(graph_file);
            while ((this_line = br1.readLine()) != null) {
                this_line = this_line.replaceAll("\\s+", " ");
                pieces = this_line.split(" ");
                String v1_id = pieces[0];
                Vertex v1 = new Vertex(v1_id);

                graph.remove(v1_id);
                graph.put(v1_id, v1);

                for (int i = 2; i < pieces.length; i+=2) {
                    String v2_id = pieces[i];
                    int peso = Integer.parseInt(pieces[i+1]);
                    Vertex v2 = new Vertex(v2_id);

                    Edge e = new Edge(peso);
                    v1.addEdge(v2, e);
                    v2.addEdge(v1, e);

                    graph.remove(v1_id);
                    graph.put(v1_id, v1);

                    graph.remove(v2_id);
                    graph.put(v2_id, v2);
                }
            }

            /* graph.forEach((key, value) -> System.out.println(key + ":" + value.getEdges().values()));
            for (Map.Entry<String, Vertex> entry : graph.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue().getEdges().values());
            } */

            List<Vertex> teste = new ArrayList<Vertex>(graph.values());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* GraphGenerator graphGenerator = new GraphGenerator();
        Prim prim = new Prim(graphGenerator.createGraph(1));
        prim.printGraph();
        prim.execute();
        prim.printMST(); */
    }
}