package com.mindplex.graph;

import com.mindplex.graph.matrix.UndirectedGraph;
import junit.framework.*;

/**
 *
 */
public class UndirectedGraphTest extends TestCase
{
    protected static final String A = "A";
    protected static final String B = "B";
    protected static final String C = "C";
    protected static final String D = "D";
    protected static final String E = "E";

    @Override public void setUp() {
    }

    public Graph<String> getGraph() {
        return new SimpleUndirectedGraph<String>();    
    }

    public void testUndirected() throws Exception {
        Graph<String> graph = new UndirectedGraph<String>();
        assertTrue(graph.addVertex(A));
        assertTrue(graph.addVertex(B));
        assertTrue(graph.addEdge(A,B) != null);
        assertTrue(graph.addEdge(B,A) == null);
        assertTrue(graph.containsEdge(A,B));
        assertTrue(graph.containsEdge(B,A));
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
        assertTrue(graph.getEdge(B, A) != null);        
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
        //assertTrue(graph.addEdge(A, B) != null);
        //assertTrue(graph.addEdge(A, C) != null);
        //assertTrue(graph.edgeSet().size() == 4);
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
}
