package jeu.models;

import java.awt.*;

public class Brique extends Rectangle {

    public Brique(int x, int y) {
        super(x, y, new Color((float)Math.random(),(float)Math.random(),(float)Math.random()), 48, 18);
    }
}
