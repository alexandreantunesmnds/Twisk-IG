package twisk.vues;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import twisk.mondeIG.ArcIG;

public class VueArcIG extends Pane implements Observateur {
    public VueArcIG(ArcIG arc){
        Line line = new Line();
        line.setStartX(arc.getPoint1().getPosX());
        line.setStartY(arc.getPoint1().getPosY());
        line.setEndX(arc.getPoint2().getPosX());
        line.setEndY(arc.getPoint2().getPosY());
        line.setStrokeWidth(10);
        line.setStroke(Color.PINK);
        //Polyline polyLine = new Polyline();
        this.getChildren().add(line);
    }

    @Override
    public void reagir() {
    }
}
