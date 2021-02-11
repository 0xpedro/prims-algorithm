import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
	public static void main(String[] args) {
		if (args.length < 1) {
            System.out.println("Entrada invalida. Digite: java App <arquivo_grafo>");
            System.exit(-1);
        }
		
		readGraph(args[0]);
	}

	public static void readGraph(String graphFilePath) {
		Map<String, Vertex> graph = new HashMap<String, Vertex>();
		String this_line = null;
		String pieces[];

		try {
			FileReader graph_file = new FileReader(graphFilePath);
			BufferedReader br1 = new BufferedReader(graph_file);
			
			while ((this_line = br1.readLine()) != null) {
				this_line = this_line.replaceAll("\\s+", " ");
				pieces = this_line.split(" ");
				String v1_id = pieces[0];
				Vertex v1 = graph.containsKey(v1_id) ? graph.get(v1_id) : new Vertex(v1_id);

				graph.remove(v1_id);
				graph.put(v1_id, v1);

				for (int i = 2; i < pieces.length; i += 2) {
					String v2_id = pieces[i];
					int peso = Integer.parseInt(pieces[i + 1]);
					Vertex v2 = graph.containsKey(v2_id) ? graph.get(v2_id) : new Vertex(v2_id);

					Edge e = new Edge(peso);
					v1.addEdge(v2, e);
					v2.addEdge(v1, e);

					graph.remove(v1_id);
					graph.put(v1_id, v1);

					graph.remove(v2_id);
					graph.put(v2_id, v2);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo "+ graphFilePath + " nao encontrado");
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			System.out.println("Arquivo " + graphFilePath + " mal formatado");
			e.printStackTrace();
			System.exit(-1);
		}
		
		Prim prim = new Prim(new ArrayList<Vertex>(graph.values()));
		System.out.println(prim.printGraph());
		System.out.println("----------------");
		prim.execute();
		System.out.println();
		System.out.println(prim.printMST());
	}
}
