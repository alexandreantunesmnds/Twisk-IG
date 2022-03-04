package twisk.mondeIG;

public class ActiviteIG extends EtapeIG {
    public ActiviteIG(String nom, String idf, int larg, int haut){
        super(nom,idf,larg,haut);
    }
    public String getNom(){
        return this.nom;
    }
    public String getId(){
        return this.identifiant;
    }
    public int getPosX(){
        return this.posX;
    }
    public int getPosY(){
        return this.posY;
    }
    public int getLarg(){
        return this.largeur;
    }
    public int getHaut(){
        return this.hauteur;
    }
}
