package game.player;

import base.GameObject;
import game.player.bullet.PlayerShoot;
import input.MouseMotionInput;
import physic.BoxCollider;
import utils.Utils;

public class Player extends GameObject {

    private PlayerShoot playerShoot;
    public BoxCollider boxCollider;
    private PlayerHitBullet hitBullet;
    private PlayerHitEnemy hitEnemy;
    private PlayerHitSquare hitSquare;

    public Player() {
        this.image = Utils.loadImage("resources/player/straight.png");
        this.playerShoot = new PlayerShoot();
        this.boxCollider = new BoxCollider(40,40);
        this.hitBullet = new PlayerHitBullet();
        this.hitEnemy = new PlayerHitEnemy();
        this.hitSquare = new PlayerHitSquare();

//        MouseMotionInput mouseMotionInput = new MouseMotionInput(); //ko the nao khai bao nhu nay, ko listen dc
    }

    @Override
    public void run() {
        super.run();

        this.playerShoot.run(this);
        this.position.set(MouseMotionInput.instance.position); //chinh lai dieu kien de ngan player ra ngoai window
        this.boxCollider.position.set(this.position); //put hit box on bullet
        this.hitBullet.run(this);
        this.hitEnemy.run(this);
        this.hitSquare.run(this);

    }

    public void hitBullet() {
        System.out.println("Player Hit Enemy Bullet");
    }

    public void hitEnemy() {
        System.out.println("Player Hit Enemy");
    }

    public void hitSquare() {
        System.out.println("Player Hit Square");
    }
}
