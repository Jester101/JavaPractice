package Meny.view.SimpleFigures;

import java.awt.geom.Point2D;

public class Point extends Point2D {
    private double x;
    private double y;

    public  Point(double x, double y) {
        setLocation(x,y);
    }

    public  Point() {}

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setLocation(double v, double v1) {
        x = v;
        y = v1;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isequal(Point other) {
        if((this!= null)&&(x == other.x)&&(y == other.y))
                return  true;
        return false;
    }
}
