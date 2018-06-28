import java.util.ArrayList;

public class node {
    private int name;
    private ArrayList<node> relateNode;
    public node()
    {

    }
    public node(int NameNode)
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
    public int GetName()
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
