package base;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2D set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }


    public Vector2D set(Vector2D vector2D) {
        return this.set(vector2D.x, vector2D.y);
    }


    public Vector2D addUp(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public Vector2D addUp(Vector2D vector2D) {
        this.x += vector2D.x;
        this.y += vector2D.y;
        return this.addUp(vector2D.x, vector2D.y);
    }

    public Vector2D add(float x, float y) {
        return new Vector2D(this.x + x, this.y + y);
    }

    public Vector2D add(Vector2D vector2D) {
        //return new base.Vector2D(this.x + vector2D.x, this.y + vector2D.y);
        return this.add(vector2D.x, vector2D.y);
    }

    public Vector2D substractBy(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    public Vector2D substractBy(Vector2D vector2D) {
        return this.addUp(vector2D.x, vector2D.y);
    }

    public Vector2D subtract(float x, float y) {
        return new Vector2D(this.x - x, this.y - y);
    }

    public Vector2D subtract(Vector2D vector2D) {
        return this.subtract(vector2D.x, vector2D.y);
    }

    public Vector2D multiply(float number) {
        this.x *= number;
        this.y *= number;
        return this;
    }

    public Vector2D clone() {
        return new Vector2D(this.x, this.y);
    }

    public float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public Vector2D normalize() {
        float length = this.length();
        return new Vector2D(this.x / length, this.y / length);
    }

    public Vector2D rotate(Double angle) {
        Double radian = Math.toRadians(angle);
        Double cos = Math.cos(radian);
        Double sin =Math.sin(radian);
        return new Vector2D((float)(cos * this.x - sin * this.y), (float)(sin * this.x + cos * this.y));
    }

}
