package twisk.vues;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import twisk.mondeIG.ArcIG;

public class VueArcIG extends Pane implements Observateur {
    public VueArcIG(ArcIG arc){
        Line line = new Line(arc.getPoint1().getPosX(),arc.getPoint1().getPosY(),arc.getPoint2().getPosY(),arc.getPoint2().getPosY());
        //Polyline polyLine = new Polyline();
        this.getChildren().add(line);
    }

    @Override
    public void reagir() {

    }
}
