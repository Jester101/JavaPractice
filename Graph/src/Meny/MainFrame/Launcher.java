package Meny.MainFrame;

import Meny.MainFrame.Panels.ControllPanel;
import Meny.MainFrame.Panels.EditPanel;
import Meny.MainFrame.Panels.MainWindow;
import Meny.controller.FindBridge;
import Meny.model.*;
import Meny.view.DrawGraph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class Launcher extends JFrame {

    private MainWindow mainWindow;
    private JMenuBar menuBar;
    private JMenu menu, submenu;
    private JButton importGraph;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Launcher().setVisible(true));
    }

    private Launcher() {

        menuBar = new JMenuBar();
        importGraph = new JButton("import...");
        menu = new JMenu("File...");
        menu.add(importGraph);
        menuBar.add(menu);

        setJMenuBar(menuBar);
        mainWindow = new MainWindow();
        mainWindow.setSize(new Dimension(800, 600));
        mainWindow.setMaximumSize(new Dimension(600, 600));
        setPreferredSize(new Dimension(900, 750));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(mainWindow,BorderLayout.WEST);
        setContentPane(mainWindow);
        setResizable(false);
        pack();
        mainWindow.setLocation(10,10);
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() throws Exception {

        mainWindow.setNameForControlPanel("Find Bridges Algorithm");
        Graph<SimpleNode> NodeGraph = new Graph<>(SimpleNode::new);
//        NodeGraph.addNode("Могилев");
//        NodeGraph.addNode("Минск");
//        NodeGraph.addNode("Витебск");
//        NodeGraph.addNode("Гомель");
//
//        NodeGraph.addNode("Санкт-Петербург");
//        NodeGraph.addNode("Москва");
//        NodeGraph.addNode("Архангельск");
//
//        NodeGraph.addNode("New-York");
//        NodeGraph.addNode("LosAngeles");
//
//
//        NodeGraph.ConnectNodes("Могилев","Минск");
//        NodeGraph.ConnectNodes("Могилев","Гомель");
//        NodeGraph.ConnectNodes("Могилев","Витебск");
//        NodeGraph.ConnectNodes("Минск","Витебск");
//        NodeGraph.ConnectNodes("Минск","New-York");
//        NodeGraph.ConnectNodes("LosAngeles","New-York");
//        NodeGraph.ConnectNodes("Санкт-Петербург","Витебск");
//        NodeGraph.ConnectNodes("Санкт-Петербург","Москва");
//        NodeGraph.ConnectNodes("Санкт-Петербург","Архангельск");
//        NodeGraph.ConnectNodes("Москва","Архангельск");
        FindBridge findBridge = new FindBridge(NodeGraph);
        EditPanel edit = mainWindow.getEditPanel();
        findBridge.setDrawClass(mainWindow);
        findBridge.setFrame(this);
        mainWindow.getEditPanel().setGraph(NodeGraph);
        findBridge.setEditor(mainWindow.getEditPanel());
        edit.addBuildButtonListener(e -> findBridge.buildGraph(edit.getTextArea()));
        edit.addEditNodeButtonListener(e -> findBridge.AddNode(edit.getEditNode(), edit.getConnection()));
        edit.addRemoveNodeButtonListener(e -> findBridge.DeleteNode(edit.getEditNode()));
        edit.addEditConnectionButtonListener(e -> findBridge.addConnection(edit.getFirstSelected(), edit.getSeconsSelected()));
        edit.addRemoveConnectionButtonListener(e -> findBridge.deleteConnection(edit.getFirstSelected(), edit.getDeleteSelected()));
        addImportFileListener(e-> {
            try {
                findBridge.buildGraph(GetGrapgFromFile());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        ControllPanel control = mainWindow.getControllPanel();

        control.addAlgButtonListener(e -> findBridge.FindBridges(control.getRun_by_step()));
        control.addManualButtonListener(e-> findBridge.ManualStep());

    }

    public void addImportFileListener(ActionListener listener) {
        importGraph.addActionListener(listener);
    }

    private String[] GetGrapgFromFile()throws Exception
    {
        JFileChooser fileopen = new JFileChooser();

        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();


            if ("txt".equals(file.getName().substring(file.getName().length() - 3)))
            {
                Scanner In = new Scanner(file);
                String input = "";

                while (In.hasNextLine())
                {
                    input +=In.nextLine();
                    input +='\n';
                }


                return input.split("\\n");
            }
        }
        return null;
    }
}
