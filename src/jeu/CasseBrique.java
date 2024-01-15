package jeu;

import jeu.models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class CasseBrique extends Canvas implements KeyListener {

    public static final int LARGEUR = 500;
    public static final int HAUTEUR = 600;

    protected ArrayList<Balle> listeBalle = new ArrayList<>();

    protected ArrayList<Bonus> listeBonus = new ArrayList<>();

    protected ArrayList<Brique> listeBrique = new ArrayList<>();
    protected Barre barre = new Barre();

    public CasseBrique () {

        JFrame fenetre = new JFrame();

        this.setSize(LARGEUR, HAUTEUR);
        this.setBounds(0,0, LARGEUR, HAUTEUR);
        this.setIgnoreRepaint(true);
        this.setFocusable(false);

        fenetre.pack();
        fenetre.setSize(LARGEUR +10, HAUTEUR);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.setResizable(false);
        fenetre.requestFocus();
        fenetre.addKeyListener(this);

        Container panneau = fenetre.getContentPane();
        panneau.add(this);

        fenetre.setVisible(true);
        this.createBufferStrategy(2);

        demarrer();
    }

    public void demarrer() {



        for(int i = 0 ; i < 3 ; i++) {
            listeBalle.add(new Balle(20));
        }

        // créer  10 x 5 briques
        // alimenter l'ArrayList listeBriques
        for(int j = 0 ; j < 101 ; j+=20) {
            for(int k = 0 ; k < 501 ; k += 50) {
                listeBrique.add(new Brique(k,j));
            }
        }



        // création d'une boucle infinie pour rafraîchir la page et donner une impression d'animation
        while(true) {

            try { // try/catch servira à détecter une éventuelle interruption

                Graphics2D dessin = (Graphics2D) this.getBufferStrategy().getDrawGraphics();

                // tout ce qu'on va dessiner sera disposé là
                dessin.setColor(Color.black);
                dessin.fillRect(0,0, LARGEUR, HAUTEUR);

                barre.dessiner(dessin);

                // dessiner briques
                for(Brique brique : listeBrique) {
                    brique.dessiner(dessin);
                }

                for(Balle balle : listeBalle) {
                    balle.dessiner(dessin);
                    balle.deplacement();

                    // pour chaque brique, tester la collision
                    // stocker dans une liste les briques impactées
                    // après le foreach des briques, supprimer les briques impactées
                    // parce qu'on ne peut pas supprimer un élément d'une liste alors qu'on parcourt cette liste

                    ArrayList<Brique> briqueImpact = new ArrayList<>();

                    for(Brique brique : listeBrique) {
//                        brique.collision(balle);
                        if (brique.collision(balle)) {
                            briqueImpact.add(brique);
                            balle.setVitesseVerticale(-balle.getVitesseVerticale());
                        }
                    }

                    for(Brique brique : briqueImpact) {
                        listeBrique.remove(brique);
                        double bonusChance = (Math.random());
                        if(bonusChance < 0.2) {
                            Bonus bonus = new Bonus(brique.getX()+brique.getLargeur() /2, brique.getY() + brique.getHauteur());
                            listeBonus.add(bonus);
                        }
                    }

                    if(barre.collision(balle)) {
                        balle.setVitesseVerticale(-balle.getVitesseVerticale());
                    }

                }

                int foundIndex = -1;
                for(int i = 0; i < listeBonus.size(); i++){
                    Bonus bonus = listeBonus.get(i);
                    bonus.dessiner(dessin);
                    bonus.deplacement();
                    if(barre.collision(bonus)) {
                        foundIndex = i;
                    }
                }

                //  quand barre touche bonus : supprimer et agrandir barre
                if(foundIndex >= 0) {
                    listeBonus.remove(foundIndex);
                    barre.setLargeur(barre.getLargeur() + 10);
                }

                // balles et bonus > sort si touche bas écran
                listeBalle.removeIf(balle -> balle.getY() >= CasseBrique.HAUTEUR - balle.getDiametre() * 2);
                listeBonus.removeIf(bonus -> bonus.getY() >= CasseBrique.HAUTEUR - bonus.getDiametre() * 2);

                // si plus de balles, afficher GAME OVER
                if (listeBalle.size() <= 0) {
                    dessin.drawString("GAME OVER",200, 300);
                }

                dessin.dispose();
                this.getBufferStrategy().show();

                Thread.sleep(1000 / 60); // 60 images seconde
            } catch (InterruptedException e) {
                System.out.println("Processus arrêté");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // quand la touche gauche est enfoncée
        if (e.getKeyCode() == 37) {

            barre.deplacerGauche();

            // quand la touche droite est enfoncée
        } else if (e.getKeyCode() == 39) {

            barre.deplacerDroite();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {

        new CasseBrique();
    }

}
