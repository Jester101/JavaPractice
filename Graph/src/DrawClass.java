
import Algorithmpcg.*;
import Graphpcg.*;

import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import java.util.ArrayList;
import  java.util.Random;


public class DrawClass extends JFrame {

    public DrawClass(Graph NodesGraph) {

        super("Hello, World!");

        Random rnd = new Random(System.currentTimeMillis());
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        ArrayList<SimpleNode> nodes = NodesGraph.getNodes();
        int i = 1;



        //value for rotation
        double k = 360.0 /nodes.size();
        double PI = 3.14;

        double Rot = 0;

        double x = 300; // координаты центра во кргу которого рисуем
        double y = 250;

        double x0 = 300;// координаты первой вершины
        double y0 = 50;

        double NX;
        double NY;



        try
        {

            for(SimpleNode node: nodes) {


                Rot +=k;
                NX = x + (x0 - x) * Math.cos(Rot * PI / 180) - (y0 - y) * Math.sin(Rot * PI / 180);
                NY = y + (y0 - y) * Math.cos(Rot * PI / 180) + (x0 - x) * Math.sin(Rot * PI / 180);


                Object obj = graph.insertVertex(parent, null, node.getName(),
                        (NX),
                        (NY),
                        60,60,"shape=ellipse;perimeter=ellipsePerimeter");
                node.setPictrue(obj);
                ++i;
            }
            for(SimpleNode node: nodes) {

                for(Edge edge: node.getEdgesList()) {

                    if(node.equals(edge.getSourceNode()))
                        graph.insertEdge(parent, null, "", node.getPictrue(),edge.getDestNode().getPictrue());
                }
            }
        }
        finally
        {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);


        /**/
        FindBridge a = new FindBridge(NodesGraph);
        a.FindBridges();
        /**/
    }

    public static void main(String[] args)
    {

        Graph<SimpleNode> NodeGraph = new Graph(SimpleNode::new);
        NodeGraph.addNode("First");
        NodeGraph.addNode("Second");
        NodeGraph.addNode("Third");
        NodeGraph.addNode("5");
        NodeGraph.addNode("1");
        NodeGraph.addNode("2");
        NodeGraph.addNode("3");
        NodeGraph.ConnectNodes("First","Second");
        NodeGraph.ConnectNodes("5","Second");
        NodeGraph.ConnectNodes("First","Third");
        NodeGraph.ConnectNodes("Third","5");
        DrawClass frame = new DrawClass(NodeGraph);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setVisible(true);
    }
}
