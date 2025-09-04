package com.cdiclass.class4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class BranchAndBoundKnapsack {
  

    // Cálculo de la cota superior (greedy fraccional)
    private int bound(Node node, int capacity, List<Item> items) {
        if (node.getWeight() > capacity) return 0;

        int result = node.getValue();
        int totalWeight = node.getWeight();
        int i = node.getLevel();

        // Añadir objetos mientras quepan
        while (i < items.size() && totalWeight + items.get(i).getWeight() <= capacity) {
            totalWeight += items.get(i).getWeight();
            result += items.get(i).getValue();
            i++;
        }

        // Si aún queda capacidad, añadir fracción del siguiente objeto
        if (i < items.size()) {
            result += (capacity - totalWeight) * 
                    items.get(i).getValue() / items.get(i).getWeight();
        }

        return result;
    }

    // Algoritmo de ramificación y poda con estrategia FIFO (cola)
    public void knapsackFIFO(int capacity, List<Item> items) {
        Queue<Node> queue = new LinkedList<>();

        Node root = new Node(0, 0, 0, 0, new ArrayList<>());
        
        root.setBound(bound(root, capacity, items));
        
        queue.add(root);

        int maxValue = 0;
        List<String> bestItems = new ArrayList<>();

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.getLevel() == items.size()) continue;

            // Nodo "sí coger"
            Item item = items.get(node.getLevel());
            Node with = new Node(
                node.getLevel() + 1,
                node.getValue() + item.getValue(),
                node.getWeight() + item.getWeight(),
                0,
                node.getTaken()
            );
            with.getTaken().add(item.getName());

            if (with.getWeight() <= capacity && with.getValue() > maxValue) {
                maxValue = with.getValue();
                bestItems = with.getTaken();
            }
            
            with.setBound(bound(with, capacity, items));
            
            if (with.getBound() > maxValue) queue.add(with);

            // Nodo "no coger"
            Node without = new Node(
                node.getLevel() + 1,
                node.getValue(),
                node.getWeight(),
                0,
                node.getTaken()
            );
            without.setBound(bound(without, capacity, items));
            
            if (without.getBound() > maxValue) queue.add(without);
        }

        System.out.println("FIFO -> Mejor valor: " + maxValue + " con items " + bestItems);
    }

    // Algoritmo de ramificación y poda con estrategia LIFO (pila)
    public void knapsackLIFO(int capacity, List<Item> items) {
        Stack<Node> stack = new Stack<>();

        Node root = new Node(0, 0, 0, 0, new ArrayList<>());
        
        root.setBound(bound(root, capacity, items));
        
        stack.push(root);

        int maxValue = 0;
        List<String> bestItems = new ArrayList<>();

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            if (node.getLevel() == items.size()) continue;

            // Nodo "sí coger"
            Item item = items.get(node.getLevel());
            Node with = new Node(
                node.getLevel() + 1,
                node.getValue() + item.getValue(),
                node.getWeight() + item.getWeight(),
                0,
                node.getTaken()
            );
            with.getTaken().add(item.getName());

            if (with.getWeight() <= capacity && with.getValue() > maxValue) {
                maxValue = with.getValue();
                bestItems = with.getTaken();
            }
            
            with.setBound(bound(with, capacity, items));
            
            if (with.getBound() > maxValue) stack.push(with);

            // Nodo "no coger"
            Node without = new Node(
                node.getLevel() + 1,
                node.getValue(),
                node.getWeight(),
                0,
                node.getTaken()
            );
            
            without.setBound(bound(without, capacity, items));
            
            if (without.getBound() > maxValue) stack.push(without);
        }

        System.out.println("LIFO -> Mejor valor: " + maxValue + " con items " + bestItems);
    }
    
}
