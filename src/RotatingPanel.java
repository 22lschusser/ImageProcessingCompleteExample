import processing.core.PApplet;
public class RotatingPanel extends Panel {
    private float degrees;
    private boolean rotating;

    public RotatingPanel(PApplet _pApplet, int _x, int _y, int _width, int _height, int _identifier) {
        super(_pApplet, _x, _y, _width, _height, _identifier);
        degrees = 1;
        rotating = false;
    }

    public void display() {
        if (!rotating) {
            super.display();
            getPApplet().background(0,0,0);
            getPApplet().textAlign(getPApplet().CENTER);
            getPApplet().text("Click me!", getX() + getWidth()/2, getY() + getHeight()/2);
        } else {
            getPApplet().imageMode(getPApplet().CENTER);
            int x = getX();
            int y = getY();

            getPApplet().push();

            getPApplet().translate(x + getWidth()/2, y + getHeight()/2);
            getPApplet().rotate(getPApplet().radians(degrees));
            degrees+=10;

            setX(0);
            setY(0);
            super.display();
            setX(x);
            setY(y);

            getPApplet().pop();

            getPApplet().imageMode(getPApplet().CORNER);
        }
    }

    public void handleMouseClicked(int _x, int _y) {
        if (_x > getX() && _x < getX() + getWidth() &&
                _y > getY() && _y < getY() + getHeight()) {
            rotating = !rotating;
        }
    }
}
