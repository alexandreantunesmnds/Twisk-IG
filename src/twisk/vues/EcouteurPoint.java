package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class EcouteurPoint implements EventHandler<MouseEvent> {
    private MondeIG monde;
    private PointDeControleIG point;
    public EcouteurPoint (MondeIG monde, PointDeControleIG point){
        this.monde = monde;
        this.point = point;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        this.monde.selectionPoint(this.point);
    }
}
