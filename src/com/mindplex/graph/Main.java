package com.mindplex.graph;

import com.mindplex.graph.matrix.UndirectedGraph;

import java.util.Set;

/**
 *
 */
public class Main
{
    public static void main(String[] args) {

        Graph<String> g = new SimpleDirectedGraph<String>();
        g.addVertex("A");
        g.addVertex("B");
        g.addEdge("A", "B");
        System.out.println("contains: {A,B} " + g.containsEdge("A", "B"));
        
        //test();
        //run();
        //breadthFirstSearch();
        //depthFirstSearch();
        //minSpanningTree();
        //undirected();
    }

    public static void undirected() {
        Graph<String> g = new UndirectedGraph<String>();

        String a = "A";
        String b = "B";

        g.addVertex(a);
        g.addVertex(b);

        g.addEdge(a,b);
        g.addEdge(b,a);

        for (Edge<String> e : g.edgeSet()) {
            System.out.println(e);
        }
    }

    public static void minSpanningTree() {
        
        Graph<String> g = new UndirectedGraph<String>();

        String a = "A";
        String b = "B";
        String c = "C";
        String d = "D";
        String e = "E";

        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);
        g.addVertex(d);
        g.addVertex(e);

        g.addEdge(a,b);
        g.addEdge(a,c);
        g.addEdge(a,d);
        g.addEdge(a,e);
        g.addEdge(b,c);
        g.addEdge(b,d);
        g.addEdge(b,e);
        g.addEdge(c,d);
        g.addEdge(c,e);
        g.addEdge(d,e);

        System.out.println("min spanning tree: ");
        Set<Edge<String>> tree = g.minSpanningTree();
        for (Edge<String> edge : tree) {
            System.out.println(edge);
        }

    }

    public static void breadthFirstSearch() {
        Graph<String> g = new UndirectedGraph<String>();

        String a = "A";
        String b = "B";
        String c = "C";
        String d = "D";
        String e = "E";

        // vertices
        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);
        g.addVertex(d);
        g.addVertex(e);

        // edges
        g.addEdge(a, b);
        g.addEdge(b, c);
        g.addEdge(a, d);
        g.addEdge(d, e);

        Set<String> vertices = g.breadthFirstSearch();
        for (String v : vertices) {
            System.out.print(v);
        }
        System.out.println("");
    }

    public static void depthFirstSearch() {
        Graph<String> g = new UndirectedGraph<String>();

        String a = "A";
        String b = "B";
        String c = "C";
        String d = "D";
        String e = "E";

        // vertices
        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);
        g.addVertex(d);
        g.addVertex(e);

        // edges
        g.addEdge(a, b);
        g.addEdge(b, c);
        g.addEdge(a, d);
        g.addEdge(d, e);

        Set<String> vertices = g.depthFirstSearch();
        for (String v : vertices) {
            System.out.print(v);
        }
        System.out.println("");
    }

    public static void run() {

        Graph<String> g = new UndirectedGraph<String>();

        String a = "A";
        String b = "B";
        String c = "C";
        String d = "D";
        String f = "E";

        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);
        g.addVertex(d);

        // A edges
        g.addEdge(a, b);
        g.addEdge(a, c);
        g.addEdge(a, d);

        // B edges
        g.addEdge(b, d);

        // C edges
        g.addEdge(c, d);

        // D edges
        // g.addEdge(d, a);
        // g.addEdge(d, b);

        g.depthFirstSearch();
        System.out.println("");
        g.breadthFirstSearch();
        System.out.println("");


        System.out.println("contains vertex {A}: " + g.containsVertex(a));
        System.out.println("contains vertex {B}: " + g.containsVertex(b));
        System.out.println("contains vertex {C}: " + g.containsVertex(c));
        System.out.println("contains vertex {D}: " + g.containsVertex(d));
        System.out.println("contains vertex {E}: " + g.containsVertex(f));


        System.out.println("contains edge {A,B}: " + g.containsEdge(a, b));
        System.out.println("contains edge {A,C}: " + g.containsEdge(a, c));
        System.out.println("contains edge {A,D}: " + g.containsEdge(a, d));
        System.out.println("contains edge {B,A}: " + g.containsEdge(b, a));
        System.out.println("contains edge {B,C}: " + g.containsEdge(b, c));
        System.out.println("contains edge {B,D}: " + g.containsEdge(b, d));
        System.out.println("contains edge {D,B}: " + g.containsEdge(d, b));

        // remove vertex
        System.out.println("removing vertex {A}");
        g.removeVertex(a);
        System.out.println("contains vertex {A}: " + g.containsVertex(a));
        System.out.println("contains edge {A,B}: " + g.containsEdge(a, b));
        System.out.println("contains edge {C,A}: " + g.containsEdge(c, a));

        // remove edge
        System.out.println("removing edge {B,D}");
        g.removeEdge(b, d);
        System.out.println("contains Edge {B,D}: " + g.containsEdge(b, d));
        System.out.println("contains Edge {D,B}: " + g.containsEdge(d, b));

        // Check for duplicates
        g.addVertex(a);
        g.addVertex(a);
        g.addVertex(a);
        g.removeVertex(b);
        System.out.println("contains vertex {A}: " + g.containsVertex(a));
        g.addEdge(a, d);
        g.addEdge(a, d);
        g.addEdge(a, d);
        System.out.println("contains Edge {A,D}: " + g.containsEdge(a, d));

        System.out.println("-----------------------");
        for (String v : g.getVertices()) {
            System.out.println("<"+v+">");
        }
        for (Edge<String> e : g.edgeSet()) {
            System.out.println(e);
        }

        Edge edge = g.getEdge(a, d);
        System.out.println("found edge: " + edge);
        Edge edge2 = g.getEdge(d, a);
        System.out.println("found edge: " + edge2);

        Edge<String> es = new Edge<String>(new Vertex<String>(a), new Vertex<String>(d));

        System.out.println("contains edge object: " + g.containsEdge(edge));
        System.out.println("contains external edge object: " + g.containsEdge(es));
    }    
}
