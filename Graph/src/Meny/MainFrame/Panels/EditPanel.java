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
    private JComboBox<String> other_sourse_list = new JComboBox<>();
    private JComboBox<String> dest_list = new JComboBox<>();

    private JButton build_graph_button = new JButton("Build Graph");
    private JButton edit_node_button = new JButton("Add Node");
    private JButton remove_node_button = new JButton("Delete Node");

    private JButton addConnectionButton = new JButton("Add Edge");
    private JButton removeConnectionButton = new JButton("Delete Edge");

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
        list_area.setMinimumSize(new Dimension(200,150));
        add(list_area, constraints);
        add(build_graph_button, constraints);
        add(new JLabel("Isert:Source node name"),constraints);
        add(sourse_node_name, constraints);
        add(new JLabel("Isert:List of neighbors nodes"),constraints);
        add(connection, constraints);
        add(edit_node_button, constraints);
        add(remove_node_button, constraints);
        add(new JLabel("Source node name"),constraints);
        add(sourse_list, constraints);
        add(new JLabel("Dest node name"),constraints);
        add(other_sourse_list, constraints);
        add(new JLabel("List of neighbors nodes"),constraints);
        add(dest_list, constraints);
        add(addConnectionButton, constraints);
        add(removeConnectionButton,constraints);
    }

    public String[] getTextArea() {
        if(!list_area.getText().isEmpty())
            return  list_area.getText().split("\\n");
        return null;
    }

    public String getEditNode() {return  sourse_node_name.getText();}

    public String[] getConnection() {
        if(!connection.getText().isEmpty())
           return  connection.getText().split("\\W");
        return null;
    }

    public String getFirstSelected() {return  sourse_list.getSelectedItem().toString();}

    public String getDeleteSelected() {return  dest_list.getSelectedItem().toString();}

    public String getSeconsSelected() {return  other_sourse_list.getSelectedItem().toString();}

    public void setGraph(Graph g) {
        graph = g;
        sourse_list.removeAllItems();
        other_sourse_list.removeAllItems();
        ArrayList<SimpleNode> nodes = graph.getNodes();
        for (SimpleNode node :nodes) {
            sourse_list.addItem(node.getName());
            other_sourse_list.addItem(node.getName());
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
        constraints.insets = new Insets(2, 2, 2, 2);
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
        addConnectionButton.addActionListener(listener);
    }
    public void addRemoveConnectionButtonListener(ActionListener listener) {
        removeConnectionButton.addActionListener(listener);
    }
}
