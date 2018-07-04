package Meny.model;

public interface NodeFactory<T extends Node> {
    T createNode(String name);
}
