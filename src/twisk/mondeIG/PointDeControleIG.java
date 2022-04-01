package twisk.mondeIG;

import twisk.outils.TailleComposants;

public class PointDeControleIG {
    private double posX;
    private double posY;
    private String id;
    private EtapeIG etape;

    /**
     * Constructeur
     * @param posX
     * @param posY
     * @param id
     * @param etape
     */
    public PointDeControleIG (double posX, double posY, String id, EtapeIG etape){
        this.posX = posX;
        this.posY = posY;
        this.id = id;
        this.etape = etape;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public String getId() {
        return id;
    }
    public String getNomEtape(){
        return this.etape.getNom();
    }
    public double getTaille(){
        TailleComposants constante = TailleComposants.getInstance();
        return constante.getCircleSize();
    }
    public void setX(double posX){
        this.posX = posX;
    }
    public void setY(double posY){
        this.posY = posY;
    }
}
