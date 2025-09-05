package com.algorithms.class5;

// Nodo del árbol de decisión

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int level;       // índice del objeto considerado
    private int value;       // valor acumulado
    private int weight;      // peso acumulado
    private int bound;       // cota superior estimada
    private List<String> taken; // objetos elegidos

    Node(int level, int value, int weight, int bound, List<String> taken) {
        this.level = level;
        this.value = value;
        this.weight = weight;
        this.bound = bound;
        this.taken = new ArrayList<>(taken);
    }
    
    public void setBound(int bound){
        this.bound = bound;
    }
    
    
    public int getLevel(){
        return level;
    }
        
    public int getValue(){
        return value;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public int getBound(){
        return bound;
    }
    
    public List<String> getTaken(){
        return taken;
    }
    
}
