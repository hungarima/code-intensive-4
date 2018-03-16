package base;

import game.player.Player;
import game.square.Square;
import physic.BoxCollider;

import java.awt.*;
import java.util.Vector;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager(); //chi co duy nhat mot object gameobjectmanager

    private Vector<GameObject> vector = new Vector<>();
    private Vector<GameObject> temp = new Vector<>();

    //chi dc phep khoi tao object trong class nay, ngoai class thi ko dc
    private GameObjectManager() {
    }

    public void runAll() {
        this.vector
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.run());
        this.vector.addAll(this.temp);
        this.temp.clear();
    }

    public void renderAll(Graphics graphics) {
        this.vector
                .stream()
                .filter(gameObject -> gameObject.isAlive) //loc object dang song
                .forEach(gameObject -> gameObject.render(graphics));
    }

    public Player getPlayer() {
        return (Player) this.vector
                .stream()
                .filter(gameObject -> gameObject instanceof Player) //duyet tat ca phan tu sao cho thoa dien kien truyen (thuc chat true || false) vao thi lay
                .findFirst() //phan tu dau tien
                .orElse(null); // neu ko lay dc tra null
    }

    public Square checkCollision(BoxCollider other) {
        return (Square) this.vector
                .stream()
                .filter(gameObject -> gameObject.isAlive) //lay object con song
                .filter(gameObject -> gameObject instanceof Square) //Lay con Square
                .filter(gameObject -> {
                    BoxCollider boxCollider = ((Square) gameObject).boxCollider; //Lay BoxCollider
                    return boxCollider.checkCollider(other); // lay square dang co box chong len nhau
                })
                .findFirst()
                .orElse(null);
    }

    public void add(GameObject gameObject) {
        this.temp.add(gameObject);
    }
}
