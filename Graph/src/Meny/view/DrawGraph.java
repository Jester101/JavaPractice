package Meny.view;

import Meny.MainFrame.Panels.MainWindow;
import Meny.MainFrame.Panels.View;
import Meny.MainFrame.SwingGraphics;
import Meny.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.util.ArrayList;

public class DrawGraph {

    private Graph graph;
    private  JFrame frame;

    private ArrayList<DrawNode> nodesd;
    private ArrayList<DrawEdge> edgesd;
    private MainWindow view;

    public DrawGraph(Graph graph) {
        nodesd = new ArrayList<>();
        edgesd = new ArrayList<>();
        setGraph(graph);
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setView(MainWindow view) {
        this.view = view;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void drawGraph() {

        nodesd.clear();
        edgesd.clear();
        ArrayList<SimpleNode> nodes = graph.getNodes();
        int i = 1;


        //value for rotation
        double k = 360.0 / nodes.size();
        double PI = 3.14;

        double Rot = 10;

        double x = 300; // координаты центра во кргу которого рисуем
        double y = 250;

        double x0 = 300;// координаты первой вершины
        double y0 = 50;

        double NX;
        double NY;

        for (SimpleNode node : nodes) {

            Rot += k;
            NX = x + (x0 - x) * Math.cos(Rot * PI / 180) - (y0 - y) * Math.sin(Rot * PI / 180);
            NY = y + (y0 - y) * Math.cos(Rot * PI / 180) + (x0 - x) * Math.sin(Rot * PI / 180) + 13;

            DrawNode drawNode = new DrawNode(node.getName(), NX, NY);
            nodesd.add(drawNode);
            node.setPictrue(drawNode);
            ++i;
        }
       // view.addComponents(nodesd,edgesd);
        for (SimpleNode node : nodes) {
            for (Edge edge : node.getEdgesList()) {
                if (node == edge.getSourceNode()) {
                    DrawEdge drawEdge = new DrawEdge(node.getPictrue(), edge.getDestNode().getPictrue());
                    edgesd.add(drawEdge);
                    edge.setPicture(drawEdge);
                }
            }
        }

        frame.repaint();
        view.getVisualPanel().addComponents(nodesd,edgesd);
    }
}
