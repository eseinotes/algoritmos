/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package algorithms.graph_implementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author noeliagarciahervella
 */
public class Graph_implementation {

    public static void main(String[] args) {
        List<Vertex<Integer>> vertices = new ArrayList<>();
        List<Arc<Integer, Integer>> arcs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            vertices.add(new Vertex(i));
        }

        arcs.add(new Arc(vertices.get(0), vertices.get(1), 4));
        arcs.add(new Arc(vertices.get(0), vertices.get(2), 3));
        arcs.add(new Arc(vertices.get(0), vertices.get(3), 8));

        arcs.add(new Arc(vertices.get(1), vertices.get(2), 2));
        arcs.add(new Arc(vertices.get(1), vertices.get(3), 5));
        arcs.add(new Arc(vertices.get(1), vertices.get(4), 4));

        arcs.add(new Arc(vertices.get(2), vertices.get(4), 7));

        arcs.add(new Arc(vertices.get(3), vertices.get(2), 5));

        arcs.add(new Arc(vertices.get(4), vertices.get(3), 1));

        ArcsList<Integer, Integer> arcsList = new ArcsList<>(vertices, arcs);

        if(arcsList.isEmpty()) System.out.println("El grafo no tiene elementos.");
        else System.out.println("El grafo si tiene elementos");

        Vertex<Integer> v1 = new Vertex(3);

        if(arcsList.containsVertex(v1))System.out.println("El grafo contiene el vértice indicado.");
        else System.out.println("El grafo no contiene el vértice.");

        System.out.println("El grafo contiene los siguientes arcos: ");

        Iterator<Arc<Integer, Integer>> arcsIterator = arcsList.arcs();

        while(arcsIterator.hasNext()){
            Arc<Integer, Integer> arc = arcsIterator.next();

            System.out.println(arc.getSource().getLabel()+" -> "+ arc.getTarget().getLabel()+": "+arc.getWeight());
        }


  
    }
}
