package Graphpcg;

public abstract class Node {

    Node(String name) {

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
}

