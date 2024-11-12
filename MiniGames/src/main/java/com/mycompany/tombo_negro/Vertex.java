package com.mycompany.tombo_negro;

import java.awt.*;

class Vertex {
    private Point position;

    public Vertex(int x, int y) {
        this.position = new Point(x, y);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}
