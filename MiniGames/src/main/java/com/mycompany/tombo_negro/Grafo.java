package com.mycompany.tombo_negro;

import java.awt.*;
import java.util.ArrayList;

public class Grafo {
    private Point[] vertices; // Array de vértices
    private ArrayList<int[]> edges; // Lista de aristas

    public Grafo() {
        selectGraph(); // Seleccionar el grafo predeterminado
    }

    // Método para seleccionar el grafo (inicializar vértices y aristas)
    private void selectGraph() {
        vertices = new Point[]{
            new Point(100, 100), new Point(200, 100), new Point(300, 100), new Point(400, 100),
            new Point(100, 200), new Point(200, 200), new Point(300, 200), new Point(400, 200),
        };

        edges = new ArrayList<>();
        edges.add(new int[]{0, 1});
        edges.add(new int[]{1, 2});
        edges.add(new int[]{2, 3});
        edges.add(new int[]{0, 4});
        edges.add(new int[]{1, 5});
        edges.add(new int[]{2, 6});
        edges.add(new int[]{3, 7});
        edges.add(new int[]{4, 5});
        edges.add(new int[]{5, 6});
        edges.add(new int[]{6, 7});
        edges.add(new int[]{2, 7});
    }

    // Método para obtener los vértices
    public Point[] getVertices() {
        return vertices;
    }

    // Método para obtener las aristas
    public ArrayList<int[]> getEdges() {
        return edges;
    }

    // Método para verificar si dos vértices son adyacentes
    public boolean areAdjacent(int vertex1, int vertex2) {
        for (int[] edge : edges) {
            if ((edge[0] == vertex1 && edge[1] == vertex2) || (edge[0] == vertex2 && edge[1] == vertex1)) {
                return true;
            }
        }
        return false; // Si no son adyacentes
    }
}
