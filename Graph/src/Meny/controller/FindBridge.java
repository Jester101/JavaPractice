package Meny.controller;
import Meny.MainFrame.Panels.EditPanel;
import Meny.MainFrame.Panels.MainWindow;
import Meny.MainFrame.Panels.View;
import Meny.model.Edge;
import Meny.model.*;
import Meny.view.DrawGraph;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FindBridge extends Algorithm {

    /*value required for the algorithm*/
    private int time = 0;
    private int S[] ;
    private int Up[] ;
    private boolean Res[] ;
    private EditPanel editor;
    private DrawGraph drawGraph;
    private Timer timer;
    private int flag = -1;
    private int step;
    /**/

    private ArrayList<SimpleNode> nodes ;
    private ArrayList<Edge> edgesOfBridge;
    private ArrayList<Edge> WayOfbridge;
    private ArrayList<SimpleNode> tmpNodes = new ArrayList<>();

    public ArrayList<Edge> GetWat()
    {
        return WayOfbridge;
    }

    public FindBridge(Graph N)
    {
        WayOfbridge = new ArrayList<>();
        NewGraph = N;
        nodes = N.getNodes();
        edgesOfBridge = new ArrayList<>() ;
    }

    @Override
    public void setGraph(Graph A) {

        NewGraph = A;
        nodes = NewGraph.getNodes();
        if(drawGraph != null)
            drawGraph.setGraph(A);
    }

    public void setDrawClass(MainWindow panel) {
        drawGraph = new DrawGraph(NewGraph);
        drawGraph.setView(panel);
    }

    private boolean isBridge(Edge edge,ArrayList<Edge> list) {
        String one = edge.getDestNode().getName();
        String two = edge.getSourceNode().getName();
        for(int i=0;i<list.size();++i) {
            Edge ed = list.get(i);
            if((ed.getDestNode().getName().equals(one))&&(ed.getSourceNode().getName().equals(two))) {
                step = i;
                return true;
            }
        }
        return false;
    }

    public void buildGraph(String[] list) {

        Graph<SimpleNode> graph = new Graph<>(SimpleNode::new);
        if(list == null)
            return;
//        if(graph == null) {
//            Graph<SimpleNode> graph = new Graph<>(SimpleNode::new);
//            setGraph(graph);
//        }
        ArrayList<SimpleNode> nodes = new ArrayList<>();
        for(int i=0; i<list.length; ++i) {
            String s = list[i];
            String[] items = s.split(("\\W+"));
            ArrayList<String> temp = new ArrayList<>();
            for (int j = items.length - 1; j >= 0; --j) {
                if (!graph.checkNode(items[j])) {
                    graph.addNode(items[j]);
                }
                if (j == 0) {
                    for (String str : temp) {
                        graph.ConnectNodes(items[0], str);
                    }
                } else
                    temp.add(items[j]);
            }
            temp.clear();
        }
        setGraph(graph);
        editor.setGraph(NewGraph);
        drawGraph.drawGraph();
    }

    public void AddNode(String s,String[] list) {
        if(list == null)
            return;
        if(!NewGraph.checkNode(s)){
            NewGraph.addNode(s);
        }
        for(String name:list) {
            System.out.println(name);
            if(!NewGraph.checkNode(name)){
                NewGraph.addNode(name);
            }
            NewGraph.ConnectNodes(s,name);
        }
        editor.setGraph(NewGraph);
        drawGraph.drawGraph();
    }
    public void DeleteNode(String s) {
        if(NewGraph.checkNode(s)){
            NewGraph.deleteNode(s);
        }
        editor.setGraph(NewGraph);
        drawGraph.drawGraph();
    }

    public void addConnection(String first, String second) {
        if((NewGraph.checkNode(first))&&(NewGraph.checkNode(second))) {
            SimpleNode firstNode = (SimpleNode)NewGraph.findByName(first);
            firstNode.addEdge(NewGraph.findByName(second));
        }
        drawGraph.drawGraph();
    }

    public void deleteConnection(String first, String second){
        if((NewGraph.checkNode(first))&&(NewGraph.checkNode(second))) {
            SimpleNode firstNode = (SimpleNode)NewGraph.findByName(first);
            firstNode.deleteConnection(second);
        }
        drawGraph.drawGraph();
    }

    public void setEditor(EditPanel editor) {
        this.editor = editor;
    }
    public void setFrame(JFrame frame) {
        drawGraph.setFrame(frame);
    }
    public ArrayList<Edge> FindBridges(boolean step_by_step)
    {
        edgesOfBridge.clear();
        WayOfbridge.clear();
        NewGraph.clearBridges();
        int kolNodes = GetGraph().getNodes().size();//bred
        S = new int[kolNodes]; // Star
        Up = new int[kolNodes]; // End
        Res = new boolean[kolNodes]; // Most or no

        for(int i = 0;i < kolNodes;i++)
        {
            if (S[i] == 0)
            {
                DPS(i,0);
            }
        }

        flag = 0;
        if(step_by_step) {
            timer = new Timer(500,e-> updateNode());
            timer.setRepeats(true);
            timer.start();
            System.out.println(edgesOfBridge);
            System.out.println(WayOfbridge);
        }
        else {
            for(Edge ed:edgesOfBridge)
                ed.setBridge(true);
            drawGraph.drawGraph();
        }
        return edgesOfBridge;
    }

    public void updateNode() {
        for(SimpleNode node:tmpNodes) {
            node.setChoosen(false);
        }
        tmpNodes.clear();
        if(WayOfbridge.size() != 0) {
            if (flag == 0) {
                tmpNodes.add(WayOfbridge.get(0).getDestNode());
                tmpNodes.get(0).setChoosen(true);
                tmpNodes.add(WayOfbridge.get(0).getSourceNode());
                tmpNodes.get(1).setChoosen(true);
                if (isBridge(WayOfbridge.get(0),edgesOfBridge))
                    ++flag;
                WayOfbridge.remove(0);
            }
            else {
                flag = 0;
                edgesOfBridge.get(step).setBridge(true);
                System.out.println("status");
            }
            drawGraph.drawGraph();
            return;
        }
        if((timer!=null)&&(timer.isRunning())) {
            timer.stop();
        }
        for(SimpleNode node:tmpNodes) {
            node.setChoosen(false);
        }
        tmpNodes.clear();
        flag = -1;
    }

    void setDefaults() {
        for (SimpleNode node: nodes) {
            node.setChoosen(false);
        }
        NewGraph.clearBridges();
    }

    public void ManualStep() {
        if(flag == -1) {
            FindBridges(false);
            setDefaults();
        }
        updateNode();
    }

    public void DPS(int v,int p)
    {
        Res[v] = true;
        S[v] = Up[v] = time++;

        SimpleNode elem;
        for(Edge TMP: nodes.get(v).getEdgesList()) {

            if(nodes.get(v) != TMP.getDestNode())
            {
                elem = TMP.getDestNode();
            }
            else
            {
                elem = TMP.getSourceNode();
            }
            //int to = NewGraph.GetPosOfNode(elem);
            int to = nodes.indexOf(elem);
            if (to == p) continue;
            if (Res[to]) {
                Up[v] = Math.min(Up[v], S[to]);

            } else {
                WayOfbridge.add(TMP);
                DPS(to, v);
                WayOfbridge.add(TMP);
                Up[v] = Math.min(Up[v], Up[to]);
                if (Up[to] > S[v]) {

                    for(Edge elemEdge:nodes.get(v).getEdgesList())
                    {
                        if (nodes.get(v) == elemEdge.getDestNode())
                        {
                            if (nodes.get(to) == elemEdge.getSourceNode())
                            {
                                edgesOfBridge.add(elemEdge);
                            }
                        }

                        else
                        {
                            if (nodes.get(to) == elemEdge.getDestNode())
                            {
                                edgesOfBridge.add(elemEdge);
                            }
                        }
                    }
                }
            }
        }
    }
}
