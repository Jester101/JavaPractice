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
        for(int i =0;i <nodes.size();++i) {
            if(nodes.get(i).getName().equals(name)) {
                String name_for_delete = nodes.get(i).getName();
                nodes.remove(i);
                for(T node:nodes) {
                    node.deleteConnection(name_for_delete);
                }
            }
        }
    }

    public void clearBridges() {
        for(T node:nodes) {
            for(Edge edge:node.getEdgesList()) {
                edge.setStatus(false);
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
