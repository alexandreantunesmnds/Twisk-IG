package twisk.vues;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;
import twisk.vues.ecouteurs.EcouteurPoint;

public class VuePointDeControleIG extends Circle implements Observateur {
    public VuePointDeControleIG(MondeIG monde, PointDeControleIG point) {
        super(point.getTaille());
        //Setting the color of the circle
        this.setFill(Color.BLACK);
        this.relocate(point.getPosX(), point.getPosY());
        this.setOnMouseClicked(new EcouteurPoint(monde,point));
    }

    @Override
    public void reagir() {
    }
}
