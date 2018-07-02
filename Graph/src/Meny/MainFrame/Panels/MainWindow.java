package Meny.MainFrame.Panels;

import javax.swing.*;
import java.awt.*;
import Meny.model.*;

public class MainWindow extends JPanel {

    private ControllPanel controll_panel = new ControllPanel();
    private EditPanel edit_panel = new EditPanel();
    private View visual_panel;
    private GridBagLayout layout = new GridBagLayout();
    private GridBagConstraints constraints = new GridBagConstraints();

    public MainWindow() {

        super(null);
        initConstrains();
        visual_panel = new View();
        setLayout(layout);
        setPanelSize(edit_panel, new Dimension(240,600));
        setPanelSize(controll_panel, new Dimension(360,120));
        visual_panel.setPreferredSize(new Dimension(600,600));
        visual_panel.setVisible(true);
        /*/

        * * * *     * * * * * *
        * * * *     * * * * * *

        * * * *     * * * * * *
        * * * *     * * * * * *
        * * * *     * * * * * *
        * * * *     * * * * * *
        * * * *     * * * * * *
        * * * *     * * * * * *
        * * * *     * * * * * *
        * * * *     * * * * * *
         */

       // setElementSize(1,1);
        add(edit_panel, constraints);
        setElementPos(0,1);
       // setElementSize(1,1);
        add(controll_panel,constraints);
        setElementPos(1,0);
        setElementSize(3,3);
        add(visual_panel,constraints);
        System.out.println(visual_panel.getGraphics());
    }

    private void initConstrains() {
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.fill   = GridBagConstraints.HORIZONTAL;
        constraints.gridheight = 1;
        constraints.gridwidth  = 1;
        //constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(2, 2, 2, 2);
        constraints.ipadx = 0;
        constraints.ipady = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
    }

    private void setElementPos(int x, int y) {

        constraints.gridx = x;
        constraints.gridy = y;
    }

    private void setElementSize(int height, int width) {

        constraints.gridheight = height;
        constraints.gridwidth = width;
    }

    public View getVisualPanel() {
        return visual_panel;
    }

    public void setNameForControlPanel(String name) {

        controll_panel.setName(name);
    }

    private void setPanelSize(JPanel panel , Dimension size) {
        panel.setPreferredSize(size);
    }

    private void setPanelMinimumSize(JPanel panel , Dimension size) {
        panel.setMinimumSize(size);
    }
}
