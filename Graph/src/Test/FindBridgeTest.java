package Test;
import Algorithmpcg.FindBridge;
import Graphpcg.*;
import java.util.*;
import java.io.*;
import javax.naming.Name;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FindBridgeTest {

        private Graph<SimpleNode> NodeGraph= new Graph(SimpleNode::new);
        private Map<String,String> TestInput= new HashMap<String , String>();
        private ArrayList<Edge> Bridges ;
        private FindBridge OutputAlgorithm;
        private ConvertEdgeToMap OutputMap = new ConvertEdgeToMap();

        /*
        * 1 вершина
        * 2 вершины
        * 2 вершины - 1 ребро
        * 3 вершины 2 ребра
        * 1 ребро
        * 3 вершины 3 ребра
        * Big date1
        * */

        @org.junit.Test
        public void OneNode() { // нет мостов
            NodeGraph.addNode("Витебск");

            OutputAlgorithm = new FindBridge(NodeGraph);
            assertEquals(TestInput,OutputMap.Convert(OutputAlgorithm.FindBridges()));
        }
        @org.junit.Test
        public void TwoNodes() { // нет мостов
            NodeGraph.addNode("Витебск");
            NodeGraph.addNode("Санкт-Петербург");

            OutputAlgorithm = new FindBridge(NodeGraph);
            assertEquals(TestInput,OutputMap.Convert(OutputAlgorithm.FindBridges()));
        }
        @org.junit.Test
        public void TwoNodesOneBridge() { // нет мостов
            NodeGraph.addNode("Витебск");
            NodeGraph.addNode("Санкт-Петербург");
            NodeGraph.ConnectNodes("Санкт-Петербург","Витебск");

            OutputAlgorithm = new FindBridge(NodeGraph);

            TestInput.put("Санкт-Петербург","Витебск");
            assertEquals(TestInput,OutputMap.Convert(OutputAlgorithm.FindBridges()));
        }
        @org.junit.Test
        public void ThreeNodesTreeBridges() { //3 вершины - 2 мост
            NodeGraph.addNode("Витебск");
            NodeGraph.addNode("Санкт-Петербург");
            NodeGraph.addNode("Могилёв");
            NodeGraph.ConnectNodes("Санкт-Петербург","Витебск");
            NodeGraph.ConnectNodes("Могилёв","Витебск");
            NodeGraph.ConnectNodes("Могилёв","Санкт-Петербург");

            OutputAlgorithm = new FindBridge(NodeGraph);

            assertEquals(TestInput,OutputMap.Convert(OutputAlgorithm.FindBridges()));
        }
        @org.junit.Test
        public void ThreeNodesTwoBridges() { //3 вершины - 2 мост
            NodeGraph.addNode("Витебск");
            NodeGraph.addNode("Санкт-Петербург");
            NodeGraph.addNode("Могилёв");
            NodeGraph.ConnectNodes("Санкт-Петербург","Витебск");
            NodeGraph.ConnectNodes("Могилёв","Витебск");

            OutputAlgorithm = new FindBridge(NodeGraph);

            TestInput.put("Санкт-Петербург","Витебск");
            TestInput.put("Могилёв","Витебск");
            assertEquals(TestInput,OutputMap.Convert(OutputAlgorithm.FindBridges()));
        }
        @org.junit.Test
        public void OneBridge() { //3 вершины - 2 мост
            NodeGraph.ConnectNodes("Санкт-Петербург","Витебск");

            OutputAlgorithm = new FindBridge(NodeGraph);

            assertEquals(TestInput,OutputMap.Convert(OutputAlgorithm.FindBridges()));
        }
        @org.junit.Test
        public void BidGate1() { //3 вершины - 2 мост
            NodeGraph.addNode("Могилев");
            NodeGraph.addNode("Минск");
            NodeGraph.addNode("Витебск");
            NodeGraph.addNode("Гомель");

            NodeGraph.addNode("Санкт-Петербург");
            NodeGraph.addNode("Москва");
            NodeGraph.addNode("Архангельск");

            NodeGraph.addNode("New-York");
            NodeGraph.addNode("LosAngeles");


            NodeGraph.ConnectNodes("Могилев","Минск");
            NodeGraph.ConnectNodes("Могилев","Гомель");
            NodeGraph.ConnectNodes("Могилев","Витебск");
            NodeGraph.ConnectNodes("Минск","Витебск");
            NodeGraph.ConnectNodes("Минск","New-York");
            NodeGraph.ConnectNodes("LosAngeles","New-York");
            NodeGraph.ConnectNodes("Санкт-Петербург","Витебск");
            NodeGraph.ConnectNodes("Санкт-Петербург","Москва");
            NodeGraph.ConnectNodes("Санкт-Петербург","Архангельск");
            NodeGraph.ConnectNodes("Москва","Архангельск");

            OutputAlgorithm = new FindBridge(NodeGraph);
            TestInput.put("Санкт-Петербург","Витебск");
            TestInput.put("Минск","New-York");
            TestInput.put("Могилев","Гомель");
            TestInput.put("LosAngeles","New-York");
            assertEquals(TestInput,OutputMap.Convert(OutputAlgorithm.FindBridges()));
        }
        @org.junit.Test
        public void BidGate2()  throws IOException{


            String Node;
            File file = new File("src/Test/TestFB/input1.in");
            Scanner In = new Scanner(file);

            int countOfNodes=In.nextInt(), countOfEdges=In.nextInt();
            Node = In.nextLine();
            for(int i = 0; i < countOfNodes; i++)
            {
                Node = In.nextLine();
                NodeGraph.addNode(Node);
            }
            String[] ArrEdge;
            for(int i = 0; i < countOfEdges; i++)
            {
                Node = In.nextLine();
                ArrEdge = Node.split(" ");
                NodeGraph.ConnectNodes(ArrEdge[0],ArrEdge[1]);
            }
            file = new File("src/Test/TestFB/output1.out");
            In = new Scanner(file);
            countOfEdges=In.nextInt();
            Node = In.nextLine();
            for(int i = 0; i < countOfEdges; i++)
            {
                Node = In.nextLine();
                ArrEdge = Node.split(" ");
                TestInput.put(ArrEdge[0],ArrEdge[1]);
            }

            OutputAlgorithm = new FindBridge(NodeGraph);

            assertEquals(TestInput,OutputMap.Convert(OutputAlgorithm.FindBridges()));
        }
        @org.junit.Test
        public void BidGate3()  throws IOException{


        String Node;
        File file = new File("src/Test/TestFB/input2.in");
        Scanner In = new Scanner(file);

        int countOfNodes=In.nextInt(), countOfEdges=In.nextInt();
        Node = In.nextLine();
        for(int i = 0; i < countOfNodes; i++)
        {
            Node = In.nextLine();
            NodeGraph.addNode(Node);
        }
        String[] ArrEdge;
        for(int i = 0; i < countOfEdges; i++)
        {
            Node = In.nextLine();
            ArrEdge = Node.split(" ");
            NodeGraph.ConnectNodes(ArrEdge[0],ArrEdge[1]);
        }
        file = new File("src/Test/TestFB/output2.out");
        In = new Scanner(file);
        countOfEdges=In.nextInt();
        Node = In.nextLine();
        for(int i = 0; i < countOfEdges; i++)
        {
            Node = In.nextLine();
            ArrEdge = Node.split(" ");
            TestInput.put(ArrEdge[0],ArrEdge[1]);
        }

        OutputAlgorithm = new FindBridge(NodeGraph);

        assertEquals(TestInput,OutputMap.Convert(OutputAlgorithm.FindBridges()));
    }


        public class ConvertEdgeToMap
        {
            private Map<String,String> Convert(ArrayList<Edge> a)
            {
                Map<String,String> TestInput = new HashMap<String , String>();
                for(Edge elem: a)
                {
                    TestInput.put(elem.getSourceNode().getName(),elem.getDestNode().getName());
                }
                return TestInput;
            }
        }
    }
