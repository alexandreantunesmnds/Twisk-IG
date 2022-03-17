package twisk.outils;

public class TailleComposants {
    private static TailleComposants instance = new TailleComposants();
    private int LargBox;
    private int HautBox;
    private double circleSize;
    public static TailleComposants getInstance(){
        return instance;
    }
    public int getLargBox(){
        this.LargBox = 200;
        return this.LargBox;
    }
    public int getHautBox(){
        this.HautBox = 50;
        return this.HautBox;
    }
    public double getCircleSize(){
        this.circleSize = 5.0;
        return this.circleSize;
    }

}
