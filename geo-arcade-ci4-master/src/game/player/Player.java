package game.player;

import base.GameObject;
import game.player.bullet.PlayerShoot;
import input.MouseMotionInput;
import utils.Utils;

public class Player extends GameObject {

    private PlayerShoot playerShoot;

    public Player() {
        this.image = Utils.loadImage("resources/player/straight.png");
        this.playerShoot = new PlayerShoot();
//        MouseMotionInput mouseMotionInput = new MouseMotionInput(); //ko the nao khai bao nhu nay, ko listen dc
    }

    @Override
    public void run() {
        super.run();
        this.playerShoot.run(this);
        this.position.set(MouseMotionInput.instance.position); //chinh lai dieu kien de ngan player ra ngoai window
    }
}
