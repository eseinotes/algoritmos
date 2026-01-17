/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms.graph_traversal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author noeliagarciahervella
 */
public class Graph<E> {
    private List<Vertex<E>> listVertices;
    private List<Arc<E>> listArcs;

    public Graph() {
        this.listVertices = new ArrayList<>();
        this.listArcs = new ArrayList<>();
    }

    public Graph(List<Vertex<E>> listVertices, List<Arc<E>> listArcs) {
        this.listVertices = listVertices;
        this.listArcs = listArcs;
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

    public boolean containsArc(Arc<E> a) {
        for (Arc<E> arc : listArcs) {
            if (arc.getSource().equals(a.getSource()) && arc.getTarget().equals(a.getTarget())) {
                return true;
            }
        }
        return false;
    }

    public Iterator<Vertex<E>> vertexs() {
        return this.listVertices.iterator();
    }

    public Iterator<Arc<E>> arcs() {
        return this.listArcs.iterator();
    }

    public Iterator<Vertex<E>> successors(Vertex<E> v) {
        List<Vertex<E>> successors = new ArrayList<>();

        for (Arc<E> arc : listArcs) {
            if (arc.getSource().equals(v)) {
                successors.add(arc.getTarget());
            }
        }
        return successors.iterator();
    }
    
    public Iterator<Vertex<E>> predecessors(Vertex<E> v) { //Si es dirigido
        List<Vertex<E>> predecessors = new ArrayList<>();

        for (Arc<E> arc : listArcs) {
            if (arc.getTarget().equals(v)) {
                predecessors.add(arc.getSource());
            }
        }
        return predecessors.iterator();
    }

    public void dfs(Vertex<E> v, List<Vertex<E>> vertices) { //recorrido en profundidad
        vertices.add(v);
        Iterator<Vertex<E>> successors = this.successors(v);
        while (successors.hasNext()) {
            Vertex<E> successor = successors.next();
            if (!vertices.contains(successor)) {
                this.dfs(successor, vertices);
            }
        }

    }

    public void bfs(Vertex<E> v, List<Vertex<E>> vertices) { //recorrido en anchura
        Queue<Vertex<E>> queue = new LinkedList<>();
        queue.add(v);
        vertices.add(v);

        while (!queue.isEmpty()) {
            Vertex<E> vertex = queue.poll();
            Iterator<Vertex<E>> successors = this.successors(vertex);
            while (successors.hasNext()) {
                Vertex<E> successor = successors.next();
                if (!vertices.contains(successor)) {
                    queue.add(successor);
                    vertices.add(successor);
                }
            }

        }
    }
}
