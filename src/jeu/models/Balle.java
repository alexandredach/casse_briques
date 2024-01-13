package jeu.models;

import jeu.CasseBrique;

import java.awt.*;

public class Balle extends Sprite {


    private int diametre;
    private int vitesseHorizontale;
    private int vitesseVerticale;


    public Balle(int x, int y, int diametre) {
        super(x, y, Color.magenta);

//        this.x = x;
//        this.y = y;
//        this.couleur = Color.magenta;
        this.diametre = diametre;
        this.vitesseHorizontale = 8;
        this.vitesseVerticale = 7;

    }

    public Balle(int diametre) {
        super(
                (int)(Math.random() * CasseBrique.LARGEUR),
                (int)(Math.random() * CasseBrique.HAUTEUR),
                new Color((float)Math.random(),(float)Math.random(),(float)Math.random())
        );
        this.diametre = diametre;
        this.vitesseHorizontale = (int)(Math.random() * 5) + 2;
        this.vitesseVerticale = (int)(Math.random() * 5) + 2;
    }

    public int getCentreX() {
        return x + diametre;
    }

    public int getCentreY() {
        return y + diametre;
    }
    public void deplacement() {
        x += vitesseHorizontale;
        y += vitesseVerticale;

        if (x >= CasseBrique.LARGEUR - diametre *2 || x <= 0) {
            vitesseHorizontale = -vitesseHorizontale;
        }

        if (y >= CasseBrique.HAUTEUR - diametre *2 || y <= 0) {
            vitesseVerticale = -vitesseVerticale;
        }
    }

    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(x,y,diametre,diametre);
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

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
}
