package com.mycompany.tombo_negro;

import javax.swing.*;
import java.awt.*;

public class Tombo_negro {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Tombo Negro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Crear la instancia del panel de control del grafo
        GraphControlPanel panel = new GraphControlPanel();
        
        // Agregar el panel al marco
        frame.add(panel, BorderLayout.CENTER);
        
        // Configurar tamaño de la ventana
        frame.setSize(600, 500);
        frame.setVisible(true);
    }
}


