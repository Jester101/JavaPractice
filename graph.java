import java.util.ArrayList;

public class graph {
    private ArrayList<node> nodes;

    public graph()
    {
        nodes = new ArrayList<node>();
    }
    public int GetNumNodes()
    {

        return nodes.size();
    }
    public  node GetNodeOfIndex(int a)
    {
        return nodes.get(a);
    }
    public void AddNode(int N)
    {
        nodes.add(new node(N));
    }
    public void CreateRelat(int a,int b)
    {
        node E1 = new node();
        node E2 = new node();
        int flag = 0;
        for(node elem : nodes){
            if (elem.GetName() == a)
            {
                E1 = elem;
                flag++;
                if(flag == 2)
                {
                    break;
                }
            }
            if (elem.GetName() == b)
            {
                E2 = elem;
                flag++;
                if(flag == 2)
                {
                    break;
                }
            }
        }
        if (flag == 2)
        {
            E1.AddEdge(E2);
            E2.AddEdge(E1);
        }
    }
    public void ShowGraph()
    {
        for(node elem : nodes){
            elem.ShowRelateNode();
        }
    }
}
