package com.mycompany.tombo_negro;

import java.awt.*;
import java.util.ArrayList;

class GraphRenderer {
    public static void render(Graphics g, ArrayList<Vertex> vertices, ArrayList<int[]> edges,
                               Point currentMagenta, Point currentGreen, int sizeCircle, int sizeSquare) {
        g.setColor(Color.BLACK);

        // Dibuja las aristas
        for (int[] edge : edges) {
            Point p1 = vertices.get(edge[0]).getPosition();
            Point p2 = vertices.get(edge[1]).getPosition();
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }

        // Dibuja los vértices rojos
        g.setColor(Color.RED);
        for (Vertex vertex : vertices) {
            Point position = vertex.getPosition();
            g.fillOval(position.x - sizeCircle / 2, position.y - sizeCircle / 2, sizeCircle, sizeCircle);
        }

        // Dibuja el cubo magenta
        g.setColor(Color.MAGENTA);
        g.fillRect(currentMagenta.x - sizeSquare / 2, currentMagenta.y - sizeSquare / 2, sizeSquare, sizeSquare);

        // Dibuja el cubo verde
        g.setColor(Color.GREEN);
        g.fillRect(currentGreen.x - sizeSquare / 2, currentGreen.y - sizeSquare / 2, sizeSquare, sizeSquare);
    }
}
