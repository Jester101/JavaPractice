

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
        try
        {
            for(SimpleNode node: nodes) {

                Object obj = graph.insertVertex(parent, null, node.getName(),
                        (rnd.nextInt(500 - 100 + 1)),
                        (rnd.nextInt(500 - 100 + 1)),
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


        /*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
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
        NodeGraph.ConnectNodes("First","Second");
        NodeGraph.ConnectNodes("First","Third");
        DrawClass frame = new DrawClass(NodeGraph);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setVisible(true);
    }
}
