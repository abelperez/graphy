package com.mindplex.graph;

/**
 *
 * @author Abel Perez
 */
public class Vertex<V>
{
    /** */
    private V vertex;

    /** */
    private boolean visited;

    /**
     * 
     * @param vertex
     */
    public Vertex(V vertex) {
        this.vertex = vertex;
    }

    /**
     * 
     * @return
     */
    public V getVertex() {
        return vertex;
    }

    /**
     *
     * @return
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * 
     */
    public void mark() {
        this.visited = true;
    }

    /**
     * 
     */
    public void unmark() {
        this.visited = false;
    }

    @Override public boolean equals(Object other) {
        //return this == other || (vertex != null && vertex.equals(other));


        if (other == this) {
            return true;
        }
        if (! (other instanceof Vertex)) {
            return false;
        }
        return vertex.equals(((Vertex) other).getVertex());

    }

    @Override public int hashCode() {
        return vertex.hashCode();
    }

    @Override public String toString() {
        return vertex.toString();
    }
}
