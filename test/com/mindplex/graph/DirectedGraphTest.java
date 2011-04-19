package com.mindplex.graph;

import junit.framework.TestCase;

/**
 *
 */
public class DirectedGraphTest extends TestCase
{
    protected static final String A = "A";
    protected static final String B = "B";
    protected static final String C = "C";
    protected static final String D = "D";
    protected static final String E = "E";
    
    public DirectedGraph<String> getGraph() {
        return new SimpleDirectedGraph<String>();
    }

    public void testDirected() throws Exception {
        Graph<String> graph = getGraph();
        assertTrue(graph.addVertex(A));
        assertTrue(graph.addVertex(B));
        assertTrue(graph.addEdge(A,B) != null);
        assertTrue(graph.addEdge(B,A) == null);
        assertTrue(graph.containsEdge(A,B));
        assertTrue(! graph.containsEdge(B,A));
        assertTrue(graph.edgeSet().size() == 1);
    }

    public void testAddVertex() throws Exception {
        Graph<String> graph = getGraph();
        assertTrue(graph.addVertex(A));
        assertTrue(graph.containsVertex(A));
    }

    public void testRemoveVertex() throws Exception {
        Graph<String> graph = getGraph();
        assertTrue(graph.addVertex(A));
        assertTrue(graph.removeVertex(A));
        assertTrue(! graph.containsVertex(A));
    }

    public void testGetVertices() throws Exception {
        Graph<String> graph = getGraph();
        assertTrue(graph.addVertex(A));
        assertTrue(graph.addVertex(B));
        assertTrue(graph.addVertex(C));
        assertTrue(graph.addVertex(D));
        assertTrue(graph.addVertex(E));
        assertTrue(graph.getVertices().size() == 5);

    }

    public void testContainsVertex() throws Exception {
        Graph<String> graph = getGraph();
        assertTrue(graph.addVertex(A));
        assertTrue(graph.containsVertex(A));
    }

    public void testAddEdge() throws Exception {
        Graph<String> graph = getGraph();
        graph.addVertex(A);
        graph.addVertex(B);
        assertTrue(graph.addEdge(A, B) != null);
        assertTrue(graph.containsEdge(A, B));
    }

    public void testRemoveEdge() throws Exception {
        Graph<String> graph = getGraph();
        graph.addVertex(A);
        graph.addVertex(B);
        assertTrue(graph.addEdge(A, B) != null);
        assertTrue(graph.removeEdge(A, B));
        assertTrue(! graph.containsEdge(A, B));
    }

    public void testGetEdge() { //throws Exception {
        Graph<String> graph = getGraph();
        graph.addVertex(A);
        graph.addVertex(B);
        assertTrue(graph.addEdge(A, B) != null);
        assertTrue(graph.getEdge(A, B) != null);
    }

    public void testGetEdges() throws Exception {
        Graph<String> graph = getGraph();
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        assertTrue(graph.addEdge(A, B) != null);
        assertTrue(graph.addEdge(A, C) != null);
        assertTrue(graph.getEdges(A).size() == 2);
    }

    public void testEdgeSet() throws Exception {
        Graph<String> graph = getGraph();
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        assertTrue(graph.addEdge(A, B) != null);
        assertTrue(graph.addEdge(A, C) != null);
        assertTrue(graph.edgeSet().size() == 2);
    }

    public void testContainsEdgeFromVertices() throws Exception {
        Graph<String> graph = getGraph();
        graph.addVertex(A);
        graph.addVertex(B);
        assertTrue(graph.addEdge(A, B) != null);
        assertTrue(graph.containsEdge(A, B));
    }

    public void testContainsEdge() throws Exception {
        Graph<String> graph = getGraph();
        graph.addVertex(A);
        graph.addVertex(B);
        assertTrue(graph.addEdge(A, B) != null);
        assertTrue(graph.containsEdge(new Edge<String>(new Vertex<String>(A), new Vertex<String>(B))));
    }

    public void testInDegree() throws Exception {
        DirectedGraph<String> graph = getGraph();
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);
        assertTrue(graph.addEdge(A, B) != null);
        assertTrue(graph.addEdge(A, C) != null);
        assertTrue(graph.addEdge(D, A) != null);
        assertTrue(graph.inDegree(A) == 1);
    }

    public void testIncomingEdges() throws Exception {
        DirectedGraph<String> graph = getGraph();
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        graph.addVertex(D);        
        assertTrue(graph.addEdge(A, B) != null);
        assertTrue(graph.addEdge(A, C) != null);
        assertTrue(graph.addEdge(D, A) != null);        
        assertTrue(graph.incomingEdges(A).size() == 1);

        for (Edge<String> edge : graph.incomingEdges(A)) {
            System.out.println(edge);
        }
    }

    public void testOutDegree() throws Exception {
        DirectedGraph<String> graph = getGraph();
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        assertTrue(graph.addEdge(A, B) != null);
        assertTrue(graph.addEdge(A, C) != null);
        assertTrue(graph.outDegree(A) == 2);
    }

    public void testOutgoingEdges() throws Exception {
        DirectedGraph<String> graph = getGraph();
        graph.addVertex(A);
        graph.addVertex(B);
        graph.addVertex(C);
        assertTrue(graph.addEdge(A, B) != null);
        assertTrue(graph.addEdge(A, C) != null);
        assertTrue(graph.outgoingEdges(A).size() == 2);

        for (Edge<String> edge : graph.outgoingEdges(A)) {
            System.out.println(edge);
        }
    }

}
