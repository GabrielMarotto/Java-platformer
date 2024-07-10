package entities;

public abstract class Entity {

    protected float x,y; //Protected = classes that extend it can use it
    protected int width, height;

    public Entity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

}
