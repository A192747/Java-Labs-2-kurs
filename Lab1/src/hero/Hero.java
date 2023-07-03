package hero;
import move.*;

public class Hero {
    private Move moveStrategy = new Stay();

    public void move() {
        this.moveStrategy.move();
    }
    public void setMoveStrategy(Move move) {
        this.moveStrategy = move;
    }
}
