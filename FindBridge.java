package Graphpcg;

import java.util.ArrayList;

public class FindBridge extends Algorithm{



    /*value required for the algorithm*/
    private int time = 0;
    private int S[] ;
    private int Up[] ;
    private boolean Res[] ;
    /**/

    private ArrayList<SimpleNode> nodes ;
    public FindBridge(Graph N)
    {
        SetGraph(N);
        nodes = N.getNodes();
    }


    public void FindBridges()
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
    }

    public void DPS(int v,int p)
    {
        Res[v] = true;
        S[v] = Up[v] = time++;

        //GetNodeOfIndex - get
        //nodes.get()

        SimpleNode elem;
        for(Edge TMP: nodes.get(v).getEdgesList()) { //pass through the list of adjacent vertices
            elem= TMP.getDestNode();
            //int to = NewGraph.GetPosOfNode(elem);
            int to = nodes.indexOf(elem);
            if (to == p) continue;
            if (Res[to]) {
                Up[v] = Math.min(Up[v], S[to]);

            } else {
                DPS(to, v);
                Up[v] = Math.min(Up[v], Up[to]);
                if (Up[to] > S[v]) {
                
                   /*OUTPUT*/
                    System.out.print(nodes.get(v).getName());
                    System.out.print(' ');
                    System.out.println(nodes.get(to).getName());
                   /**/ 
                    
                }
            }
        }
    }
}
