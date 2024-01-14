package jeu.models;

import java.awt.*;

public class Rectangle extends Sprite {

    protected int largeur;
    protected int hauteur;

    public Rectangle(int x, int y, Color couleur, int largeur, int hauteur) {
        super(x, y, couleur);
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public boolean collision(Rond rond) {
        // si la balle touche la barre = collision

        return rond.getCentreX() > x
                && rond.getCentreX() < x + largeur
                && rond.getCentreY() > y
                && rond.getCentreY() < y + hauteur +20;
    }


    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }


    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillRect(x,y,largeur,hauteur);
    }
}
