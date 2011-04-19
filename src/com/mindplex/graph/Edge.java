package com.mindplex.graph;

import java.util.Arrays;

/**
 *
 * @author Abel Perez
 */
public class Edge<V>
{
    /** */
    private Vertex<V> source;

    /** */
    private Vertex<V> target;

    /**
     *
     */
    public Edge() {
    }

    /**
     * 
     * @param source
     * @param target
     */
    public Edge(Vertex<V> source, Vertex<V> target) {
        this.source = source;
        this.target = target;
    }

    /**
     *
     * @return
     */
    public Vertex<V> getSource() {
        return source;
    }

    /**
     *
     * @param source
     * @return
     */
    public Edge setSource(Vertex<V> source) {
        this.source = source;
        return this;
    }

    /**
     *
     * @return
     */
    public Vertex<V> getTarget() {
        return target;
    }

    /**
     * 
     * @param target
     * @return
     */
    public Edge setTarget(Vertex<V> target) {
        this.target = target;
        return this;
    }

    /**
     *
     * @return
     */
    public V getSourceVertex() {
        return source.getVertex();
    }

    /**
     * 
     * @return
     */
    public V getTargetVertex() {
        return target.getVertex();
    }

    @Override public boolean equals(Object other) {

        if (this == other) return true;

        if (! (other instanceof Edge)) {
            return false;
        }
        
        Edge<V> that = (Edge<V>)other;

        if (source == null && that.source != null || source != null && that.source == null) {
            return false;
        }
        if (target == null && that.target != null || target != null && that.target == null) {
            return false;
        }
        if (! this.source.equals(that.getSource())) {
            return false;
        }
        if (! this.target.equals(that.getTarget())) {
            return false;
        }
        
        return true;
    }

    @Override public int hashCode() {
        return Arrays.hashCode(new Object[] {source, target});    
    }

    @Override public String toString() {
        return new StringBuilder().append("{").append(source).append(",").append(target).append("}").toString();
    }

}
