package Block;
import Sprites.BlockSprite;
import User.User;

public class Pared extends Block {

    public Pared() {
        sprite = BlockSprite.DAY;
        speed = 0.00;
        id = 1;
    }

    
    @Override
    public String getSprite() {
       switch(sprite) {
           case DAY:
               return "[ ]";
           case NIGHT:
               return "[ ]";
           default:
               return "[ ]";
       }
    }

    @Override
    public void setSprite(String sprite) {
        switch(sprite) {
            case "DAY":
                this.sprite = BlockSprite.DAY;
                break;
            case "NIGHT":
                this.sprite = BlockSprite.NIGHT;
                break;
            default:
                this.sprite = BlockSprite.DAY;
                break;
        }
    }


    @Override
    public boolean canStep(User user) {
        return false;
    }
    
}