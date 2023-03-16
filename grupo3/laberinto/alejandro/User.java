public class User {
    private int xPosition;
    private int yPosition;

    private char userIcon = '@';

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }
    public int getxPosition() {
        return xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
    public int getyPosition() {
        return yPosition;
    }

    public char getUserIcon() {
        return userIcon;
    }
}
