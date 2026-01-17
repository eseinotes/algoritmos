/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package algorithms.graph_traversal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author noeliagarciahervella
 */
public class Graph_traversal {

    public static void main(String[] args) {
        List<Vertex<Integer>> vertices = new ArrayList<>();
        List<Arc<Integer>> arcs = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            vertices.add(new Vertex(i));
        }

        //Arcos del vertice que tiene la etiqueta 1
        arcs.add(new Arc(vertices.get(0), vertices.get(1)));
        arcs.add(new Arc(vertices.get(0), vertices.get(2)));
        arcs.add(new Arc(vertices.get(0), vertices.get(3)));

        //Arcos del vertice que tiene la etiqueta 2
        arcs.add(new Arc(vertices.get(1), vertices.get(2)));
        arcs.add(new Arc(vertices.get(1), vertices.get(3)));
        arcs.add(new Arc(vertices.get(1), vertices.get(4)));

        //Arcos del vertice que tiene la etiqueta 3
        arcs.add(new Arc(vertices.get(2), vertices.get(4)));
        arcs.add(new Arc(vertices.get(2), vertices.get(5)));

        //Arcos del vertice que tiene la etiqueta 4
        arcs.add(new Arc(vertices.get(3), vertices.get(4)));
        arcs.add(new Arc(vertices.get(3), vertices.get(7)));

        //Arcos del vertice que tiene la etiqueta 5
        arcs.add(new Arc(vertices.get(4), vertices.get(6)));
        arcs.add(new Arc(vertices.get(4), vertices.get(7)));

        //Arcos del vertice que tiene la etiqueta 6
        arcs.add(new Arc(vertices.get(5), vertices.get(6)));
        arcs.add(new Arc(vertices.get(5), vertices.get(7)));

        //Arcos del vertice que tiene la etiqueta 7
        arcs.add(new Arc(vertices.get(6), vertices.get(7)));

        //Arcos del vertice que tiene la etiqueta 9
        arcs.add(new Arc(vertices.get(8), vertices.get(0)));
        arcs.add(new Arc(vertices.get(8), vertices.get(1)));
        arcs.add(new Arc(vertices.get(8), vertices.get(2)));

        System.out.println("El grafo está formado por los siguientes arcos:");

        for (int i = 0; i < arcs.size(); i++) {
            System.out.println(arcs.get(i).getSource().getLabel()+" -> "+ arcs.get(i).getTarget().getLabel());
        }


        Graph<Integer> graph = new Graph<>(vertices, arcs);
        Vertex<Integer> v = new Vertex<>(2);
        List<Vertex<Integer>> verticesDFS = new ArrayList<>();

        graph.dfs(v, verticesDFS);

        if(verticesDFS.size()>0){
            System.out.println("El recorrido en profundidad recorre los vértices en el siguiente orden:");
            for (int i = 0; i < verticesDFS.size(); i++) {
                if(i == verticesDFS.size()-1) System.out.println(verticesDFS.get(i).getLabel());
                else System.out.print(verticesDFS.get(i).getLabel()+", ");
            }   
        }else System.out.println("O no existe el vértice o no se puede acceder a otro desde el vértice indicado.");


        List<Vertex<Integer>> verticesBFS = new ArrayList<>();

        graph.bfs(v, verticesBFS);

        if(verticesBFS.size()>0){
            System.out.println("El recorrido en anchura recorre los vértices en el siguiente orden:");
            for (int i = 0; i < verticesBFS.size(); i++) {
                if(i == verticesBFS.size()-1) System.out.println(verticesBFS.get(i).getLabel());
                else System.out.print(verticesBFS.get(i).getLabel()+", ");
            }   
        }else System.out.println("O no existe el vértice o no se puede acceder a otro desde el vértice indicado.");
        


        
    }
}
