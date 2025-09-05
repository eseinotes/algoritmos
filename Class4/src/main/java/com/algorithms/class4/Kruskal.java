package com.algorithms.class4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kruskal {
    
    private Map<String, String> parent = new HashMap<>();
    private Graph g;
    
    Kruskal(Graph g){
        this.g = g;
    }

    String find(String v) {
        if (!parent.get(v).equals(v)) {
            parent.put(v, find(parent.get(v))); // compresión de caminos
        }
        return parent.get(v);
    }

    void union(String u, String v) {
        String rootU = find(u);
        String rootV = find(v);
        parent.put(rootU, rootV);
    }

    public void kruskalMST() {
        for (String v : g.getNodes()) {
            parent.put(v, v);
        }

        List<Edge> result = new ArrayList<>();
        g.getEdges().sort(Comparator.comparingInt(e -> e.getWeight()));

        for (Edge e : g.getEdges()) {
            String u = find(e.getSrc());
            String v = find(e.getDest());
            if (!u.equals(v)) {
                result.add(e);
                union(u, v);
            }
        }

        System.out.println("Kruskal MST:");
        for (Edge e : result) {
            System.out.println(e.getSrc() + " - " + e.getDest() + 
                    " : " + e.getWeight());
        }
    }
    
}
