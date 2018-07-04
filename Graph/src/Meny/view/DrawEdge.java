package Meny.view;
import Meny.model.Edge;

import java.awt.*;

import Meny.view.SimpleFigures.Point;

public class DrawEdge {

    private DrawNode first;
    private DrawNode second;
    private Graphics graphics;
    private Color color;

    private Point startPoint;
    private Point endPoint;

    public DrawEdge(DrawNode first, DrawNode second) {
        this.first = first;
        this.second = second;
        startPoint = new Point();
        endPoint = new Point();
        setPoint(first,second);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    void setPoint(DrawNode first,DrawNode second) {

        Point p1 = new Point(first.getxPos(),first.getyPos());
        Point p2 = new Point(second.getxPos(),second.getyPos());

        int r = 35;
        p1.setX(p1.getX()+r);
        p1.setY(p1.getY()+r);
        p2.setX(p2.getX()+r);
        p2.setY(p2.getY()+r);
        Point left = new Point();
        Point up = new Point();
        double tan = Math.abs(p1.getX() - p2.getX())/Math.abs(p1.getY() - p2.getY());
        double si = Math.sin(Math.atan(tan));
        double co = Math.sqrt(1 - si*si);
        if(p1.getX() <= p2.getX())
            left = p1;
        else
            left = p2;
        if(p1.getY() <= p2.getY())
            up = p2;
        else
            up = p1;
        if(left.isequal(p1)) {
            startPoint.setX(p1.getX() + r * si);
            endPoint.setX(p2.getX() - r * si);
        }
        else {
            endPoint.setX(p2.getX() + r * si);
            startPoint.setX(p1.getX() - r * si);
        }
        if (up.isequal(p1)){
            startPoint.setY(p1.getY() - r * co);
            endPoint.setY(p2.getY() + r * co);
        }
        else {
            endPoint.setY(p2.getY() - r * co);
            startPoint.setY(p1.getY() + r * co);
        }
    }
    public Point getStart() {
        return startPoint;
    }

    public Point getEnd() {
        return endPoint;
    }

    public Color getColor() {
        return color;
    }

    void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }
}
