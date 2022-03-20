package twisk.vues;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import twisk.mondeIG.ArcIG;

public class VueArcIG extends Pane implements Observateur {
    public VueArcIG(ArcIG arc){
        Line line = new Line();
        // points
        /*double points[] = { 100.0d, 20.0d, 40.0d, 240.0d, 60.0d,
                180.0d, 80.0d, 200.0d, 100.0d, 90.0d, 20.0d, 20.0d };*/
        line.setStartX(arc.getPoint1().getPosX());
        line.setStartY(arc.getPoint1().getPosY());
        line.setEndX(arc.getPoint2().getPosX());
        line.setEndY(arc.getPoint2().getPosY());
        line.setStrokeWidth(4);
        line.setStroke(Color.MAGENTA);
        //Polyline polyLine = new Polyline(points);
        this.getChildren().addAll(line);
    }

    @Override
    public void reagir() {
    }
}
