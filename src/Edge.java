public class Edge {
	private int peso; //peso da aresta
	private boolean incluido = false; //faz parte da MST
	private boolean printado = false; //varaivel para print

	public Edge(int peso) {
		this.peso = peso;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public boolean isIncluido() {
		return incluido;
	}

	public void setIncluido(boolean incluido) {
		this.incluido = incluido;
	}

	public boolean isPrintado() {
		return printado;
	}

	public void setPrintado(boolean printado) {
		this.printado = printado;
	}
}