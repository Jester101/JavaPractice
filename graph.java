import java.util.ArrayList;

/*
    nodes - вершины в графе(type node)

    GetNumNodes - Return количесвто вершин
    GetNodeOfIndex - Return вершину по индексу
    AddNode - Добавляет вершину в граф
    CreateRelat - создаёт ребро между вершинами
    ShowGraph - Выводит информауию о графе: Вершина1 : В2 ... Вs
 */
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
        /*Создали две вершины*/
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
        /*
            Присвоили этим вершинам вершины из спика в графе
        */
        if (flag == 2) // если две вершины СУЩЕСТВУЮТ
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
