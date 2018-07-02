//package Meny.MainFrame.Panels;
//
//import Meny.controller.Algorithmpcg.*;
//import Meny.model.Edge;
//import Meny.model.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import com.mxgraph.util.mxConstants;
//import com.mxgraph.swing.mxGraphComponent;
//import com.mxgraph.view.mxStylesheet;
//import com.mxgraph.view.mxGraph;
//
//import javax.swing.*;
//import java.util.ArrayList;
//
//public class VisualPanel extends JPanel {
//
//    private mxGraph graph;
//    private Object parent;
//
//    public VisualPanel() {
//
//        super(null);
//        //getContentPane().add(graphComponent);
//    }
//
//    public void setGraph(Graph NodesGraph) {
//
//        graph = new mxGraph();
//        parent = graph.getDefaultParent();
//
//        graph.getModel().beginUpdate();
//        ArrayList<SimpleNode> nodes = NodesGraph.getNodes();
//
//        int i = 1;
//
//
//        //value for rotation
//        double k = 360.0 / nodes.size();
//        double PI = 3.14;
//
//        double Rot = 10;
//
//        double x = 300; // координаты центра во кргу которого рисуем
//        double y = 250;
//
//        double x0 = 300;// координаты первой вершины
//        double y0 = 50;
//
//        double NX;
//        double NY;
//
//
//        try {
//            for (SimpleNode node : nodes) {
//                Rot += k;
//                NX = x + (x0 - x) * Math.cos(Rot * PI / 180) - (y0 - y) * Math.sin(Rot * PI / 180);
//                NY = y + (y0 - y) * Math.cos(Rot * PI / 180) + (x0 - x) * Math.sin(Rot * PI / 180) + 13;
//
//
//                Object obj = graph.insertVertex(parent, null, node.getName(),
//                        (NX),
//                        (NY),
//                        60, 60, "shape=ellipse;perimeter=ellipsePerimeter");
//                node.setPictrue(obj);
//                ++i;
//            }
//
//            /*Стиль для обычного моста*/
//            Map<String, Object> StyleForEdge = new HashMap<String, Object>();
//            StyleForEdge.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_CONNECTOR);
//            StyleForEdge.put(mxConstants.STYLE_STROKECOLOR, "#6482B9"); // default is #6482B9
//            mxStylesheet edgeStyle1 = new mxStylesheet();
//            edgeStyle1.setDefaultEdgeStyle(StyleForEdge);
//            graph.setStylesheet(edgeStyle1);
//            /**/
//
//            for (SimpleNode node : nodes) {
//                for (Edge edge : node.getEdgesList()) {
//                    if (node == edge.getDestNode())
//                        graph.insertEdge(parent, null, "", node.getPictrue(), edge.getSourceNode().getPictrue());
//                }
//            }
//        } finally {
//            graph.getModel().endUpdate();
//        }
//
//        mxGraphComponent graphComponent = new mxGraphComponent(graph);
//        add(graphComponent);
//    }
//
//    public void DrawBriedge(Graph NodesGraph) {
//
//        Map<String, Object> StyleForBridge = new HashMap<String, Object>();
//        StyleForBridge.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_CONNECTOR);
//        StyleForBridge.put(mxConstants.STYLE_STROKECOLOR, "#ff0000"); // default is #6482B9
//        mxStylesheet edgeStyle = new mxStylesheet();
//        edgeStyle.setDefaultEdgeStyle(StyleForBridge);
//        graph.setStylesheet(edgeStyle);
//
//
//        FindBridge a = new FindBridge(NodesGraph);
//        ArrayList<Edge> Bridges = a.FindBridges();
//        try {
//            for (int i = 0; i < Bridges.size(); i++) {
//                graph.insertEdge(parent, null, "", Bridges.get(i).getSourceNode().getPictrue(), Bridges.get(i).getDestNode().getPictrue());
//
//            }
//        } finally {
//
//        }
//
//        graph.getModel().endUpdate();
//        mxGraphComponent graphComponent = new mxGraphComponent(graph);
//        //getContentPane().add(graphComponent);
//        add(graphComponent);
//    }
//}
