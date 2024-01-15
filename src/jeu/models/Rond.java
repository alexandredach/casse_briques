package jeu.models;

import jeu.CasseBrique;

import java.awt.*;

public class Rond extends Sprite {

    private int vitesseHorizontale;
    private int vitesseVerticale;
    private int diametre;

    public Rond(int x, int y, Color couleur) {
        super(x, y, couleur);
        this.diametre = 20;
    }

    public void deplacement() {
        x += vitesseHorizontale;
        y += vitesseVerticale;

        if (x >= CasseBrique.LARGEUR - diametre -5 || x <= 0) {
            vitesseHorizontale = -vitesseHorizontale;
        }

        if (y >= CasseBrique.HAUTEUR - diametre *2 || y <= 0) {
            vitesseVerticale = -vitesseVerticale;
        }
    }

    public void basEcran() {
        if (y >= CasseBrique.HAUTEUR - diametre *2) {
            vitesseVerticale = -vitesseVerticale;
        }
    }

    public int getDiametre() {
        return diametre;
    }

    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }

    public int getVitesseHorizontale() {
        return vitesseHorizontale;
    }

    public void setVitesseHorizontale(int vitesseHorizontale) {
        this.vitesseHorizontale = vitesseHorizontale;
    }

    public int getVitesseVerticale() {
        return vitesseVerticale;
    }

    public void setVitesseVerticale(int vitesseVerticale) {
        this.vitesseVerticale = vitesseVerticale;
    }

    public int getCentreX() {
        return x + diametre;
    }

    public int getCentreY() {
        return y + diametre;
    }


    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(x,y,diametre,diametre);
    }
}
