package Meny.MainFrame.Panels;

import Meny.model.SimpleNode;
import Meny.view.*;
import Meny.view.SimpleFigures.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.util.ArrayList;

public class View extends JPanel {

    private ArrayList<Line> lines;
    private ArrayList<Circle> circles;

    private Line superline;
    private  Circle superCircle;

    public View() {
        super(null);
        lines = new ArrayList<>();
        circles = new ArrayList<>();

        superline = new Line(50,20,40,100);
        superCircle = new Circle(40,30,40,40);
    }

    public void addComponents(ArrayList<DrawNode> nodes, ArrayList<DrawEdge> edges){
        makeNodesList(nodes);
        makeEdgeList(edges);
        repaint();
    }

    private void makeNodesList(ArrayList<DrawNode> nodes) {
        circles.clear();
        for(DrawNode node: nodes) {
            Circle crcl = new Circle(node.getxPos(),node.getyPos(),70);
            double cx = crcl.getCenterX();
            double cy = crcl.getCenterY();
            crcl.name = node.getName();
            //crcl.setFrameFromCenter(cx,cy,cx+crcl.getHeight(),cy+crcl.getWidth());
            circles.add(crcl);
        }
    }

    private void makeEdgeList(ArrayList<DrawEdge> edges) {
        lines.clear();
        for(DrawEdge edge: edges) {
            Line ln = new Line(edge.getStart(),edge.getEnd());
            lines.add(ln);
        }

    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D)g;
        for(Circle crcl: circles) {

            g2.draw(crcl);
            g2.drawString(crcl.name,(int)crcl.getCenterX()-20,(int)crcl.getCenterY());
        }
        for(Line ln: lines) {

            g2.draw(ln);
        }
//        g2.draw(superCircle);
//        g2.draw(superline);
    }

}
