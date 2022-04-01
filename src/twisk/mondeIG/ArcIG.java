package twisk.mondeIG;

public class ArcIG {
    private PointDeControleIG point1;
    private PointDeControleIG point2;
    private int selected;
    public ArcIG(PointDeControleIG point1, PointDeControleIG point2){
        this.point1 = point1;
        this.point2 = point2;
        this.selected = 0;
    }

    public PointDeControleIG getPoint1() {
        return point1;
    }

    public PointDeControleIG getPoint2() {
        return point2;
    }
    public void setSelected (){
        this.selected = 1;
    }
    public void setDeSelect(){
        this.selected = -1;
    }
    public int getSelected(){
        return this.selected;
    }
}
