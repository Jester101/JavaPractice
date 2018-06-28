import java.util.ArrayList;


public class Edge {

        public static void main(String[] args) {
            Node a = new Node("a");
            Node b = new Node("b");
            Edge ed = new Edge(a,b);
            Node m = ed.getSourceNode();
            Node n = ed.getDestNode();

            System.out.println(m.GetName());
            System.out.println(n.GetName());

            Node p0 = new Node ("c");
            Node p1 = new Node ("d");
            ed.setSourseNode(p0);
            ed.setDestNode(p1);
            m = ed.getSourceNode();
            n = ed.getDestNode();

            System.out.println(m.GetName());
            System.out.println(n.GetName());


        }
        private Node sourceNode;  //исходный узел
        private Node destNode; //конечный  узел

        Edge(Node sourceNode, Node destNode) {
            this.sourceNode = sourceNode;
            this.destNode = destNode;
        }

        public Node getSourceNode() {
            return sourceNode;
        }

        public Node getDestNode() {
            return destNode;
        }

        public void setSourseNode(Node sourceNode) {
            if (sourceNode!=null){
                this.sourceNode = sourceNode;
            }
        }
        public void setDestNode(Node destNode){
            if (destNode!=null){
                this.destNode = destNode;
            }
        }
}

class Node {
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