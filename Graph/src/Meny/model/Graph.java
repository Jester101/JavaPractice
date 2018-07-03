package Meny.model;

import java.util.ArrayList;

public class Graph<T extends Node> {

    private ArrayList<T> nodes = new ArrayList<>();

    private final NodeFactory<T> factory;

    public Graph(NodeFactory<T> factory) {
        this.factory = factory;
    }
    public void addNode(String name) {
        T node = factory.createNode(name);
        nodes.add(node);
    }

    public ArrayList<T> getNodes() {
        return nodes;
    }

    public T findByName(String name) {

        for( T obj: nodes) {
            if (obj.getName().equals(name))
                return obj;
        }
        return null;
    }

    public void ConnectNodes(String first, String second) {

        T sourceNode = findByName(first);
        T destNode = findByName(second);
        if ((sourceNode != null) && (destNode != null))
            sourceNode.addEdge(destNode);
        //else
        // throw exeption;
    }

    public  boolean checkNode(String name) {
        for(T node: nodes){
            if(node.getName().equals(name))
                return true;
        }
        return false;
    }

    public void deleteNode(String name) {
        for(T node: nodes) {
            if(node.getName().equals(name)) {
                node.deleteConnection();
                node = null;
            }
        }
    }
}

//public class Graph{
//
//    private ArrayList<SimpleNode> nodes_list;
//
//    Graph() {
//
//        nodes_list = new ArrayList<SimpleNode>();
//    }
//
//    public SimpleNode findByName(String name) {
//
//        for( SimpleNode obj: nodes_list) {
//            if (obj.getNode_name().equals(name))
//                return obj;
//        }
//        return null;
//    }
//
//    public void addNode(String name) {
//
//        SimpleNode node = new SimpleNode(name);
//        nodes_list.add(node);
//    }
//
//    public void ConnectNodes(String first, String second) {
//
//        SimpleNode sourceNode = findByName(first);
//        SimpleNode destNode = findByName(second);
//        if ((sourceNode != null) && (destNode != null))
//            sourceNode.AddEdge(destNode);
//        //else
//            // throw exeption;
//    }
//
//    public ArrayList<SimpleNode> getNodes_list() {
//        return nodes_list;
//    }
//}
