package Meny.view;

public interface Graphics {

    void drawOval(int x, int y, int width, int height, int rgb);
    void drawText(int x, int y, String text, int rgb);
    void drawLine(int startX, int startY, int endX, int endY, int rgb);
}
