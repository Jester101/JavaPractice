public class DFS {
    private graph NewGraph ;

    private int time = 0;
    private int S[] ;
    private int Up[] ;
    private boolean Res[] ;

    public DFS(graph A)
    {
        NewGraph = A;

        S = new int[NewGraph.GetNumNodes()]; // Start
        Up = new int[NewGraph.GetNumNodes()]; // End
        Res = new boolean[NewGraph.GetNumNodes()]; // Most or no?


        for(int i = 0;i < NewGraph.GetNumNodes();i++)
        {
            if (S[i] == 0)
            {
                FindMost(i,0);
            }
        }
    }

    public void FindMost(int v,int p)// k - номер/номер в списке
    {
        Res[v] = true;
        S[v] = Up[v] = time++;

        for(node elem: NewGraph.GetNodeOfIndex(v).GetList()) {

            int to = NewGraph.GetPosOfNode(elem);
            if (to == p) continue;
            if (Res[to]) {
                Up[v] = Math.min(Up[v], S[to]);

            } else {
                FindMost(to, v);
                Up[v] = Math.min(Up[v], Up[to]);
                if (Up[to] > S[v]) {
                    System.out.print(NewGraph.GetNodeOfIndex(v).GetName());
                    System.out.print(' ');
                    System.out.println(NewGraph.GetNodeOfIndex(to).GetName());
                }
            }
        }
    }
    void ShowRes()
    {

    }
}
