package twisk.vues;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;
import twisk.outils.TailleComposants;

public class VuePointDeControleIG extends Circle implements Observateur {
    public VuePointDeControleIG(MondeIG monde, PointDeControleIG point) {
        super(point.getTaille());
        //Setting the color of the circle
        this.setFill(Color.MAGENTA);
        this.relocate(point.getPosX(), point.getPosY());
        this.setOnMouseClicked(new EcouteurPoint(monde,point));
    }

    @Override
    public void reagir() {
    }
}
