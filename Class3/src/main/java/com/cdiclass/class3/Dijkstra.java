package com.cdiclass.class3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    
    private Graph g;
    
    Dijkstra(Graph g){
        this.g = g;
    }
    
    public void shortestPath(String src) {
        Map<String, Integer> dist = new HashMap<>();
        for (String v : g.getNodes()) {
            dist.put(v, Integer.MAX_VALUE);
        }
        dist.put(src, 0);

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.getWeight()));
        pq.add(new Edge(src, src, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            String u = current.getDest();

            for (Edge e : g.getAdj().get(u)) {
                int newDist = dist.get(u) + e.getWeight();
                if (newDist < dist.get(e.getDest())) {
                    dist.put(e.getDest(), newDist);
                    pq.add(new Edge(u, e.getDest(), newDist));
                }
            }
        }

        System.out.println("Dijkstra el camino más corte desde el nodo "
                + "" + src + ":");
        for (String v : dist.keySet()) {
            System.out.println("Distancia a " + v + " = " + dist.get(v));
        }
    }
    
}
