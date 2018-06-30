package Graphpcg;

public interface NodeFactory<T extends Node> {
    T createNode(String name);
}
