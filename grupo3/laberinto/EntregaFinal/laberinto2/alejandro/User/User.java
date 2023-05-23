package User;
import Position.Position;
import Sprites.PlayerSprite;
import World.World;
import Block.Block;
import Entity.Entity;

public class User extends Entity{
    
    public User() {
        super();
        position = new Position(1, 1);
    }
    public boolean isMounted;
    public Entity mount;
    
    public Position getPosition() {
        return super.getPosition();
    }

    protected void setPosition(double x, double y) {
        super.setPosition(x, y);
    }

    public String getSprite() { 
        switch (this.sprite) {
            case DEFAULT:
                return " @ ";
            case ALT:
                return "[@]";
            default:
                return " @ ";
            
        }
    }
    public void setSprite(String sprite) {
        switch (sprite) {
            case "DEFAULT":
                this.sprite = PlayerSprite.DEFAULT;
                break;
            case "ALT":
                this.sprite = PlayerSprite.ALT;
                break;
            default:
                this.sprite = PlayerSprite.DEFAULT;
                break;
        }
    }

    public void move(String direccion){
        switch (direccion) {
                case "w":
                    if ((int) Math.floor(this.position.getX()) > 0) {
                        int xPosition = (int) Math.floor(this.position.getX());
                        xPosition -= World.getBlock(this.position).getSpeed();
                        Block nextStep = World.getBlock(new Position(xPosition, this.position.getY()));
                        if(nextStep.canStep(this))
                        this.position.setX(xPosition);
                    }
                    break;
                case "a":
                    if ((int) Math.floor(this.position.getY()) > 0) {
                        int yPosition = (int) Math.floor(this.position.getY());
                        yPosition -= World.getBlock(this.position).getSpeed();
                        Block nextStep = World.getBlock(new Position(this.position.getX(), yPosition));
                        if(nextStep.canStep(this))
                        this.position.setY(yPosition);
                    }
                    break;
                case "s":
                    if ((int) Math.floor(this.position.getX()) < World.getRows() - 1) {
                        int xPosition = (int) Math.floor(this.position.getX());
                        xPosition+= World.getBlock(this.position).getSpeed();
                        Block nextStep = World.getBlock(new Position(xPosition, this.position.getY()));
                        if(nextStep.canStep(this))
                        this.position.setX(xPosition);
                    }
                    break;
                case "d":
                    if ((int) Math.floor(this.position.getY()) < World.getColumns() - 1) {
                        int yPosition = (int) Math.floor(this.position.getY());
                        yPosition+= World.getBlock(this.position).getSpeed();
                        Block nextStep = World.getBlock(new Position(this.position.getX(), yPosition));
                        if(nextStep.canStep(this))
                        this.position.setY(yPosition);
                        
                    }
                    break;
                default:
                    System.out.println("Dirección inválida.");
                    break;
            }
    }
}
