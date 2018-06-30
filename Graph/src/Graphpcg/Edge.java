package Graphpcg;

public class Edge {

    private SimpleNode sourceNode;  //исходный узел
    private SimpleNode destNode; //конечный  узел

    Edge(SimpleNode sourceNode, SimpleNode destNode) {
        this.sourceNode = sourceNode;
        this.destNode = destNode;
    }

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
}
