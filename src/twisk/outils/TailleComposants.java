package twisk.outils;

public class TailleComposants {
    private static TailleComposants instance = new TailleComposants();
    private int LargBox;
    private int HautBox;
    public static TailleComposants getInstance(){
        return instance;
    }
    public int getLargBox(){
        this.LargBox = 40;
        return this.LargBox;
    }
    public int getHautBox(){
        this.HautBox = 100;
        return this.HautBox;
    }
}
