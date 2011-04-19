package com.mindplex.graph;

import java.util.Set;

/**
 * <code>Graph</code> is a top level interface in the Mindplex Graph API that
 * contains operations related to Graph Theory.  Without going into great detail
 * a graph is data structure that consists of connected endpoints.  The term
 * Vertex is used to identify an endpoint within a graph.  And the connections
 * between endpoints are referred to as edges.
 *
 * <p>There are many types of graphs, for example some graphs are directed,
 * meaning that a connection between two vertices can only exist in one direction.
 * Other graphs are weighted meaning the edges between vertices hold a weight
 * that can be used to measure the distance between vertices.  Graphs can also
 * be acyclic not allowing for loops within the graph.  To learn more about
 * graphs see <a href="http://en.wikipedia.org/wiki/Glossary_of_graph_theory">
 * http://en.wikipedia.org/wiki/Glossary_of_graph_theory</a>.</p>
 *
 * <p>Its important to note that this graph depends on proper equals and <code>
 * hashCode</code> semantics for vertices placed within the graph.  Unexpected
 * behavior will occur if the vertex types placed in this graph do not properly
 * implement <code>equals</code> and <code>hashCode</code>.  To learn more about
 * properly implementing equals and <code>hashCode</code> see <a
 * href="http://www.ibm.com/developerworks/java/library/j-jtp05273/index.html">
 * http://www.ibm.com/developerworks/java/library/j-jtp05273/index.html</a>
 *
 * <p>This graph allows arbitrary Vertex types through the generic parameter
 * <code>V</code>. As a result vertices of type <code>V</code> can be stored in
 * this graph.
 * 
 * @author Abel Perez <aperez@mindplexmedia.com>
 */
public interface Graph<V>
{
    /**
     * Adds the specified vertex to this graph.  The given vertex will not be
     * added to this graph if this graph contains the vertex.  In other words
     * this graph does not allow duplicate vertices. The way this graph
     * concludes if the specified vertex is a duplicate is through the equals
     * convention. For example <code>element.equals(vertex)</code>.
     *
     * <p>This method will return false if the given vertex is <code>null
     * </code></p>.
     * 
     * @param vertex the vertex to add to this graph.
     *
     * @return <tt>true</tt> of the specified vertex is added to this
     * graph; otherwise <tt>false</tt>.
     */
    public boolean addVertex(V vertex);

    /**
     * Removes the specified vertex from this graph if the vertex actually
     * exists in this graph.  Any edges that are connected to the given
     * vertex will also be removed from this graph.  If the specified vertex
     * is not contained within this graph then the graph is unchanged and this
     * operation return <tt>false</tt>; otherwise <tt>true</tt>.
     *
     * <p>This method will return false if the given vertex is <code>null
     * </code></p>.
     * 
     * @param vertex the vertex to remove from this graph.
     * 
     * @return <tt>true</tt> if the given vertex is removed; otherwise <tt>
     * false</false>
     */
    public boolean removeVertex(V vertex);

    /**
     * Gets the set of vertices contained within this graph.  The set is
     * an unmodifiable view so modifications to the set do not affect this
     * graph's internal set of vertices. 
     *
     * @return a read-only view of the vertices contained withing this graph.
     */
    public Set<V> getVertices();

    /**
     * Checks if this graph contains the specified vertex.  If the given
     * vertex is present in this graph, this operation returns <tt>true</tt>
     * ;otherwise <tt>false</tt>.  The way this graph concludes if the
     * specified vertex is a present is through the equals convention. For
     * example <code>element.equals(vertex)</code>.
     *
     * <p>This method will return false if the given vertex is <code>null
     * </code></p>.
     *  
     * @param vertex the vertex to verify is present within this graph.
     * 
     * @return <tt>true</tt> if the specified vertex is present in this graph;
     * otherwise <tt>false</tt>.
     */
    public boolean containsVertex(V vertex);

