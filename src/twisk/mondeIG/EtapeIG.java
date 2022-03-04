package twisk.mondeIG;

import java.util.Random;

public abstract class EtapeIG {
    protected String nom;
    protected String identifiant;
    protected int posX,posY;
    protected int largeur,hauteur;

    public EtapeIG(String nom,String idf, int larg, int haut){
        //on positionne l'étape aléatoirement
        Random random = new Random();
        this.posX = 100+random.nextInt(600-100);
        this.posY = 100+random.nextInt(600-100);
        this.nom = nom;
        this.identifiant = idf;
        this.largeur = larg;
        this.hauteur = haut;
    }
}
