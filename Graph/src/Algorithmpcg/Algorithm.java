package Algorithmpcg;

import Graphpcg.*;

public abstract class Algorithm {
    private Graph NewGraph; // The Graph
    Graph GetGraph(){return NewGraph;};
    void SetGraph(Graph A){NewGraph = A;}

    void FindBridge(Graph A){};
}
