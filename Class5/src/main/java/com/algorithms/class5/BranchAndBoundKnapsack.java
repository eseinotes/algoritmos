package com.algorithms.class5;

import java.util.*;

public class BranchAndBoundKnapsack {
    
    private List<Item> items;        
    private int capacity;

    public BranchAndBoundKnapsack(List<Item> items, int capacity) {
        this.items = items;
        this.capacity = capacity;
    }

    // ------------------------------------------------------------
    // Cálculo de la cota superior 
    // ------------------------------------------------------------
    private int bound(Node node) {
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

        return result;
    }

    // ------------------------------------------------------------
    // Estrategia FIFO (cola)
    // ------------------------------------------------------------
    public void knapsackFIFO() {
        Queue<Node> queue = new LinkedList<>();

        Node root = new Node(0, 0, 0, 0, new ArrayList<>());
        root.setBound(bound(root));
        queue.add(root);

        int maxValue = 0;
        List<String> bestItems = new ArrayList<>();

        System.out.println("\n========= EXPLORACIÓN FIFO (cola) =========");

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.getLevel() == items.size()) continue;

            Item item = items.get(node.getLevel());

            // ----- Nodo "sí coger" -----
            Node with = new Node(
                    node.getLevel() + 1,
                    node.getValue() + item.getValue(),
                    node.getWeight() + item.getWeight(),
                    0,
                    new ArrayList<>(node.getTaken())
            );
            with.getTaken().add(item.getName());
            with.setBound(bound(with));

            System.out.printf("Nodo SÍ coger %-5s -> Peso=%d, Valor=%d, Cota=%.2f%n",
                    item.getName(), with.getWeight(), with.getValue(), (double) with.getBound());

            if (with.getWeight() <= capacity) {
                if (with.getValue() > maxValue) {
                    maxValue = with.getValue();
                    bestItems = new ArrayList<>(with.getTaken());
                    System.out.printf("  ✅ Nuevo mejor valor encontrado: %d con %s%n",
                            maxValue, bestItems);
                }
                if (with.getBound() > maxValue) {
                    queue.add(with);
                    System.out.println("  ➕ Insertado en la cola");
                } else {
                    System.out.println("  ❌ PODADO por cota (no mejora)");
                }
            } else {
                System.out.println("  ❌ PODADO por capacidad");
            }

            // ----- Nodo "no coger" -----
            Node without = new Node(
                    node.getLevel() + 1,
                    node.getValue(),
                    node.getWeight(),
                    0,
                    new ArrayList<>(node.getTaken())
            );
            without.setBound(bound(without));

            System.out.printf("Nodo NO coger %-5s -> Peso=%d, Valor=%d, Cota=%.2f%n",
                    item.getName(), without.getWeight(), without.getValue(), (double) without.getBound());

            if (without.getBound() > maxValue) {
                queue.add(without);
                System.out.println("  ➕ Insertado en la cola");
            } else {
                System.out.println("  ❌ PODADO por cota (no mejora)");
            }

            System.out.println("--------------------------------------------------");
        }

        System.out.println("FIFO -> Mejor valor: " + maxValue + " con items " + bestItems);
    }

    // ------------------------------------------------------------
    // Estrategia LIFO (pila)
    // ------------------------------------------------------------
    public void knapsackLIFO() {
        Stack<Node> stack = new Stack<>();

        Node root = new Node(0, 0, 0, 0, new ArrayList<>());
        root.setBound(bound(root));
        stack.push(root);

        int maxValue = 0;
        List<String> bestItems = new ArrayList<>();

        System.out.println("\n========= EXPLORACIÓN LIFO (pila) =========");

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            if (node.getLevel() == items.size()) continue;

            Item item = items.get(node.getLevel());

            // ----- Nodo "sí coger" -----
            Node with = new Node(
                    node.getLevel() + 1,
                    node.getValue() + item.getValue(),
                    node.getWeight() + item.getWeight(),
                    0,
                    new ArrayList<>(node.getTaken())
            );
            with.getTaken().add(item.getName());
            with.setBound(bound(with));

            System.out.printf("Nodo SÍ coger %-5s -> Peso=%d, Valor=%d, Cota=%.2f%n",
                    item.getName(), with.getWeight(), with.getValue(), (double) with.getBound());

            if (with.getWeight() <= capacity) {
                if (with.getValue() > maxValue) {
                    maxValue = with.getValue();
                    bestItems = new ArrayList<>(with.getTaken());
                    System.out.printf("  ✅ Nuevo mejor valor encontrado: %d con %s%n",
                            maxValue, bestItems);
                }
                if (with.getBound() > maxValue) {
                    stack.push(with);
                    System.out.println("  ➕ Insertado en la pila");
                } else {
                    System.out.println("  ❌ PODADO por cota (no mejora)");
                }
            } else {
                System.out.println("  ❌ PODADO por capacidad");
            }

            // ----- Nodo "no coger" -----
            Node without = new Node(
                    node.getLevel() + 1,
                    node.getValue(),
                    node.getWeight(),
                    0,
                    new ArrayList<>(node.getTaken())
            );
            without.setBound(bound(without));

            System.out.printf("Nodo NO coger %-5s -> Peso=%d, Valor=%d, Cota=%.2f%n",
                    item.getName(), without.getWeight(), without.getValue(), (double) without.getBound());

            if (without.getBound() > maxValue) {
                stack.push(without);
                System.out.println("  ➕ Insertado en la pila");
            } else {
                System.out.println("  ❌ PODADO por cota (no mejora)");
            }

            System.out.println("--------------------------------------------------");
        }

        System.out.println("LIFO -> Mejor valor: " + maxValue + " con items " + bestItems);
    }
}
