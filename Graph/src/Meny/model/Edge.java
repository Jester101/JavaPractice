package Meny.model;

import Meny.model.SimpleNode;
import Meny.view.DrawEdge;

public class Edge {

    private SimpleNode sourceNode;  //исходный узел
    private SimpleNode destNode; //конечный  узел
    private boolean isBrtide = false;

    DrawEdge picture;

    Edge(SimpleNode sourceNode, SimpleNode destNode) {
        this.sourceNode = sourceNode;
        this.destNode = destNode;
    }

    public void setStatus(boolean status) {
        isBrtide = status;
    }

    public void setBridge(boolean status) {
        isBrtide = status;
        for (Edge edge : destNode.getEdgesList()) {
            if (edge.destNode.getName().equals(sourceNode.getName()))
                edge.setStatus(true);
        }
    }
    public boolean getStatus() { return isBrtide;}
    public SimpleNode getSourceNode() {
        return sourceNode;
    }

    public SimpleNode getDestNode() {
        return destNode;
    }

    public void setSourseNode(SimpleNode sourceNode) {
        if (sourceNode!=null){
            this.sourceNode = sourceNode;
        }
    }
    public void setDestNode(SimpleNode destNode){
        if (destNode!=null){
            this.destNode = destNode;
        }
    }

    public void setPicture(DrawEdge picture) {
        this.picture = picture;
    }

    public DrawEdge getPicture() {
        return picture;
    }
}
