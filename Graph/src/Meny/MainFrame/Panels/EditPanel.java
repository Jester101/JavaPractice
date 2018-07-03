package Meny.MainFrame.Panels;

import Meny.controller.ChangeListener;
import Meny.model.Edge;
import Meny.model.Graph;
import Meny.model.Node;
import Meny.model.SimpleNode;
import com.sun.org.apache.bcel.internal.generic.SIPUSH;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditPanel extends JPanel {

    private JLabel name_label = new JLabel("Redact Area");
    private JTextArea list_area = new JTextArea();
    private JTextField sourse_node_name = new JTextField();
    private JTextField connection = new JTextField();
    private JComboBox<String> sourse_list = new JComboBox<>();
    private JComboBox<String> dest_list = new JComboBox<>();

    private JButton build_graph_button = new JButton("Build Graph");
    private JButton edit_node_button = new JButton("Add Node");
    private JButton remove_node_button = new JButton("Delete Node");

    private JButton addConnection = new JButton("Add Edge");
    private JButton removeConnection = new JButton("Add Edge");

    private GridBagLayout layout = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();

    private Graph graph;

    public EditPanel() {

        super(null);
        initConstrains();
        setLayout(layout);
        name_label.setMaximumSize(new Dimension(Integer.MAX_VALUE, name_label.getMinimumSize().height));
        add(name_label, constraints);
        list_area.setPreferredSize(new Dimension(220, 200));
        add(list_area, constraints);
        add(build_graph_button, constraints);
        add(sourse_node_name, constraints);
        add(connection, constraints);
        add(edit_node_button, constraints);
        add(sourse_list, constraints);
        add(dest_list, constraints);
        add(remove_node_button, constraints);
    }

    public String[] getTextArea() {return  list_area.getText().split("\\n");}

    public String getEditNode() {return  sourse_node_name.getText();}

    public String[] getConnection() {return  connection.getText().split(" ");}

    public String getFirstSelected() {return  sourse_list.getSelectedItem().toString();}

    public String getSeconsSelected() {return  dest_list.getSelectedItem().toString();}

    public void setGraph(Graph g) {
        graph = g;
        ArrayList<SimpleNode> nodes = graph.getNodes();
        for (SimpleNode node :nodes) {
            sourse_list.addItem(node.getName());
        }
        ChangeListener listener = new ChangeListener(this);
        sourse_list.addItemListener(listener);
    }

    public void updateBox() {
        String s = getFirstSelected();
        dest_list.removeAllItems();
        SimpleNode node = (SimpleNode)graph.findByName(s);
        for(Edge ed:node.getEdgesList()) {
            dest_list.addItem(ed.getDestNode().getName());
        }
    }

    private void initConstrains() {
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill   = GridBagConstraints.BOTH;
        constraints.gridheight = 1;
        constraints.gridwidth  = 1;
        constraints.gridx = 0;
        constraints.gridy = GridBagConstraints.RELATIVE;
        constraints.insets = new Insets(10, 10, 8, 8);
        constraints.ipadx = 0;
        constraints.ipady = 0;
        constraints.weightx = 0.0;
        constraints.weighty = 0.0;
    }

    public void addBuildButtonListener(ActionListener listener) {
        build_graph_button.addActionListener(listener);
    }

    public void addEditNodeButtonListener(ActionListener listener) {
        edit_node_button.addActionListener(listener);
    }

    public void addRemoveNodeButtonListener(ActionListener listener) {
        remove_node_button.addActionListener(listener);
    }

    public void addEditConnectionButtonListener(ActionListener listener) {
        addConnection.addActionListener(listener);
    }

    public void addRemoveConnectionButtonListener(ActionListener listener) {
        removeConnection.addActionListener(listener);
    }
}
