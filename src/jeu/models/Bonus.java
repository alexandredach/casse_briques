package jeu.models;

import jeu.CasseBrique;

import java.awt.*;

public class Bonus extends Rond {

    private int vitesseVerticale;

    public Bonus(int x, int y) {
        super(x, y, Color.blue);
        this.setVitesseVerticale(3);
        this.setVitesseHorizontale(0);
    }
    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(x,y,this.getDiametre(), this.getDiametre());
        dessin.drawString("B",x + this.getDiametre() ,y + this.getDiametre() / 2);

    }

}
