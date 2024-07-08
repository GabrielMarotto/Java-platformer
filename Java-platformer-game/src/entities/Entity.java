package entities;

public abstract class Entity {

    protected float x,y; //Protected = classes that extend it can use it

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }

}
