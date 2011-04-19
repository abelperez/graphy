package com.mindplex.graph;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Abel Perez
 */
public class SimpleDirectedGraph<V> extends AbstractGraph<V> implements Graph<V>, DirectedGraph<V>
{

    /**
     * @see com.mindplex.graph.Graph#addEdge(Object, Object)
     */
    @Override public Edge<V> addEdge(V source, V target) {

        if (source == null || target == null) {
            return null;
        }

        Vertex<V> s = new Vertex<V>(source);
        Vertex<V> t = new Vertex<V>(target);
        Edge<V> edge = new Edge<V>(s, t);
        Edge<V> edge2 = new Edge<V>(t, s);

        // bail if either vertex doesn't exist
        if ((! getStore().containsKey(s)) || (! getStore().containsKey(t))) {
            return null;
        }

        // duplicate check
        if (getStore().get(s).contains(edge) || getStore().get(t).contains(edge2)) {
            return null;
        }

        if (getStore().get(s).add(edge)) {
            return edge;
        }
        return null;
    }

    /**
     * @see com.mindplex.graph.Graph#removeEdge(Object, Object)
     */
    @Override public boolean removeEdge(V source, V target) {

        if (source == null || target == null) {
            return false;
        }

        Edge<V> out = createEdge(source, target);
        
        if (! getStore().containsKey(out.getSource())) {
            return false;
        }

        return (getStore().get(out.getSource()).remove(out));
    }

    /**
     * @see com.mindplex.graph.Graph#containsEdge(Object, Object)
     */
    public boolean containsEdge(V source, V target) {

        if (source == null || target == null) {
            return false;
        }

        Edge<V> out = createEdge(source, target);
        
        if (! getStore().containsKey(out.getSource())) {
            return false;
        }
        return (getStore().get(out.getSource()).contains(out));
    }

    /**
     * @see com.mindplex.graph.DirectedGraph#inDegree(Object)
     */
    public int inDegree(V vertex) {
        if (vertex == null) return 0;

        Vertex<V> target = new Vertex<V>(vertex);
        int count = 0;
        for (Map.Entry<Vertex<V>, Set<Edge<V>>> entry : getStore().entrySet()) {
            for (Edge<V> edge : entry.getValue()) {
                if (edge.getTarget().equals(target)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * @see com.mindplex.graph.DirectedGraph#incomingEdges(Object)
     */
    public Set<Edge<V>> incomingEdges(V vertex) {
        if (vertex == null) return null;

        Vertex<V> target = new Vertex<V>(vertex);
        Set<Edge<V>> edges = new HashSet<Edge<V>>();
        
        for (Map.Entry<Vertex<V>, Set<Edge<V>>> entry : getStore().entrySet()) {
            for (Edge<V> edge : entry.getValue()) {
                if (edge.getTarget().equals(target)) {
                    edges.add(edge);
                }
            }
        }
        return edges;
    }

    /**
     * @see com.mindplex.graph.DirectedGraph#outDegree(Object)
     */
    public int outDegree(V vertex) {
        if (vertex == null) return 0;
        Set<Edge<V>> edges = getStore().get(new Vertex<V>(vertex));
        return (edges != null) ? edges.size() : 0;
    }

    /**
     * @see com.mindplex.graph.DirectedGraph#outgoingEdges(Object)
     */
    public Set<Edge<V>> outgoingEdges(V vertex) {
        if (vertex == null) return new HashSet<Edge<V>>();
        Set<Edge<V>> edges = getStore().get(new Vertex<V>(vertex));
        return (edges != null) ? edges : new HashSet<Edge<V>>();
    }

}
