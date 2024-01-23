package jeu.models;

import jeu.CasseBrique;

import java.awt.*;

public class Bouton extends Rectangle {

    protected String texte;

    protected EvenementBouton evenement;
    public Bouton(String texte,int x,int y) {
        super(
                x,
                y,
                new Color(147, 180, 194),
                80,
                30);
                this.texte = texte;
    }

    public void addEvenementBouton(EvenementBouton evenement) {
        this.evenement = evenement;
    }

    public void clic() {
        evenement.declenche();
    }

    public boolean collision(int xSouris, int ySouris) {
        return xSouris > this.x
                && xSouris < this.x + this.largeur
                && ySouris > this.y
                && ySouris < this.y + this.hauteur;
    }

    @Override
    public void dessiner(Graphics2D dessin) {
        super.dessiner(dessin);
        dessin.setColor(Color.black);
        dessin.drawString(texte,x + 15,y +20);
    }



}
