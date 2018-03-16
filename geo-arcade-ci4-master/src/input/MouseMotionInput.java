package input;

import base.Vector2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

//Nhiem vu bat su kien motion cua chuot va thong cho nhung thang khac khi no su MouseMotionInput
// ko the cho phep tao nhieu nhieu object dc
//chi can mot object nay di lang nghe thoi
//giong nhu gameobject manager
//su dung singleton
public class MouseMotionInput implements MouseMotionListener {

    public static MouseMotionInput instance = new MouseMotionInput();

    public Vector2D position;

    private MouseMotionInput() {
        this.position = new Vector2D();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.position.set(e.getX(), e.getY());
    }
}
