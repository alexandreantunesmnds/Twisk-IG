package twisk.mondeIG;

public class ArcIG {
    PointDeControleIG point1;
    PointDeControleIG point2;
    public ArcIG(PointDeControleIG point1, PointDeControleIG point2){
        this.point1 = point1;
        this.point2 = point2;
    }

    public PointDeControleIG getPoint1() {
        return point1;
    }

    public PointDeControleIG getPoint2() {
        return point2;
    }
}
