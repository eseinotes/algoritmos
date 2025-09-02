package com.cdiclass.class3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Class3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 10;
        
        List<String> nodes = Arrays.asList("A","B","C","D");
        Graph g = new Graph(nodes);

        g.addEdge("A", "B", 1);
        g.addEdge("A", "C", 3);
        g.addEdge("B", "D", 4);
        g.addEdge("B", "C", 2);
        g.addEdge("C", "D", 5);
        
        while(option != -1){
            
            System.out.println("Introduce un número: ");
            option = sc.nextInt();
        
            switch (option) { 

                case 1:
                    // Lista de actividades: (nombre, inicio, fin)
                    List<Activity> activities = Arrays.asList(
                        new Activity("A1", 9, 10),     // 9:00–10:00
                        new Activity("A2", 9, 12),     // 9:00–12:00
                        new Activity("A3", 11, 12),    // 11:00–12:00
                        new Activity("A4", 12, 14),    // 12:00–14:00
                        new Activity("A5", 14, 15),    // 14:00–15:00
                        new Activity("A6", 10, 11)     // 10:00–11:00
                    );

                    // Ordenar por hora de finalización (criterio voraz)
                    Collections.sort(activities, new Comparator<Activity>() {
                        public int compare(Activity a1, Activity a2) {
                            return Integer.compare(a1.end, a2.end);
                        }
                    });

                    List<Activity> solution = new ArrayList<>();
                    int lastEndTime = -1;

                    // Algoritmo voraz: escoger la actividad que termine antes
                    for (Activity activity : activities) {
                        if (activity.start >= lastEndTime) {
                            solution.add(activity);
                            lastEndTime = activity.end;
                        }
                    }

                    // Mostrar resultado
                    System.out.println("Selected activities:");
                    for (Activity activity : solution) {
                        System.out.println(activity);
                    }                   
                    
                break;
                
                case 2:
                    Kruskal k = new Kruskal(g);
                    k.kruskalMST(); 
                break;
                
                case 3:
                    Prim p = new Prim(g);
                    p.primMST("A");
                break;
                
                case 4:
                    
                    List<String> nodesD = Arrays.asList("A","B","C","D", "E");
                    Graph gd = new Graph(nodesD);

                    gd.addEdge("A", "B", 4);
                    gd.addEdge("A", "C", 2);
                    gd.addEdge("A", "E", 7);
                    gd.addEdge("B", "C", 3);
                    gd.addEdge("B", "D", 1);
                    gd.addEdge("C", "E", 2);
                    gd.addEdge("D", "E", 2);
                    
                    Dijkstra d = new Dijkstra(gd);
                    d.shortestPath("A");
                    
                break;
                
                
                case -1:
                    System.out.println("Adios");
                
                default:
                    System.out.println("Número equivocado");
            }   
        }
    }
    
}

