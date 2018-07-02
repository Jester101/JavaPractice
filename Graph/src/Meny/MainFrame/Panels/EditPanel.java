package Meny.MainFrame.Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EditPanel extends JPanel {

    private JLabel name_label = new JLabel("Redact Area");
    private JTextArea list_area = new JTextArea();
    private JTextField sourse_node_name = new JTextField();
    private JTextField dest_node_name = new JTextField();
    private JComboBox<String> sourse_list = new JComboBox<>();
    private JComboBox<String> dest_list = new JComboBox<>();

    private JButton build_graph_button = new JButton("Build Graph");
    private JButton edit_node_button = new JButton("Add Node");
    private JButton remove_node_button = new JButton("Delete Node");

    private GridBagLayout layout = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();

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
        add(dest_node_name, constraints);
        add(edit_node_button, constraints);
        add(sourse_list, constraints);
        add(dest_list, constraints);
        add(remove_node_button, constraints);
    }

    private void initConstrains() {
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill   = GridBagConstraints.HORIZONTAL;
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

    public void addEditButtonListener(ActionListener listener) {
        edit_node_button.addActionListener(listener);
    }

    public void addRemoveButtonListener(ActionListener listener) {
        remove_node_button.addActionListener(listener);
    }

}
