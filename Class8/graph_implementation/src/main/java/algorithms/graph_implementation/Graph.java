/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package algorithms.graph_implementation;

import java.util.Iterator;

/**
 *
 * @author noeliagarciahervella
 */
public interface Graph<E, T> {

    public boolean isEmpty();
    public boolean containsVertex(Vertex<E> v);
    public boolean containsArc(Arc<E, T> a);
    public Iterator<Vertex<E>> vertexs();
    public Iterator<Arc<E, T>> arcs();
    public Iterator<Vertex<E>> adjacent(Vertex<E> v);
    public void insertVertex(Vertex<E> v);
    public void insertArc(Arc<E, T> a);
    public void removeVertex(Vertex<E> v);
    public void removeArc(Arc<E, T> a);

}
