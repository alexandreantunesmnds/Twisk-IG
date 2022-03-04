package twisk.outils;

public class FabriqueIdentifiant {
    private static FabriqueIdentifiant instance = new FabriqueIdentifiant();
    private int noEtape;
    public static FabriqueIdentifiant getInstance(){
        return instance;
    }
    public String getIdentifiantEtape(){
        this.noEtape++;
        return String.valueOf(this.noEtape);
    }
}
