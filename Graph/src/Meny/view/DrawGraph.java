package Meny.view;

import Meny.MainFrame.SwingGraphics;
import Meny.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraph {

    private Graph graph;
    private  JFrame frame;

    public DrawGraph(Graph graph) {
        this.frame = frame;
        setGraph(graph);
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Graph getGraph() {
        return graph;
    }

    public void drawGraph(Meny.view.Graphics graphics) {

        ArrayList<SimpleNode> nodes = graph.getNodes();
        int i = 1;
        double k = 360.0 / nodes.size();
        double PI = 3.14;

        double Rot = 10;

        double x = 200; // координаты центра во кргу которого рисуем
        double y = 150;

        double x0 = 300;// координаты первой вершины
        double y0 = 50;

        double NX;
        double NY;

        for (SimpleNode node : nodes) {

            Rot += k;
            NX = x + (x0 - x) * Math.cos(Rot * PI / 180) - (y0 - y) * Math.sin(Rot * PI / 180);
            NY = y + (y0 - y) * Math.cos(Rot * PI / 180) + (x0 - x) * Math.sin(Rot * PI / 180) + 13;

            DrawNode drawNode = new DrawNode(node.getName(), 0, 0, graphics);
            node.setPictrue(drawNode);
            ++i;
        }
        for (SimpleNode node : nodes) {
            for (Edge edge : node.getEdgesList()) {
                if (node == edge.getDestNode()) {
                    DrawEdge drawEdge = new DrawEdge(node.getPictrue(), edge.getDestNode().getPictrue(),
                                                    graphics);
                    edge.setPicture(drawEdge);
                }
            }
        }
    }
}
