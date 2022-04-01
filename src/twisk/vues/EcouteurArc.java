package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class EcouteurArc implements EventHandler<MouseEvent> {
    private MondeIG monde;
    private PointDeControleIG point;
    public EcouteurArc (MondeIG monde, PointDeControleIG point){
        this.monde = monde;
        this.point = point;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        this.monde.sel;

    }
}
