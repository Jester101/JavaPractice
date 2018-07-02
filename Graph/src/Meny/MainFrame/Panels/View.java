package Meny.MainFrame.Panels;

import Meny.model.SimpleNode;
import Meny.view.DrawEdge;
import Meny.view.DrawNode;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JPanel {

    private ArrayList<DrawNode> nodes;

    public View() {
        super(null);
        nodes = new ArrayList<>();
    }

    @Override
    public void paintComponents(Graphics g) {

        Graphics2D grap = (Graphics2D)g;
        grap.setColor(Color.BLACK);
        grap.drawLine(10,5,20,20);
    }

}
