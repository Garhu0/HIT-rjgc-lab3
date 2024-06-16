package main;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class MainFunc {
    public static void main(String[] args) {
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the main.Graph Application!");
        while (true) {
            System.out.println("\nOptions: ");
            System.out.println("1. Construct main.Graph");
            System.out.println("2. Show Directed main.Graph");
            System.out.println("3. Query Bridge Words");
            System.out.println("4. Generate New Text");
            System.out.println("5. Calculate Shortest Path");
            System.out.println("6. Perform Random Walk");
            System.out.println("7. Exit");

            System.out.print("Enter option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    System.out.print("Enter file path to construct graph: ");
                    graph.constructGraph();
                    break;
                case 2:
                    graph.showDirectedGraph();
                    break;
                case 3:
                    System.out.print("Enter query word1: ");
                    String queryWord1 = scanner.next();
                    System.out.print("Enter query word2: ");
                    String queryWord2 = scanner.next();
                    graph.queryBridgeWords(queryWord1, queryWord2);
                    break;
                case 4:
                    System.out.print("Enter input text: ");
                    String inputText = scanner.nextLine();
                    System.out.println("Generated text: " + graph.generateNewText(inputText));
                    break;
                case 5:
                    System.out.print("Enter word1 for shortest path: ");
                    String word1 = scanner.next();
                    System.out.print("Enter word2 for shortest path: ");
                    String word2 = scanner.next();
                    System.out.println("Shortest path: " + graph.calcShortestPath(word1, word2));
                    break;
                case 6:
                    System.out.println("Random walk path: " + graph.randomWalk());
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}