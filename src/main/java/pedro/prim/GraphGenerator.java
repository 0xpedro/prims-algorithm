package pedro.prim;

import java.util.ArrayList;
import java.util.List;

public class GraphGenerator {
    public List<Vertex> createGraph(int n) {
        List<Vertex> graph = new ArrayList<>();

        if (n == 1) {
            Vertex a = new Vertex("A");
            Vertex b = new Vertex("B");
            Vertex c = new Vertex("C");
            Vertex d = new Vertex("D");
            Vertex e = new Vertex("E");

            Edge ab = new Edge(2);
            a.addEdge(b, ab);
            b.addEdge(a, ab);

            Edge ac = new Edge(3);
            a.addEdge(c, ac);
            c.addEdge(a, ac);

            Edge bc = new Edge(2);
            b.addEdge(c, bc);
            c.addEdge(b, bc);

            Edge be = new Edge(5);
            b.addEdge(e, be);
            e.addEdge(b, be);

            Edge cd = new Edge(1);
            c.addEdge(d, cd);
            d.addEdge(c, cd);

            Edge ce = new Edge(1);
            c.addEdge(e, ce);
            e.addEdge(c, ce);

            graph.add(a);
            graph.add(b);
            graph.add(c);
            graph.add(d);
            graph.add(e);
        } else if (n == 2) {
            Vertex a = new Vertex("A");
            Vertex b = new Vertex("B");
            Vertex c = new Vertex("C");
            Vertex d = new Vertex("D");
            Vertex e = new Vertex("E");

            Edge ab = new Edge(2);
            a.addEdge(b, ab);
            b.addEdge(a, ab);

            Edge ac = new Edge(3);
            a.addEdge(c, ac);
            c.addEdge(a, ac);

            Edge bc = new Edge(2);
            b.addEdge(c, bc);
            c.addEdge(b, bc);

            Edge be = new Edge(5);
            b.addEdge(e, be);
            e.addEdge(b, be);

            Edge cd = new Edge(1);
            c.addEdge(d, cd);
            d.addEdge(c, cd);

            Edge ce = new Edge(1);
            c.addEdge(e, ce);
            e.addEdge(c, ce);

            graph.add(a);
            graph.add(b);
            graph.add(c);
            graph.add(d);
            graph.add(e);

        } else {
            Vertex a = new Vertex("A");
            Vertex b = new Vertex("B");
            Vertex c = new Vertex("C");
            Vertex d = new Vertex("D");
            Vertex e = new Vertex("E");
            Vertex f = new Vertex("F");
            Vertex g = new Vertex("G");

            Edge ab = new Edge(7);
            a.addEdge(b, ab);
            b.addEdge(a, ab);

            Edge ad = new Edge(5);
            a.addEdge(d, ad);
            d.addEdge(a, ad);

            Edge bc = new Edge(8);
            b.addEdge(c, bc);
            c.addEdge(b, bc);

            Edge bd = new Edge(9);
            b.addEdge(d, bd);
            d.addEdge(b, bd);

            Edge be = new Edge(7);
            b.addEdge(e, be);
            e.addEdge(b, be);

            Edge ce = new Edge(5);
            c.addEdge(e, ce);
            e.addEdge(c, ce);

            Edge de = new Edge(15);
            d.addEdge(e, de);
            e.addEdge(d, de);

            Edge df = new Edge(6);
            d.addEdge(f, df);
            f.addEdge(d, df);

            Edge ef = new Edge(8);
            e.addEdge(f, ef);
            f.addEdge(e, ef);

            Edge eg = new Edge(9);
            e.addEdge(g, eg);
            g.addEdge(e, eg);

            Edge fg = new Edge(11);
            f.addEdge(g, fg);
            g.addEdge(f, fg);

            graph.add(a);
            graph.add(b);
            graph.add(c);
            graph.add(d);
            graph.add(e);
            graph.add(f);
            graph.add(g);
        }

        return graph;
    }
}
