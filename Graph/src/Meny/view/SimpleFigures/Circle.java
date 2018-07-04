package Meny.view.SimpleFigures;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Circle extends Ellipse2D {

    private Point center;
    private int height = 0;
    private int width = 0;

    private Color color;

    public String name;

    public Circle() {
        center = new Point();
    }

    public Circle(double x, double y) {
        center = new Point(x,y);
    }

    public Circle(double x, double y,int height, int width) {
        center = new Point(x,y);
        this.height = height;
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Circle(double x, double y, int ray) {
        center = new Point(x,y);
        this.height = ray;
        this.width = ray;
    }

    @Override
    public double getX() {
        return center.getX();
    }

    @Override
    public double getY() {
        return center.getY();
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public boolean isEmpty() {
        if((center != null) && (height != 0) && (width != 0))
            return true;
        return false;
    }

    @Override
    public void setFrame(double v, double v1, double v2, double v3) {

    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }
}
