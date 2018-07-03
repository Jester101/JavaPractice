package Meny.controller;

import Meny.model.*;

import javax.swing.*;
import java.util.ArrayList;

public abstract class Algorithm {
    protected Graph NewGraph;
    public Graph GetGraph(){return NewGraph;};
    public void setGraph(Graph A){NewGraph = A;}

    void FindBridge(Graph A){};
}
