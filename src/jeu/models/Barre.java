package jeu.models;

import jeu.CasseBrique;

import java.awt.*;

public class Barre extends Rectangle {

    protected int vitesse = 35;

    public Barre() {
        super(
                0,
                CasseBrique.HAUTEUR - 100,
                new Color(241,127,0),
                100,
                20);

        this.x = CasseBrique.LARGEUR / 2 - this.largeur / 2;

    }

    public void deplacerGauche() {
        if (x > 0) {
            x -= vitesse;
        }
    }
    public void deplacerDroite() {
        if (x < CasseBrique.LARGEUR - largeur) {
            x += vitesse;
        }
    }



}
