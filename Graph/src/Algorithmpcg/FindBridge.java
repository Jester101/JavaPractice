package Algorithmpcg;
import Graphpcg.*;

import java.util.ArrayList;

public class FindBridge extends Algorithm{



    /*value required for the algorithm*/
    private int time = 0;
    private int S[] ;
    private int Up[] ;
    private boolean Res[] ;
    /**/

    private ArrayList<SimpleNode> nodes ;
    private ArrayList<Edge> edgesOfBridge;
    public FindBridge(Graph N)
    {
        SetGraph(N);
        nodes = N.getNodes();
        edgesOfBridge = new ArrayList<>() ;
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
