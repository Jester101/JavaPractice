import java.util.ArrayList;

/*
 name - имя вершины(её номер)
 relateNode - список смежых вершин
 GetList - return список смежных вершин
 CheckNode(N) - проверяет, смежна ли вершина с вершиной N
 AddEdge - добавляет ребро между вершмной и вершиной N
 GetName - return имя вершины
 ShowRelateNode - вывод смжных вершин с вершиной
*/
public class node {
    private String name;
    private ArrayList<node> relateNode;
    public node()
    {

    }
    public node(String NameNode)
    {
        name = NameNode;
        relateNode = new ArrayList<node>();
    }
    public ArrayList<node> GetList()
    {
        return relateNode;
    }
    public  boolean CheckNode(node n)
    {
        if( relateNode.contains(n) == true )
        {
            return true;
        }
        return false;
    }
    public void AddEdge(node n)
    {
        /*
        1. Проверка на принадлежность
        2. Т.к. не ориентированный, то а -> а не имеет смысла
        */

        if (CheckNode(n) == false && this != n)
        {
            relateNode.add(n);
        }

    }

    /*
        Next Functions provides additional opportunities
    */
    public int GetNumRelateNodes(){return relateNode.size();}
    public String GetName()
    {
        return name;
    }
    public void ShowRelateNode()
    {
        System.out.print("Из Вершины " + GetName() + ": ");
        for(node elem : relateNode){
            System.out.print(elem.GetName());
            System.out.print(' ');
        }
        System.out.println();
    }
}
