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
    public ArrayList<node> GetList()
    {
        return nodes;
    }
    /*Добавлено независимый регистр*/
    //Раньше: добавлена вершина 4 первая, регситр 1
    //Теперь:добавлена вершина 4 первая, регистр 4


    public  node GetNodeOfIndex(int a)
    {
        return nodes.get(a);
    }
    public  node GetNodeOfName(String a)
    {
        node ans = new node();
        for(node elem : nodes)
        {
            if (elem.GetName() == a)
            {
                ans = elem;
                break;
            }
        }
        return ans;
    }
    public  String GetPosOfName(String a)
    {
        String pos = "";
        for(node elem : nodes)
        {
            if (elem.GetName() == a)
            {
                pos = elem.GetName();
                break;
            }
        }
        return pos;
    }
    public  int GetPosOfNode(node a)
    {
        int pos = 0;
        for(node elem : nodes)
        {
            if (elem == a)
            {

                break;
            }
            pos++;
        }
        return pos;
    }





    public void AddNode(String N)
    {
        nodes.add(new node(N));
    }
    public void CreateRelat(String a,String b)
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
