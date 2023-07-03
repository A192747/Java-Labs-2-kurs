package com.example.Lab1.hero;
import com.example.Lab1.move.*;

public class Hero {
    private Move moveStrategy = new Stay();

    public String move() {
        return this.moveStrategy.move();
    }
    public void setMoveStrategy(Move move) {
        this.moveStrategy = move;
    }
}
