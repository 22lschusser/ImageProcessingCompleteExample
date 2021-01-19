
import processing.core.PApplet;
public class ImageProcessingCompleteExample extends PApplet{

    final int NUM_PANELS_HORIZONTAL = 4; // the horizontal quantity of panels
    final int NUM_PANELS_VERTICAL = 4; // the vertical quantity of panels
    private Panel[] panels;

    private static PApplet app;

    //make main class
    public static void main(String[] args) {

        PApplet.main("ImageProcessingCompleteExample");
    }

    public ImageProcessingCompleteExample(){
        super();
    }

    public void setup(){
        panels = new Panel[NUM_PANELS_HORIZONTAL * NUM_PANELS_VERTICAL];

        int index = 0;
        for (int i = 0; i < NUM_PANELS_VERTICAL; i++){
            for (int j = 0; j < NUM_PANELS_HORIZONTAL; j++){
                int w = j * width/NUM_PANELS_HORIZONTAL;
                int h = i * height/NUM_PANELS_VERTICAL;
                int x = j * w;
                int y = i * h;
                Panel s;
                if (i % 4 == 0){
                    s = new Panel(this, x, y, w, h, index);
                } else if (i % 4 == 1) {
                    s = new TintedPanel( this, x, y, w, h, index);
                } else if (i % 4 == 2){
                    s = new ContrastedPanel( this, x, y, w, h, index);
                } else {
                    s = new RotatingPanel( this, x, y, w, h, index);
                }
                s.setupImage("data/bunny.png");
                panels[index] = s;
                index++;
            }
        }
    }

    public void settings() {
        super.settings();
        setSize(600, 600);
    }

    public void draw(){
        fancyBackground();

        for (int i = 0; i < panels.length; i++){
            Panel s = panels[i];
            s.display();
        }
    }

    public void mouseClicked(){
        for (int i = 0; i < panels.length; i++){
            Panel s = panels[i];
            int mouseX;
            s.handleMouseClicked(s.getPApplet().mouseX, s.getPApplet().mouseY);
        }
    }

    private void fancyBackground(){
        loadPixels();

        for (int x = 0; x < width; x++ ) {
            for (int y = 0; y < height; y++ ) {

                int loc = x + y * width;

                if (x % 2 == 0) {
                    pixels[loc] = color(255);
                } else {
                    pixels[loc] = color(0);
                }
            }
        }

        updatePixels();
    }
}
