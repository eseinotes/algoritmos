package com.algorithms.class1;

import java.util.HashMap;

public class HashSearch {
    
    private HashMap<Integer, String> map;
    
    HashSearch(HashMap<Integer, String> map){
        this.map = map;
    }
    
    public String searchElement(int key){
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            return "No encontrado";
        }   
    }
    
}
