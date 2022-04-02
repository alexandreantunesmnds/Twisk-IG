package twisk.mondeIG;

import twisk.vues.Observateur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public abstract class EtapeIG implements Iterable <PointDeControleIG>{
    protected String nom;
    protected String identifiant;
    protected int ecartTemps, temps;
    protected int posX,posY;
    protected int largeur,hauteur;
    protected ArrayList <PointDeControleIG> pcList;
    protected int selected; //si l'étape est selectionnée = à 1
    protected int estUneEntree; //si l'étape est une entrée = à 1

    public EtapeIG(String nom,String idf, int larg, int haut, int ecartTemps,int temps){
        //on positionne l'étape aléatoirement
        Random random = new Random();
        this.posX = 100+random.nextInt(600-100);
        this.posY = 100+random.nextInt(600-100);
        this.nom = nom;
        this.identifiant = idf;
        this.ecartTemps = ecartTemps;
        this.temps = temps;
        this.largeur = larg;
        this.hauteur = haut;
        this.selected = 0;
        this.estUneEntree = 0;
    }
    public abstract Iterator<PointDeControleIG> iterator();
    public abstract String getNom();
    public abstract  String getId();
    public abstract int getTemps();
    public abstract int getEcartTemps();
    public abstract int getPosX();
    public abstract  int getPosY();
    public abstract int getLarg();
    public abstract int getHaut();
    public abstract void etapeSelect();
    public abstract void etapeDeSelect();
    public abstract int getSelected();
    public abstract void setPosX(int posX);
    public abstract void setPosY(int posY);
    public abstract ArrayList <PointDeControleIG> getPoint();
    public abstract void setEstUneEntree(int estUneEntree);
    public abstract int getEstUneEntree();
}
