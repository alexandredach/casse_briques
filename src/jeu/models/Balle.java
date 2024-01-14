package jeu.models;

import jeu.CasseBrique;

import java.awt.*;

public class Balle extends Rond {


//    public Balle(int x, int y) {
//        super(x, y, Color.magenta);
//        this.vitesseHorizontale = 8;
//        this.vitesseVerticale = 7;
//    }

    public Balle(int diametre) {
        super(
                (int)(Math.random() * CasseBrique.LARGEUR),
                (int)(Math.random() * CasseBrique.HAUTEUR),
                new Color((float)Math.random(),(float)Math.random(),(float)Math.random())
        );
        this.setVitesseHorizontale((int)(Math.random() * 5) + 2);
        this.setVitesseVerticale((int)(Math.random() * 5) + 2);
        this.setDiametre(diametre);
    }


}
