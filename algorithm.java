public class algorithm {
    /*Основная цель - работа с графом*/
    public static void main(String[] args) {
        graph NewGraph = new graph();
        NewGraph.AddNode("1");
        NewGraph.AddNode("2");
        NewGraph.AddNode("3");

        NewGraph.CreateRelat("1","2");
        NewGraph.CreateRelat("3","1");

        NewGraph.ShowGraph();
        DFS start = new DFS(NewGraph);
        //start.ShowRes();
    }

}

