/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms.graph_implementation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author noeliagarciahervella
 */
public class ArcsList<E, T> implements Graph<E, T>{
    private List<Vertex<E>> listVertices;
    private List<Arc<E, T>> listArcs;

    public ArcsList() {
        this.listVertices = new ArrayList<>();
        this.listArcs = new ArrayList<>();
    }

    public ArcsList(List<Vertex<E>> listVertices, List<Arc<E, T>> listArcs) {
        this.listVertices = listVertices;
        this.listArcs = listArcs;
    }

    public boolean isEmpty() {
        return listVertices.isEmpty();
    }
    
    public int vertexPosition(Vertex<E> v){
        int i = -1;
        boolean find = false;
        while (i < listVertices.size()-1 && !find) {
            i++;
            if (listVertices.get(i).equals(v)) {
                find = true;
            }
        }
        if (!find) return -1;
        else return i;
    }

    public boolean containsVertex(Vertex<E> v) {
        int i = 0;
        boolean find = false;
        while (i < listVertices.size() && !find) {
            if (listVertices.get(i).equals(v)) {
                find = true;
            }
            i++;
        }
        return find;
    }
    
    public int arcPosition(Arc<E, T> a){
        int i = -1;
        boolean find = false;
        while (i < listArcs.size()-1 && !find) {
            i++;
            Arc<E, T> arc = listArcs.get(i);
            if (arc.getWeight().equals(a.getWeight()) && arc.getSource().equals(a.getSource()) && arc.getTarget().equals(a.getTarget())) {
                find = true;
            }
        }
        if (!find) return -1;
        else return i;
    }

    public boolean containsArc(Arc<E, T> a) {
        for (Arc<E, T> arc : listArcs) {
            if (arc.getWeight().equals(a.getWeight()) && arc.getSource().equals(a.getSource()) && arc.getTarget().equals(a.getTarget())) {
                return true;
            }
        }
        return false;
    }

    public Iterator<Vertex<E>> vertexs() {
        return this.listVertices.iterator();
    }

    public Iterator<Arc<E, T>> arcs() {
        return this.listArcs.iterator();
    }

    public Iterator<Vertex<E>> adjacent(Vertex<E> v) { //no dirigido
        List<Vertex<E>> adjacent = new ArrayList<>();

        for (Arc<E, T> arc : listArcs) {
            if (arc.getSource().equals(v)) {
                adjacent.add(arc.getTarget());
            } else if (arc.getTarget().equals(v)) {
                adjacent.add(arc.getSource());
            }

        }

        return adjacent.iterator();
    }

    public Iterator<Vertex<E>> successors(Vertex<E> v) { //Si es dirigido
        List<Vertex<E>> successors = new ArrayList<>();

        for (Arc<E, T> arc : listArcs) {
            if (arc.getSource().equals(v)) {
                successors.add(arc.getTarget());
            }
        }
        return successors.iterator();
    }
    
    public Iterator<Vertex<E>> predecessors(Vertex<E> v) { //Si es dirigido
        List<Vertex<E>> predecessors = new ArrayList<>();

        for (Arc<E, T> arc : listArcs) {
            if (arc.getTarget().equals(v)) {
                predecessors.add(arc.getSource());
            }
        }
        return predecessors.iterator();
    }

    public int grado(Vertex<E> v) { //Si no es dirigido
        Iterator<Vertex<E>> adya = adjacent(v);
        int i = 0;

        while (adya.hasNext()) {
            adya.next();
            i++;
        }
        return i;
    }

    public int gradoSalida(Vertex<E> v) { //Si es dirigido
        Iterator<Vertex<E>> adya = successors(v);
        int i = 0;

        while (adya.hasNext()) {
            adya.next();
            i++;
        }
        return i;
    }
    
     public int gradoEntrada(Vertex<E> v) { //Si es dirigido
        Iterator<Vertex<E>> adya = predecessors(v);
        int i = 0;

        while (adya.hasNext()) {
            adya.next();
            i++;
        }
        return i;
    }
    

    public void insertVertex (Vertex<E> v){
        if(!containsVertex(v)) listVertices.add(v);
        else System.out.println("no se puede insertar");
    }
    
    public void insertArc (Arc<E,T> a){ //comprobar que existen los Vertexs
        if(!containsArc(a) && containsVertex(a.getSource()) && containsVertex(a.getTarget())) listArcs.add(a);
        else System.out.println("no se puede insertar");
    }
    public void removeVertex (Vertex<E> v){ //ekiminar sus Arcs
        if(containsVertex(v)){
            int posVertex = vertexPosition(v);
            listVertices.remove(posVertex);
            List<Arc<E,T>> Arcs = new ArrayList<>();
            for (Arc<E,T> arc: listArcs){
                if(!arc.getSource().equals(v) && !arc.getTarget().equals(v)) Arcs.add(arc);
            }
            listArcs = Arcs;
        }
          
        
    }
    public void removeArc (Arc<E,T> a){ 
        if(containsArc(a)){
            int posArco = arcPosition(a);
            listArcs.remove(posArco);
        }
    }
    
    public void showVertexs(){
        System.out.print("Los vértices son: [ ");
        for(int i = 0; i< this.listVertices.size(); i++){
            if (i!= this.listVertices.size()-1) System.out.print(listVertices.get(i).getLabel()+", ");
            else System.out.println(listVertices.get(i).getLabel()+" ]");
        }
    }
    
    public void showArcs(){
        System.out.print("Los Arcs son: [ ");
        for(int i = 0; i< this.listArcs.size(); i++){
            Arc<E, T> arc = listArcs.get(i);
            if (i!= this.listArcs.size()-1) System.out.print("("+arc.getSource().getLabel()
                    +" - "+arc.getTarget().getLabel()+", "+ arc.getWeight()+"), ");
            else System.out.println("("+arc.getSource().getLabel()
                    +" - "+arc.getTarget().getLabel()+", "+ arc.getWeight()+")]");
        }
    }



}
