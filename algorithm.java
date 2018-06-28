public class algorithm {
    private graph NewGraph ;

    public algorithm()
    {

    }

    public static void main(String[] args) {
        graph NewGraph = new graph();
        NewGraph.AddNode(1);
        NewGraph.AddNode(2);
        NewGraph.AddNode(3);
        NewGraph.AddNode(4);

        NewGraph.CreateRelat(1,2);
        NewGraph.CreateRelat(2,3);
        NewGraph.CreateRelat(3,4);


        NewGraph.ShowGraph();
        DFS start = new DFS(NewGraph);

    }

}

