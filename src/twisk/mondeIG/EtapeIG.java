package twisk.mondeIG;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public abstract class EtapeIG implements Iterable <PointDeControleIG>{
    protected String nom;
    protected String identifiant;
    protected int posX,posY;
    protected int largeur,hauteur;
    protected ArrayList <PointDeControleIG> pcList = new ArrayList<>(4);

    public EtapeIG(String nom,String idf, int larg, int haut){
        PointDeControleIG pc1,pc2,pc3,pc4;
        //on positionne l'étape aléatoirement
        Random random = new Random();
        this.posX = 100+random.nextInt(600-100);
        this.posY = 100+random.nextInt(600-100);
        this.nom = nom;
        this.identifiant = idf;
        this.largeur = larg;
        this.hauteur = haut;
        pc1 = new PointDeControleIG(this.posX-this.largeur/2,this.posY,"id1",this);
        pc2 = new PointDeControleIG(this.posX+this.largeur/2,this.posY,"id2",this);
        pc3 =new PointDeControleIG(this.posX,this.posY-this.hauteur/2,"id3",this);
        pc4 = new PointDeControleIG(this.posX,this.posY+this.hauteur/2,"id4",this);
        this.pcList.add(pc1);
        this.pcList.add(pc2);
        this.pcList.add(pc3);
        this.pcList.add(pc4);
    }
    public Iterator<PointDeControleIG> iterator() {
        return pcList.iterator();
    }
    public abstract String getNom();
    public abstract  String getId();
    public abstract int getPosX();
    public abstract  int getPosY();
    public abstract int getLarg();
    public abstract int getHaut();
}
