package twisk.mondeIG;

public abstract class EtapeIG {
    protected String nom;
    protected String identifiant;
    private int posX,posY;
    protected int largeur,hauteur;

    public EtapeIG(String nom,String idf, int larg, int haut){
        this.nom = nom;
        this.identifiant = idf;
        this.largeur = larg;
        this.hauteur = haut;
    }
}
