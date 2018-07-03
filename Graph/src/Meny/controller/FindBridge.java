package Meny.controller;
import Meny.MainFrame.Panels.EditPanel;
import Meny.MainFrame.Panels.MainWindow;
import Meny.MainFrame.Panels.View;
import Meny.model.Edge;
import Meny.model.*;
import Meny.view.DrawGraph;

import javax.swing.*;
import java.util.ArrayList;

public class FindBridge extends Algorithm {

    /*value required for the algorithm*/
    private int time = 0;
    private int S[] ;
    private int Up[] ;
    private boolean Res[] ;
    private EditPanel editor;
    private DrawGraph drawGraph;
    /**/

    private ArrayList<SimpleNode> nodes ;
    private ArrayList<Edge> edgesOfBridge;

    public FindBridge(Graph N)
    {
        NewGraph = N;
        nodes = N.getNodes();
        edgesOfBridge = new ArrayList<>() ;
    }

    @Override
    public void setGraph(Graph A) {
        super.setGraph(A);
    }

    public void setDrawClass(MainWindow panel) {
        drawGraph = new DrawGraph(NewGraph);
        drawGraph.setView(panel);
    }

    public void buildGraph(String[] list) {
        if(list == null)
            return;
        if(NewGraph == null) {
            Graph<SimpleNode> graph = new Graph<>(SimpleNode::new);
            setGraph(graph);
        }
        ArrayList<SimpleNode> nodes = new ArrayList<>();
        for(int i=0; i<list.length; ++i) {
            String s = list[i];
            String[] items = s.split(("\\W+"));
            ArrayList<String> temp = new ArrayList<>();
            for (int j = items.length - 1; j >= 0; --j) {
                if (!NewGraph.checkNode(items[j])) {
                    NewGraph.addNode(items[j]);
                }
                if (j == 0) {
                    for (String str : temp) {
                        NewGraph.ConnectNodes(items[0], str);
                    }
                } else
                    temp.add(items[j]);
            }
            temp.clear();
        }
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
    public ArrayList<Edge> FindBridges()
    {
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
        return edgesOfBridge;
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
                DPS(to, v);
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
