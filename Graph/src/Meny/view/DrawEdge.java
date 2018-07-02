package Meny.view;
import Meny.model.Edge;

import java.awt.*;

public class DrawEdge {

    private DrawNode first;
    private DrawNode second;
    private Graphics graphics;
    private Color color;

    public DrawEdge(DrawNode first, DrawNode second, Graphics graphics) {
        this.first = first;
        this.second = second;
        color = Color.BLACK;
        setGraphics(graphics);
        draw(color);
    }

    void draw(Color color) {
        graphics.drawLine(first.getxPos(),first.getyPos(),
                        second.getxPos(),second.getyPos(),color.getRGB());
    }

    public void setColor(Color color) {
        this.color = color;
    }

    void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }
}
