package twisk.vues;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.MondeIG;
import twisk.vues.ecouteurs.EcouteurArc;

public class VueArcIG extends Pane implements Observateur {
    public VueArcIG(MondeIG monde, ArcIG arc){
        Line line = new Line();
        Polyline polyLine = new Polyline();
        //Ligne
        line.setStartX(arc.getPoint1().getPosX());
        line.setStartY(arc.getPoint1().getPosY());
        line.setEndX(arc.getPoint2().getPosX());
        line.setEndY(arc.getPoint2().getPosY());
        //Tête de la flèche
        double angle = Math.atan2((line.getEndY() - line.getStartY()), (line.getEndX() - line.getStartX())) - Math.PI / 2.0;
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);
        //point 1
        double x1 = (- 1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * 10 + line.getEndX();
        double y1 = (- 1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * 10 + line.getEndY();
        //point 2
        double x2 = (1.0 / 2.0 * cos + Math.sqrt(3) / 2 * sin) * 10 + line.getEndX();
        double y2 = (1.0 / 2.0 * sin - Math.sqrt(3) / 2 * cos) * 10 + line.getEndY();
        polyLine.getPoints().setAll(x1,y1,x2,y2,line.getEndX(),line.getEndY());
        line.setStrokeWidth(5);
        polyLine.setStrokeWidth(10);
        if (arc.getSelected()==1){
            line.setStroke(Color.RED);
            polyLine.setStroke(Color.RED);
        }
        else{
            line.setStroke(Color.valueOf("#ff9a00"));
            polyLine.setStroke(Color.valueOf("#ff9a00"));
        }
        this.setOnMouseClicked(new EcouteurArc(monde,arc));
        this.getChildren().addAll(line,polyLine);
    }

    @Override
    public void reagir() {
    }
}
