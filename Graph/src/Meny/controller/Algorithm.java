package Meny.controller;

import Meny.model.*;

public abstract class Algorithm {
    private Graph NewGraph; // The Graph
    public Graph GetGraph(){return NewGraph;};
    public void SetGraph(Graph A){NewGraph = A;}

    void FindBridge(Graph A){};
}