    /**
     * Adds an edge (based on the specified vertices) to this graph.  The edge
     * will not be added to this graph if this graph already contains an edge
     * between the specified vertices.  In other words this graph does not allow
     * duplicate edges.
     * 
     * <p>This method will return false if any of the given vertices are
     * <code>null</code></p>.
     *
     * @param source the source vertex for the edge to add to this graph.
     * @param target the target vertex for the edge to add to this graph.
     *
     * @return <tt>true</tt> of the edge is added to this graph; otherwise
     * <tt>false</tt>.
     */
    public Edge<V> addEdge(V source, V target);

    /**
     * Removes the edge (based on the given vertices) from this graph if the
     * edge actually exists in this graph.  If the specified vertices are not
     * contained within this graph then the graph is unchanged and this
     * operation returns <tt>false</tt>; otherwise <tt>true</tt>.
     *
     * <p>This method will return false if any of the given vertices are
     * <code>null</code></p>.
     *
     * @param source the source vertex for the edge to remove.
     * @param target the target vertex for the edge to remove.
     *
     * @return <tt>true</tt> if the edge that contains the specified vertices
     * is removed; otherwise <tt>
     * false</false>
     */
    public boolean removeEdge(V source, V target);

    /**
     * Gets the edge connected by the given source and target vertices.  If
     * either of the specified vertices are not present in this graph, then
     * this operation returns null.  If any of the specified vertices are
     * <code>null</code> then <code>null</code> is returned.
     *
     * <p>The order of vertices in the resulting edge is not guaranteed if this
     * graph is an undirected graph.</p>  
     *
     * @param source the source vertex for the edge to lookup in this graph.
     * @param target the target vertex for the edge to lookup in this graph.
     *
     * @return an edge that connects the specified vertices.
     */
    public Edge<V> getEdge(V source, V target);

    /**
     * Gets a set of edges connected to the specified vertex that are contained
     * within this graph.  The set is an unmodifiable view so modifications to
     * the set do not affect this graph's internal set of edges.
     *
     * @param vertex the vertex connected to the set of edges to lookup.
     * 
     * @return a read-only view of the edges connected to the given vertex that
     * are withing this graph.
     */
    public Set<Edge<V>> getEdges(V vertex);

    /**
     * Gets the set of edges contained within this graph.  The set is
     * an unmodifiable view so modifications to the set do not affect this
     * graph's internal set of edges.
     *
     * @return a read-only view of the edges contained withing this graph.
     */
    public Set<Edge<V>> edgeSet();

    /**
     * Checks if this graph contains an edge based on the specified vertices.
     * If either of the given vertices are not present in this graph, this
     * operation returns <tt>false</tt>.  Both specified vertices have to exists
     * in this graph and have a defined edge in order for this method to return
     * <tt>true</tt>.
     *
     * <p>This method will return false if any of the given vertices are
     * <code>null</code></p>.
     *
     * @param source the source vertex for the edge to verify is present within
     * this graph.
     * @param target the target vertex for the edge to verify is present within 
     * this graph.
     *
     * @return <tt>true</tt> if the edge is present in this graph; otherwise
     * <tt>false</tt>.
     */
    public boolean containsEdge(V source, V target);

    /**
     * Checks if this graph contains the specified edge.  If the given edge is
     * not present in this graph, this operation returns <tt>false</tt>.
     *
     * <p>This method will return false if the given edge is <code>null</code>
     * </p>.
     *
     * @param edge the edge to verify is present within this graph.
     *
     * @return <tt>true</tt> if the specified edge is present in this graph;
     * otherwise <tt>false</tt>.
     */
    public boolean containsEdge(Edge<V> edge);

    /**
     *
     * @return
     */
    public Set<V> breadthFirstSearch();

    /**
     *
     * @return
     */
    public Set<V> depthFirstSearch();

    /**
     * 
     * @return
     */
    public Set<Edge<V>> minSpanningTree();
}