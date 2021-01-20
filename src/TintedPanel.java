import processing.core.PApplet;
public class TintedPanel extends Panel {

    public TintedPanel(PApplet _pApplet, int _x, int _y, int _width, int _height, int _identifier){
        super(_pApplet, _x, _y, _width, _height, _identifier);// calling the super/parent class constructor
    }

    // overriding the inherited display method
    public void display(){
        getPApplet().tint(255, 0, 200);
        super.display(); // calling the inherited display method
        getPApplet().noTint();// turns off tint effect after the image is displayed
    }
}

