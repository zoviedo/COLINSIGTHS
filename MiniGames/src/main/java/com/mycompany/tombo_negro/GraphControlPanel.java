package com.mycompany.tombo_negro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class GraphControlPanel extends JPanel {

    private Grafo grafo; // Instancia de la clase Grafo
    private ArrayList<Vertex> vertices; // Lista de vértices
    private ArrayList<int[]> edges;
    private int magentaVertex;
    private int greenVertex;
    private final int sizeCircle = 30;
    private final int sizeSquare = 10;
    private Point currentMagentaPosition;
    private Point currentGreenPosition;
    private boolean controlMagenta = true;

    public GraphControlPanel() {
        // Crear la instancia de Grafo
        grafo = new Grafo();
        vertices = new ArrayList<>();
        for (Point vertex : grafo.getVertices()) {
            vertices.add(new Vertex(vertex.x, vertex.y));
        }
        edges = grafo.getEdges();

        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BorderLayout());

        Random rand = new Random();
        do {
            magentaVertex = rand.nextInt(vertices.size());
            greenVertex = rand.nextInt(vertices.size());
        } while (magentaVertex == greenVertex);

        currentMagentaPosition = new Point(vertices.get(magentaVertex).getPosition());
        currentGreenPosition = new Point(vertices.get(greenVertex).getPosition());

        // Timer para el movimiento
        Timer timer = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controlMagenta) {
                    VertexMover.moveTowards(currentMagentaPosition, vertices.get(magentaVertex).getPosition());
                } else {
                    VertexMover.moveTowards(currentGreenPosition, vertices.get(greenVertex).getPosition());
                }
                repaint();
            }
        });
        timer.start();

        // Configuración de botones
        JButton greenButton = new JButton("Control Verde");
        JButton magentaButton = new JButton("Control Magenta");

        greenButton.setBackground(Color.GREEN);
        magentaButton.setBackground(Color.MAGENTA);

        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlMagenta = false;
            }
        });

        magentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlMagenta = true;
            }
        });

        // Agregar botones al panel en la parte inferior
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(magentaButton);
        buttonPanel.add(greenButton);
        this.add(buttonPanel, BorderLayout.SOUTH);

        // Agregar listener para clic en el mouse
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                Point clickPoint = e.getPoint();
                if (controlMagenta) {
                    for (int i = 0; i < vertices.size(); i++) {
                        if (vertices.get(i).getPosition().distance(clickPoint) < sizeCircle / 2) {
                            if (areAdjacent(magentaVertex, i)) {
                                magentaVertex = i;
                                break;
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < vertices.size(); i++) {
                        if (vertices.get(i).getPosition().distance(clickPoint) < sizeCircle / 2) {
                            if (areAdjacent(greenVertex, i)) {
                                greenVertex = i;
                                break;
                            }
                        }
                    }
                }
            }
        });
    }

    private boolean areAdjacent(int vertex1, int vertex2) {
        return grafo.areAdjacent(vertex1, vertex2); // Usar el método areAdjacent de la clase Grafo
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        GraphRenderer.render(g, vertices, edges, currentMagentaPosition, currentGreenPosition, sizeCircle, sizeSquare);
    }
}
