import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.math3.util.Pair;

public class Vertex {
	private String label = null; //id do vertice
	private Map<Vertex, Edge> edges = new HashMap<>(); //arestas
	private boolean isVisited = false; //ja foi visitado

	public Vertex(String label) {
		this.label = label;
	}

	public void addEdge(Vertex vertex, Edge edge) {
		if (this.edges.containsKey(vertex)) {
			if (edge.getPeso() < this.edges.get(vertex).getPeso()) {
				this.edges.replace(vertex, edge);
			}
		} else {
			this.edges.put(vertex, edge);
		}
	}

	/* Itero pelas arestas do vertice e retorno a de menor custo */
	public Pair<Vertex, Edge> nextMinimum() {
		Edge nextMinimum = new Edge(Integer.MAX_VALUE);
		Vertex nextVertex = this;
		Iterator<Map.Entry<Vertex, Edge>> it = edges.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Vertex, Edge> pair = it.next();
			if (!pair.getKey().isVisited()) {
				if (!pair.getValue().isIncluido()) {
					if (pair.getValue().getPeso() < nextMinimum.getPeso()) {
						nextMinimum = pair.getValue();
						nextVertex = pair.getKey();
					}
				}
			}
		}
		return new Pair<>(nextVertex, nextMinimum);
	}

	public String originalToString() {
		StringBuilder sb = new StringBuilder();
		Iterator<Map.Entry<Vertex, Edge>> it = edges.entrySet().iterator();
		
		if(it == null || !it.hasNext()) {
			sb.append(getLabel() + "\n");
		}
		
		while (it.hasNext()) {
			Map.Entry<Vertex, Edge> pair = it.next();
			if (!pair.getValue().isPrintado()) {
				sb.append(getLabel());
				sb.append(" --- ");
				sb.append(pair.getValue().getPeso());
				sb.append(" --- ");
				sb.append(pair.getKey().getLabel());
				sb.append("\n");
				pair.getValue().setPrintado(true);
			}
		}
		return sb.toString();
	}

	public String includedToString() {
		StringBuilder sb = new StringBuilder();
		if (isVisited()) {
			Iterator<Map.Entry<Vertex, Edge>> it = edges.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<Vertex, Edge> pair = it.next();
				if (pair.getValue().isIncluido()) {
					if (!pair.getValue().isPrintado()) {
						sb.append(getLabel());
						sb.append(" --- ");
						sb.append(pair.getValue().getPeso());
						sb.append(" --- ");
						sb.append(pair.getKey().getLabel());
						sb.append("\n");
						pair.getValue().setPrintado(true);
					}
				}
			}
		}
		return sb.toString();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Map<Vertex, Edge> getEdges() {
		return edges;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean visited) {
		isVisited = visited;
	}
}