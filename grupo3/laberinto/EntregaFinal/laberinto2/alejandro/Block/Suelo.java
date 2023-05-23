package Block;
import Sprites.BlockSprite;
import User.User;

public class Suelo extends Block {

    public Suelo() {
        sprite = BlockSprite.DAY;
        speed = 1.00;
        id = 0;
    }

    
    @Override
    public String getSprite() {
       switch(sprite) {
           case DAY:
               return "___";
           case NIGHT:
               return "  _";
           default:
               return "___";
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
       return true;
    }
    
}
