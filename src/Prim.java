import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.util.Pair;

public class Prim {
	private List<Vertex> graph;
	private int quantity_vertex;

    public Prim(List<Vertex> graph){
        this.graph = graph;
        quantity_vertex = graph.size();
    }

    public void execute(){
        if (graph.size() > 0){
            graph.get(0).setVisited(true); //comeca pelo primeiro vertice

            while (isConnected()) {
            	Edge e = new Edge(Integer.MAX_VALUE);
            	Vertex v = graph.get(0);
            	for (Vertex vertex : graph){
            		if (vertex.isVisited()){
            			Pair<Vertex, Edge> minimum = vertex.nextMinimum(); // recebe a aresta de menor custo e o vertice a qual eh ligada
            			if (minimum.getValue().getPeso() < e.getPeso()){
            				e = minimum.getValue();
            				v = minimum.getKey();
            			}
            		}
            	}
            	e.setIncluido(true); // arestas e vertices sao setados como incluidos p ser impressos na MST
            	v.setVisited(true);
            }
        } else {
        	System.out.println("Nao eh um grafo. Parando execucao do programa...");
        	System.exit(-1);
        }
    }

    private boolean isConnected(){
    	quantity_vertex--;
    	if(quantity_vertex < 0) {
    		//checou o mesmo vertice mais de uma vez, eh desconexo
    		System.out.println("Grafo desconexo. Parando execucao do programa...");
    		System.exit(-1);
    	}
    	
        for (Vertex vertex : graph){
            if (!vertex.isVisited()){
                return true;
            }
        }
        return false;
    }

    public String printGraph(){
        resetPrintHistory();
        
        System.out.println("Grafo original");

        StringBuilder sb = new StringBuilder();
        for (Vertex vertex : graph){
            sb.append(vertex.originalToString());
        }
        return sb.toString();
    }

    private void resetPrintHistory(){
    	// limpar as variaveis relacionadas ao print p printar a MST
        for (Vertex vertex : graph){
            Iterator<Map.Entry<Vertex,Edge>> it = vertex.getEdges().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Vertex,Edge> pair = it.next();
                pair.getValue().setPrintado(false);
            }
        }
    }

    public String printMST(){
        resetPrintHistory();
        
        System.out.println("MST");

        StringBuilder sb = new StringBuilder();
        for (Vertex vertex : graph){
            sb.append(vertex.includedToString());
        }
        return sb.toString();
    }
}