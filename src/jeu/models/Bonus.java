package jeu.models;

import jeu.CasseBrique;

import java.awt.*;

public class Bonus extends Rond {

    public Bonus(int x, int y) {
        super(x, y, Color.yellow);
        this.setVitesseVerticale(3);
        this.setVitesseHorizontale(0);
    }
    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(x,y,this.getDiametre(), this.getDiametre());
        dessin.setColor(Color.black);
        dessin.drawString("B",x + this.getDiametre() -14 ,y + this.getDiametre() -6);

    }

}
