package com.mycompany.tombo_negro;

import java.awt.*;

class VertexMover {
    public static void moveTowards(Point currentPosition, Point target) {
        int dx = target.x - currentPosition.x;
        int dy = target.y - currentPosition.y;
        if (Math.abs(dx) > 1) currentPosition.x += dx / 20;
        if (Math.abs(dy) > 1) currentPosition.y += dy / 20;
    }
}

