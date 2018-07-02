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
        draw(color);
    }

    void draw(Color color) {
       // graphics.drawLine(first.getxPos(),first.getyPos(),
      //                  second.getxPos(),second.getyPos(),color.getRGB());
    }

    void setPoint(DrawNode first,DrawNode second) {

        Point p1 = new Point(first.getxPos(),first.getyPos());
        Point p2 = new Point(second.getxPos(),second.getyPos());

        int r = 70;
        r/=2;

        p1.setX(p1.getX()+r);
        p1.setY(p1.getY()+r);
        p2.setX(p2.getX()+r);
        p2.setY(p2.getY()+r);

//        startPoint.setLocation(p1.getX(),p1.getY());
//        endPoint.setLocation(p2.getX(),p2.getY());
        Point left = new Point();
        Point up = new Point();
        System.out.println(p1.getX());
        System.out.println(p1.getY());
        System.out.println(p2.getX());
        System.out.println(p2.getY());
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
        System.out.println(startPoint.getX());
        System.out.println(startPoint.getY());
        System.out.println(endPoint.getX());
        System.out.println(endPoint.getY());

    }

    public Point getStart() {
        return startPoint;
    }

    public Point getEnd() {
        return endPoint;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }
}
