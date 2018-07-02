package Meny.MainFrame;

import Meny.MainFrame.Panels.MainWindow;
import Meny.model.*;
import Meny.view.DrawGraph;

import javax.swing.*;
import java.awt.*;

public class Launcher extends JFrame {

    private MainWindow mainWindow;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Launcher().setVisible(true));
    }

    private Launcher() {

        mainWindow = new MainWindow();
        mainWindow.setSize(new Dimension(800,600));
        mainWindow.setMaximumSize(new Dimension(600,600));
        setSize(new Dimension(800,600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setContentPane(mainWindow);
        pack();
        setLocationRelativeTo(null);
        init();
    }

    private void init() {

        mainWindow.setNameForControlPanel("Find Bridges Algorithm");
        Graph<SimpleNode> NodeGraph = new Graph(SimpleNode::new);

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

        System.out.println(mainWindow == null);
        System.out.println(mainWindow.getVisualPanel() == null);
        System.out.println(mainWindow.getVisualPanel().getGraphics());

        Graphics gr = mainWindow.getVisualPanel().getGraphics();

        DrawGraph drawGraph = new DrawGraph(NodeGraph);
        if(mainWindow.getVisualPanel().getGraphics() != null)
            drawGraph.drawGraph(mainWindow.getVisualPanel());
        //DrawGraph drawGraph = new DrawGraph(NodeGraph,new SwingGraphics(this,panel.getGraphics()));

    }


}