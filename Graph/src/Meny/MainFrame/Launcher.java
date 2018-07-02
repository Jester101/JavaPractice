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

       // mainWindow.setNameForControlPanel("Find Bridges Algorithm");
        Graph<SimpleNode> NodeGraph = new Graph(SimpleNode::new);
        NodeGraph.addNode("First");
        NodeGraph.addNode("Second");
        NodeGraph.addNode("Third");
        NodeGraph.ConnectNodes("First","Second");
        NodeGraph.ConnectNodes("First","Third");

        System.out.println(mainWindow == null);
        System.out.println(mainWindow.getVisualPanel() == null);
        System.out.println(mainWindow.getVisualPanel().getGraphics());

        Graphics gr = mainWindow.getVisualPanel().getGraphics();

        DrawGraph drawGraph = new DrawGraph(NodeGraph);
        if(mainWindow.getVisualPanel().getGraphics() != null)
            drawGraph.drawGraph(new SwingGraphics((JPanel)mainWindow.getVisualPanel(),gr));
        //DrawGraph drawGraph = new DrawGraph(NodeGraph,new SwingGraphics(this,panel.getGraphics()));

    }


}
