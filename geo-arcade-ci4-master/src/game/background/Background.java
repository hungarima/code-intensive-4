package game.background;

import base.GameObject;
import utils.Utils;

public class Background extends GameObject {

    public Background() {
        this.image = Utils.loadImage("resources/background/background.png");
    }
}
