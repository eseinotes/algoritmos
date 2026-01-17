/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms.graph_traversal;

/**
 *
 * @author noeliagarciahervella
 */
public class Arc<E> {
    private Vertex<E> source, target;
    public Arc(Vertex<E> source, Vertex<E> target){
        this.source = source;
        this.target = target;
    }
    public Vertex<E> getSource(){
        return this.source;
    }
    public Vertex<E> getTarget(){
        return this.target;
    }
}
