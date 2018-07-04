package Meny.model;

import java.util.ArrayList;

public abstract class Node {

    public Node(String name) {

        setName(name);
    }
    private String node_name;

    public String getName() {

        return node_name;
    }

    private void setName(String name) {

        node_name = name;
    }
    abstract void addEdge(Node node);
    abstract void deleteConnection(String name);
    public abstract ArrayList<Edge> getEdgesList();
}

