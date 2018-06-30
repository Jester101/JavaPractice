import java.util.ArrayList;

/*
        Дорогой Станислав

    Я реализовал так, что каждая врешина типа Node хрнаится в себе вершины типа Node
    Т.к. ребро это две вершины, первая это вершина даннаого экзэмпляра, а вторая один из элементов в массиве

 */
public class Node {
    public static void main(String[] args) {
        /*Test*/
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");

        a.AddEdge(b);
        a.AddEdge(b);// +
        a.AddEdge(c);
        a.DeleteEdge(b);
        a.AddEdge(a);// +
        a.DeleteEdge(d);
        a.AddEdge(d);
        a.ShowRelateNode();
    }

    private String NameNode;
    private ArrayList<Node> RelateNode= new ArrayList<Node>(); // смежные Веришны с данной. По типу 1: 2,3;   2:1   3:1


    //Эти два метода я реализовал для себя, но я считаю, что они не бдудут лишними
    public Node(String name)
    {
        NameNode = name;
    }
    public String GetName()
    {
        return NameNode;
    }



    public void DeleteEdge(Node n)
    {
        RelateNode.remove(n);
        n.RelateNode.remove(n);
        /*
        1. Удаление из данной вершины
        2. Удаление из смежной
         */
    }
    public boolean CheckNode(Node n)
    {
        /*
        1.Проверка на смежность(true/false)
        */
        if( RelateNode.contains(n) == true )
        {
            return true;
        }
        return false;
    }
    public void AddEdge(Node n)
    {
        /*
        1. Проверка на принадлежность
        2. Т.к. не ориентированный, то а -> а не имеет смысла
        */
        if (CheckNode(n) == false && this != n)
        {
            RelateNode.add(n);
        }
    }
    public void ShowRelateNode()
    {
        System.out.print("Из Вершины " + GetName() + ": ");
        for(Node elem : RelateNode){
            System.out.print(elem.GetName() + ' ');
        }
    }
}
