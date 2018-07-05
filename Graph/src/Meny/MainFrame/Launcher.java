package Meny.MainFrame;

import Meny.MainFrame.Panels.ControllPanel;
import Meny.MainFrame.Panels.EditPanel;
import Meny.MainFrame.Panels.MainWindow;
import Meny.controller.FindBridge;
import Meny.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Launcher extends JFrame {

    private MainWindow mainWindow;
    private JMenuBar menuBar;
    private JMenu menu, submenu;
    private JButton importGraph, helpButton;
    private File file;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Launcher().setVisible(true));
    }

    private Launcher() {

        menuBar = new JMenuBar();
        importGraph = new JButton("import...");
        menu = new JMenu("File...");
        helpButton = new JButton("help");
        menu.add(importGraph);
        menuBar.add(menu);
        menuBar.add(helpButton);

        setJMenuBar(menuBar);
        mainWindow = new MainWindow();
        mainWindow.setSize(new Dimension(800, 600));
        mainWindow.setMaximumSize(new Dimension(600, 600));
        setPreferredSize(new Dimension(900, 750));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(mainWindow, BorderLayout.WEST);
        setContentPane(mainWindow);
        setResizable(false);
        pack();
        mainWindow.setLocation(10, 10);
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
        addImportFileListener(e -> {
            try {
                findBridge.buildGraph(GetGrapgFromFile());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        HelpFileListener(e -> {
            try {
                Help();
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        });


        ControllPanel control = mainWindow.getControllPanel();

        control.addAlgButtonListener(e -> findBridge.FindBridges(control.getRun_by_step()));
        control.addManualButtonListener(e -> findBridge.ManualStep());

    }

    public void addImportFileListener(ActionListener listener) {
        importGraph.addActionListener(listener);
    }

    public void HelpFileListener(ActionListener listener) {
        helpButton.addActionListener(listener);
    }

    private String[] GetGrapgFromFile() throws Exception {
        JFileChooser fileopen = new JFileChooser();

        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();


            if ("txt".equals(file.getName().substring(file.getName().length() - 3))) {
                Scanner In = new Scanner(file);
                String input = "";

                while (In.hasNextLine()) {
                    input += In.nextLine();
                    input += '\n';
                }


                return input.split("\\n");
            }
        }
        return null;
    }

    public void Help() throws MalformedURLException, FileNotFoundException {

        ClassLoader cl = this.getClass().getClassLoader();
        final String path = "/com/abc/xyz/Help.html";
        file = new File("test.html");
        InputStream stream = getClass().getResourceAsStream(path);
        OutputStream out = new FileOutputStream(file);
        try {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = stream.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        System.out.println(url.getPath());
//        try {
//            Desktop.getDesktop().open(new File(url.getFile()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            Desktop.getDesktop().browse(url.toURI());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }

    }
}
