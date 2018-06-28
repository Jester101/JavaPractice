public class DFS {
    private graph NewGraph ;
    private int time = -1;
    private int S[] ;
    private int Up[] ;
    private boolean Res[] ;
    public DFS(graph A)
    {
        NewGraph = A;
        S = new int[NewGraph.GetNumNodes()];
        Up = new int[NewGraph.GetNumNodes()];
        Res = new boolean[NewGraph.GetNumNodes()];
        for(int i = 0;i < NewGraph.GetNumNodes();i++)
        {
            if (S[i] == 0)
            {
                FindMost(0,-1);
            }
        }

    }
    public void FindMost(int v,int p)
    {

        Res[v] = true;
        S[v] = Up[v] = time++;
        for(node elem: NewGraph.GetNodeOfIndex(v).GetList())
        {
            int to = elem.GetName() - 1;
            if(to == p) continue;
            if (Res[to])
            {
                Up[v] = Math.min(Up[v],S[to]);

            }
            else
            {
               FindMost(to,v);
               Up[v] = Math.min(Up[v],Up[to]);
               if (Up[to] > S[v])
               {
                   System.out.print(v+1);
                   System.out.print(' ');
                   System.out.println(to+1);
               }
            }


        }
    }
    void ShowRes()
    {
        for(int i = 0;i < Res.length;i++){
            if (Res[i] == true)
            {
                System.out.println(i+1);
            }
        }
    }
}
