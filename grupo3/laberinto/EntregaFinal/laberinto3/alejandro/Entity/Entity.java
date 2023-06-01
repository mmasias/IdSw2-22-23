package Entity;

import Position.Position;
import Sprites.PlayerSprite;

public abstract class Entity {
    protected Position position;
    protected PlayerSprite sprite;
    protected boolean canBeMounted;
    protected boolean isBeingRidden;

    public abstract String getSprite();

    public abstract void setSprite(String sprite);

    public Position getPosition() {
        return position;
    }

    protected void setPosition(double x, double y) {
        this.position = new Position(x, y);
    }

    protected void setPosition(Position position) {
        this.position = position;
    }

    protected abstract void move(String direccion);

    public Entity() {
        sprite = PlayerSprite.DEFAULT;
        position = new Position(0, 0);
    }
}