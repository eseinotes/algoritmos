/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms.graph_implementation;

/**
 *
 * @author noeliagarciahervella
 */
public class Arc<E,T> {
    
    private Vertex<E> source, target;
    private T weight;
    public Arc(Vertex<E> source, Vertex<E> target, T weight){
        this.source = source;
        this.target = target;
        this.weight= weight;
    }
    public Vertex<E> getSource(){
        return this.source;
    }
    public Vertex<E> getTarget(){
        return this.target;
    }
    public T getWeight(){
        return this.weight;
    }

}
