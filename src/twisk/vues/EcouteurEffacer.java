package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurEffacer implements EventHandler<ActionEvent> {
    private MondeIG monde;
    public EcouteurEffacer(MondeIG monde){
        this.monde = monde;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        this.monde.effacerSelect();
    }
}
