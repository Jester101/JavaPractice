package Meny.model;

import Meny.view.DrawNode;

import java.util.ArrayList;

//public abstract class AbstractNode {
//
//    AbstractNode(String name) {
//
//        setName(name);
//    }
//    private String node_name;
//    public String getNode_name() {
//
//        return node_name;
//    }
//
//    private void setName(String name) {
//
//        node_name = name;
//    }
//    // public abstract ArrayList<Edge> getEdgesList();
//}


/*
 name - имя вершины(её номер)
 relateNode - список смежых вершин
 GetList - return список смежных вершин
 CheckNode(N) - проверяет, смежна ли вершина с вершиной N
 AddEdge - добавляет ребро между вершмной и вершиной N
 GetName - return имя вершины
 ShowRelateNode - вывод смжных вершин с вершиной
*/
public class SimpleNode extends Node{

    public SimpleNode(String name)
    {
        super(name);
        edges_list = new ArrayList<Edge>();
    }

    private ArrayList<Edge> edges_list;
    private DrawNode pictrue;

    public ArrayList<Edge> getEdgesList() {
        return edges_list;
    }

    public void setPictrue(DrawNode pictrue) {
        this.pictrue = pictrue;
    }

    public DrawNode getPictrue() {
        return pictrue;
    }

    public ArrayList<Edge> GetList()
    {
        return edges_list;
    }

    //    public  boolean CheckNode(String name)
//    {
//        if( relateNode.contains(n) == true )
//        {
//            return true;
//        }
//        return false;
//    }
    @Override
    public void addEdge(Node dest_node)
    {
        if(!checkConnection(dest_node)) {
            Edge edge = new Edge(this, (SimpleNode) dest_node);
            edges_list.add(edge);
            ((SimpleNode) dest_node).addEdge(edge);
        }
    }

    @Override
    public void deleteConnection(String name) {
        for(int i =0;i <edges_list.size();++i) {
            if(edges_list.get(i).getDestNode().getName().equals(name)) {
                SimpleNode dest = edges_list.get(i).getDestNode();
                edges_list.remove(i);
                dest.deleteConnection(getName());
            }
        }
    }
    private void addEdge(Edge edge) {

        SimpleNode dest = edge.getSourceNode();
        Edge newEdge = new Edge(this, (SimpleNode)dest);
        edges_list.add(edge);
    }

    public boolean checkConnection(Node node) {
        for(Edge edge : edges_list) {
            if(edge.getDestNode().getName().equals(node.getName()))
                return true;
        }
        return  false;
    }

    /*
        Next Functions provides additional opportunities
    */
//    public int GetNumRelateNodes(){return relateNode.size();}
//    public int GetName()
//    {
//        return name;
//    }
//    public void ShowRelateNode()
//    {
//        System.out.print("Из Вершины " + GetName() + ": ");
//        for(node elem : relateNode){
//            System.out.print(elem.GetName());
//            System.out.print(' ');
//        }
//        System.out.println();
//    }
}
