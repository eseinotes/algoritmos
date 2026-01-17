/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms.graph_implementation;

/**
 *
 * @author noeliagarciahervella
 */
public class Vertex<E> {
    private E label;
    public Vertex(E label){
        this.label = label;
    }
    public E getLabel(){
        return this.label;
    }
    
    public boolean equals(Vertex<E> v){
        return this.label.equals(v.getLabel());
        
    }
}
