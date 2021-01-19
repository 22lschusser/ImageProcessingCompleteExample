import processing.core.PApplet;
import processing.core.PImage;
public class ContrastedPanel extends Panel {

    public ContrastedPanel(PApplet _pApplet, int _x, int _y, int _width, int _height, int _identifier){
        super(_pApplet, _x, _y, _width, _height, _identifier);
    }

    public void display(){
        PImage newImg = getImage().copy(); // apply contrasting to a COPY of the original
        newImg.loadPixels();

        // apply the contrast to the new image
        for (int y = 0; y < newImg.height; y++){
            for (int x = 0; x < newImg.width; x++){
                int loc = x + y * newImg.width;
                if (getPApplet().brightness(newImg.pixels[loc]) > 190){
                    newImg.pixels[loc] = getPApplet().color(255); // if very bright, then make it white
                } else {
                    newImg.pixels[loc] = getPApplet().color(0, 0); // if not very bright, make completely transparent
                }
            }
        }
        newImg.updatePixels();
        getPApplet().image(newImg, getX(), getY(), getWidth(), getHeight());
    }

}


