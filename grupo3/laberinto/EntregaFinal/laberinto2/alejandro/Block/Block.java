package Block;

import java.util.List;

import Entity.Entity;

import Sprites.BlockSprite;
import User.User;


public abstract class Block {
    protected BlockSprite sprite;
    protected double speed;
    protected Integer id;
    protected List<Entity> transitList;

    public double getSpeed() {
        return this.speed;
    }
    public abstract String getSprite();
    public abstract void setSprite(String sprite);

    public abstract boolean canStep(User user);

    public Integer getId() {
        return this.id;
    }
    public List<Entity> getTransitList() {
        return this.transitList;
    }



}
