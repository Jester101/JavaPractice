package Algorithmpcg;
import Graphpcg.*;

import javax.naming.Name;
import java.util.ArrayList;

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
