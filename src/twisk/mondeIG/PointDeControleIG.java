package twisk.mondeIG;

import twisk.outils.TailleComposants;

public class PointDeControleIG {
    private int posX;
    private int posY;
    private String id;
    private EtapeIG etape;

    /**
     * COnstructeur
     * @param posX
     * @param posY
     * @param id
     * @param etape
     */
    public PointDeControleIG (int posX, int posY, String id, EtapeIG etape){
        this.posX = posX;
        this.posY = posY;
        this.id = id;
        this.etape = etape;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
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
}
