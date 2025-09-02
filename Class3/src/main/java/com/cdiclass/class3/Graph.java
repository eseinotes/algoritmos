package com.cdiclass.class3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private List<String> nodes; // lista de nodos
    private List<Edge> edges; // lista de aristas
    private Map<String, List<Edge>> adj; // lista de adyacencia
    
    public List<Edge> getEdges(){
        return edges;
    }
    
    public List<String> getNodes(){
        return nodes;
    }
    
    public Map<String, List<Edge>> getAdj(){
        return adj;
    }

    public Graph(List<String> nodes) {
        edges = new ArrayList<>();
        adj = new HashMap<>();
        this.nodes = nodes;
        for (String node : nodes) {
            adj.put(node, new ArrayList<>());
        }
    }

    public void addEdge(String src, String dest, int weight) {
        Edge e1 = new Edge(src, dest, weight);
        Edge e2 = new Edge(dest, src, weight); // no dirigido
        edges.add(e1);
        edges.add(e2);
        adj.get(src).add(e1);
        adj.get(dest).add(e2);
    }
    
}
