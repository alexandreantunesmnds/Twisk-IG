package twisk.mondeIG;

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
}
