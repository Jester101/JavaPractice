package Meny.MainFrame.Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ControllPanel extends JPanel {

    private final JButton run_algorithm = new JButton("Start algorithm");
    private final JButton run_manual = new JButton("Start manually");
    private  JCheckBox run_by_step = new JCheckBox("Step by step solution");
    private JLabel algorithm_name = new JLabel();
    private GridBagLayout layout = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();

    public  ControllPanel() {

        super(null);
        initConstrains();
        setLayout(layout);
        add(algorithm_name, constraints);
        add(run_algorithm, constraints);
        add(run_manual, constraints);
        add(run_by_step,constraints);
    }

    public  ControllPanel(String name) {

        super(null);
        initConstrains();
        setLayout(layout);
        setAlgorithmName(name);
        add(algorithm_name, constraints);
        add(run_algorithm, constraints);
        add(run_manual, constraints);
        add(run_by_step,constraints);
    }

    private void initConstrains() {

        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill   = GridBagConstraints.BOTH;
        constraints.gridheight = 1;
        constraints.gridwidth  = GridBagConstraints.REMAINDER;
        constraints.gridx = GridBagConstraints.RELATIVE;
        constraints.gridy = GridBagConstraints.RELATIVE;
        constraints.insets = new Insets(1, 2, 3, 4);
        constraints.ipadx = 0;
        constraints.ipady = 0;
        constraints.weightx = 0.0;
        constraints.weighty = 0.0;
    }

    public void addAlgButtonListener(ActionListener listener) {
        run_algorithm.addActionListener(listener);
    }

    public void addManualButtonListener(ActionListener listener) {
        run_manual.addActionListener(listener);
    }

    void setAlgorithmName(String name) {

        algorithm_name.setText(name);
    }
}
