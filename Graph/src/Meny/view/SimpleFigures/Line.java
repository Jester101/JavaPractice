package Meny.view.SimpleFigures;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Line extends Line2D {


    private Point p1;
    private Point p2;

    public Line() {
        p1 = new Point();
        p2 = new Point();
    }

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public  Line(double p1x, double p1y, double p2x, double p2y) {

        p1 = new Point(p1x,p1y);
        p2 = new Point(p2x,p2y);
    }

    @Override
    public double getX1() {
        return p1.getX();
    }

    @Override
    public double getY1() {
        return p1.getY();
    }

    @Override
    public Point getP1() {
        return p1;
    }

    @Override
    public double getX2() {
        return p2.getX();
    }

    @Override
    public double getY2() {
        return p2.getY();
    }

    @Override
    public Point getP2() {
        return p2;
    }

    @Override
    public void setLine(double v, double v1, double v2, double v3) {

        p1.setLocation(v, v1);
        p1.setLocation(v2,v3);
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }
}
