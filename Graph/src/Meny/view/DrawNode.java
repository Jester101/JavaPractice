package Meny.view;

import java.awt.*;
import java.awt.Graphics;

public class DrawNode {

    private double xPos;
    private  double yPos;
    private Meny.view.Graphics graphics;
    private final String text;

    private Color color;

    public DrawNode(String text, double xPos, double yPos) {
        setPos(xPos,yPos);
        this.text = text;
        setGraphics(graphics);
        color = new Color(Color.BLACK.getRGB());
        draw(color);
    }

    public void setPos(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getxPos() {
        return (int)xPos;
    }

    public int getyPos() {
        return (int)yPos;
    }

    public void draw(Color color) {
     //   graphics.drawOval((int)xPos,(int)yPos,80,80,color.getRGB());
        setText(text);
      //  drawBackGround(Color.WHITE);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setText(String text) {
      //  graphics.drawText((int)xPos,(int)yPos,text,color.getRGB());
    }

    public String getName(){
        return text;
    }

    void setGraphics(Meny.view.Graphics graphics) {
        this.graphics = graphics;
    }
}
