package com.mindplex.graph;

import java.util.Set;

/**
 * <code>DirectedGraph</code> is a graph that only contains edges that point
 * in one direction.  For example, a directed graph cannot have both an edge
 * {A -> B} and {B -> A}.  In this scenario it would only allow one or the
 * other but not both.
 *
 * <p>You can learn more about Directed Graphs here:
 * <a href="http://en.wikipedia.org/wiki/Directed_graph">
 * http://en.wikipedia.org/wiki/Directed_graph</a></p>
 *
 * @author Abel Perez
 */
public interface DirectedGraph<V> extends Graph<V>
{
    /**
     * Gets the in-degree for the specified vertex.  The in-degree is the
     * total count of edges that terminate at the specified
     * vertex.
     * 
     * @param vertex the vertex to get the in-degree for.
     *
     * @return the in-degree for the specified vertex.  The in-degree is the
     * total count of edges that terminate at the specified
     * vertex.
     */
    public int inDegree(V vertex);

    /**
     * Gets all the incoming edges for the specified vertex. Incoming edges are
     * all the edges that terminate at the specified vertex.
     *
     * @param vertex the vertex to get all the incoming edges for.
     *
     * @return all the incoming edges for the specified vertex. Incoming edges are
     * all the edges that terminate at the specified vertex.
 
     */
    public Set<Edge<V>> incomingEdges(V vertex);

    /**
     * Gets the out-degree for the specified vertex.  The out-degree is the number
     * of edges that originate at the specified vertex.
     * 
     * @param vertex the vertex to get the out-degree for.
     *
     * @return the out-degree for the specified vertex.  The out-degree is the number
     * of edges that originate at the specified vertex.
     */
    public int outDegree(V vertex);

    /**
     * Gets the outgoing edges for the specified vertex. The outgoing edges are
     * the edges that originate at the specified vertex.
     *
     * @param vertex the vertex to get the outgoing edges for.
     *
     * @return the outgoing edges for the specified vertex. The outgoing edges are
     * the edges that originate at the specified vertex.
     */
    public Set<Edge<V>> outgoingEdges(V vertex);
}
