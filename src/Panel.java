import processing.core.PApplet;
import processing.core.PImage;

public class Panel {
    // private instance variables
    private PImage img;
    private int x;
    private int y;
    private int w;
    private int h;
    private int identifier;
    private PApplet pApplet;

    // constructor
    public Panel(PApplet _pApplet, int _x, int _y, int _w, int _h, int _identifier) {
        pApplet = _pApplet;
        x = _x;
        y = _y;
        w = _w;
        h = _h;
        identifier = _identifier;
    }

    public void setupImage(String imageName) {
        img = getPApplet().loadImage(imageName);
    }

    public void display() {
        pApplet.image(img, x, y, w, h);
    }

    public void handleMouseClicked(int _x, int _y) {
        System.out.println("Mouse clicked " + Integer.toString(identifier));
    }

    public void handleKeyPressed(char key) {
        System.out.println(key);
    }

    public PImage getImage() {
        return img;
    }

    public PApplet getPApplet() {
        return pApplet;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int _x) {
        x = _x;
    }

    public void setY(int _y) {
        y = _y;
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }
}
