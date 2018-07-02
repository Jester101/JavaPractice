package Meny.MainFrame;

import javax.swing.*;
import java.awt.*;

import Meny.MainFrame.Panels.View;
import  Meny.view.Graphics;

public class SwingGraphics implements Graphics {

    private final JPanel mainFrame;
    private final java.awt.Graphics graphics;

    public SwingGraphics(JPanel panel, java.awt.Graphics graphics) {
        this.mainFrame = panel;
        this.graphics = graphics;
        System.out.println(graphics);
    }

    @Override
    @SuppressWarnings("SuspiciousNameCombination")
    public void drawOval(int x, int y, int width, int height, int rgb) {

        Color color = new Color((rgb));
        System.out.println(mainFrame.getGraphics());
        View view = new View();
        view.setPreferredSize(new Dimension(50,50));
//        mainFrame.getGraphics().setColor(Color.BLACK);
//        mainFrame.getGraphics().fillOval(y, x, width, height);
//        Graphics2D g2 = (Graphics2D)graphics;
//        g2.setColor(color);
//        g2.drawLine(0,0,500,500);
        graphics.setColor(color);
      //  graphics.fillOval(y, x, width, height);
        graphics.drawRect(50,50,100,100);
        mainFrame.add(view);
        view.paintComponents(graphics);
    }

    @Override
    public void drawText(int x, int y, String text, int rgb) {
        char[] symbols = text.toCharArray();
        graphics.setColor(new Color(rgb));
        graphics.drawChars(symbols, 0, symbols.length, x, y);
    }

    @Override
    public void drawLine(int startX, int startY, int endX, int endY, int rgb) {

        graphics.setColor(new Color(rgb));
        graphics.drawLine(startX, startY, endX, endY);
    }

}
