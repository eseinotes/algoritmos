package com.algorithms.class4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Prim {
    
    private Graph g;
    
    Prim(Graph g){
        this.g = g;
    }
    
    public void primMST(String start) {
        Set<String> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.getWeight()));
        List<Edge> result = new ArrayList<>();

        visited.add(start);
        pq.addAll(g.getAdj().get(start));

        while (!pq.isEmpty() && result.size() < g.getNodes().size() - 1) {
            Edge e = pq.poll();
            if (visited.contains(e.getDest())) continue;
            visited.add(e.getDest());
            result.add(e);
            pq.addAll(g.getAdj().get(e.getDest()));
        }

        System.out.println("Prim MST:");
        for (Edge e : result) {
            System.out.println(e.getSrc() + " - " + e.getDest() + 
                    " : " + e.getWeight());
        }
    }
}
