package com.algorithms.class5;

// Clase para representar un objeto
public class Item {
    private String name;
    private int weight;
    private int value;

    Item(String name, int weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }
    
    public String getName(){
        return name;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public int getValue(){
        return value;
    }
    
}
