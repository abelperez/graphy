package com.mindplex.graph;

import java.util.*;

/**
 *
 */
public abstract class AbstractGraph<V> implements Graph<V>
{
    private Map<Vertex<V>, Set<Edge<V>>> store = new HashMap<Vertex<V>, Set<Edge<V>>>();

    public AbstractGraph() {
    }

    /**                               
     * @see com.mindplex.graph.Graph#addVertex(Object)
     */
    public boolean addVertex(V vertex) {
        boolean changed = false;
        Vertex<V> v = new Vertex<V>(vertex);
        if (! store.containsKey(v)) {
            store.put(v, new HashSet<Edge<V>>());
            changed = true;
        }
        return changed;
    }

    /**
     * @see com.mindplex.graph.Graph#removeVertex(Object)
     */
    public boolean removeVertex(V vertex) {
        return (vertex) != null && (store.remove(new Vertex<V>(vertex)) != null);
    }

    /**
     * @see com.mindplex.graph.Graph#getVertices()
     */
    public Set<V> getVertices() {
        Set<V> vertices = new HashSet<V>();
        for (Vertex<V> vertex : store.keySet()) {
            vertices.add(vertex.getVertex());
        }
        return Collections.unmodifiableSet(vertices);
    }

    /**
     * @see com.mindplex.graph.Graph#containsVertex(Object)
     */
    public boolean containsVertex(V vertex) {
        return vertex != null && store.containsKey(new Vertex<V>(vertex));    
    }

    // --------------------------------------------------------------------
    // ~ Edge operations
    // --------------------------------------------------------------------

    /**
     * @see com.mindplex.graph.Graph#addEdge(Object, Object)
     */    
    public Edge<V> addEdge(V source, V target) {

        if (source == null || target == null) {
            return null;
        }

        Vertex<V> s = new Vertex<V>(source);
        Vertex<V> t = new Vertex<V>(target);
        Edge<V> edge = new Edge<V>(s, t);
        Edge<V> edge2 = new Edge<V>(t, s);

        // bail if either vertex doesn't exist
        if ((! store.containsKey(s)) || (! store.containsKey(t))) {
            return null;
        }

        // duplicate check
        if (store.get(s).contains(edge) && store.get(t).contains(edge2)) {
            return null;
        }

        if (store.get(s).add(edge) && store.get(t).add(edge2)) {
            return edge;
        }
        return null;
    }

    /**
     * @see com.mindplex.graph.Graph#removeEdge(Object, Object)
     */
    public boolean removeEdge(V source, V target) {

        if (source == null || target == null) {
            return false;
        }

        Vertex<V> s = new Vertex<V>(source);
        Vertex<V> t = new Vertex<V>(target);
        Edge<V> out = new Edge<V>(s, t);
        Edge<V> in = new Edge<V>(t, s);

        if (! store.containsKey(s)) {
            return false;
        }

        return (store.get(s).remove(out)) && (store.get(t).remove(in));
    }

    /**
     * @see com.mindplex.graph.Graph#getEdge(Object, Object)
     */    
    public Edge<V> getEdge(V source, V target) {

        if (source == null || target == null) {
            return null;
        }

        Vertex<V> s = new Vertex<V>(source);
        Vertex<V> t = new Vertex<V>(target);

        if (! store.containsKey(s)) return null;
        
        for (Edge<V> e : store.get(s)) {
            if (e.getSource().equals(s) && e.getTarget().equals(t) ||
                    e.getSource().equals(t) && e.getTarget().equals(s)) {
                return e;
            }
        }
        return null;
    }

    /**
     * @see com.mindplex.graph.Graph#getEdges(Object)
     */    
    public Set<Edge<V>> getEdges(V vertex) {
        if (vertex == null) return null;
        return Collections.unmodifiableSet(store.get(new Vertex<V>(vertex)));       
    }

    /**
     * @see com.mindplex.graph.Graph#edgeSet()
     */    
    public Set<Edge<V>> edgeSet() {
        Set<Edge<V>> edges = new HashSet<Edge<V>>();
        for (Map.Entry<Vertex<V>, Set<Edge<V>>> e : store.entrySet()) {
            edges.addAll(e.getValue());
        }
        return Collections.unmodifiableSet(edges);
    }

    /**
     * @see com.mindplex.graph.Graph#containsEdge(Object, Object)
     */
    public boolean containsEdge(V source, V target) {

        if (source == null || target == null) {
            return false;
        }

        Vertex<V> s = new Vertex<V>(source);
        Vertex<V> t = new Vertex<V>(target);
        Edge<V> out = new Edge<V>(s, t);
        Edge<V> in = new Edge<V>(t, s);

        if (! store.containsKey(s)) {
            return false;
        }
        return (store.get(s).contains(out)) || (store.get(t).contains(in));
    }

    /**
     * @see com.mindplex.graph.Graph#containsEdge(Edge)
     */    
    public boolean containsEdge(Edge<V> edge) {

        if (edge == null) return false;

        return (store.get(edge.getSource()).contains(edge) ||
                store.get(edge.getTarget()).contains(edge));
    }

    public Set<V> breadthFirstSearch() {
        return null;
    }

    /**
     *
     * @return
     */
    public Set<V> depthFirstSearch() {
        return null;
    }

    /**
     *
     * @return
     */
    public Set<Edge<V>> minSpanningTree() {
        return null;
    }

    protected Map<Vertex<V>, Set<Edge<V>>> getStore() {
        return store;
    }

    protected Edge<V> createEdge(V source, V target) {
        return new Edge<V>(new Vertex<V>(source), new Vertex<V>(target));
    }

}
