package twisk.vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurSortie implements EventHandler<ActionEvent> {
    MondeIG monde;
    public EcouteurSortie(MondeIG monde){
        this.monde = monde;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        this.monde.selectSortie();
    }
}
