package twisk.mondeIG;

public class EtapeIG {
    private String nom;
    private String identifiant;
    private int posX,posY;
    private int largeur,hauteur;

    public EtapeIG(String nom,String idf, int larg, int haut){
        this.nom = nom;
        this.identifiant = idf;
        this.largeur = larg;
        this.hauteur = haut;
    }
}
