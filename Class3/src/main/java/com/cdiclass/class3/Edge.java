package com.cdiclass.class3;

public class Edge {
    
    private String src;
    private String dest;
    private int weight;   
    
    public Edge(String src, String dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    
    public String getSrc(){
        return src;
    }
    
    public String getDest(){
        return dest;
    }
    
    public int getWeight(){
        return weight;
    }
    
}
